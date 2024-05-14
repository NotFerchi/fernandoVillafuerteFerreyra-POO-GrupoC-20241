package libros;

import libreria.Libreria;
import libros.constants.ClasificacionLibro;
import libros.constants.Genero;
import libros.utils.LibrosUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LibroAccion extends Libro {

    private ClasificacionLibro clasificacion;

    public LibroAccion(String nombre, String autor, String editorial, LocalDate fechaPublicacion, double precio, Genero genero, int stock, ClasificacionLibro clasificacion) {
        super(nombre, autor, editorial, fechaPublicacion, precio, Genero.ACCION, stock);
        this.clasificacion = clasificacion;
    }

    public LibroAccion() {}

    @Override
    public String toString() {
        return String.format("%s, Clasificacion: %s", super.toString(), clasificacion);
    }

    public static void registrarLibro() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nRegistrar Libro de Accion");

        ArrayList<String> datosComun = LibrosUtils.registrarLibroDatosComun();

        String nombre = datosComun.get(0);
        String autor = datosComun.get(1);
        String editorial = datosComun.get(2);
        LocalDate fecha = LocalDate.parse(datosComun.get(3));
        double precio = Double.parseDouble(datosComun.get(4));
        int stock = Integer.parseInt(datosComun.get(5));

        ClasificacionLibro clasificacionInput = null;
        int opcionClasificacion = 0;
        boolean esDatoValido = false;

        do {
            System.out.println("Ingresa la clasificacion del libro");
            System.out.println("1. A");
            System.out.println("2. B");
            System.out.println("3. C");
            System.out.println("4. Salir");

            opcionClasificacion = scanner.nextInt();

            while (!esDatoValido) {
                try {
                    opcionClasificacion = scanner.nextInt();

                    if (opcionClasificacion > 4 || opcionClasificacion < 1) {
                        throw new InputMismatchException();
                    }
                    esDatoValido = true;
                } catch (InputMismatchException error) {
                    System.out.println("Ingresaste un valor incorrecto, intenta de nuevo");
                } finally {
                    scanner.nextLine();
                }
            }

            switch (opcionClasificacion) {
                case 1:
                    clasificacionInput = ClasificacionLibro.A;
                    break;
                case 2:
                    clasificacionInput = ClasificacionLibro.B;
                    break;
                case 3:
                    clasificacionInput = ClasificacionLibro.C;
                    break;
            }
        } while(opcionClasificacion != 4);

        LibroAccion libroAccion = new LibroAccion(nombre, autor, editorial, fecha, precio, Genero.ACCION, stock, clasificacionInput);

        Libreria.libros.get(Genero.ACCION).add(libroAccion);
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
        boolean esDatoValido = false;
        LibroAccion mostrarLibro = new LibroAccion();

        do {
            System.out.println("1. Mostrar lista de libros");
            System.out.println("2. Filtrar libros por inicial del libro");
            System.out.println("3. Filtrar libros por ID");
            System.out.println("4. Por nombre del autor");
            System.out.println("5. Salir");
            opcion = scanner.nextInt();

            while (!esDatoValido) {
                try {
                    opcion = scanner.nextInt();

                    if (opcion > 5 || opcion < 1) {
                        throw new InputMismatchException();
                    }
                    esDatoValido = true;
                } catch (InputMismatchException error) {
                    System.out.println("Ingresaste un valor incorrecto, intenta de nuevo");
                } finally {
                    scanner.nextLine();
                }
            }

            esDatoValido = false;

            switch (opcion) {
                case 1:
                    System.out.println("Estos son todos los libros: ");
                    mostrarLibro.mostrarLibroConDatos();
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
        } while(opcion != 5);
    }

    public void mostrarLibroConDatos() {
        System.out.printf("Estos son los libros de accion");
        for (Libro libro : libreria.Libreria.libros.get(Genero.ACCION)) {
            System.out.println(libro.toString());
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