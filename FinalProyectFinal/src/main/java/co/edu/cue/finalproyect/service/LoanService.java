package co.edu.cue.finalproyect.service;

import co.edu.cue.finalproyect.model.*;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

import java.time.LocalDate;
import java.util.List;

public interface LoanService {
    List<LoanDTO> genereDTO();
    void createLoan(Client debtorName, Car car, boolean chair, boolean porta, String placeCollected,
                    String plateDelivery,String typeCount, String countNumber);
    void eliminateLoan(TableView<LoanDTO> tblLoan, ObservableList<LoanDTO> observableList);
    void select(TableView<LoanDTO> tblLoan);
    void setDeliveryLoan(LocalDate deliveryLoan);
    void setDateLoan(LocalDate dateLoan);
    Loan getLoan();
    void initLoan();
}