package libros;

import com.google.gson.annotations.Expose;
import libreria.Libreria;
import libros.constants.ClasificacionLibro;
import libros.constants.Genero;
import libros.utils.LibrosUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LibroAccion extends Libro {

    @Expose
    private ClasificacionLibro clasificacion;

    public LibroAccion(String nombre, String autor, String editorial, String fechaPublicacion, double precio, int stock, ClasificacionLibro clasificacion) {
        super(nombre, autor, editorial, fechaPublicacion, precio, Genero.ACCION, stock);
        this.clasificacion = clasificacion;
    }

    private LibroAccion() {}

    @Override
    public String toString() {
        return String.format("%s, Clasificacion: %s", super.toString(), clasificacion);
    }

    public static void registrarLibro() {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        System.out.println("\nRegistrar Libro de Accion");
        ArrayList<String> datosComun = LibrosUtils.registrarLibroDatosComun();

        String nombre = datosComun.get(0);
        String autor = datosComun.get(1);
        String editorial = datosComun.get(2);
        LocalDate fecha = LocalDate.parse(datosComun.get(3));
        double precio = Double.parseDouble(datosComun.get(4));
        int stock = Integer.parseInt(datosComun.get(5));

        ClasificacionLibro clasificacionInput = null;

        System.out.println("Ingresa la clasificacion del libro");
        System.out.println("1. A");
        System.out.println("2. B");
        System.out.println("3. C");
        System.out.println("4. Salir");
        opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                clasificacionInput = ClasificacionLibro.A;
                break;
            case 2:
                clasificacionInput = ClasificacionLibro.B;
                break;
            case 3:
                clasificacionInput = ClasificacionLibro.C;
                break;
            default:
                System.out.println("Error al asignar clasificacion");
                break;
        }

        LibroAccion libroAccion = new LibroAccion(nombre, autor, editorial, fecha.toString(), precio, stock, clasificacionInput);
        Libreria.libros.get(Genero.ACCION).add(libroAccion);
        Libreria.guardarLibroEnJSON();
        System.out.println("Libro registrado correctamente");
    }

    public static void eliminarLibroAccion() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Libro> librosAccion = libreria.Libreria.libros.get(Genero.ACCION);
        System.out.println("Ingrese el ID del libro que desea eliminar: ");
        int id = scanner.nextInt();
        for (Libro libro : librosAccion) {
            if (libro.getId() == id) {
                libreria.Libreria.libros.get(Genero.ACCION).remove(libro);
                System.out.println("Se ha eliminado el libro exitosamente");
                return;
            }
        }
    }

    public static void menuMostrarLibroAccion() {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        LibroAccion mostrarLibro = new LibroAccion();


        System.out.println("1. Mostrar lista de libros");
        System.out.println("2. Filtrar libros por inicial del libro");
        System.out.println("3. Filtrar libros por ID");
        System.out.println("4. Por nombre del autor");
        System.out.println("5. Salir");
        opcion = scanner.nextInt();

        try {
            switch (opcion) {
                case 1:
                    System.out.println("Estos son todos los libros: ");
                    mostrarLibroAccion();
                    break;
                case 2:
                    System.out.println("Ingresa la inicial del libro: ");
                    String inicial = scanner.nextLine();
                    mostrarLibro.filtrarLibroPorInicialDeLibro(inicial);
                    break;
                case 3:
                    System.out.println("Ingresa el ID del libro: ");
                    int id = scanner.nextInt();
                    mostrarLibro.filtrarLibroPorId(id);
                    break;
                case 4:
                    System.out.println("Ingresa el nombre del autor: ");
                    String nombre = scanner.nextLine();
                    mostrarLibro.filtrarLibroPorAutor(nombre);
                    break;
            }
        } catch (Exception e) {
            System.out.println("Ingrese una opcion valida");
        }
    }

    public static void mostrarLibroAccion() {
        System.out.println("\nLibros de accion en la biblioteca");
        for (Libro libro : Libreria.libros.get(Genero.ACCION)) {
            libros.LibroAccion libroAccion = (libros.LibroAccion) libro;
            System.out.println(libroAccion.toString());
            System.out.println(" ");
        }
    }

    @Override
    public void filtrarPorPrecioMayorA(double precio) {
        Libreria.libros.get(Genero.ACCION).stream()
                .filter(libro -> libro.getPrecio() > precio)
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
        libreria.Libreria.libros.get(Genero.ACCION)
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
        libreria.Libreria.libros.get(Genero.ACCION)
                .stream()
                .map(libro->libro.getAutor().equals(nombre))
                .forEach(libro-> System.out.println(libro.toString()));
    }
}