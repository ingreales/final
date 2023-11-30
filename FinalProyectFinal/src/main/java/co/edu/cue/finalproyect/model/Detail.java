package co.edu.cue.finalproyect.model;

import java.time.LocalDate;

public class Detail {

    private double price=0;
    private boolean chair;
    private  boolean porta;
    private String placeCollect;
    private String placeDelivery;
    private LocalDate dateLoan;
    private LocalDate deliveryLoan;
    private String countNumber;
    private String typeCount;
    private int days;

    public String getPlaceCollect() {
        return placeCollect;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isChair() {
        return chair;
    }

    public void setChair(boolean chair) {
        this.chair = chair;
    }

    public boolean isPorta() {
        return porta;
    }

    public void setPorta(boolean porta) {
        this.porta = porta;
    }

    public void setPlaceCollect(String placeCollect) {
        this.placeCollect = placeCollect;
    }

    public String getPlaceDelivery() {
        return placeDelivery;
    }

    public void setPlaceDelivery(String placeDelivery) {
        this.placeDelivery = placeDelivery;
    }

    public LocalDate getDateLoan() {
        return dateLoan;
    }

    public void setDateLoan(LocalDate dateLoan) {
        this.dateLoan = dateLoan;
    }

    public LocalDate getDeliveryLoan() {
        return deliveryLoan;
    }

    public void setDeliveryLoan(LocalDate deliveryLoan) {
        this.deliveryLoan = deliveryLoan;
    }

    public String getCountNumber() {
        return countNumber;
    }

    public void setCountNumber(String countNumber) {
        this.countNumber = countNumber;
    }

    public String getTypeCount() {
        return typeCount;
    }

    public void setTypeCount(String typeCount) {
        this.typeCount = typeCount;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public Detail(double price, boolean chair, boolean porta, String placeCollect, String placeDelivery, LocalDate dateLoan,
                  LocalDate deliveryLoan, String typeCount, String countNumber) {
        this.price = price;
        this.chair = chair;
        this.porta = porta;
        this.dateLoan = dateLoan;
        this.deliveryLoan = deliveryLoan;
        this.placeCollect = placeCollect;
        this.placeDelivery = placeDelivery;
        this.typeCount = typeCount;
        this.countNumber  = countNumber;
        day();
        additionPrice();
    }
    public void day(){
        System.out.println(price);
        System.out.println(deliveryLoan.getDayOfYear());
        System.out.println(deliveryLoan.hashCode());
         days = ((dateLoan.getDayOfYear()-deliveryLoan.getDayOfYear()));
         System.out.println(days);
         price*=days;
    }
    public  void additionPrice(){
        if(chair && porta){
            price+=75000;
        } else if (chair) {
            price+=50000;
        } else if (porta) {
            price+=25000;
        }
    }
}
