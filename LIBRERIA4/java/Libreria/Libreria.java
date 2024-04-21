  package Libreria;
  import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
  import java.util.HashMap;
  import Usuarios.Asistente;
  import Usuarios.Cliente;
  import Usuarios.Gerente;
  import Usuarios.Usuario;
  import Usuarios.Utils.Libro;
  import Usuarios.Utils.Rol;
  import java.util.Arrays;

public class Libreria {

    private ArrayList<Libro> libros = new ArrayList<Libro>();
    HashMap<Rol, ArrayList<Usuario>> usuarios = new HashMap<Rol, ArrayList<Usuario>>();

    public Usuario verificarInicioSesion(String nombreUsuario, String contrasena) {
        for (ArrayList<Usuario> listaUsuarios : usuarios.values()) {
            for (Usuario usuario : listaUsuarios) {
                if (usuario.getNombreUsuario().equals(nombreUsuario) && usuario.getContrasena().equals(contrasena)) {
                    return usuario;
                }
            }
        }
        return null;
    }

    private ArrayList<String> obtenerDatosComun(Rol rol) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> datosComun = new ArrayList<String>();

        String rolUsuario = rol == Rol.CLIENTE ? "Cliente" : rol == Rol.ASISTENTE ? "Asistente" : "Gerente";
        System.out.println(String.format("Bienvenido al registro del %s", rolUsuario));
        System.out.println("\nRegistrar " + rolUsuario);
        System.out.println("Ingresa los siguientes datos para continuar");

        System.out.println("Ingresa el nombre: ");
        String nombre = scanner.nextLine();

        System.out.println("Ingresa el apellido: ");
        String apellido = scanner.nextLine();

        String telefono = registrarTelefonoUsuario();

        String nombreUsuario = registrarNombreUsuario();

        System.out.println("Ingresa la contraseña: ");
        String contrasena = scanner.nextLine();

        datosComun.addAll(Arrays.asList(nombre, apellido, telefono, nombreUsuario, contrasena));
        return datosComun;
    }

    public void registrarCliente() {
        ArrayList<String> datosComun = obtenerDatosComun(Rol.CLIENTE);
        String nombre = datosComun.get(0);
        String apellido = datosComun.get(1);
        String telefono = datosComun.get(2);
        String nombreUsuario = datosComun.get(3);
        String contrasena = datosComun.get(4);

        Cliente cliente = new Cliente(nombre, apellido, telefono, nombreUsuario, contrasena);

        if (!usuarios.containsKey(Rol.CLIENTE)) {
            usuarios.put(Rol.CLIENTE, new ArrayList<Usuario>());
        }

        usuarios.get(Rol.CLIENTE).add(cliente);
        System.out.println("Cliente registrado correctamente.");
    }

    public void mostrarClientes() {
        System.out.println("\nClientes en la biblioteca");
        for (Usuario usuario : usuarios.get(Rol.CLIENTE)) {
            Cliente cliente = (Cliente) usuario;
            System.out.println(cliente.toString());
        }
    }

    public void registrarAsistente() {
        ArrayList<String> datosComun = obtenerDatosComun(Rol.ASISTENTE);
        String nombre = datosComun.get(0);
        String apellido = datosComun.get(1);
        String telefono = datosComun.get(2);
        String nombreUsuario = datosComun.get(3);
        String contrasena = datosComun.get(4);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa el sueldo: ");
        double sueldo = scanner.nextDouble();

        System.out.println("Ingresa tu RFC: ");
        String rfc = scanner.nextLine();

        Asistente asistente = new Asistente(nombre, apellido, telefono, sueldo, rfc, nombreUsuario, contrasena);

        if (!usuarios.containsKey(Rol.ASISTENTE)) {
            usuarios.put(Rol.ASISTENTE, new ArrayList<Usuario>());
        }

        usuarios.get(Rol.ASISTENTE).add(asistente);
        System.out.println("Asistente registrado correctamente.");
    }

    public void mostrarAsistentes() {
        System.out.println("\nAsistentes en la biblioteca");
        for (Usuario usuario : usuarios.get(Rol.ASISTENTE)) {
            Asistente asistente = (Asistente) usuario;
            System.out.println(asistente.toString());
        }
    }

    public void registrarGerente() {
        ArrayList<String> datosComun = obtenerDatosComun(Rol.GERENTE);
        String nombre = datosComun.get(0);
        String apellido = datosComun.get(1);
        String telefono = datosComun.get(2);
        String nombreUsuario = datosComun.get(3);
        String contrasena = datosComun.get(4);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa el sueldo: ");
        double sueldo = scanner.nextDouble();

        System.out.println("Ingresa tu INE: ");
        String ine = scanner.nextLine();

        Gerente gerente = new Gerente(nombre, apellido, telefono, sueldo, ine, nombreUsuario, contrasena);

        if (!usuarios.containsKey(Rol.GERENTE)) {
            usuarios.put(Rol.GERENTE, new ArrayList<Usuario>());
        }

        usuarios.get(Rol.GERENTE).add(gerente);
        System.out.println("Gerente registrado correctamente.");
    }

    public void mostrarGerentes() {
        System.out.println("\nGerentes en la biblioteca");
        for (Usuario usuario : usuarios.get(Rol.GERENTE)) {
            Gerente gerente = (Gerente) usuario;
            System.out.println(gerente.toString());
        }
    }

    public void registrarLibros() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nRegistrar Libros");
        System.out.println("Ingresa los siguientes datos para continuar");

        System.out.println("Ingresa el nombre: ");
        String nombre = scanner.nextLine();

        System.out.println("Ingresa el autor del libro: ");
        String autor = scanner.nextLine();

        System.out.println("Ingresa el stock disponible: ");
        int stock = scanner.nextInt();

        Libro libro = new Libro(nombre, autor, stock);
        libros.add(libro);
    }

    public void mostrarLibros() {
        System.out.println("\nLibros disponibles en la biblioteca");
        for (Libro libro : libros) {
            System.out.println(libro.toString());
        }
    }

    private String registrarTelefonoUsuario() {
        Scanner scanner = new Scanner(System.in);
        boolean telefonoExistente = true;
        String telefono = "";
        do {
            System.out.println("Ingresa el teléfono: ");
            telefonoExistente = false;
            telefono = scanner.nextLine();

            for (ArrayList<Usuario> listaUsuarios : usuarios.values()) {
                for (Usuario usuario : listaUsuarios) {
                    if (usuario.getTelefono().equals(telefono)) {
                        telefonoExistente = true;
                        break;
                    }
                }
            }

            if (telefonoExistente) {
                System.out.println("El teléfono ya se encuentra registrado. Intente de nuevo.");
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

            for (ArrayList<Usuario> listaUsuarios : usuarios.values()) {
                for (Usuario usuario : listaUsuarios) {
                    if (usuario.getNombreUsuario().equals(nombreUsuario)) {
                        nombreUsuarioExistente = true;
                        break;
                    }
                }
            }

            if (nombreUsuarioExistente) {
                System.out.println("Ya existe un registro con ese nombre de usuario. Intente de nuevo.");
            }
        } while (nombreUsuarioExistente);

        return nombreUsuario;
    }
}

