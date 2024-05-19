package libros;

import com.google.gson.annotations.Expose;
import libros.constants.Genero;

import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

public abstract class Libro {
    @Expose
    private String nombre;
    @Expose
    private String autor;
    @Expose
    private String editorial;
    @Expose
    private String fechaPublicacion;
    @Expose
    private double precio;
    @Expose
    private int id;
    @Expose
    private Genero genero;
    @Expose
    private int stock;
    @Expose
    private static int CANTIDAD_LIBROS = 1;


    public Libro(String nombre, String autor, String editorial, String fechaPublicacion, double precio, Genero genero, int stock) {
        this.nombre = nombre;
        this.autor = autor;
        this.editorial = editorial;
        this.fechaPublicacion = fechaPublicacion;
        this.precio = precio;
        this.genero = genero;
        this.stock = stock;
        this.id = CANTIDAD_LIBROS;
        CANTIDAD_LIBROS++;
    }

    public Libro() { }

    @Override
    public String toString(){
        return String.format("Nombre del libro: %s, \n Autor: %s, \n Precio: %.2f \n Genero: %s", nombre, autor, precio, genero.toString());
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public double getPrecio() {
        return precio;
    }

    public int getId() {
        return id;
    }

    public Genero getGenero() {
        return genero;
    }

    protected abstract void filtrarPorPrecioMayorA(double precio);

    protected abstract void filtrarLibroPorInicialDeAutor(String inicial);

    protected abstract void filtrarLibroPorInicialDeLibro(String inicial);

    protected abstract void filtrarLibroPorId(int id);

    protected abstract void filtrarLibroPorAutor(String nombre);
}