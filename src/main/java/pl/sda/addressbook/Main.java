package pl.sda.addressbook;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.sda.addressbook.controller.RootViewController;
import pl.sda.addressbook.model.Person;

/**
 * @author Remigiusz Zudzin
 */

public class Main extends Application {

    private ObservableList<Person> personList = FXCollections.observableArrayList();

    public Main() {
        personList.add(new Person("Jan", "Kowalski", "adres",
                "85-100", "123456789", "Bydgoszcz"));
        personList.add(new Person("Tomasz", "Nowak", "adres2",
                "85-101", "123456123", "Gdańsk"));
        personList.add(new Person("Roman", "Kowalski", "adres3",
                "85-102", "123123789", "Sopot"));
    }

    public ObservableList<Person> getPersonList() {
        return personList;
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
//        Parent root =
//                FXMLLoader.load(
//                        getClass()
//                                .getResource("/root.fxml"));

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/root.fxml"));
        loader.load();
        Parent root = loader.getRoot();
        RootViewController rootViewController = loader.getController();
        //odniesienie się przez referencję z Maina do Controllera
        //stworzenie obiektu klasy FXMLoader, następnie ustawienie lokalizacji jego roota, a potem załadowanie
        //Następnie pobranie roota i ustawienie na instancji RootViewController tego kontrollera którego tworzymy
        //przez użycie metody getController dla obiektu loader

        rootViewController.setMain(this);
        rootViewController.loadPerson();
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
