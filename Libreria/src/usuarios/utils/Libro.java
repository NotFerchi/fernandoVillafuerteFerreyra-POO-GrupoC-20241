package usuarios.utils;

import libreria.Libreria;

import java.util.Scanner;

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
        return String.format("Nombre del libro: %s, ID del libro: %d, Autor del libro: %s, Stock disponible: %d",
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

    public static void registrarLibros() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nRegistrar Libros");
        System.out.println("Ingresa los siguientes datos para continuar");

        System.out.println("Ingresa el nombre: ");
        String nombre = scanner.nextLine();

        System.out.println("Ingresa el autor del libro: ");
        String autor = scanner.nextLine();

        System.out.println("Ingresa el stock disponible: ");
        int stock = scanner.nextInt();

        Libro libro = new Libro(nombre, autor, stock);
        Libreria.libros.add(libro);
    }

    public static void mostrarLibros() {
        System.out.println("\nLibros disponibles en la biblioteca");
        for (Libro libro : Libreria.libros) {
            System.out.println(libro.toString());
            System.out.println(" ");
        }
    }
}