package libros.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import libreria.Libreria;
import libros.Libro;
import libros.constants.Genero;
import usuarios.Usuario;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class LibroSerializer {
    public static void serialize(HashMap<Genero, ArrayList<Libro>> libros){
        Gson json = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("libros.json"));
            json.toJson(Libreria.libros, writer);
            writer.close();
        } catch (IOException e){
            System.out.println(e);
        } catch (Exception e){
            System.out.println(e);
        }
    }
}