package libreria.utils;

import libreria.Libreria;
import usuarios.Usuario;
import usuarios.utils.Rol;

import javax.swing.text.DateFormatter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class DatosComun {

    public static ArrayList<String> ObtenerDatosComun(Rol rol) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> datosComun = new ArrayList<String>();

        String rolUsuario = rol == Rol.CLIENTE ? "Cliente" : rol == Rol.ASISTENTE ? "Asistente" : "Gerente";
        System.out.println(String.format("Bienvenido al Registro del %s", rolUsuario));

        System.out.println("Ingresa los siguientes datos para continuar");

        System.out.println("Ingresa el nombre: ");
        String nombre = scanner.nextLine();

        System.out.println("Ingresa el apellido: ");
        String apellido = scanner.nextLine();

        String fechaNacimiento = registrarFechaNacimiento();

        String telefono = registrarTelefonoUsario(rol);

        String nombreUsuario = registrarNombreUsuario(rol);

        System.out.println("Ingresa la contrasena: ");
        String contrasena = scanner.nextLine();

        datosComun.addAll(Arrays.asList(nombre, apellido, fechaNacimiento, telefono, nombreUsuario, contrasena));
        return datosComun;
    }

    private static String registrarTelefonoUsario(Rol rol) {
        Scanner scanner = new Scanner(System.in);
        boolean telefonoExistente = true;
        String telefono;
        do {
            System.out.println("Ingresa el telefono: ");
            telefonoExistente = false;
            telefono = scanner.nextLine();

            ArrayList<Usuario> telefonoUsuario = Libreria.usuarios.get(rol);
            for (Usuario usuario : telefonoUsuario) {
                if (usuario.getTelefono().equals(telefono)) {
                    telefonoExistente = true;
                    break;
                }
            }

            if (telefonoExistente) {
                System.out.println("EL telefono ya se encuentra registrado. Intenta de nuevo.");
                break;
            }
        } while (telefonoExistente);
        return telefono;
    }

    private static String registrarNombreUsuario(Rol rol) {
        Scanner scanner = new Scanner(System.in);
        String nombreUsuario;
        boolean nombreUsuarioExistente = true;
        do {

            System.out.println("Ingresa el nombre de usuario: ");
            nombreUsuarioExistente = false;
            nombreUsuario = scanner.nextLine();

            ArrayList<Usuario> nombreUsuarioList = Libreria.usuarios.get(rol);
            for (Usuario usuario : nombreUsuarioList) {
                if (usuario.getNombreUsuario().equals(nombreUsuario)) {
                    nombreUsuarioExistente = true;
                    break;
                }
            }

            if (nombreUsuarioExistente) {
                System.out.println("Ya existe un registro con ese nombre de usuario. Intenta de nuevo");
            }
        } while (nombreUsuarioExistente);

        return nombreUsuario;
    }

    private static String registrarFechaNacimiento(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese su dia de nacimiento: ");
        int dia = scanner.nextInt();

        System.out.println("Ingrese su mes de nacimiento: ");
        int mes = scanner.nextInt();

        System.out.println("Ingrese su año de nacimiento: ");
        int anio = scanner.nextInt();

        LocalDate fecha = LocalDate.of(anio, mes, dia);
        LocalTime time = LocalTime.now();
        LocalDateTime fechaCompleta = LocalDateTime.of(fecha, time);
        DateTimeFormatter fechaFormat = DateTimeFormatter.ofPattern("dd/MM/YYYY");
        String fechaNacimiento = fechaCompleta.format(fechaFormat);

        return fechaNacimiento;
    }

}