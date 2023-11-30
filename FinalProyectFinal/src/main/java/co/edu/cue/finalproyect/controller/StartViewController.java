package co.edu.cue.finalproyect.controller;

import co.edu.cue.finalproyect.HelloApplication;
import co.edu.cue.finalproyect.exceptions.Alert;
import co.edu.cue.finalproyect.exceptions.Validations;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.concurrent.CompletableFuture;

public class StartViewController implements Initializable {
    Validations validations = new Validations();
    Alert alert = new Alert();
    boolean emphy;

    ModelFactoryController mfc =  ModelFactoryController.getInstance();
    ObservableList<String> citys = FXCollections.observableArrayList("Armenia","Bogota","Pereira");

    LocalDate dateSince;
    LocalDate dateUntil;
    String country;
    String city;

    @FXML
    private ChoiceBox<String> cityChoise;

    @FXML
    private DatePicker sinceDate;

    @FXML
    private DatePicker untilDate;
    @FXML
    private ChoiceBox<String> countryChoise;

    @FXML
    void loginAdmi(ActionEvent event) throws IOException {
        HelloApplication.login(event);
    }

    @FXML
    void searchResult(ActionEvent event) throws IOException {
        getData();
        if(!emphy){
            HelloApplication.tableV(event);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("initialize ");
        countryChoise.setValue("Colombia");
        cityChoise.setValue("Bogota");
        cityChoise.setItems(citys);
        CompletableFuture.runAsync(()-> {
            try {
                mfc.init();
            } catch (IOException e) {
                alert.alertError("No se puedo cargar los datos, por favor intentalo más tarde","Datos vacios");
                throw new RuntimeException("No se pudo cargar los datos");
            }
        });
    }

    public void getData(){
        dateSince = sinceDate.getValue();
        dateUntil = untilDate.getValue();
        emphy= validations.searchFull(String.valueOf(untilDate.getValue()),String.valueOf(sinceDate.getValue()));
        city = String.valueOf(cityChoise.getValue());
        country = String.valueOf(countryChoise.getValue());
        setDateLoan();
    }
    public void setDateLoan(){
        mfc.setDateLoan(dateUntil);
        mfc.setDeliveryLoan(dateSince);

    }

}
