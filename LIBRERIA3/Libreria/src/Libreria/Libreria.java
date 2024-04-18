package Libreria;
import java.util.ArrayList;
import java.util.Scanner;


import Usuarios.Asistente;
import Usuarios.Cliente;
import Usuarios.Gerente;
import Usuarios.Usuario;
import Usuarios.Utils.Libro;
import Usuarios.Utils.Rol;


public class Libreria {

    private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    private ArrayList<Libro> libros = new ArrayList<Libro>();

    public Libreria(){
        Asistente asistente = new Asistente("Fer", "Villa", "44311009913", 1223, "VIMFJLG2352GFHJI2", "FVF", "SKINNYBITCH");
        usuarios.add(asistente);

        Gerente gerente = new Gerente("Vane", "Villa", "4431434533", "VANNN", 7000, "VAN.V", "NIGGAMAN");
        usuarios.add(gerente);

        Cliente cliente = new Cliente("NATA", "CANO", "4431109976", "CT", "VIEJON");
        usuarios.add(cliente);
    }
    public Usuario verificarInicioSesion(String nombreUsuario, String contrasena){
        for(Usuario usuario : usuarios){
            if(usuario.getNombreUsuario().equals(nombreUsuario)){
               if (usuario.getContrasena().equals(contrasena)){
                    return usuario;
                }
                return null;
            }
        }
        return null;
    }

    public void registrarCliente() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nRegistrar Cliente");
        System.out.println("Ingresa los siguientes datos para continuar");

        System.out.println("Ingresa el nombre: ");
        String nombre = scanner.nextLine();

        System.out.println("Ingresa el apellido: ");
        String apellido = scanner.nextLine();

        String telefono = registrarTelefonoUsario();

        String nombreUsuario = registrarNombreUsuario();

        System.out.println("Ingresa la contrasena: ");
        String contrasena = scanner.nextLine();

