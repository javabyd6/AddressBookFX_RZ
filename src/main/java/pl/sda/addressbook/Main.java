package pl.sda.addressbook;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.sda.addressbook.model.Person;

/**
 * @author Remigiusz Zudzin
 */

public class Main extends Application {

    private static ObservableList<Person> personList = FXCollections.observableArrayList();

    static {
        personList.add(new Person("Jan", "Kowalski", "adres",
                "85-100", "123456789", "Bydgoszcz"));
        personList.add(new Person("Tomasz", "Nowak", "adres2",
                "85-101", "123456123", "Gdańsk"));
        personList.add(new Person("Roman", "Kowalski", "adres3",
                "85-102", "123123789", "Sopot"));
    }

    public static ObservableList<Person> getPersonList() {
        return personList;
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root =
                FXMLLoader.load(
                        getClass()
                                .getResource("/root.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
