package co.edu.cue.finalproyect.controller;

import co.edu.cue.finalproyect.HelloApplication;
import co.edu.cue.finalproyect.exceptions.Alert;
import co.edu.cue.finalproyect.exceptions.Validations;
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

public class LoginUserViewController implements Initializable {
    Client client = new Client();
    Alert alert = new Alert();
    Validations validations = new Validations();
    ModelFactoryController mf = ModelFactoryController.getInstance();
    ObservableList<String> genderList = FXCollections.observableArrayList("Femenino", "Masculino", "No especifica");
    ObservableList<String> countryList = FXCollections.observableArrayList("Colombia", "Argentina", "Estados Unidos", "Peru", "Francia", "Italia");
    String name;
    String password;
    String id;
    String cell;
    String gender;
    String code;
    String direction;
    String gmail;

    @FXML
    private PasswordField comprobePass;
    @FXML
    private TextField ccUser;

    @FXML
    private TextField cellUser;

    @FXML
    private ChoiceBox<String> codeCountry;

    @FXML
    private TextField directionUser;

    @FXML
    private TextField emailUser;

    @FXML
    private ChoiceBox<String> genderUser;

    @FXML
    private TextField nameUser;

    @FXML
    private PasswordField pasLogin;

    @FXML
    private TextField passUserRegis;

    @FXML
    private TextField userLogin;

    @FXML
    void backTable(ActionEvent event) throws IOException {
        HelloApplication.tableV(event);
    }

    @FXML
    void backTableRes(ActionEvent event) throws IOException {
        HelloApplication.tableV(event);
    }

    @FXML
    void login(ActionEvent event) throws IOException {
        Boolean user = mf.login(userLogin.getText(), pasLogin.getText(), mf.getArrayList());
        System.out.println(userLogin.getText());
        Boolean admi = mf.loginAdmi(userLogin.getText(), pasLogin.getText(), mf.getAdministrativeArrayList());
        System.out.println("ADMISTRADORRR LOGIN" + userLogin.getText());
        if (user) {
            mf.identi(pasLogin.getText());
            HelloApplication.ViewLn(event);
        } else if (admi) {
            HelloApplication.menu(event);
        } else {
            alert.alertError("Por favor verifique sus datos de inicio", "Datos incorrectos");
        }
    }


    @FXML
    void register(ActionEvent event) throws IOException {
        Boolean user = mf.comprobationPassword(passUserRegis.getText(), comprobePass.getText());
        if (user) {
            getData();
            mf.createClient(name, id, cell, gender, gmail, password, direction, code);
            setData();
        } else System.out.println("no es");
    }

    @FXML
    void getData() {
        name = String.valueOf(nameUser.getText());
        id = String.valueOf(ccUser.getText());
        cell = String.valueOf(cellUser.getText());
        gender = String.valueOf(genderUser.getValue());
        gmail = String.valueOf(emailUser.getText());
        password = String.valueOf(passUserRegis.getText());
        direction = String.valueOf(directionUser.getText());
        code = String.valueOf(codeCountry.getValue());
        validations.emptyRegis(name, id, cell, gender, gmail, password, direction, code);
        loadClient();
    }

    void loadClient() {
        client.setUser(gmail);
        client.setName(name);
        client.setPassword(password);
        client.setGender(gender);
        client.setCellphone(cell);
        client.setCondition(true);
        client.setId(id);
        client.setLocation(code);
        client.setDirection(direction);
        mf.setClient(client);
    }

    @FXML
    void setData() {
        nameUser.setText("");
        ccUser.setText("");
        cellUser.setText("");
        genderUser.setValue("");
        emailUser.setText("");
        passUserRegis.setText("");
        directionUser.setText("");
        codeCountry.setValue("+57");
        comprobePass.setText("");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        genderUser.setItems(genderList);
        codeCountry.setValue("Colombia");
        codeCountry.setItems(countryList);
    }
}

