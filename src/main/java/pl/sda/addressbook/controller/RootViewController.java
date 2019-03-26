package pl.sda.addressbook.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import pl.sda.addressbook.Main;
import pl.sda.addressbook.model.Person;

import javax.xml.crypto.Data;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * @author Remigiusz Zudzin
 */
public class RootViewController implements Initializable {

    @FXML
    private TableView<Person> personTableView;

    public TableView<Person> getPersonTableView() {
        return personTableView;
    }

    public void setPersonTableView(TableView<Person> personTableView) {
        this.personTableView = personTableView;
    }

    @FXML
    private TableColumn<Person, String> nameCol;

    @FXML
    private TableColumn<Person, String> lastNameCol;

    @FXML
    private Label nameLabel;

    @FXML
    private Label lastnameLabel;

    @FXML
    private Label addressLabel;

    @FXML
    private Label postalCodeLabel;

    @FXML
    private Label telephoneLabel;

    @FXML
    private Label cityLabel;

    @FXML
    private Button newPersonButton;

    @FXML
    private Button editButton;

    @FXML
    private Button deleteButton;

    @FXML
    private Button saveButton;

    private Main main;

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void loadPerson() {
        System.out.println(getMain().getPersonList());
        personTableView.setItems(getMain().getPersonList());
        nameCol.setCellValueFactory(c -> c.getValue().nameProperty());
        lastNameCol.setCellValueFactory(c -> c.getValue().lastnameProperty());
    }

    public void selectedPerson(MouseEvent mouseEvent) {
        Person person = personTableView.getSelectionModel().getSelectedItem();
        nameLabel.setText(person.getName());
        lastnameLabel.setText(person.getLastname());
        addressLabel.setText(person.getAddress());
        postalCodeLabel.setText(person.getPostalCode());
        telephoneLabel.setText(person.getTelephone());
        cityLabel.setText(person.getCity());
    }

    //1. Załadowanie FXML
    //2. Parent
    //3. Nowy obiekt Stage
    //4. Set Scene na Stage

    public void setNewPersonButton() throws IOException {
        //1. Załadowanie FXML
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/root2.fxml"));
        loader.load();
        //2. Parent
        Parent root = loader.getRoot();
        AddNewPersonRootViewController addNewPersonRootViewController = loader.getController();
        addNewPersonRootViewController.setMain(main);
        //3. Nowy obiekt Stage
        Stage stage = new Stage();
        //4. Set Scene na Stage
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void setEditButton() throws IOException {
        //1. Załadowanie FXML
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/editRoot.fxml"));
        loader.load();
        //2. Parent
        Parent root = loader.getRoot();
        EditRootViewController editRootViewController = loader.getController();
        editRootViewController.setMain(main);
        editRootViewController.setSelectedPerson(personTableView.getSelectionModel().getSelectedItem());
        editRootViewController.initializeForm();
        //3. Nowy obiekt Stage
        Stage stage = new Stage();
        //4. Set Scene na Stage
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void setDeleteButton() {
        ObservableList<Person> list = main.getPersonList();
        list.remove(personTableView.getSelectionModel().getFocusedIndex());
    }

    public void setSaveButton(MouseEvent mouseEvent) throws IOException {
        Person.toJSON(main.getJsonFileName(), main.getPersonList());
    }
}
