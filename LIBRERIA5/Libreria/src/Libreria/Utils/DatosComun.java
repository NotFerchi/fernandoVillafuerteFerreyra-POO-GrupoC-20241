package Libreria.Utils;

import Libreria.Libreria;
import Usuarios.Usuario;
import Usuarios.Utils.Rol;

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

        String telefono = registrarTelefonoUsario(rol);

        String nombreUsuario = registrarNombreUsuario(rol);

        System.out.println("Ingresa la contrasena: ");
        String contrasena = scanner.nextLine();

        datosComun.addAll(Arrays.asList(nombre, apellido, telefono, nombreUsuario, contrasena));
        return datosComun;
    }

    private static String registrarTelefonoUsario(Rol rol) {
        return "";
    }

    private static String registrarNombreUsuario(Rol rol) {
        return "";
    }
}