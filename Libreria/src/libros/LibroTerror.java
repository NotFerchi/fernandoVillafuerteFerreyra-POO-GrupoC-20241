package libros;

import libreria.Libreria;
import libros.constants.Genero;
import libros.constants.TerrorSubgenero;
import libros.utils.LibrosUtils;

import java.time.LocalDate;
import java.util.*;

public class LibroTerror extends Libro {

    private TerrorSubgenero subgenero;

    public LibroTerror(String nombre, String autor, String editorial, LocalDate fechaPublicacion, double precio, Genero genero, int stock, TerrorSubgenero subgenero) {
        super(nombre, autor, editorial, fechaPublicacion, precio, Genero.TERROR, stock);
        this.subgenero = subgenero;
    }

    public LibroTerror() { }

    @Override
    public String toString() {
        return String.format("%s, Subgenero: %s", super.toString(), subgenero);
    }

    public static void registrarLibro() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nRegistrar Libro de Terror");

        ArrayList<String> datosComun = LibrosUtils.registrarLibroDatosComun();

        String nombre = datosComun.get(0);
        String autor = datosComun.get(1);
        String editorial = datosComun.get(2);
        LocalDate fecha = LocalDate.parse(datosComun.get(3));
        double precio = Double.parseDouble(datosComun.get(4));
        int stock = Integer.parseInt(datosComun.get(5));

        TerrorSubgenero subgeneroInput = null;
        int opcionSubgenero = 0;
        boolean esDatoValido = false;

        do {
            System.out.println("Ingresa el subgenero del libro");
            System.out.println("1. Psicológico");
            System.out.println("2. Monjas");
            System.out.println("3. Salir");

            opcionSubgenero = scanner.nextInt();

            while (!esDatoValido) {
                try {
                    opcionSubgenero = scanner.nextInt();

                    if (opcionSubgenero > 3 || opcionSubgenero < 1) {
                        throw new InputMismatchException();
                    }
                    esDatoValido = true;
                } catch (InputMismatchException error) {
                    System.out.println("Ingresaste un valor incorrecto, intenta de nuevo");
                } finally {
                    scanner.nextLine();
                }
            }

            switch (opcionSubgenero) {
                case 1:
                    subgeneroInput = TerrorSubgenero.PSICOLOGICO;
                    break;
                case 2:
                    subgeneroInput = TerrorSubgenero.MONJAS;
                    break;
            }
        } while(opcionSubgenero != 4);

        LibroTerror libroTerror = new LibroTerror(nombre, autor, editorial, fecha, precio, Genero.TERROR, stock, subgeneroInput);

        Libreria.libros.get(Genero.TERROR).add(libroTerror);
    }

    public static void eliminarLibroTerror()  {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Libro> librosTerror = libreria.Libreria.libros.get(Genero.TERROR);
        System.out.println("Ingrese el ID del libro que desea eliminar: ");
        int id = scanner.nextInt();
        for (Libro libro : librosTerror) {
            if (libro.getId() == id) {
                libreria.Libreria.libros.get(Genero.TERROR).remove(libro);
                System.out.println("Se ha eliminado el libro exitosamente");
                return;
            }
        }
    }

    public static void menuMostrarLibroTerror() {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        boolean esDatoValido = false;
        LibroTerror mostrarLibro = new LibroTerror();

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
        System.out.printf("Estos son los libros de terror");
        for (Libro libro : libreria.Libreria.libros.get(Genero.TERROR)) {
            System.out.println(libro.toString());
        }
    }

    @Override
    public void filtrarPorPrecioMayorA(double precio) {
        Libreria.libros.get(Genero.TERROR).stream()
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
        libreria.Libreria.libros.get(Genero.TERROR)
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
        libreria.Libreria.libros.get(Genero.TERROR)
                .stream()
                .map(libro->libro.getAutor().equals(nombre))
                .forEach(libro-> System.out.println(libro.toString()));
    }
}