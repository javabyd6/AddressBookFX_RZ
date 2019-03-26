package pl.sda.addressbook.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Remigiusz Zudzin
 */
public class Person {

    private StringProperty name;
    private StringProperty lastname;
    private StringProperty address;
    private StringProperty postalCode;
    private StringProperty telephone;
    private StringProperty city;

    public Person(String name, String lastname, String address, String postalCode, String telephone, String city) {

        this.name = new SimpleStringProperty(name);
        this.lastname = new SimpleStringProperty(lastname);
        this.address = new SimpleStringProperty(address);
        this.postalCode = new SimpleStringProperty(postalCode);
        this.telephone = new SimpleStringProperty(telephone);
        this.city = new SimpleStringProperty(city);

    }

    public static void toJSON(String filename, List<Person> people) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            String JsonString = mapper.writeValueAsString(people);
            Files.write(Paths.get(filename), JsonString.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ObservableList<Person> fromJSON (File file) {
        ObjectMapper mapper = new ObjectMapper();

        ObservableList<Person> output = FXCollections.observableArrayList();
        List<Person> list = new ArrayList<>();

        output.addAll(list);
        return output;
    }

    public static List<Person> readListFromJSON(File file) {
        ObjectMapper mapper = new ObjectMapper();
        List<Person> output = new ArrayList<>();
        Person[] outArray;

        try {
            outArray = mapper.readValue(file, Person[].class);
            output = Arrays.asList(outArray);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return output;

    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getLastname() {
        return lastname.get();
    }

    public StringProperty lastnameProperty() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname.set(lastname);
    }

    public String getAddress() {
        return address.get();
    }

    public StringProperty addressProperty() {
        return address;
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    public String getPostalCode() {
        return postalCode.get();
    }

    public StringProperty postalCodeProperty() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode.set(postalCode);
    }

    public String getTelephone() {
        return telephone.get();
    }

    public StringProperty telephoneProperty() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone.set(telephone);
    }

    public String getCity() {
        return city.get();
    }

    public StringProperty cityProperty() {
        return city;
    }

    public void setCity(String city) {
        this.city.set(city);
    }
}
