package usuarios;

import libreria.Libreria;
import libreria.utils.DatosComun;
import usuarios.utils.Rol;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Cliente extends Usuario {
    private LocalDate fechaRegistro;

    public Cliente(String nombre, String apellido, String telefono, String nombreUsuario, String contrasena, String fechaNacimiento) {
        super(nombre, apellido, telefono, Rol.CLIENTE, nombreUsuario, contrasena, fechaNacimiento);
        this.fechaRegistro = LocalDate.now();
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", fecha registro: %s", fechaRegistro);
    }

    // Método para registrar un cliente
    public static void registrarCliente() {
        ArrayList<String> datosComun = DatosComun.ObtenerDatosComun(Rol.CLIENTE);
        String nombre = datosComun.get(0);
        String apellido = datosComun.get(1);
        String telefono = datosComun.get(2);
        String nombreUsuario = datosComun.get(3);
        String contrasena = datosComun.get(4);
        String fechaNacimiento = datosComun.get(5);

        Cliente cliente = new Cliente(nombre, apellido, telefono, nombreUsuario, contrasena, fechaNacimiento) {
            @Override
            public void setFechaNacimiento(String nuevaFecha) {

            }
        };

        if (!Libreria.usuarios.containsKey(Rol.CLIENTE)) {
            Libreria.usuarios.put(Rol.CLIENTE, new ArrayList<>());
        }

        Libreria.usuarios.get(Rol.CLIENTE).add(cliente);
        System.out.println("\nCliente Registrado Exitosamente\n");
    }

    // Método para mostrar clientes
    public static void mostrarCliente() {
        System.out.println("\nClientes en la biblioteca");
        for (Usuario usuario : Libreria.usuarios.get(Rol.CLIENTE)) {
            Cliente cliente = (Cliente) usuario;
            System.out.println(cliente.toString());
            System.out.println(" ");
        }
    }

    // Método para eliminar clientes
    public static void eliminarClientes() {
        int eliminarCliente;
        boolean clienteExistente;
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEliminar clientes del sistema");
        System.out.println("Esta es la lista de clientes registrados: ");
        for (Usuario usuario : Libreria.usuarios.get(Rol.CLIENTE)) {
            Cliente cliente = (Cliente) usuario;
            System.out.println(usuario.toString());
            System.out.println(" ");
        }

        do {
            clienteExistente = false;
            System.out.println("Ingrese el ID del cliente que desee eliminar del sistema: ");
            eliminarCliente = scanner.nextInt();

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
                System.out.println("El ID que ingresó no pertenece a ningún cliente registrado. Intenta de nuevo.");
                System.out.println(" ");
            }
        } while (!clienteExistente);
    }
}