package co.edu.cue.finalproyect.persistence.personPersistence;

import co.edu.cue.finalproyect.model.Client;
import co.edu.cue.finalproyect.model.Person;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;



public class PeristencePerson {

        public static final String RUTA_ARCHIVO_CLIENTES = "src/main/resources/clientes.txt";

        public static void guardarClientes(ArrayList<Client> listaClientes) throws IOException {

            String contents = "";

            for(Client cliente: listaClientes) {
                contents+= cliente.getPassword()+"@"+cliente.getName()+"@"+cliente.getCellphone()+"@"+
                        cliente.getGender()+"@"+cliente.isCondition()+"@"+cliente.getUser()+"@"+cliente.getId()+"@"+ cliente.getDirection()+
                        "@"+cliente.getLocation()+"\n";
                }
            ArchiveUsefulPerson.guardarArchivo(RUTA_ARCHIVO_CLIENTES, contents, false);
        }

        //METODO PARA CARGAR LOS CLIENTES A PARTIR DEL ARCHIVO
        public static ArrayList<Client> cargarClientes() throws FileNotFoundException, IOException {
            System.out.println("cargar clientes");
            ArrayList<Client> clientes = new ArrayList<Client>();

            ArrayList<String> contenido = ArchiveUsefulPerson.leerArchivo(RUTA_ARCHIVO_CLIENTES);
            System.out.println("conteido"+contenido);
            String linea = "";

            for (int i = 0;i<contenido.size(); i++) {
                Client miCliente = new Client();
                linea = contenido.get(i);

                miCliente.setPassword((linea.split("@")[0]));
                miCliente.setName(linea.split("@")[1]);
                miCliente.setCellphone(linea.split("@")[2]);
                miCliente.setGender(linea.split("@")[3]);
                miCliente.setCondition(Boolean.parseBoolean(linea.split("@")[4]));
                miCliente.setUser(linea.split("@")[5]);
                miCliente.setId(linea.split("@")[6]);
                miCliente.setDirection(linea.split("@")[7]);
                miCliente.setLocation(linea.split("@")[8]);

                System.out.println("Cliente"+miCliente);
                clientes.add(miCliente);
            }
            for (Person c:clientes
                 ) {
                System.out.println(c);
            }
            return clientes;
        }

}
