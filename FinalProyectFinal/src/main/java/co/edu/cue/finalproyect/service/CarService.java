package co.edu.cue.finalproyect.service;

import co.edu.cue.finalproyect.model.Car;
import javafx.collections.ObservableList;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.util.HashMap;

public interface CarService {
    public void create(String name, String type, String ubication, String plate, double price, String model,
                       String brand, TableView<Car> tableView, ImageView linkImage, String thumbUrl, boolean state, ObservableList carObservableList) throws IOException;
    void  selectCar(TableView<Car> tblCar, TextField nameCar, TextField ubicationCar, TextField priceCar, TextField plateCar, ChoiceBox brandCar, ChoiceBox modelCar, ChoiceBox stateCar, ChoiceBox typeCar);
    void carSelectTable(TableView<Car> tblCar);
    Car getCarSelectTable();
    HashMap<String, Car> getCarHashMap();
    void edit(Car car, TableView<Car> tblCar,ObservableList carObservableList);
    void eliminate(TableView<Car> tblCar,ObservableList carObservableList);
    void search(TableView<Car> tblCar, String plate, TextField nameCar, TextField ubicationCar,
                TextField priceCar,TextField plateCar, ChoiceBox brandCar, ChoiceBox modelCar, ChoiceBox stateCar, ChoiceBox typeCar);
    void fillTable(ObservableList<Car> observableList);
}
