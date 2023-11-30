package co.edu.cue.finalproyect.persistence.carPersistence;

import co.edu.cue.finalproyect.model.Car;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Persistencia{


    public static final String RUTA_ARCHIVO_CLIENTES = "src/main/resources/car.txt";

    public static void saveClient(HashMap<String,Car> carHashMap) throws IOException {

        String contents = "";

        for(Map.Entry<String, Car> carEntry: carHashMap.entrySet()) {
            contents+= carEntry.getValue().getName()+"@"+carEntry.getValue().getBrand()+"@"+
                    carEntry.getValue().getModel()+"@"+carEntry.getValue().getPlate()+"@"+carEntry.getValue().getType()+"@"+
                    carEntry.getValue().getUbication()+"@"+carEntry.getValue().getLinkImage().getImage().getUrl()+"@"+carEntry.getValue().getPrice()+"@"+
                    carEntry.getValue().isState()+"\n";
        }
        ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_CLIENTES, contents, false);
    }

    //METODO PARA CARGAR LOS CLIENTES A PARTIR DEL ARCHIVO
    public static HashMap<String,Car> loadClient() throws FileNotFoundException, IOException {
        System.out.println("cargar clientes");
        HashMap<String,Car> carHashMap = new HashMap<>();

        ArrayList<String> contenido = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_CLIENTES);
        System.out.println("conteido"+contenido);
        String linea = "";

        for (int i = 0;i<contenido.size(); i++) {
            Car car = new Car();
            linea = contenido.get(i);
            car.setName(linea.split("@")[0]);
            System.out.println(car.getName());;
            car.setBrand(linea.split("@")[1]);
            car.setModel(linea.split("@")[2]);
            car.setPlate(linea.split("@")[3]);
            car.setType(linea.split("@")[4]);
            car.setUbication(linea.split("@")[5]);
            car.setLinkImage(new ImageView(new Image(linea.split("@")[6])));
            //car.setLinkImage(linea.split("-")[1]);
            car.setPrice(Double.parseDouble(linea.split("@")[7]));
            car.setState(Boolean.getBoolean(linea.split("@")[8]));
            carHashMap.put(car.getPlate(),car);
        }
        return carHashMap;
    }


}
