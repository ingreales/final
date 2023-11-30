package co.edu.cue.finalproyect.service;

import co.edu.cue.finalproyect.model.Administrative;
import co.edu.cue.finalproyect.model.Client;
import co.edu.cue.finalproyect.model.ClientDTO;
import co.edu.cue.finalproyect.model.Person;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface PersonService {
    ArrayList<Client> getArrayList();
    void init () throws IOException;
    void createClient(String name, String id, String cellphone, String gender, String user, String password, String direction, String location) throws IOException;
    void editClient(String name, String gender,String cellphone, String email, String password);
    Client getClient();
    void setClient(Client client);
    void identi(String pass);
    List<ClientDTO> genereListDTOs();
    ArrayList<Administrative> getAdministrativeArrayList();
}
