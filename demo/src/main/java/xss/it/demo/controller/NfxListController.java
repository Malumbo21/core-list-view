package xss.it.demo.controller;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;
import xss.it.demo.Demo;
import xss.it.demo.data.entity.Person;
import xss.it.demo.data.model.PersonModel;
import xss.it.nfx.list.NfxCell;
import xss.it.nfx.list.NfxListView;
import xss.it.nfx.list.misc.SelectionModel;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author XDSSWAR
 * Created on 02/23/2025
 */
public final class NfxListController extends AnchorPane implements Initializable {
    /**
     * The buttons in the header
     */
    @FXML
    private Button clearSelectionBtn, enableUnselectBtn, factoryBtn, multiSelectionBtn, randScrollBtn, refreshBtn;

    /**
     * The label displaying the total number of items in the list view.
     */
    @FXML
    private Label counterTxt;

    /**
     * The list view component displaying {@link Person} objects.
     */
    @FXML
    private NfxListView<Person> listView;

    /**
     * The text field for searching and filtering items in the list view.
     */
    @FXML
    private TextField searchTxt;


    /**
     * The default stylesheet for this component, loaded from resources.
     */
    private static final String STYLE_SHEET = load("/style.css").toExternalForm();

    /**
     * A final callback for {@code BaseListView} to {@code NfxCell}.
     */
    private Callback<NfxListView<Person>, NfxCell<Person>> factory;

    /**
     * A static thread pool with a fixed thread count of 1.
     * Each thread in the pool is set to daemon mode.
     */
    static final ExecutorService THREAD_POOL = Executors.newFixedThreadPool(1, r -> {
        Thread t = new Thread(r);
        t.setDaemon(true);
        return t;
    });


    /**
     * Constructs an {@code NfxListController} instance.
     */
    public NfxListController() throws IOException {
        super();
        /*
         * Add styles
         */
        getStylesheets().add(STYLE_SHEET);

        /*
         * Load the fxml and add it
         */
        Parent parent = load("/view.fxml", this);
        AnchorPane.setLeftAnchor(parent, 0d);
        AnchorPane.setTopAnchor(parent, 0d);
        AnchorPane.setRightAnchor(parent, 0d);
        AnchorPane.setBottomAnchor(parent, 0d);
        getChildren().add(parent);
    }

    /**
     * Initializes the controller when the associated FXML file is loaded.
     *
     * @param url    the location of the FXML file
     * @param bundle the resource bundle containing localized data
     */
    @Override
    public void initialize(URL url, ResourceBundle bundle) {
        // Save the cell factory for later use
        factory = listView.getCellFactory();

        /*
         * Load the data
         */
        loadData();

        /*
         * Sets the action for the refresh button to reload data.
         */
        refreshBtn.setOnAction(event -> loadData());

        /*
         * Sets the action for the cell factory button to toggle the cell factory.
         */
        factoryBtn.setOnAction(event -> {
            if (Objects.equals(factory, listView.getCellFactory())) {
                listView.setCellFactory(cellFactory());
            } else {
                listView.setCellFactory(factory);
            }
        });

        /*
         * Sets the action for the random scroll button to scroll to a random item.
         */
        randScrollBtn.setOnAction(event -> {
            int index = rand(listView.getItems().size() - 1);
            Person person = listView.getItems().get(index);
            listView.scrollToItem(person);
            listView.getSelectionModel().select(person);
        });

        /*
         * Sets the action for the clear selection button to clear the current selection.
         */
        clearSelectionBtn.setOnAction(event -> listView.getSelectionModel().clearSelection());

        /*
         * Sets the action for the refresh button to refresh the {@code listView}.
         */
        refreshBtn.setOnAction(event -> loadData());

        /*
         * Sets the action for the unselect button to toggle unselect on click behavior.
         */
        enableUnselectBtn.setOnAction(event ->
                listView.setAllowUnselectOnClick(!listView.isAllowUnselectOnClick())
        );

        /*
         * Sets the action for the multi-selection button to toggle selection mode.
         */
        multiSelectionBtn.setOnAction(event -> {
            if (listView.getSelectionMode().equals(SelectionModel.Mode.MULTIPLE)) {
                listView.setSelectionMode(SelectionModel.Mode.SINGLE);
            } else {
                listView.setSelectionMode(SelectionModel.Mode.MULTIPLE);
            }
        });

        /*
         * Handles the initial selection mode.
         */
        handleSelectionMode(listView.getSelectionMode());
        listView.selectionModeProperty().addListener((obs, o, mode) -> handleSelectionMode(mode));

        /*
         * Handles the initial unselect on click setting.
         */
        handleUnselectOnClick(listView.isAllowUnselectOnClick());
        listView.allowUnselectOnClickProperty().addListener((obs, o, enabled) -> {
            handleUnselectOnClick(enabled);
        });
    }


