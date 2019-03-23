package pl.sda.addressbook.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pl.sda.addressbook.Main;
import pl.sda.addressbook.model.Person;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Remigiusz Zudzin
 */
public class AddNewPersonRootViewController implements Initializable {

    @FXML
    private TextField nameLabel;

    @FXML
    private TextField lastNameLabel;

    @FXML
    private TextField addressLabel;

    @FXML
    private TextField cityLabel;

    @FXML
    private TextField postalCodeLabel;

    @FXML
    private TextField telephoneLabel;

    @FXML
    private Button saveButton;

    @FXML
    private Button cancelButton;

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

    public void setSaveButton() throws IOException {
        Person person = createNewPerson();
        main.getPersonList().add(person);
        Stage stage = (Stage) saveButton.getScene().getWindow();
        stage.close();
    }

    private Person createNewPerson() {

        String name = nameLabel.getText();
        String lastName = lastNameLabel.getText();
        String address = addressLabel.getText();
        String postalCode = postalCodeLabel.getText();
        String telephoneNumber = telephoneLabel.getText();
        String city = cityLabel.getText();

        return new Person(name, lastName, address, postalCode, telephoneNumber, city);

    }

    public void setCancelButton() {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }


}
