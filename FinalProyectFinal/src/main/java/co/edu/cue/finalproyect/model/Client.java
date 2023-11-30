package co.edu.cue.finalproyect.model;

public class Client extends Person {
    private  String direction;
    private String location;

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Client(String name, String id, String cellphone, String gender, String user, String password, String direction, String location, boolean condition) {
        super(name, id, cellphone, gender, user, password,condition);
        this.direction = direction;
        this.location = location;
    }

    public Client() {
        super();
    }
}
