package libros.utils;

import libros.LibroAccion;
import libros.LibroComedia;
import libros.LibroTerror;

import java.util.ArrayList;

public class LibroModel {
    private ArrayList<LibroTerror> librosTerror;
    private ArrayList<LibroAccion> librosAccion;
    private ArrayList<LibroComedia> librosComedia;

    public ArrayList<LibroTerror> getLibrosTerror() { return librosTerror; }
    public ArrayList<LibroAccion> getLibrosAccion() { return librosAccion; }
    public ArrayList<LibroComedia> getLibrosComedia() { return librosComedia; }
}