package co.edu.cue.finalproyect.service.Impl;

import co.edu.cue.finalproyect.model.*;
import co.edu.cue.finalproyect.persistence.loanPersistence.PersistenceLoan;
import co.edu.cue.finalproyect.service.LoanService;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class LoanServiceImpl implements LoanService {
    Loan loan = new Loan();
    Loan loanselect = new Loan();
    LoanDTO loanDtoSelect = new LoanDTO();
    ArrayList<Loan> loanList = new ArrayList<>();
    LocalDate dateLoan;
    LocalDate deliveryLoan;

    public Loan getLoan() {
        return loan;
    }

    public LoanDTO getLoanDtoSelect() {
        return loanDtoSelect;
    }

    public ArrayList<Loan> getLoanList() {
        return loanList;
    }


    public void setDateLoan(LocalDate dateLoan) {
        this.dateLoan = dateLoan;
    }

    public void setDeliveryLoan(LocalDate deliveryLoan) {
        this.deliveryLoan = deliveryLoan;
    }

    public  void createLoan(Client debtorName, Car car, boolean chair, boolean porta, String placeCollected,
                            String plateDelivery, String typeCount, String countNumber){
        Detail detail = new Detail(car.getPrice(), chair,porta,placeCollected,placeCollected,dateLoan,deliveryLoan, typeCount,countNumber);
        loan = new Loan(debtorName, car, detail);
        loanList.add(loan);
       CompletableFuture.runAsync(()-> {
           try {
               PersistenceLoan.saveLoan(loanList);
           } catch (IOException e) {
               throw new RuntimeException(e);
           }
       });
    }
    public void initLoan(){
        CompletableFuture.runAsync(()->{
            try {
                loanList = PersistenceLoan.loadLoan();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
    public void select(TableView<LoanDTO> tblLoan){
       loanDtoSelect = tblLoan.getSelectionModel().getSelectedItem();
       searchLoan();
    }
    public void searchLoan(){
        for (Loan ln: loanList) {
            if(ln.getDebtorName().getName().equals(loanDtoSelect.getNameUser()) && ln.getCar().getName().equals(loanDtoSelect.getCarName())){
                loanselect = ln;
            }
        }
    }
    public void eliminateLoan(TableView<LoanDTO> tblLoan,ObservableList<LoanDTO> observableList){
        if(loanselect != (null)){
            loanList.remove(loanselect);
            observableList.remove(loanDtoSelect);
            tblLoan.refresh();
        }
    }
    public List<LoanDTO> genereDTO(){
        System.out.println(loanList.size());
      return  loanList.stream()
              .map(l -> new LoanDTO(l.getCar().getPrice(),l.getCar().getPlate(),l.getDetail().getDateLoan(), l.getDetail().getDeliveryLoan(), l.getDebtorName().getName(),l.getCar().getName()))
              .collect(Collectors.toList());
    }

}
