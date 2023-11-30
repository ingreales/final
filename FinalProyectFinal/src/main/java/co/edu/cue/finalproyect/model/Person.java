package co.edu.cue.finalproyect.model;

public class Person {
    private String name;
    private String id;
    private String cellphone;
    private String gender;
    private String user;
    private String password;

    private boolean condition;

    public Person() {

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isCondition() {
        return condition;
    }

    public void setCondition(boolean condition) {
        this.condition = condition;
    }

    public Person(String name, String id, String cellphone, String gender, String user, String password, boolean state) {
        this.name = name;
        this.id = id;
        this.cellphone = cellphone;
        this.gender = gender;
        this.user = user;
        this.password = password;
        this.condition = state;
    }
}
