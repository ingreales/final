package co.edu.cue.finalproyect.service.Impl;

import co.edu.cue.finalproyect.exceptions.Alert;
import co.edu.cue.finalproyect.model.Administrative;
import co.edu.cue.finalproyect.model.Client;
import co.edu.cue.finalproyect.service.LoginService;

import java.util.ArrayList;

public class LoginServiceImpl implements LoginService {
    Alert alert = new Alert();
    ArrayList<Client> arrayList = new ArrayList<>();
    ArrayList<Administrative> arrayListAdmi = new ArrayList<>();

    // @Override
    public Boolean login(String userRegis, String passwordRegis, ArrayList<Client> arrayList){
        this.arrayList = arrayList;
        boolean pass = validatePass(passwordRegis);
        boolean us = validateUser(userRegis);
        aler(pass,us);
        return (pass == true && us == true) ? true : false;
    }
    public Boolean validatePass(String passwordRegis){
        for (Client person:arrayList) {
            return person.getPassword().equals(passwordRegis) ? true: false;
        }
        return false;
    }
    public Boolean validateUser(String userRegis){
        for (Client person: arrayList) {
            return  person.getUser().equals(userRegis) ? true : false;
        }
        return false;
    }
    public void aler(boolean pass, boolean us){
        if (!pass && us){
            alert.alertError("Por favor verifique su contraseña","Contraseña Incorrecta");
        } else if (pass && !us) {
            alert.alertError("Por favor verifique su usuario","Usuario incorrectos");
        }
    }

    public Boolean comprobationPassword(String pass, String pass2){
        return pass.equals(pass2) ? true : false;
    }
    public Boolean loginAdmi (String userRegis, String passwordRegis, ArrayList<Administrative> arrayList){
        this.arrayListAdmi = arrayList;
        boolean pass = validatePassAdmi(passwordRegis);
        boolean us = validateUserAdmi(userRegis);
        aler(pass,us);
        return (pass == true && us == true) ? true : false;
    }

    public Boolean validatePassAdmi(String passwordRegis){
        for (Administrative person:arrayListAdmi) {
            System.out.println(person.getPassword());
            return person.getPassword().equals(passwordRegis) ? true: false;
        }
        return false;
    }
    public Boolean validateUserAdmi(String userRegis){
        for (Administrative person:arrayListAdmi) {
            System.out.println(person.getUser());
            return  person.getUser().equals(userRegis) ? true : false;
        }
        return false;
    }
}
