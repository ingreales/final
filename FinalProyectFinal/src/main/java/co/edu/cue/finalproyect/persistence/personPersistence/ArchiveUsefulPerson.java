package co.edu.cue.finalproyect.persistence.personPersistence;

import java.io.*;
import java.util.ArrayList;

public class ArchiveUsefulPerson {

        public static ArrayList<String> leerArchivo(String ruta) throws IOException {

            ArrayList<String> contenido = new ArrayList<String>();
            FileReader fr = new FileReader(ruta);
            BufferedReader bfr = new BufferedReader(fr);
            String linea = "";
            while((linea = bfr.readLine())!= null) {
                contenido.add(linea);
            }
            bfr.close();
            fr.close();
            return contenido;
        }

        //EDITA Y GUARDA NUESTRO CONTENIDO
        public static void guardarArchivo(String ruta, String contenido, boolean b) throws IOException {
            FileWriter fw = new FileWriter(ruta, b);
            BufferedWriter bfw = new BufferedWriter(fw);
            bfw.write(contenido);
            bfw.close();
            fw.close();

        }

}
