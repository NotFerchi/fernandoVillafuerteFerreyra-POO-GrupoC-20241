package usuarios;

import libreria.Libreria;
import libreria.utils.DatosComun;
import usuarios.utils.Rol;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Asistente extends Usuario {
    private double sueldo;
    private String rfc;
    private String fechaInicio;

    public Asistente(String nombre, String apellido, String telefono, double sueldo, String rfc, String fechaInicio, String nombreUsuario, String contrasena, String fechaNacimiento) {
        super(nombre, apellido, telefono, Rol.ASISTENTE, nombreUsuario, contrasena, fechaNacimiento);
        this.sueldo = sueldo;
        this.rfc = rfc;
        this.fechaInicio = fechaInicio;
    }

    public Asistente(String juan, String rivera, String number, double sueldo, String juanito1234123, String juan123) {
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", sueldo: %.2f, RFC: %s, fecha inicio: %s", sueldo, rfc, fechaInicio);
    }

    public static void registrarAsistente() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> datosComun = DatosComun.ObtenerDatosComun(Rol.ASISTENTE);

        String nombre = datosComun.get(0);
        String apellido = datosComun.get(1);
        String telefono = datosComun.get(2);
        String nombreUsuario = datosComun.get(3);
        String contrasena = datosComun.get(4);
        String fechaNacimiento = datosComun.get(5);

        System.out.println("Ingresa el sueldo: ");
        double sueldo = scanner.nextDouble();
        scanner.nextLine(); // Limpiar el buffer del scanner

        System.out.println("Ingresa tu RFC: ");
        String rfc = scanner.nextLine();

        System.out.println("Ingresa la fecha de inicio: ");
        String fechaInicio = scanner.nextLine();

        Asistente asistente = new Asistente(nombre, apellido, telefono, sueldo, rfc, fechaInicio, nombreUsuario, contrasena, fechaNacimiento);

        if (!Libreria.usuarios.containsKey(Rol.ASISTENTE)) {
            Libreria.usuarios.put(Rol.ASISTENTE, new ArrayList<>());
        }

        Libreria.usuarios.get(Rol.ASISTENTE).add(asistente);

        System.out.println("\nAsistente Registrado Exitosamente\n");
    }

    public static void mostrarAsistentes() {
        System.out.println("\nAsistentes en la biblioteca");
        for (Usuario usuario : Libreria.usuarios.get(Rol.ASISTENTE)) {
            Asistente asistente = (Asistente) usuario;
            System.out.println(asistente.toString());
            System.out.println(" ");
        }
    }

    public static void eliminarAsistentes() {
        int eliminarAsistente;
        boolean asistenteExistente;
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEliminar asistentes del sistema");
        System.out.println("Esta es la lista de asistentes registrados: ");
        for (Usuario usuario : Libreria.usuarios.get(Rol.ASISTENTE)) {
            Asistente asistente = (Asistente) usuario;
            System.out.println(asistente.toString());
            System.out.println(" ");
        }

        do {
            asistenteExistente = false;
            System.out.println("Ingrese el ID del asistente que desee eliminar del sistema: ");
            eliminarAsistente = scanner.nextInt();

            ArrayList<Usuario> eliminar = Libreria.usuarios.get(Rol.ASISTENTE);
            for (int i = 0; i < eliminar.size(); i++) {
                Usuario usuarioEliminar = eliminar.get(i);
                if (usuarioEliminar.getId() == eliminarAsistente) {
                    asistenteExistente = true;
                    eliminar.remove(i);
                    System.out.println("El asistente: " + usuarioEliminar.getNombre() + " se ha eliminado correctamente del sistema");
                    System.out.println(" ");
                    break;
                }
            }
            if (!asistenteExistente) {
                System.out.println("El ID que ingresó no pertenece a ningún asistente registrado. Intenta de nuevo.");
                System.out.println(" ");
            }
        } while (!asistenteExistente);
    }
}