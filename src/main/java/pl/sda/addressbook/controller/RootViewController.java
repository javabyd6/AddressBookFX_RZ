package pl.sda.addressbook.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import pl.sda.addressbook.Main;
import pl.sda.addressbook.model.Person;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Remigiusz Zudzin
 */
public class RootViewController implements Initializable {

    @FXML
    private TableView<Person> personTableView;

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


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println(Main.getPersonList());
    }

}
