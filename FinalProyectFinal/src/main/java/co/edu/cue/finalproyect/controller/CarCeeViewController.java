package co.edu.cue.finalproyect.controller;

import co.edu.cue.finalproyect.HelloApplication;
import co.edu.cue.finalproyect.exceptions.Alert;
import co.edu.cue.finalproyect.model.Car;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

public class CarCeeViewController implements Initializable {
    ModelFactoryController mfc= ModelFactoryController.getInstance();
    ObservableList<Car> carObservableList = FXCollections.observableArrayList();
    ObservableList<String> typeCars = FXCollections.observableArrayList("Camioneta","Deportivo","Automovil","Campero","Sedan","Hatchback");
    ObservableList<String> modelCars = FXCollections.observableArrayList("Sandero","Picanto kwid");
    ObservableList<String> brandCars = FXCollections.observableArrayList("Mercedes","Kia","Chevrolet","Ford");
    ObservableList<String> stateCars = FXCollections.observableArrayList("Disponible","No Disponible");
    private  String name;
    private String type;
    private String ubication;
    private String brand;
    private double price;
    private String model;
    private String plate;
    private ImageView linkImage;
    private  Image imgLoad;
   private String thumbUrl;
   private  boolean state;


    @FXML
    private ChoiceBox<String> brandCar;

    @FXML
    private TableColumn<?, ?> brandTable;

    @FXML
    private TableColumn<?, ?> fotoTable;

    @FXML
    private ImageView imageCar;

    @FXML
    private ChoiceBox<String> modelCar;

    @FXML
    private TableColumn<?, ?> modelTable;

    @FXML
    private TextField nameCar;

    @FXML
    private TableColumn<?, ?> nameTable;

    @FXML
    private TextField plateCar;

    @FXML
    private TableColumn<?, ?> plateTable;

    @FXML
    private TextField priceCar;

    @FXML
    private ChoiceBox<String> typeCar;

    @FXML
    private TableColumn<?, ?> typeTable;

    @FXML
    private TextField ubicationCar;

    @FXML
    private TableColumn<?, ?> ubicationTable;

    @FXML
    private TableView<Car> tableCar;

    @FXML
    private TableColumn<?, ?> priceTable;
    @FXML
    private ChoiceBox<String> stateChoise;
    @FXML
    private TextField searchPlate;
    Alert alert = new Alert();
    @FXML
    void turnOfTable(ActionEvent event) throws IOException {
        HelloApplication.menu(event);
    }

    @FXML
    void search(ActionEvent event) {
        mfc.search(tableCar,String.valueOf(this.searchPlate.getText()),nameCar, ubicationCar, priceCar, plateCar, brandCar, modelCar, stateChoise, typeCar);
    }

    @FXML
    void addImage(ActionEvent event) {
        final FileChooser fileChooser = new FileChooser();
        File file =  fileChooser.showOpenDialog(new Stage());
           try{
                if(file.getName().contains(".jpg") || file.getName().contains(".png")){
                    thumbUrl = file.toURI().toURL().toString();
                    System.out.println(file.toURI().toURL().toString());
                    imgLoad = new Image(thumbUrl);
                    System.out.println(thumbUrl);
                    imageCar.setImage(imgLoad);
                }
           } catch (MalformedURLException e) {
               throw new RuntimeException(e);
           }
    }
    @FXML
    void editPropertis(){
        linkImage.setFitHeight(120);
        linkImage.setFitWidth(120);

    }
    @FXML
    void createCar(ActionEvent event) throws IOException {
        System.out.println("crear");
        getData();
        mfc.createCar(name,type,ubication,plate,price,model,brand,tableCar,linkImage,thumbUrl,state,carObservableList);
        alert.alertAT("Se ha creado correctamente","Nuevo Carro");
    }

    @FXML
    void editCar(ActionEvent event) {
        getData();
        Car car = new Car(linkImage,plate,name,type,ubication,price,model,brand,state);
        mfc.edit(car,tableCar,carObservableList);
    }

    @FXML
    void eliminateCar(ActionEvent event) {
        mfc.eliminate(tableCar,carObservableList);
    }

    @FXML
    void removeImage(ActionEvent event) {
        imageCar.setImage(null);
    }

    @FXML
    void selectCar(ActionEvent event) {
          mfc.select(tableCar,nameCar,ubicationCar,priceCar,plateCar,brandCar,modelCar,stateChoise,typeCar);
    }
    @FXML
    void getData(){
        name = String.valueOf(this.nameCar.getText());
        type = String.valueOf(this.typeCar.getValue());
        price =  Double.parseDouble(this.priceCar.getText());
        brand = String.valueOf(this.brandCar.getValue());
        plate = String.valueOf(this.plateCar.getText());
        ubication = String.valueOf(this.ubicationCar.getText());
        model = String.valueOf(this.modelCar.getValue());
        linkImage = new ImageView(this.imageCar.getImage());
        state = getStateChoise();
        editPropertis();
    }
    @FXML
    boolean getStateChoise(){
        return String.valueOf(this.stateChoise.getValue()).equals("Disponible") ? true : false;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nameTable.setCellValueFactory(new PropertyValueFactory<>("name"));
        typeTable.setCellValueFactory(new PropertyValueFactory<>("type"));
        priceTable.setCellValueFactory(new PropertyValueFactory<>("price"));
        brandTable.setCellValueFactory(new PropertyValueFactory<>("brand"));
        plateTable.setCellValueFactory(new PropertyValueFactory<>("plate"));
        ubicationTable.setCellValueFactory(new PropertyValueFactory<>("ubication"));
        modelTable.setCellValueFactory(new PropertyValueFactory<>("model"));
        fotoTable.setCellValueFactory(new PropertyValueFactory<>("linkImage"));
        stateChoise.setValue("Disponible");
        stateChoise.setItems(stateCars);
        typeCar.setValue("Camioneta");
        typeCar.setItems(typeCars);
        modelCar.setValue("Sandero");
        modelCar.setItems(modelCars);
        brandCar.setValue("Kia");
        brandCar.setItems(brandCars);
    }

}
