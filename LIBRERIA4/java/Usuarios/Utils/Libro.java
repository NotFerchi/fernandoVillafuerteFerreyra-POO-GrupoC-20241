package Usuarios.Utils;

public class Libro {
    private String nombre;
    private String autor;
    private int stock;
    private int id;
    private static int CANTIDAD_LIBROS = 1;

    public Libro(String nombre, String autor, int stock) {
        this.nombre = nombre;
        this.autor = autor;
        this.stock = stock;
        this.id = CANTIDAD_LIBROS;
        CANTIDAD_LIBROS++;
    }

    @Override
    public String toString() {
        return String.format("Nombre: %s, ID: %d, Autor: %s, Stock disponible: %d",
                nombre, id, autor, stock);
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
}