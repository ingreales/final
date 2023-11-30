package co.edu.cue.finalproyect.controller;

import co.edu.cue.finalproyect.HelloApplication;
import co.edu.cue.finalproyect.model.ClientDTO;
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
import java.util.List;
import java.util.ResourceBundle;

public class ListUserViewController implements Initializable {
    ObservableList<ClientDTO> userObservableList= FXCollections.observableArrayList();
    ModelFactoryController mfc= ModelFactoryController.getInstance();


    @FXML
    private TableColumn<?, ?> cellphoneUser;



    @FXML
    private TableColumn<?, ?> idUser;

    @FXML
    private TableColumn<?, ?> nameUser;

    @FXML
    private TableView<ClientDTO> tableUser;

    @FXML
    void back(ActionEvent event) throws IOException {
        HelloApplication.cee(event);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nameUser.setCellValueFactory(new PropertyValueFactory<>("name"));
        idUser.setCellValueFactory(new PropertyValueFactory<>("id"));
        cellphoneUser.setCellValueFactory(new PropertyValueFactory<>("cellphone"));
        load();
        tableUser.setItems(userObservableList);
    }
    public void load(){
        try{
            List<ClientDTO> list = mfc.genereListDTOs();
            System.out.println(list.size());
            for (ClientDTO cli: list) {
                System.out.println(cli.getName());
                userObservableList.add(cli);
            }
        }catch (ClassCastException e){

        }
    }
}

