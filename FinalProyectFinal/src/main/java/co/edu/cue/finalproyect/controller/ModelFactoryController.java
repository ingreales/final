package co.edu.cue.finalproyect.controller;

import co.edu.cue.finalproyect.model.*;
import co.edu.cue.finalproyect.service.Impl.RentCarServiceImpl;
import co.edu.cue.finalproyect.service.ModelFactoryControllerService;
import javafx.collections.ObservableList;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class ModelFactoryController implements ModelFactoryControllerService {
        RentCarServiceImpl rentCarService;
        private static class SingletonHolder {
            // El constructor de Singleton puede ser llamado desde aquí al ser protected
            private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
        }

        // Método para obtener la instancia de nuestra clase
        public static ModelFactoryController getInstance() {
            return SingletonHolder.eINSTANCE;
        }

        public ModelFactoryController() {
            System.out.println("invocación clase singleton");
            rentCarService = new RentCarServiceImpl();
        }
        public  ArrayList<Client> getArrayList(){
           return rentCarService.getPersonService().getArrayList();

        }
        public HashMap<String,Car> getHashMap(){
            return rentCarService.getCarService().getCarHashMap();
        }
        public void init () throws IOException {
            System.out.println("mfc llamado");
            rentCarService.getPersonService().init();
        }
        public void createCar(String name, String type, String ubication, String plate, double price, String model,
                              String brand, TableView<Car> tableView, ImageView linkImage, String thumbUrl, boolean state,ObservableList carObservableList) throws IOException {
            rentCarService.getCarService().create(name, type, ubication, plate, price, model, brand,tableView,linkImage,thumbUrl, state,carObservableList);
        }
        public Boolean login(String userRegis, String passwordRegis, ArrayList<Client> arrayList){
            return rentCarService.getLoginService().login(userRegis, passwordRegis, arrayList);
        }
        public Boolean comprobationPassword(String pass, String pass2){
            return rentCarService.getLoginService().comprobationPassword(pass, pass2);
        }
        public Boolean loginAdmi (String userRegis, String passwordRegis, ArrayList<Administrative> arrayList){
            return rentCarService.getLoginService().loginAdmi(userRegis, passwordRegis, arrayList);
        }
        public void createClient(String name, String id, String cellphone, String gender, String user, String password, String direction, String location) throws IOException {
            rentCarService.getPersonService().createClient(name, id, cellphone, gender, user, password, direction, location);
        }

        public void  select(TableView<Car> tblCar, TextField nameCar, TextField ubicationCar, TextField priceCar, TextField plateCar, ChoiceBox brandCar, ChoiceBox modelCar, ChoiceBox stateCar, ChoiceBox typeCar){
             rentCarService.getCarService().selectCar(tblCar, nameCar, ubicationCar, priceCar, plateCar, brandCar, modelCar, stateCar, typeCar);
        }
        public void edit(Car car, TableView<Car> tblCar,ObservableList carObservableList){
            rentCarService.getCarService().edit(car,tblCar,carObservableList);
        }
        public void carSelectTable(TableView<Car> tblCar){
            rentCarService.getCarService().carSelectTable(tblCar);
        }
        public Car getCarSelectTable(){
            return rentCarService.getCarService().getCarSelectTable();
        }
        public void eliminate(TableView<Car> tblCar, ObservableList carObservableList){
            rentCarService.getCarService().eliminate(tblCar,carObservableList);
        }
        public  void search(TableView<Car> tblCar, String plate, TextField nameCar, TextField ubicationCar, TextField priceCar,TextField plateCar, ChoiceBox brandCar, ChoiceBox modelCar, ChoiceBox stateCar, ChoiceBox typeCar){
            rentCarService.getCarService().search(tblCar, plate, nameCar, ubicationCar, priceCar, plateCar, brandCar, modelCar, stateCar, typeCar);
        }
        public void editClient(String name, String gender,String cellphone, String email, String password){
            rentCarService.getPersonService().editClient(name, gender, cellphone, email, password);
        }
        public void setClient(Client client){
            rentCarService.getPersonService().setClient(client);
        }
        public void identi(String pass){
            rentCarService.getPersonService().identi(pass);
        }
        public Client getClient(){
            return rentCarService.getPersonService().getClient();
        }
        public void fillTable(ObservableList<Car> observableList){
             rentCarService.getCarService().fillTable(observableList);
        }
        public List<ClientDTO> genereListDTOs(){
            return rentCarService.getPersonService().genereListDTOs();
        }
        public void createLoan(Client debtorName,  Car car, boolean chair, boolean porta,String placeCollected,
                               String plateDelivery,String typeCount, String countNumber){
            rentCarService.getLoanService().createLoan(debtorName,car,chair,porta,placeCollected,plateDelivery,typeCount,countNumber);
        }
        public List<LoanDTO> genereDTO(){
            return rentCarService.getLoanService().genereDTO();
        }
        public void selectLoan(TableView<LoanDTO> tblLoan){
            rentCarService.getLoanService().select(tblLoan);
        }
        public void eliminateLoan(TableView<LoanDTO> tblLoan,ObservableList<LoanDTO> observableList){
            rentCarService.getLoanService().eliminateLoan(tblLoan, observableList);
        }
        public ArrayList<Administrative> getAdministrativeArrayList(){
            return rentCarService.getPersonService().getAdministrativeArrayList();
        }
        public void setDateLoan(LocalDate dateLoan){
            rentCarService.getLoanService().setDateLoan(dateLoan);
        }
        public void setDeliveryLoan(LocalDate deliveryLoan){
            rentCarService.getLoanService().setDeliveryLoan(deliveryLoan);
        }
        public Loan getLoan(){
            return rentCarService.getLoanService().getLoan();
        }
        public void initLoan(){
            rentCarService.getLoanService().initLoan();
        }
}
