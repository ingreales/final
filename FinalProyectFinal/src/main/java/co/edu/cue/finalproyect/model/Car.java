package co.edu.cue.finalproyect.model;

import javafx.scene.image.ImageView;

public class Car {
/*    private ImageView linkImage;
    private final SimpleStringProperty brand;
    private final SimpleStringProperty name;
    private final SimpleStringProperty type;
    private final SimpleDoubleProperty price;

    public Car(ImageView linkImage, SimpleStringProperty brand, SimpleStringProperty name, SimpleStringProperty type, SimpleDoubleProperty price) {
        this.linkImage = linkImage;
        this.brand = brand;
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public ImageView getLinkImage() {
        return linkImage;
    }

    public void setLinkImage(ImageView linkImage) {
        this.linkImage = linkImage;
    }

    public String getBrand() {
        return brand.get();
    }

    public SimpleStringProperty brandProperty() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand.set(brand);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getType() {
        return type.get();
    }

    public SimpleStringProperty typeProperty() {
        return type;
    }

    public void setType(String type) {
        this.type.set(type);
    }

    public double getPrice() {
        return price.get();
    }

    public SimpleDoubleProperty priceProperty() {
        return price;
    }

    public void setPrice(double price) {
        this.price.set(price);
    }*/
     private ImageView linkImage;
    private String plate;
    private String name;
    private String type;
    private String ubication;

    private double price;
    private boolean state;
    private String model;
    private String  brand;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUbication() {
        return ubication;
    }

    public void setUbication(String ubication) {
        this.ubication = ubication;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public ImageView getLinkImage() {
        return linkImage;
    }

    public void setLinkImage(ImageView linkImage) {
        this.linkImage = linkImage;
    }



    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }


    public Car(ImageView linkImage, String plate, String name, String type, String ubication, double price, String model, String brand, boolean state) {
        this.linkImage = linkImage;
        this.plate = plate;
        this.name = name;
        this.type = type;
        this.ubication = ubication;
        this.price = price;
        this.model = model;
        this.brand = brand;
        this.state = state;
    }
    public Car(){
        super();
    }

}
