package Usuarios;
import Usuarios.Utils.Rol;
import java.time.LocalDate;
import Usuarios.Usuario;

import Libreria.Libreria;
import Libreria.Utils.DatosComun;
import java.util.ArrayList;
import java.util.Scanner;
public class Gerente extends Usuario{
    private double sueldo;
    private String INE;
    private LocalDate fechaInicio;


    public Gerente(String nombre, String apellido, String telefono, String INE, double sueldo, String nombreUsuario, String contrasena) {
        super(nombre, apellido, telefono, Rol.GERENTE, nombreUsuario, contrasena);
        this.sueldo = sueldo;
        this.INE = INE;
        this.fechaInicio = LocalDate.now();

    }
    @Override
    public String toString() {
        return String.format("%s , fecha inicio: %s, INE: %s, Sueldo de: %f", super.toString(), fechaInicio, INE, sueldo);
    }

    public static void registrarGerente() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> datosComun = DatosComun.ObtenerDatosComun(Rol.GERENTE);

        String nombre = datosComun.get(0);
        String apellido = datosComun.get(1);
        String telefono = datosComun.get(2);
        String nombreUsuario = datosComun.get(3);
        String contrasena = datosComun.get(4);

        System.out.println("Ingresa el sueldo: ");
        double sueldo = scanner.nextDouble();

        System.out.println("Ingresa tu INE: ");
        String ine = scanner.nextLine();

        Gerente gerente = new Gerente(nombre, apellido, telefono, ine, sueldo, nombreUsuario, contrasena);
        if (!Libreria.usuarios.containsKey(Rol.GERENTE)) {
            Libreria.usuarios.put(Rol.GERENTE, new ArrayList<Usuario>());
        }

        Libreria.usuarios.get(Rol.GERENTE).add(gerente);
        System.out.println("\nGerente Registrado Exitosamente\n");
    }

    public static void mostrarGerentes() {
        System.out.println("\nGerentes en la biblioteca");
        for (Usuario usuario : Libreria.usuarios.get(Rol.GERENTE)) {
            Gerente gerente = (Gerente) usuario;
            System.out.println(gerente.toString());
            System.out.println(" ");
        }
    }

    public static void eliminarGerentes() {
        int eliminarGerente = 0;
        boolean gerenteExistente = true;
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEliminar gerentes del sistema");
        System.out.println("Esta es la lista de gerentes registrados: ");
        for (Usuario usuario : Libreria.usuarios.get(Rol.GERENTE)) {
            if (usuario.getRol() == Rol.GERENTE) {
                Gerente gerente = (Gerente) usuario;
                System.out.println(usuario.toString());
                System.out.println(" ");
            }
            do {
                System.out.println("Ingrese el ID del gerente que desee eliminar del sistema: ");
                eliminarGerente = scanner.nextInt();
                gerenteExistente = false;

                ArrayList<Usuario> eliminar = Libreria.usuarios.get(Rol.GERENTE);
                for (int i = 0; i < eliminar.size(); i++) {
                    Usuario usuarioEliminar = eliminar.get(i);
                    if (usuarioEliminar.getId() == eliminarGerente) {
                        gerenteExistente = true;
                        eliminar.remove(i);
                        System.out.println("El gerente: " + usuarioEliminar.getNombre() + " se ha eliminado correctamente del sistema");
                        System.out.println(" ");
                        break;
                    }
                }
                if (!gerenteExistente) {
                    System.out.println("El id que ingreso no pertecene a ningun gerente registrado. Intenta de nuevo.");
                    System.out.println(" ");
                    break;
                }
            } while (gerenteExistente);
        }
    }

}