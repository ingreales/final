package co.edu.cue.finalproyect.controller;

import co.edu.cue.finalproyect.HelloApplication;
import co.edu.cue.finalproyect.model.Client;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UserViewController implements Initializable {
    ModelFactoryController mfc= ModelFactoryController.getInstance();
    ObservableList<String> genderList = FXCollections.observableArrayList("Femenino","Masculino","No especifica");
    private String nameU;
    private String cellphoneU;
    private String genderU;
    private String userU;
    private String passwordU;


    @FXML
    private TextField cellphone;

    @FXML
    private TextField country;

    @FXML
    private TextField email;

    @FXML
    private ChoiceBox<String> gender;

    @FXML
    private TextField name;

    @FXML
    private PasswordField password;
    @FXML
    void backLoan(ActionEvent event) throws IOException {
        HelloApplication.ViewLn(event);
    }

    @FXML
    void saveInformation(ActionEvent event) throws IOException {
        getData();
        mfc.editClient(nameU,genderU,cellphoneU,userU,passwordU);
        HelloApplication.ViewLn(event);
    }
    void getData(){
        genderU = String.valueOf(gender.getValue());
        nameU = String.valueOf(name.getText());
        cellphoneU = String.valueOf(cellphone.getText());
        userU = String.valueOf(email.getText());
        passwordU = String.valueOf(password.getText());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        gender.setItems(genderList);
        Client client = mfc.getClient();
        name.setText(client.getName());

    }
}