        Cliente cliente = new Cliente(nombre, apellido, telefono, nombreUsuario, contrasena);
        usuarios.add(cliente);
    }

    public void mostrarClientes() {
        System.out.println("\nClientes en la biblioteca");
        for (Usuario usuario : usuarios) {
            if (usuario.getRol() == Rol.CLIENTE) {
                Cliente cliente = (Cliente) usuario;
                System.out.println(cliente.toString());
                System.out.println(" ");
            }
        }
    }

    public void eliminarClientes() {
        int eliminarCliente = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEliminar clientes del sistema");
        System.out.println("Esta es la lista de clientes registrados: ");
        for (Usuario usuario : usuarios) {
            if (usuario.getRol() == Rol.CLIENTE) {
                Cliente cliente = (Cliente) usuario;
                System.out.println(".-" + usuario.toString());
                System.out.println(" ");
            }
        }
        System.out.println("Ingrese el ID del cliente que desee eliminar del sistema: ");
        eliminarCliente = scanner.nextInt();
        for (int i = 0 ;  i < usuarios.size(); i++) {
            if (usuarios.get(i).getId() == eliminarCliente) {
                usuarios.remove(i);
                break;
            }
        }

        System.out.println("El usuario " + usuarios.get(eliminarCliente).getNombreUsuario() + " con rol " + usuarios.get(eliminarCliente).getRol()
                + "eliminado del sistema correctamente");
    }

    public void registrarAsistente() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nRegistrar Asistente");
        System.out.println("Ingresa los siguientes datos para continuar");

        System.out.println("Ingresa el nombre: ");
        String nombre = scanner.nextLine();

        System.out.println("Ingresa el apellido: ");
        String apellido = scanner.nextLine();

        String telefono = registrarTelefonoUsario();

        System.out.println("Ingresa el sueldo: ");
        double sueldo = scanner.nextDouble();

        String ine = registrarIneUsuario();

        String nombreUsuario = registrarNombreUsuario();

        System.out.println("Ingresa la contrasena: ");
        String contrasena = scanner.nextLine();

        Asistente asistente = new Asistente(nombre, apellido, telefono, sueldo, ine, nombreUsuario, contrasena);
        usuarios.add(asistente);
    }

    public void mostrarAsistentes() {
        System.out.println("\nAsistentes en la biblioteca");
        for (Usuario usuario : usuarios) {
            if (usuario.getRol() == Rol.ASISTENTE) {
                Asistente asistente = (Asistente) usuario;
                System.out.println(asistente.toString());
                System.out.println(" ");
            }
        }
    }

    public void eliminarAsistentes() {
        int eliminarAsistente = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEliminar clientes del sistema");
        System.out.println("Esta es la lista de clientes registrados: ");
        for (Usuario usuario : usuarios) {
            if (usuario.getRol() == Rol.ASISTENTE) {
                Asistente asistente = (Asistente) usuario;
                System.out.println(".-" + usuario.toString());
                System.out.println(" ");
            }
        }
        System.out.println("Ingrese el ID del cliente que desee eliminar del sistema: ");
        eliminarAsistente = scanner.nextInt();
        for (int i = 0 ;  i < usuarios.size(); i++) {
            if (usuarios.get(i).getId() == eliminarAsistente) {
                usuarios.remove(i);
                break;
            }
        }

        System.out.println("El usuario " + usuarios.get(eliminarAsistente).getNombreUsuario() + " con rol " + usuarios.get(eliminarAsistente).getRol()
                + "eliminado del sistema correctamente");
    }

    public void registrarGerente() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nRegistrar Gerente");
        System.out.println("Ingresa los siguientes datos para continuar");

        System.out.println("Ingresa el nombre: ");
        String nombre = scanner.nextLine();

        System.out.println("Ingresa el apellido: ");
        String apellido = scanner.nextLine();

        String telefono = registrarTelefonoUsario();

        String ine = registrarIneUsuario();

        System.out.println("Ingresa el sueldo: ");
        double sueldo = scanner.nextDouble();

        String nombreUsuario = registrarNombreUsuario();

        System.out.println("Ingresa la contrasena: ");
        String contrasena = scanner.nextLine();

        Gerente gerente = new Gerente(nombre, apellido, telefono, ine, sueldo, nombreUsuario, contrasena);
        usuarios.add(gerente);
    }

    public void mostrarGerentes() {
        System.out.println("\nGerentes de la biblioteca");
        for (Usuario usuario : usuarios) {
            if (usuario.getRol() == Rol.GERENTE) {
                Gerente gerente = (Gerente) usuario;
                System.out.println(gerente.toString());
                System.out.println(" ");
            }
        }
    }

    public void eliminarGerentes() {
        int eliminarGerente = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEliminar cliente del sistema");
        System.out.println("Lista de clientes registrados: ");
        for (Usuario usuario : usuarios) {
            if (usuario.getRol() == Rol.GERENTE) {
                Gerente gerente = (Gerente) usuario;
                System.out.println(".-" + usuario.toString());
                System.out.println(" ");
            }
        }
        System.out.println("Ingrese el ID del cliente que desee eliminar del sistema: ");
        eliminarGerente = scanner.nextInt();
        for (int i = 0 ;  i < usuarios.size(); i++) {
            if (usuarios.get(i).getId() == eliminarGerente) {
                usuarios.remove(i);
                break;
            }
        }

        System.out.println("El usuario " + usuarios.get(eliminarGerente).getNombreUsuario() + " con rol " + usuarios.get(eliminarGerente).getRol()
                + "eliminado del sistema correctamente");
    }

    public void registrarLibros() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nRegistrar Libros");
        System.out.println("Ingresa los siguientes datos para continuar");

        System.out.println("Ingresa el nombre: ");
        String nombre = scanner.nextLine();

        System.out.println("Ingresa el autor del libro: ");
        String autor = scanner.nextLine();

        System.out.println("Ingresa el stock: ");
        int stock = scanner.nextInt();

        Libro libro = new Libro(nombre, autor, stock);
        libros.add(libro);
    }

    public void mostrarLibros() {
        System.out.println("\nLibros disponibles en la biblioteca");
        for (Libro libro : libros) {
            System.out.println(libro.toString());
            System.out.println(" ");
        }
    }

    private String registrarTelefonoUsario() {
        Scanner scanner = new Scanner(System.in);
        boolean telefonoExistente = true;
        String telefono = "";
        do {
            System.out.println("Ingresa el telefono: ");
            telefonoExistente = false;
            telefono = scanner.nextLine();

            for (Usuario usuario : usuarios) {
                if (usuario.getTelefono().equals(telefono)) {
                    telefonoExistente = true;
                    break;
                }
            }

            if (telefonoExistente) {
                System.out.println("EL telefono ya se encuentra registrado. Intenta de nuevo.");
            }
        } while (telefonoExistente);
        return telefono;
    }

    private String registrarNombreUsuario() {
        Scanner scanner = new Scanner(System.in);
        String nombreUsuario = "";
        boolean nombreUsuarioExistente = true;
        do {

            System.out.println("Ingresa el nombre de usuario: ");
            nombreUsuarioExistente = false;
            nombreUsuario = scanner.nextLine();

            for (Usuario usuario : usuarios) {
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

    private String registrarIneUsuario() {
        Scanner scanner = new Scanner(System.in);
        String ineUsuario = "";
        boolean ineUsuarioExistente = true;
        do {

            System.out.println("Ingresa el INE de usuario: ");
            ineUsuarioExistente = false;
            ineUsuario = scanner.nextLine();

            for (Usuario usuario : usuarios) {
                if (usuario.getNombreUsuario().equals(ineUsuario)) {
                    ineUsuarioExistente = true;
                    break;
                }
            }

            if (ineUsuarioExistente) {
                System.out.println("Ya existe un registro con esa INE. Intenta de nuevo");
            }
        } while (ineUsuarioExistente);

        return ineUsuario;
    }
}