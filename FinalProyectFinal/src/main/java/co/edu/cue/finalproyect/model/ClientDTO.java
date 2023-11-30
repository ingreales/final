package co.edu.cue.finalproyect.model;

public class ClientDTO {
    String name;
    String id;
   // String location;
    String cellphone;

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

    public ClientDTO(String name, String id, String cellphone) {
        this.name = name;
        this.id = id;
        this.cellphone = cellphone;
       // this.location = location;
    }

}
