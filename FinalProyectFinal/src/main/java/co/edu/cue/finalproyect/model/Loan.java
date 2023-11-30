package co.edu.cue.finalproyect.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Loan {
     private Client debtorName;
     private Car car;
     Detail detail;

    public Loan() {

    }

     public Client getDebtorName() {
          return debtorName;
     }

     public void setDebtorName(Client debtorName) {
          this.debtorName = debtorName;
     }


     public Car getCar() {
          return car;
     }

     public void setCar(Car car) {
          this.car = car;
     }

     public Detail getDetail() {
          return detail;
     }

     public void setDetail(Detail detail) {
          this.detail = detail;
     }

     public Loan(Client debtorName, Car car, Detail detail) {
          this.debtorName = debtorName;
          this.car = car;
          this.detail = detail;
     }
}
