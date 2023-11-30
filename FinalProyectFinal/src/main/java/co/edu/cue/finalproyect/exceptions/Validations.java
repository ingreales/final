package co.edu.cue.finalproyect.exceptions;

import co.edu.cue.finalproyect.model.Car;

public class Validations {
    Alert alert = new Alert();
    public   void isNumInteger(String name) throws Excepcions {
        try
        {
            Integer.parseInt(name);

        }
        catch (NumberFormatException nfe)
        {
            throw  new Excepcions("Debe ingresar caracteres solamente");
        }
    }
    public boolean isString(Integer num){
        try {
            Integer.parseInt(String.valueOf(num));
            return false;
        }catch (NumberFormatException err){
            return true;
        }
    }
    public boolean searchFull(String valid, String valid2){
        System.out.println(valid);
        if(valid == "null" || valid2 == "null"){
            alert.alertError("Debe llenar ambas fechas","Datos vacios");
            return true;
        }
        return false;
    }
    public void vacio(Car car) throws Excepcions {
        try {
            if(!car.equals(null)){
                System.out.println("esta seleccionado");
            }
        }catch (NullPointerException e){
            alert.alertError("Debe tener un elemento seleccionado","Sin seleccion");
            throw  new Excepcions("Debe tener un elemento seleccionado");
        }
    }
    public void emptyRegis(String name, String id, String  cell,String gender, String gmail, String pass, String dire, String code){
        try {
            if(name != "null" ||  id !="null" || cell != "null" || gender != "null" || gmail != "null" || pass != dire || code != "null"){
                alert.alertAT("El proceso se realizo de manera exitosa","Exitoso");
            }
        }catch (NullPointerException e){
            alert.alertError("Tienes que llenar todos los datos","Datos vacios");
        }

    }
}
