package co.edu.cue.finalproyect.controller;

import co.edu.cue.finalproyect.HelloApplication;
import co.edu.cue.finalproyect.exceptions.Alert;
import co.edu.cue.finalproyect.exceptions.Excepcions;
import co.edu.cue.finalproyect.exceptions.Validations;
import co.edu.cue.finalproyect.model.Car;
import co.edu.cue.finalproyect.model.Client;
import co.edu.cue.finalproyect.persistence.carPersistence.Persistencia;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class CarTableViewController implements Initializable {
    Alert alert = new Alert();
    Validations validations = new Validations();
    ModelFactoryController mfc= ModelFactoryController.getInstance();
    private final  ObservableList<Car> data = FXCollections.observableArrayList();

    @FXML
    private TableColumn<?, ?> brand;

    @FXML
    private TableColumn<?, ?> name;

    @FXML
    private TableColumn<Car, String> photo;

    @FXML
    private TableColumn<?, ?> price;

    @FXML
    private TableView<Car> tableCar;

    @FXML
    private TableColumn<Car, ?> type;
    @FXML
    void turnOffList(ActionEvent event) throws IOException {
        HelloApplication.init(event);
    }

    @FXML
    void selectCar(ActionEvent event) throws IOException, Excepcions {
        mfc.carSelectTable(tableCar);
        validations.vacio(mfc.getCarSelectTable());
        skipLogin(event);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
        brand.setCellValueFactory(new PropertyValueFactory<>("brand"));
        photo.setCellValueFactory(new PropertyValueFactory<>("linkImage"));
        type.setCellValueFactory(new PropertyValueFactory<>("type"));
       // init();
         mfc.fillTable(data);
         tableCar.setItems(data);
        try {
            cargarTable();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }catch (NullPointerException e){
            alert.alertError("Lo sentimos los datos no se pudieron cargar","Error");
        }
    }
    public  void cargarTable() throws IOException {
        HashMap<String,Car> cars = Persistencia.loadClient();
        if(cars == null){
           // alert.alertError("Lo sentimos los datos no se pudieron cargar","Error");
        }else {
            for (Map.Entry<String, Car> car: cars.entrySet()) {
                data.add(car.getValue());
                editPropertis(car.getValue());
            }
            tableCar.setItems(data);
            tableCar.refresh();
        }
    }
    @FXML
    void skipLogin(ActionEvent event) throws IOException {
        Client client1 = mfc.getClient();
        System.out.println(client1.isCondition()+ client1.getName());
        if(client1.isCondition() ){
            HelloApplication.ViewLn(event);
        }else {
            HelloApplication.login(event);
        }
    }
    @FXML
    void editPropertis(Car car){
        car.getLinkImage().setFitHeight(120);
        car.getLinkImage().setFitWidth(120);

    }
}
