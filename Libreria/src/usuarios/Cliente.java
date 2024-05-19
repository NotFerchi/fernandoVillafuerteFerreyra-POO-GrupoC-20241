package usuarios;
import libreria.Libreria;
import libreria.utils.DatosComun;
import usuarios.utils.Rol;
import java.util.ArrayList;
import java.util.Scanner;

public class Cliente extends Usuario {

    public Cliente(String nombre, String apellido, String fechaNacimiento ,String telefono, String nombreUsuario, String contrasena) {
        super(nombre, apellido, fechaNacimiento, telefono, Rol.CLIENTE, nombreUsuario, contrasena);
    }

    @Override
    public String toString() {
        return String.format("%s ", super.toString());
    }

    public static void registrarCliente() {
        ArrayList<String> datosComun = DatosComun.ObtenerDatosComun(Rol.CLIENTE);
        String nombre = datosComun.get(0);
        String apellido = datosComun.get(1);
        String fechaNacimiento = datosComun.get(2);
        String telefono = datosComun.get(3);
        String nombreUsuario = datosComun.get(4);
        String contrasena = datosComun.get(5);

        Cliente cliente = new Cliente(nombre, apellido, fechaNacimiento,telefono, nombreUsuario, contrasena);

        if (!Libreria.usuarios.containsKey(Rol.CLIENTE)) {
            Libreria.usuarios.put(Rol.CLIENTE, new ArrayList<Usuario>());
        }

        Libreria.usuarios.get(Rol.CLIENTE).add(cliente);
        Libreria.guardarUsuarioEnJSON();
        System.out.println("\nCliente Registrado Exitosamente\n");
    }

    public static void mostrarCliente() {
        System.out.println("\nClientes en la biblioteca");
        for (Usuario usuario : Libreria.usuarios.get(Rol.CLIENTE)) {
            usuarios.Cliente cliente = (usuarios.Cliente) usuario;
            System.out.println(cliente.toString());
            System.out.println(" ");
        }
    }

    public static void modificarCliente() {
        int modificarCliente = 0;
        boolean clienteExistente = true;
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nActualizar info de un cliente del sistema");
        System.out.println("Esta es la lista de clientes registrados: ");
        for (Usuario usuario : Libreria.usuarios.get(Rol.CLIENTE)) {
            Cliente cliente = (Cliente) usuario;
            System.out.println(usuario.toString());
            System.out.println(" ");
        }
        do {
            System.out.println("Ingrese el ID del cliente que desee actualizar del sistema: ");
            modificarCliente = scanner.nextInt();
            clienteExistente = false;

            ArrayList<Usuario> actualizar = Libreria.usuarios.get(Rol.CLIENTE);
            for (int i = 0; i < actualizar.size(); i++) {
                Usuario usuarioActualizar = actualizar.get(i);
                if (usuarioActualizar.getId() == modificarCliente) {
                    for (Usuario usuario : Libreria.usuarios.get(Rol.CLIENTE)) {

                        clienteExistente = true;
                        System.out.println("La informacion del cliente: " + usuarioActualizar.getNombre() + " se ha actualizado correctamente en el sistema");
                        System.out.println(" ");
                        break;
                    }
                }
            }
            if (!clienteExistente) {
                System.out.println("El id que ingreso no pertecene a ningun cliente registrado. Intenta de nuevo.");
                System.out.println(" ");
                break;
            }
        } while (clienteExistente);

    }

    public static void eliminarClientes() {
        int eliminarCliente = 0;
        boolean clienteExistente = true;
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEliminar clientes del sistema");
        System.out.println("Esta es la lista de clientes registrados: ");
        for (Usuario usuario : Libreria.usuarios.get(Rol.CLIENTE)) {
            Cliente cliente = (Cliente) usuario;
            System.out.println(usuario.toString());
            System.out.println(" ");
        }

        do {
            System.out.println("Ingrese el ID del cliente que desee eliminar del sistema: ");
            eliminarCliente = scanner.nextInt();
            clienteExistente = false;

            ArrayList<Usuario> eliminar = Libreria.usuarios.get(Rol.CLIENTE);
            for (int i = 0; i < eliminar.size(); i++) {
                Usuario usuarioEliminar = eliminar.get(i);
                if (usuarioEliminar.getId() == eliminarCliente) {
                    clienteExistente = true;
                    eliminar.remove(i);
                    System.out.println("El cliente: " + usuarioEliminar.getNombre() + " se ha eliminado correctamente del sistema");
                    System.out.println(" ");
                    break;
                }
            }
            if (!clienteExistente) {
                System.out.println("El id que ingreso no pertecene a ningun cliente registrado. Intenta de nuevo.");
                System.out.println(" ");
                break;
            }
        } while (clienteExistente);
    }
}