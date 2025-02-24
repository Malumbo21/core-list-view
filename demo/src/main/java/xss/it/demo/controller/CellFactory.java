/*
 * Copyright © 2024. XTREME SOFTWARE SOLUTIONS
 *
 * All rights reserved. Unauthorized use, reproduction, or distribution
 * of this software or any portion of it is strictly prohibited and may
 * result in severe civil and criminal penalties. This code is the sole
 * proprietary of XTREME SOFTWARE SOLUTIONS.
 *
 * Commercialization, redistribution, and use without explicit permission
 * from XTREME SOFTWARE SOLUTIONS, are expressly forbidden.
 */

package xss.it.demo.controller;

import javafx.animation.ScaleTransition;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import xss.it.demo.data.entity.Person;

/**
 * @author XDSSWAR
 * Created on 06/27/2024
 */
public final class CellFactory extends AnchorPane {
    /**
     * The root container for the cell layout.
     */
    private final AnchorPane cellBox;

    /**
     * The main horizontal container for structuring cell content.
     */
    private final HBox hBox;

    /**
     * The image view displaying the person's avatar or profile picture.
     */
    private final ImageView image;

    /**
     * A vertical container for grouping labels related to person details.
     */
    private final VBox vBox;

    /**
     * A horizontal box containing a label for the person's name.
     */
    private final HBox hBox1;

    /**
     * A label for displaying "Name:" text.
     */
    private final Label label;

    /**
     * A horizontal box containing the actual name label.
     */
    private final HBox hBox2;

    /**
     * A label displaying the person's name.
     */
    private final Label nameLabel;

    /**
     * A horizontal box containing a label for the person's email.
     */
    private final HBox hBox3;

    /**
     * A label for displaying "Email:" text.
     */
    private final Label label1;

    /**
     * A horizontal box containing the actual email label.
     */
    private final HBox hBox4;

    /**
     * A label displaying the person's email.
     */
    private final Label emailLabel;

    /**
     * A horizontal box containing a label for the person's MAC address.
     */
    private final HBox hBox5;

    /**
     * A label for displaying "MAC:" text.
     */
    private final Label label2;

    /**
     * A horizontal box containing the actual MAC address label.
     */
    private final HBox hBox6;

    /**
     * A label displaying the person's MAC address.
     */
    private final Label macLabel;

    /**
     * A horizontal box containing a label for the person's city.
     */
    private final HBox hBox7;

    /**
     * A label for displaying "City:" text.
     */
    private final Label label3;

    /**
     * A horizontal box containing the actual city label.
     */
    private final HBox hBox8;

    /**
     * A label displaying the person's city.
     */
    private final Label cityLabel;

    /**
     * A horizontal box containing a label for the date.
     */
    private final HBox hBox9;

    /**
     * A label for displaying "Date:" text.
     */
    private final Label label4;

    /**
     * A horizontal box containing the actual date label.
     */
    private final HBox hBox10;

    /**
     * A label displaying the person's registration or update date.
     */
    private final Label dateLabel;

    /**
     * A horizontal box containing a label for the person's credit card details.
     */
    private final HBox hBox11;

    /**
     * A label for displaying "Card:" text.
     */
    private final Label label5;

    /**
     * A horizontal box containing the actual credit card label.
     */
    private final HBox hBox12;

    /**
     * A label displaying the person's credit card number.
     */
    private final Label cardLabel;

    /**
     * The {@link Person} instance associated with this cell.
     */
    private final Person person;

    /**
     * Constructs a {@code CellFactory} instance for the specified {@link Person}.
     *
     * @param person the {@link Person} instance associated with this cell
     */
    public CellFactory(Person person) {
        this.person = person;
        cellBox = new AnchorPane();
        hBox = new HBox();
        image = new ImageView();
        vBox = new VBox();
        hBox1 = new HBox();
        label = new Label();
        hBox2 = new HBox();
        nameLabel = new Label();
        hBox3 = new HBox();
        label1 = new Label();
        hBox4 = new HBox();
        emailLabel = new Label();
        hBox5 = new HBox();
        label2 = new Label();
        hBox6 = new HBox();
        macLabel = new Label();
        hBox7 = new HBox();
        label3 = new Label();
        hBox8 = new HBox();
        cityLabel = new Label();
        hBox9 = new HBox();
        label4 = new Label();
        hBox10 = new HBox();
        dateLabel = new Label();
        hBox11 = new HBox();
        label5 = new Label();
        hBox12 = new HBox();
        cardLabel = new Label();

        initialize();

        events();

        load();

    }

