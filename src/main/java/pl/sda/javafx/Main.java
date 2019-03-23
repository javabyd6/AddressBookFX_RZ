package pl.sda.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author Remigiusz Zudzin
 */

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root =
                FXMLLoader.load(
                        getClass()
                                .getResource("/root.fxml"));
        primaryStage.setScene(new Scene(root, 657, 400));
        primaryStage.show();
    }
}
