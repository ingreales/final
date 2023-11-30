package co.edu.cue.finalproyect.service.Impl;

import co.edu.cue.finalproyect.model.Administrative;
import co.edu.cue.finalproyect.model.Client;
import co.edu.cue.finalproyect.model.ClientDTO;
import co.edu.cue.finalproyect.persistence.personPersistence.PeristencePerson;
import co.edu.cue.finalproyect.service.PersonService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class PersonServiceImpl implements PersonService {
    Client client = new Client();
    Administrative administrative = new Administrative();
    ArrayList<Client> arrayList = new ArrayList<>();
    ArrayList<Administrative> administrativeArrayList = new ArrayList<>();

    public ArrayList<Administrative> getAdministrativeArrayList() {
        return administrativeArrayList;
    }
    public ArrayList<Client> getArrayList() {
        return arrayList;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void init () throws IOException {
       CompletableFuture.runAsync(()-> {
           try {
               arrayList = PeristencePerson.cargarClientes();
           } catch (IOException e) {
               throw new RuntimeException(e);
           }
       });
        administrativeArrayList.add(new Administrative("Der","1902","cell","Femenino","delena","delena",false));
    }


    //hilos
    public void createClient(String name, String id, String cellphone, String gender, String user, String password, String direction, String location) throws IOException {
        Client client = new Client(name, id, cellphone, gender, user, password, direction, location,false);
        arrayList.add(client);
        CompletableFuture.runAsync(()-> {
            try {
                PeristencePerson.guardarClientes(arrayList);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
    public void editClient(String name, String gender,String cellphone, String email, String password){
        editArray(name, gender, cellphone, email, password);

            client.setName(name);
            client.setCellphone(cellphone);
            client.setGender(gender);
            client.setPassword(password);
            client.setUser(email);
            editArray(name, gender, cellphone, email, password);

    }
    public void editArray(String name, String gender,String cellphone, String email, String password){
        client.setName(name);
        client.setCellphone(cellphone);
        client.setGender(gender);
        client.setPassword(password);
        client.setUser(email);
    }

    public List<ClientDTO> genereListDTOs(){
        System.out.println(arrayList.size());
        return  arrayList.stream()
                .map(c -> new ClientDTO(c.getName(),c.getId(),c.getCellphone()))
                .collect(Collectors.toList());
    }
    public void identi(String pass){
        for (Client cli: arrayList) {
            //cli.getPassword().equals(pass) ? client = (Client) cli : ;
            if(cli.getPassword().equals(pass)){
                client =  cli;
                client.setCondition(true);
            }
        }
    }
}