    /**
     * Initializes the cell factory components.
     * This method is responsible for setting up the UI layout and bindings.
     */
    private void initialize(){
        setPrefHeight(235.0);
        setPrefWidth(600.0);
        getStyleClass().add("cell-base");

        AnchorPane.setBottomAnchor(cellBox, 10.0);
        AnchorPane.setLeftAnchor(cellBox, 10.0);
        AnchorPane.setRightAnchor(cellBox, 10.0);
        AnchorPane.setTopAnchor(cellBox, 10.0);
        cellBox.setLayoutX(150.0);
        cellBox.setLayoutY(35.0);
        cellBox.setPrefHeight(200.0);
        cellBox.setPrefWidth(200.0);
        cellBox.getStyleClass().add("cell-box");

        AnchorPane.setBottomAnchor(hBox, 5.0);
        AnchorPane.setLeftAnchor(hBox, 5.0);
        AnchorPane.setRightAnchor(hBox, 5.0);
        AnchorPane.setTopAnchor(hBox, 5.0);
        hBox.setAlignment(javafx.geometry.Pos.CENTER_LEFT);
        hBox.setLayoutX(103.0);
        hBox.setLayoutY(62.0);
        hBox.setPrefHeight(100.0);
        hBox.setPrefWidth(200.0);

        image.setFitHeight(80.0);
        image.setFitWidth(80.0);
        image.setPickOnBounds(true);
        image.setPreserveRatio(true);
        image.setImage(new Image(NfxListController.load("/pay.png").toExternalForm()));
        HBox.setMargin(image, new Insets(0.0, 0.0, 0.0, 10.0));

        vBox.setAlignment(javafx.geometry.Pos.CENTER_LEFT);
        vBox.setPrefHeight(200.0);
        vBox.setPrefWidth(5000.0);
        HBox.setMargin(vBox, new Insets(0.0, 10.0, 0.0, 20.0));

        hBox1.setAlignment(javafx.geometry.Pos.CENTER_LEFT);
        hBox1.setPrefWidth(200.0);

        label.setMinWidth(110.0);
        label.getStyleClass().add("cell-label");
        label.setText("Neme");
        HBox.setMargin(label, new Insets(0.0, 0.0, 0.0, 20.0));

        hBox2.setAlignment(javafx.geometry.Pos.CENTER_RIGHT);
        hBox2.setPrefWidth(5000.0);

        nameLabel.getStyleClass().add("cell-label");
        nameLabel.setText("--");
        HBox.setMargin(nameLabel, new Insets(0.0, 0.0, 0.0, 20.0));
        VBox.setMargin(hBox1, new Insets(2.0, 5.0, 2.0, 0.0));

        hBox3.setAlignment(javafx.geometry.Pos.CENTER_LEFT);
        hBox3.setLayoutX(10.0);
        hBox3.setLayoutY(100.0);
        hBox3.setPrefWidth(200.0);

        label1.setMinWidth(110.0);
        label1.getStyleClass().add("cell-label");
        label1.setText("Email Address");
        HBox.setMargin(label1, new Insets(0.0, 0.0, 0.0, 20.0));

        hBox4.setAlignment(javafx.geometry.Pos.CENTER_RIGHT);
        hBox4.setPrefWidth(5000.0);

        emailLabel.getStyleClass().add("cell-label");
        emailLabel.setText("--");
        HBox.setMargin(emailLabel, new Insets(0.0, 0.0, 0.0, 20.0));
        VBox.setMargin(hBox3, new Insets(2.0, 5.0, 2.0, 0.0));

        hBox5.setAlignment(javafx.geometry.Pos.CENTER_LEFT);
        hBox5.setLayoutX(10.0);
        hBox5.setLayoutY(113.0);
        hBox5.setPrefWidth(200.0);

        label2.setMinWidth(110.0);
        label2.getStyleClass().add("cell-label");
        label2.setText("Mac Address");
        HBox.setMargin(label2, new Insets(0.0, 0.0, 0.0, 20.0));

        hBox6.setAlignment(javafx.geometry.Pos.CENTER_RIGHT);
        hBox6.setPrefWidth(5000.0);

        macLabel.getStyleClass().add("cell-label");
        macLabel.setText("--");
        HBox.setMargin(macLabel, new Insets(0.0, 0.0, 0.0, 20.0));
        VBox.setMargin(hBox5, new Insets(2.0, 5.0, 2.0, 0.0));

        hBox7.setAlignment(javafx.geometry.Pos.CENTER_LEFT);
        hBox7.setLayoutX(10.0);
        hBox7.setLayoutY(75.0);
        hBox7.setPrefWidth(200.0);

        label3.setMinWidth(110.0);
        label3.getStyleClass().add("cell-label");
        label3.setText("City");
        HBox.setMargin(label3, new Insets(0.0, 0.0, 0.0, 20.0));

        hBox8.setAlignment(javafx.geometry.Pos.CENTER_RIGHT);
        hBox8.setPrefWidth(5000.0);

        cityLabel.getStyleClass().add("cell-label");
        cityLabel.setText("--");
        HBox.setMargin(cityLabel, new Insets(0.0, 0.0, 0.0, 20.0));
        VBox.setMargin(hBox7, new Insets(2.0, 5.0, 2.0, 0.0));

        hBox9.setAlignment(javafx.geometry.Pos.CENTER_LEFT);
        hBox9.setLayoutX(10.0);
        hBox9.setLayoutY(100.0);
        hBox9.setPrefWidth(200.0);

        label4.setMinWidth(110.0);
        label4.getStyleClass().add("cell-label");
        label4.setText("Date");
        HBox.setMargin(label4, new Insets(0.0, 0.0, 0.0, 20.0));

        hBox10.setAlignment(javafx.geometry.Pos.CENTER_RIGHT);
        hBox10.setPrefWidth(5000.0);

        dateLabel.getStyleClass().add("cell-label");
        dateLabel.setText("--");
        HBox.setMargin(dateLabel, new Insets(0.0, 0.0, 0.0, 20.0));
        VBox.setMargin(hBox9, new Insets(2.0, 5.0, 2.0, 0.0));

        hBox11.setAlignment(javafx.geometry.Pos.CENTER_LEFT);
        hBox11.setLayoutX(10.0);
        hBox11.setLayoutY(125.0);
        hBox11.setPrefWidth(200.0);

        label5.setMinWidth(110.0);
        label5.getStyleClass().add("cell-label");
        label5.setText("Credit Card");
        HBox.setMargin(label5, new Insets(0.0, 0.0, 0.0, 20.0));

        hBox12.setAlignment(javafx.geometry.Pos.CENTER_RIGHT);
        hBox12.setPrefWidth(5000.0);

        cardLabel.getStyleClass().add("cell-label");
        cardLabel.setText("--");
        HBox.setMargin(cardLabel, new Insets(0.0, 0.0, 0.0, 20.0));
        VBox.setMargin(hBox11, new Insets(2.0, 5.0, 2.0, 0.0));

        hBox.getChildren().add(image);
        hBox1.getChildren().add(label);
        hBox2.getChildren().add(nameLabel);
        hBox1.getChildren().add(hBox2);
        vBox.getChildren().add(hBox1);
        hBox3.getChildren().add(label1);
        hBox4.getChildren().add(emailLabel);
        hBox3.getChildren().add(hBox4);
        vBox.getChildren().add(hBox3);
        hBox5.getChildren().add(label2);
        hBox6.getChildren().add(macLabel);
        hBox5.getChildren().add(hBox6);
        vBox.getChildren().add(hBox5);
        hBox7.getChildren().add(label3);
        hBox8.getChildren().add(cityLabel);
        hBox7.getChildren().add(hBox8);
        vBox.getChildren().add(hBox7);
        hBox9.getChildren().add(label4);
        hBox10.getChildren().add(dateLabel);
        hBox9.getChildren().add(hBox10);
        vBox.getChildren().add(hBox9);
        hBox11.getChildren().add(label5);
        hBox12.getChildren().add(cardLabel);
        hBox11.getChildren().add(hBox12);
        vBox.getChildren().add(hBox11);
        hBox.getChildren().add(vBox);
        cellBox.getChildren().add(hBox);
        getChildren().add(cellBox);


    }

    /**
     * Sets up event handlers for mouse interactions with the cell.
     * Adds a scaling effect on mouse enter and resets it on mouse exit.
     */
    private void events(){
        cellBox.setOnMouseEntered(event -> {
            ScaleTransition st = new ScaleTransition(Duration.millis(100), cellBox);
            st.setToX(1.02);
            st.setToY(1.02);
            st.play();
        });

        cellBox.setOnMouseExited(event -> {
            ScaleTransition st = new ScaleTransition(Duration.millis(100), cellBox);
            st.setToX(1);
            st.setToY(1);
            st.play();
        });
    }

    /**
     * Loads the person's details into the UI components.
     * Populates labels with data and masks the credit card number for privacy.
     */
    public void load(){
        nameLabel.setText(person.getName());
        emailLabel.setText(person.getEmail());
        cityLabel.setText(person.getCity());
        macLabel.setText(person.getMac());
        cardLabel.setText(person.getCreditCard().isBlank() ? "" : "****-****-****-"+person.getCreditCard().substring(15));
        dateLabel.setText(this.person.getTimestamp().length()<10 ? "Unknown" : person.getTimestamp().substring(0,10));
    }
}
