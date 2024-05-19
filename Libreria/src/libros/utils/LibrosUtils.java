package libros.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class LibrosUtils {
    public static ArrayList<String> registrarLibroDatosComun() {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> datosComun = new ArrayList<>();

        System.out.println("Ingresa el nombre del libro: ");
        String nombre = scanner.nextLine();

        System.out.println("Ingresa el autor del libro: ");
        String autor = scanner.nextLine();

        System.out.println("Ingresa la editorial del libro: ");
        String editorial = scanner.nextLine();

        String fecha = registrarFechaPublicacion();

        System.out.println("Ingresa el precio del libro: ");
        double precio = scanner.nextDouble();

        System.out.println("Ingresa el stock del libro");
        int stock = scanner.nextInt();

        datosComun.addAll(Arrays.asList(nombre, autor, editorial, fecha, String.valueOf(precio), String.valueOf(stock)));

        return datosComun;
    }

    private static String registrarFechaPublicacion() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingresa el dia de publicacion del libro: ");
        int diaPublicacion = scanner.nextInt();

        System.out.println("Ingresa el mes de publicacion del libro: ");
        int mesPublicacion = scanner.nextInt();

        System.out.println("Ingresa el año de publicacion del libro: ");
        int añoPublicacion = scanner.nextInt();

        LocalDate fecha = LocalDate.of(añoPublicacion, mesPublicacion, diaPublicacion);
        String fechaPublicacion = String.valueOf(fecha);

        return fechaPublicacion;
    }
}