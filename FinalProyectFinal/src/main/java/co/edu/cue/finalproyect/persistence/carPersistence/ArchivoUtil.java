package co.edu.cue.finalproyect.persistence.carPersistence;

import java.io.*;
import java.util.ArrayList;

public class ArchivoUtil {

    //------------------------------------SERIALIZACION  y XML

/*    public static Object cargarRecursoSerializadoXML(String rutaArchivo) throws IOException {

        System.out.println("arichivo util cargar");

        XMLDecoder decodificadorXML;
        Object objetoXML;

        decodificadorXML = new XMLDecoder(new FileInputStream(rutaArchivo));
        objetoXML = decodificadorXML.readObject();
        decodificadorXML.close();
        return objetoXML;

    }

    public static void salvarRecursoSerializadoXML(String rutaArchivo, Object objeto) throws IOException {
        <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>
        System.out.println("arichivo util salvar");


        XMLEncoder codificadorXML;

        codificadorXML = new XMLEncoder(new FileOutputStream(rutaArchivo));
        codificadorXML.writeObject(objeto);
        codificadorXML.close();

    }*/
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
    public static void guardarArchivo(String ruta, String contenido, boolean b) throws IOException {
        FileWriter fw = new FileWriter(ruta, b);
        BufferedWriter bfw = new BufferedWriter(fw);
        bfw.write(contenido);
        bfw.close();
        fw.close();

    }
}
