package pl.sda.addressbook.controller;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import pl.sda.addressbook.Main;
import pl.sda.addressbook.model.Person;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Remigiusz Zudzin
 */
public class EditRootViewController implements Initializable {

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

    public TextField getNameLabel() {
        return nameLabel;
    }

    public void setNameLabel(TextField nameLabel) {
        this.nameLabel = nameLabel;
    }

    public TextField getLastNameLabel() {
        return lastNameLabel;
    }

    public void setLastNameLabel(TextField lastNameLabel) {
        this.lastNameLabel = lastNameLabel;
    }

    public TextField getAddressLabel() {
        return addressLabel;
    }

    public void setAddressLabel(TextField addressLabel) {
        this.addressLabel = addressLabel;
    }

    public TextField getCityLabel() {
        return cityLabel;
    }

    public void setCityLabel(TextField cityLabel) {
        this.cityLabel = cityLabel;
    }

    public TextField getPostalCodeLabel() {
        return postalCodeLabel;
    }

    public void setPostalCodeLabel(TextField postalCodeLabel) {
        this.postalCodeLabel = postalCodeLabel;
    }

    public TextField getTelephoneLabel() {
        return telephoneLabel;
    }

    public void setTelephoneLabel(TextField telephoneLabel) {
        this.telephoneLabel = telephoneLabel;
    }

    public Button getSaveButton() {
        return saveButton;
    }

    public void setSaveButton(Button saveButton) {
        this.saveButton = saveButton;
    }

    public Button getCancelButton() {
        return cancelButton;
    }

    public void setCancelButton(Button cancelButton) {
        this.cancelButton = cancelButton;
    }

    private RootViewController rootViewController;

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

}