    /**
     * Loads data into the {@code listView}.
     * Reads JSON data from a resource file, converts it into a list of {@code Person} objects,
     * and updates the UI asynchronously.
     */
    private void loadData() {
        Task<List<Person>> task = new Task<>() {
            @Override
            protected List<Person> call() throws Exception {
                String json = PersonModel.readFileFromResources("/people.json");

                // Create a list from JSON data
                return PersonModel.fromJsonArray(json);
            }
        };

        /*
         * Listens for changes in the task value and updates the UI when data is loaded.
         */
        task.valueProperty().addListener((obs, o, list) -> {
            if (list != null) {
                ObservableList<Person> personObservableList = FXCollections.observableArrayList(list);
                Platform.runLater(() -> {
                    listView.getItems().clear();
                    listView.setItems(personObservableList);
                    counterTxt.setText(String.format("Total : %s", listView.getItems().size()));
                    filter(listView, searchTxt);
                });
            }
        });

        /*
         * Submits the task to the thread pool for execution.
         */
        THREAD_POOL.submit(task);
    }

    /**
     * Filters the {@code listView} based on the text input in {@code textField}.
     * Updates the displayed list dynamically as the user types.
     *
     * @param listView   the {@link NfxListView} containing {@link Person} objects
     * @param textField  the {@link TextField} used for input filtering
     */
    private void filter(NfxListView<Person> listView, TextField textField) {
        ObservableList<Person> originalItems = listView.getItems();

        textField.textProperty().addListener((observable, oldValue, newValue) -> {
            String filter = newValue.toLowerCase();

            /*
             * Asynchronous task to filter the list based on user input.
             */
            Task<FilteredList<Person>> task = new Task<>() {
                @Override
                protected FilteredList<Person> call() {
                    return new FilteredList<>(originalItems, person -> {
                        if (filter.isEmpty()) {
                            return true; // No filter applied
                        }
                        return (person.getName().toLowerCase().contains(filter))
                                || (person.getEmail().toLowerCase().contains(filter))
                                || (person.getCity().toLowerCase().contains(filter));
                    });
                }

                @Override
                protected void succeeded() {
                    /*
                     * Updates the {@code listView} with the filtered results.
                     */
                    ObservableList<Person> list = FXCollections.observableArrayList(getValue());
                    Platform.runLater(() -> {
                        listView.setItems(list);
                        counterTxt.setText(String.format("Total : %s", listView.getItems().size()));
                    });
                }
            };

            /*
             * Submits the filtering task to the thread pool for execution.
             */
            THREAD_POOL.submit(task);
        });
    }

    /**
     * Creates a cell factory for the {@code listView}.
     * Generates a custom {@code NfxCell} for each {@code Person} in the list.
     *
     * @return a {@link Callback} for creating {@link NfxCell} instances
     */
    private Callback<NfxListView<Person>, NfxCell<Person>> cellFactory() {
        return new Callback<>() {
            @Override
            public NfxCell<Person> call(NfxListView<Person> personBaseListView) {
                return new NfxCell<>(personBaseListView) {
                    @Override
                    public void update(Person item) {
                        super.update(item);
                        CellFactory factory = new CellFactory(item);
                        setGraphics(factory);
                    }
                };
            }
        };
    }

    /**
     * Handles changes in the selection mode.
     * Updates the button text based on whether multi-selection is enabled.
     *
     * @param mode the {@link SelectionModel.Mode} representing the selection mode
     */
    private void handleSelectionMode(SelectionModel.Mode mode) {
        if (SelectionModel.Mode.SINGLE.equals(mode)) {
            multiSelectionBtn.setText("Enable MultiSelection (Ctrl + Click)");
        } else {
            multiSelectionBtn.setText("Disable MultiSelection (Ctrl + Click)");
        }
    }

    /**
     * Handles changes in the unselect-on-click behavior.
     * Updates the button text based on whether unselect-on-click is enabled.
     *
     * @param enabled {@code true} to enable unselect on click, {@code false} to disable it
     */
    private void handleUnselectOnClick(boolean enabled) {
        if (enabled) {
            enableUnselectBtn.setText("Disable Unselect On Click");
        } else {
            enableUnselectBtn.setText("Enable Unselect On Click");
        }
    }


    /**
     * Generates a random integer between 0 (inclusive) and the specified maximum value (exclusive).
     *
     * @param max the upper bound (exclusive) for the random number
     * @return a random integer between 0 and {@code max}
     */
    public int rand(int max) {
        Random random = new Random();
        return random.nextInt(max);
    }

    /**
     * This method loads a URL for a given location.
     *
     * @param location The location of the resource to load.
     * @return A URL object representing the resource's location.
     */
    public static URL load(final String location) {
        return Demo.class.getResource(location);
    }

    /**
     * Loads and returns the root element of a JavaFX scene graph from the specified FXML file.
     *
     * @param location   The location of the FXML file.
     * @param controller The controller object to associate with the FXML file. Can be null.
     * @return The root element of the loaded JavaFX scene graph.
     */
    public static Parent load(final String location, Object controller) throws IOException {
        FXMLLoader loader = new FXMLLoader(load(location));
        if (controller!=null){
            loader.setController(controller);
        }
        return loader.load();
    }
}
