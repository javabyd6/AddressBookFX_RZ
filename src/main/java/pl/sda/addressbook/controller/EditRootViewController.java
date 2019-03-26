package pl.sda.addressbook.controller;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import pl.sda.addressbook.Main;
import pl.sda.addressbook.model.Person;

import java.io.IOException;
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

    private Main main;

    private Person selectedPerson;

    public void setMain(Main main) {
        this.main = main;
    }

    public void setSelectedPerson(Person selectedPerson) {
        this.selectedPerson = selectedPerson;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void initializeForm() {
        if(selectedPerson!=null) {
            nameLabel.setText(selectedPerson.getName());
            lastNameLabel.setText(selectedPerson.getLastname());
            addressLabel.setText(selectedPerson.getAddress());
            cityLabel.setText(selectedPerson.getCity());
            postalCodeLabel.setText(selectedPerson.getPostalCode());
            telephoneLabel.setText(selectedPerson.getTelephone());
        }
    }


    public void setSaveButton(MouseEvent mouseEvent) {
        Person person = new Person(nameLabel.getText(), lastNameLabel.getText(), addressLabel.getText(),
                                    postalCodeLabel.getText(), telephoneLabel.getText(), cityLabel.getText());

        main.getPersonList().set(main.getPersonList().indexOf(selectedPerson),person);
        Stage stage = (Stage) saveButton.getScene().getWindow();
        stage.close();
    }


    public void setCancelButton(MouseEvent mouseEvent) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

}
