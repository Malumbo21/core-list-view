

package xss.it.demo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import xss.it.demo.controller.NfxListController;

import java.io.IOException;

/**
 * @author XDSSWAR
 * Created on 02/23/2025
 */
public class Demo extends Application {

    /**
     * The entry point of the Java application.
     * This method calls the launch method to start a JavaFX application.
     *
     * @param args The command line arguments.
     */
    public static void main(String... args) {
        launch(args);
    }

    /**
     * This method is called after the application has been launched.
     * Override this method to create and set up the primary stage of the application.
     *
     * @param stage The primary stage for this application, onto which
     *              the application scene can be set.
     */
    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("NfxListView Demo");
        NfxListController controller = new NfxListController();
        Scene scene = new Scene(controller);
        stage.setScene(scene);
        stage.show();
    }
}
