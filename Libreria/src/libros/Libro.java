package libros;

import libros.constants.Genero;

import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

public abstract class Libro {
    private String nombre;
    private String autor;
    private String editorial;
    private LocalDate fechaPublicacion;
    private double precio;
    private int id;
    private Genero genero;
    private int stock;
    private static int CANTIDAD_LIBROS = 1;

    public Libro(String nombre, String autor, String editorial, LocalDate fechaPublicacion, double precio, Genero genero, int stock) {
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
    public String toString() {
        return String.format("ID del libro: %d, \nNombre del libro: %s, \nAutor del libro: %s, \nEditorial: %s " +
                        "\nFecha de publicacion: %d, \nPrecio: %f, \nGenero del libro: %s, \nStock disponible: %d",
                id, nombre, autor, editorial, fechaPublicacion, precio, genero, stock);
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

    protected abstract void mostrarLibroConDatos();

    protected abstract void filtrarPorPrecioMayorA(double precio);

    protected abstract void filtrarLibroPorInicialDeAutor(String inicial);

    protected abstract void filtrarLibroPorInicialDeLibro(String inicial);

    protected abstract void filtrarLibroPorId(int id);

    protected abstract void filtrarLibroPorAutor(String nombre);
}
