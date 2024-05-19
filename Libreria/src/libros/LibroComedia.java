package libros;

import libreria.Libreria;
import libros.constants.Genero;
import libros.utils.LibrosUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class LibroComedia extends Libro {


    public LibroComedia(String nombre, String autor, String editorial, String fechaPublicacion, double precio, int stock) {
        super(nombre, autor, editorial, fechaPublicacion, precio, Genero.COMEDIA, stock);
    }

    private LibroComedia() {}

    @Override
    public String toString() {
        return String.format("%s", super.toString());
    }

    public static void registrarLibro() {
        System.out.println("\nRegistrar Libro de Comedia");

        ArrayList<String> datosComun = LibrosUtils.registrarLibroDatosComun();

        String nombre = datosComun.get(0);
        String autor = datosComun.get(1);
        String editorial = datosComun.get(2);
        LocalDate fecha = LocalDate.parse(datosComun.get(3));
        double precio = Double.parseDouble(datosComun.get(4));
        int stock = Integer.parseInt(datosComun.get(5));

        LibroComedia libroComedia = new LibroComedia(nombre, autor, editorial, fecha.toString(), precio,  stock);
        Libreria.libros.get(Genero.COMEDIA).add(libroComedia);
        Libreria.guardarLibroEnJSON();
        System.out.println("Libro registrado correctamente");
    }

    public static void eliminarLibroComedia() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Libro> librosComedia = libreria.Libreria.libros.get(Genero.COMEDIA);
        System.out.println("Ingrese el ID del libro que desea eliminar: ");
        int id = scanner.nextInt();
        for (Libro libro : librosComedia) {
            if (libro.getId() == id) {
                libreria.Libreria.libros.get(Genero.COMEDIA).remove(libro);
                System.out.println("Se ha eliminado el libro exitosamente");
                return;
            }
        }
    }

    public static void menuMostrarLibroComedia() {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        LibroComedia libro = new LibroComedia();

        System.out.println("1. Mostrar lista de libros");
        System.out.println("2. Filtrar libros por inicial del libro");
        System.out.println("3. Filtrar libros por ID");
        System.out.println("4. Por nombre del autor");
        System.out.println("5. Salir");
        opcion = scanner.nextInt();

        try {
            switch (opcion) {
                case 1:
                    mostrarLibroComedia();
                    break;
                case 2:
                    System.out.println("Ingresa la inicial del libro: ");
                    String inicial = scanner.nextLine();
                    libro.filtrarLibroPorInicialDeLibro(inicial);
                    break;
                case 3:
                    System.out.println("Ingresa el ID del libro: ");
                    int id = scanner.nextInt();
                    libro.filtrarLibroPorId(id);
                    break;
                case 4:
                    System.out.println("Ingresa el nombre del autor: ");
                    String nombre = scanner.nextLine();
                    libro.filtrarLibroPorAutor(nombre);
                    break;
            }
        } catch (Exception e) {
            System.out.println("Error al mostrar el libro");
        }
    }

    public static void mostrarLibroComedia() {
        System.out.println("\nLibros de terror en la biblioteca");
        for (Libro libro : Libreria.libros.get(Genero.COMEDIA)) {
            libros.LibroComedia libroComedia = (libros.LibroComedia) libro;
            System.out.println(libroComedia.toString());
            System.out.println(" ");
        }
    }

    @Override
    public void filtrarPorPrecioMayorA(double precio) {
        Libreria.libros.get(Genero.COMEDIA).stream()
                .filter(libro -> libro.getPrecio() > precio)
                .filter(libro -> getPrecio() % 2 == 0)
                .forEach(libro -> System.out.println(libro.toString()));
    }

    @Override
    public void filtrarLibroPorInicialDeAutor(String inicial) {
        Libreria.libros.get(Genero.TERROR)
                .stream()
                .map(libro -> libro.getAutor().toUpperCase())
                .forEach(libro -> System.out.println(libro.toString()));
    }

    @Override
    public void filtrarLibroPorInicialDeLibro(String inicial){
        libreria.Libreria.libros.get(Genero.COMEDIA)
                .stream()
                .map(libro->libro.getNombre().toUpperCase())
                .forEach(libro-> System.out.println(libro.toString()));
    }

    @Override
    public void filtrarLibroPorId(int id){
        libreria.Libreria.libros.get(Genero.TERROR)
                .stream()
                .map(libro->libro.getId() == id)
                .forEach(libro-> System.out.println(libro.toString()));
    }

    @Override
    public void filtrarLibroPorAutor(String nombre){
        libreria.Libreria.libros.get(Genero.COMEDIA)
                .stream()
                .map(libro->libro.getAutor().equals(nombre))
                .forEach(libro-> System.out.println(libro.toString()));
    }
}