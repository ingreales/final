package co.edu.cue.finalproyect.service.Impl;

import co.edu.cue.finalproyect.model.Car;
import co.edu.cue.finalproyect.persistence.carPersistence.Persistencia;
import co.edu.cue.finalproyect.service.CarService;
import javafx.collections.ObservableList;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.CompletableFuture;


public class CarServiceImpl implements CarService {
    Car carSelect= new Car();
    Car carSelectTable = new Car();
    HashMap<String,Car> carHashMap = new HashMap<>();

    public Car getCarSelectTable() {
        return carSelectTable;
    }


    public HashMap<String, Car> getCarHashMap() {
        return carHashMap;
    }

    public void create(String name, String type, String ubication, String plate, double price, String model,
                       String brand, TableView<Car> tableView, ImageView linkimage, String thumbUrl, boolean state,ObservableList carObservableList) throws IOException {
        Car car = new Car(linkimage,plate,name, type, ubication, price, model,brand, state);
        System.out.println(linkimage);
        carHashMap.put(plate,car);

        CompletableFuture.runAsync(()-> {
            try {
                Persistencia.saveClient(carHashMap);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        addTable(tableView,carObservableList,car);
    }
    public void addTable(TableView<Car> tableView,ObservableList carObservableList, Car car){
        carObservableList.add(car);
        tableView.setItems(carObservableList);
        tableView.refresh();
    }

    public void selectCar(TableView<Car> tblCar, TextField nameCar, TextField ubicationCar, TextField priceCar,TextField plateCar, ChoiceBox brandCar, ChoiceBox modelCar, ChoiceBox stateCar, ChoiceBox typeCar){
        carSelect = tblCar.getSelectionModel().getSelectedItem();
        fillInput(nameCar,ubicationCar,priceCar,plateCar,brandCar,modelCar,stateCar,typeCar);
    }

    public void carSelectTable(TableView<Car> tblCar){
         carSelectTable = tblCar.getSelectionModel().getSelectedItem();
    }
    public void search(TableView<Car> tblCar, String plate, TextField nameCar, TextField ubicationCar, TextField priceCar,TextField plateCar, ChoiceBox brandCar, ChoiceBox modelCar, ChoiceBox stateCar, ChoiceBox typeCar){
        for(Map.Entry<String, Car> entrada: carHashMap.entrySet()) {
            if(entrada.getKey().equals(plate)){
                selectCar(tblCar, nameCar, ubicationCar, priceCar, plateCar, brandCar, modelCar, stateCar, typeCar);
                tblCar.getSelectionModel().getSelectedItem();
                tblCar.refresh();
            }
        }
    }

    public void eliminate(TableView<Car> tblCar, ObservableList carObservableList){
        if(carSelect != null){
            carObservableList.remove(carSelect);
            carHashMap.remove(carSelect.getPlate());
            tblCar.refresh();
        }else{

        }
    }
    public void edit(Car car, TableView<Car> tblCar, ObservableList carObservableList){
        try {
            if(!carObservableList.contains(car)){
                editCar(car);
                editTable(car);
                tblCar.refresh();
            }

        }catch (NumberFormatException e){

        }catch (NullPointerException ex){

        }
    }
    public void editTable(Car car ){
       carSelect.setState(car.isState());
       carSelect.setBrand(car.getBrand());
       carSelect.setModel(car.getModel());
       carSelect.setLinkImage(car.getLinkImage());
       carSelect.setName(car.getName());
       carSelect.setType(car.getType());
       carSelect.setPlate(car.getPlate());
       carSelect.setUbication(car.getUbication());
       carSelect.setPrice(car.getPrice());
    }
    public void editCar(Car car){
        for(Map.Entry<String, Car> entrada: carHashMap.entrySet()) {
            if(entrada.getValue().equals(car)){
                entrada.getValue().setState(car.isState());
                entrada.getValue().setLinkImage(car.getLinkImage());
                entrada.getValue().setPrice(car.getPrice());
                entrada.getValue().setPlate(car.getPlate());
                entrada.getValue().setUbication(car.getUbication());
                entrada.getValue().setName(car.getName());
                entrada.getValue().setModel(car.getModel());
                entrada.getValue().setType(car.getType());
                entrada.getValue().setBrand(car.getBrand());
            }
        }
    }
    public void fillInput(TextField nameCar, TextField ubicationCar, TextField priceCar,TextField plateCar, ChoiceBox brandCar, ChoiceBox modelCar, ChoiceBox stateCar, ChoiceBox typeCar){
        nameCar.setText(String.valueOf(carSelect.getName()));
        ubicationCar.setText(String.valueOf(carSelect.getUbication()));
        priceCar.setText(String.valueOf(carSelect.getPrice()));
        plateCar.setText(String.valueOf(carSelect.getPlate()));
        brandCar.setValue(carSelect.getBrand());
        modelCar.setValue(carSelect.getModel());
        stateCar.setValue(carSelect.isState());
        typeCar.setValue(carSelect.getType());
    }

    public void fillTable(ObservableList<Car> observableList){
        //init();
        for (Map.Entry<String, Car> entrada: carHashMap.entrySet()) {
            observableList.add(entrada.getValue());
        }
    }

    // recorre por medio de un foreach
 /*   public void wander(){
        for(Map.Entry<String, Car> entrada: carHashMap.entrySet()) {
            String clave= entrada.getKey();
            Car car=entrada.getValue();
            System.out.println(car.getName());
        }
    }
    //recorre solo los valores
    public void wanderValue(){
        for (Car c : carHashMap.values()) {
            System.out.println(c.getName());
        }
    }
    //recorre solo los identificadores
    public void wanderKeySet(){
        for (String c : carHashMap.keySet()) {
            System.out.println(c);
        }
    }
    // Otra manera un poco igual de recorrer
    public void wander2(){
        for (String c: carHashMap.keySet()) {
            System.out.println("key: " + c + " value: " + carHashMap.get(c).getName());
        }
    }
    //funcion para cuando se seleccione ver por tipo

    //public int compare(Car o1, Car o2) {return  o1.getType().compareTo(o2.getType());}

    public void orden(){
        carArrayList.sort(new ComparatorCar());
    }

    //busca un carro por nombre
    public Stream<Car> searchArray(String plate){
        return carArrayList.stream()
                .filter(c-> plate.equalsIgnoreCase(c.getName()))
                .limit(1);
    }

    //retorna una lista con el DTOs
    public List<CarDTO> genereListDTOs(){
        return  carArrayList.stream()
                .map(c-> new CarDTO(c.getName(),c.getPrice()))
                .collect(Collectors.toList());
    }*/

}
