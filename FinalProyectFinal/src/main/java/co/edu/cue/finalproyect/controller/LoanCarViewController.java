package co.edu.cue.finalproyect.controller;

import co.edu.cue.finalproyect.HelloApplication;
import co.edu.cue.finalproyect.model.Car;
import co.edu.cue.finalproyect.model.Client;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.css.FontCssMetaData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoanCarViewController implements Initializable {
     private boolean chair;
    private boolean porta;
    private String countType;
    private String Aplate;
    private String Bplate;
    private String countNumbrer;

    ModelFactoryController mfc= ModelFactoryController.getInstance();
    ObservableList<String> placeAObservable = FXCollections.observableArrayList("Aeropuerto","Centro de atención","Terminal");
    ObservableList<String> placeBObservable = FXCollections.observableArrayList("Aeropuerto","Centro de atención","Terminal");
    ObservableList<String> typeCObservable = FXCollections.observableArrayList("Credito","Debito","PSE");

    @FXML
    private Label brandCar;

    @FXML
    private Label idUser;

    @FXML
    private ImageView imageCar;

    @FXML
    private Label nameCar;

    @FXML
    private Label nameUser;

    @FXML
    private TextField numberCount;

    @FXML
    private Label priceCar;

    @FXML
    void returnSelect(ActionEvent event) throws IOException {
       HelloApplication.tableV(event);
    }

    @FXML
    private ChoiceBox<String> typeCount;
    @FXML
    private ChoiceBox<String> placeAChoisebox;

    @FXML
    private ChoiceBox<String> placeBChoisebox;

    @FXML
    private CheckBox checkBabyChair;

    @FXML
    private CheckBox checkBicycleCarrier;
    @FXML
    void editUser(ActionEvent event) throws IOException {
        HelloApplication.user(event);
    }

    @FXML
    void readyLoan(ActionEvent event) throws IOException {
        getData();
        mfc.createLoan(mfc.getClient(),mfc.getCarSelectTable(),chair,porta,Aplate,Bplate,countType,countNumbrer);
        HelloApplication.invoice(event);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        placeAChoisebox.setItems(placeAObservable);
        placeBChoisebox.setItems(placeBObservable);
        typeCount.setItems(typeCObservable);
        setLabel();
    }
    public void setLabel(){
        Car car = mfc.getCarSelectTable();
        Client client = mfc.getClient();
        nameUser.setText(client.getName());
        idUser.setText(client.getId());
        nameCar.setText(car.getName());
        imageCar.setImage(car.getLinkImage().getImage());
        priceCar.setText(String.valueOf(car.getPrice()));
        brandCar.setText(car.getBrand());
    }
    public void getData(){
        Aplate = String.valueOf(placeAChoisebox.getValue());
        Bplate = String.valueOf(placeBChoisebox.getValue());
        countNumbrer = String.valueOf(numberCount.getText());
        countType =  String.valueOf(typeCount.getValue());
        chair = checkBabyChair.isSelected();
        porta = checkBicycleCarrier.isSelected();
    }

}
