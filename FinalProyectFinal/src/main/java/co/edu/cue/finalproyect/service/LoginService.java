package co.edu.cue.finalproyect.service;

import co.edu.cue.finalproyect.model.Administrative;
import co.edu.cue.finalproyect.model.Client;
import co.edu.cue.finalproyect.model.Person;

import java.util.ArrayList;

public interface LoginService {
    Boolean login(String userRegis, String passwordRegis, ArrayList<Client> arrayList);
    Boolean comprobationPassword(String pass, String pass2);
    Boolean loginAdmi (String userRegis, String passwordRegis, ArrayList<Administrative> arrayList);

}
