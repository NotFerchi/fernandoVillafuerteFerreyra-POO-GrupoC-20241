package libreria;

import libros.LibroAccion;
import libros.LibroTerror;
import usuarios.Usuario;
import utils.UsuarioEnSesion;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    private Libreria libreria = new Libreria();

    public void iniciarSesion() {
        Scanner scanner = new Scanner(System.in);

        boolean datosCorrectos = false;
        System.out.println("Bienvenido al sistema de la biblioteca");
        do {
            System.out.println("Para continuar inicia sesion");

            System.out.println("Ingresa tu usuario: ");
            String usuario = scanner.nextLine();

            System.out.println("Ingresa tu contrasena: ");
            String contrasena = scanner.nextLine();

            Usuario usuarioActual = libreria.verificarInicioSesion(usuario, contrasena) ;
            if(usuarioActual != null) {
                datosCorrectos = true;
                UsuarioEnSesion.obtenerInstancia().setUsuarioActual(usuarioActual);
                seleccionarMenu();
            } else {
                System.out.printf("Usuario o contrasena incorrectos. Intenta de nuevo.\n");
            }
        }while(!datosCorrectos);
    }

    private void seleccionarMenu() {
        Usuario usuario = UsuarioEnSesion.obtenerInstancia().getUsuarioActual();
        switch (usuario.getRol()) {
            case CLIENTE -> mostrarMenuCliente();
            case ASISTENTE -> mostrarMenuAsistente();
            case GERENTE -> mostrarMenuGerente();
        }
    }

    private void mostrarMenuCliente() {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        System.out.println("Bienvenido al sistema del Cliente");
        do {
            System.out.println("Estas son las opciones: ");
            System.out.println("1. Ver lista de libros");
            System.out.println("2. Consultar las rentas");
            System.out.println("3. Mostrar mis datos");
            System.out.println("4. Editar mi informacion");
            System.out.println("0. Cerrar sesion");
            opcion = scanner.nextInt();

            switch (opcion) {

                case 1:
                    System.out.println("Elegiste la opcion 1");
                    menuMostrarLibro();
                    break;
                case 2:
                    System.out.println("Elegiste la opcion 2");
                    break;
                case 3:
                    System.out.println("Elegiste la opcion 3");
                    break;
                case 4:
                    System.out.println("Elegiste la opcion 4");
                    break;
                case 0:
                    System.out.println("Elegiste la opcion 5");
                    System.out.println("Cerrando sesion...");
                    UsuarioEnSesion.obtenerInstancia().cerrarSesion();
                    iniciarSesion();
                    break;
            }
        }while(opcion != 0);
    }

    private void mostrarMenuAsistente() {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        System.out.println("Bienvenido al sistema del Asistente");
        do {
            System.out.println("Estas son las opciones: ");

            System.out.println("1. Registrar un cliente");
            System.out.println("2. Registrar un libro");

            System.out.println("3. Ver lista de clientes");
            System.out.println("4. Ver lista de libros");

            System.out.println("5. Actualizar info cliente");
            System.out.println("6. Actualizar info libro");

            System.out.println("7. Eliminar cliente del sistema");
            System.out.println("8. Eliminar libro del sistema");

            System.out.println("9. Ver libros rentaddos");

            System.out.println("0. Cerrar sesion");
            opcion = scanner.nextInt();

            switch (opcion) {

                case 1:
                    libreria.registrarCliente();
                    break;
                case 2:
                    break;
                case 3:
                    libreria.mostrarClientes();
                    break;
                case 4:
                    menuMostrarLibro();
                    break;
                case 5:
                    break;
                case 6:

                    break;
                case 7:
                    libreria.eliminarClientes();
                    break;
                case 8:
                    menuEliminarLibro();
                    break;
                case 9:
                    break;
                case 10:
                    break;
                case 11:
                    break;
                case 0:
                    System.out.println("Cerrando sesion...");
                    UsuarioEnSesion.obtenerInstancia().cerrarSesion();
                    iniciarSesion();
                    break;
            }
        }while(opcion != 0);
    }

    private void menuRegistrarLibro() {
        Scanner scanner = new Scanner(System.in);
        int opcionMenuRegistrarLibro = 0;


        System.out.println("\nRegistrar libro");
        System.out.println("Ingresa el tipo de libro que deseas registrar");
        System.out.println("1. Acción");
        System.out.println("2. Comedia");
        System.out.println("3. Terror");
        System.out.println("4. Salir");
        opcionMenuRegistrarLibro = scanner.nextInt();

        try {
            switch (opcionMenuRegistrarLibro) {
                case 1:
                    System.out.println("Accion");
                    Libreria.registrarLibroAccion();
                    break;
                case 2:
                    System.out.println("Comedia");
                    Libreria.registrarLibroComedia();
                    break;
                case 3:
                    System.out.println("Terror");
                    Libreria.registrarLibroTerror();
                    break;
            }
        } catch (InputMismatchException e) {
            System.out.println("Error opcion invalida");
        }
    }

    private void menuEliminarLibro() {
        Scanner scanner = new Scanner(System.in);
        int opcionMenuEliminarLibro = 0;

        System.out.println("\nEliminar libro");
        System.out.println("Ingresa el tipo de libro que deseas eliminar");
        System.out.println("1. Acción");
        System.out.println("2. Comedia");
        System.out.println("3. Terror");
        System.out.println("4. Salir");
        opcionMenuEliminarLibro = scanner.nextInt();

        try {
            switch (opcionMenuEliminarLibro) {
                case 1:
                    System.out.println("Accion");
                    Libreria.eliminarLibroAccion();
                    break;
                case 2:
                    System.out.println("Comedia");
                    Libreria.eliminarLibroComedia();
                    break;
                case 3:
                    System.out.println("Terror");
                    Libreria.eliminarLibroTerror();
                    break;
            }

        } catch (InputMismatchException e) {
            System.out.println("Error opcion invalida");
        }
    }

    private void menuMostrarLibro() {
        Scanner scanner = new Scanner(System.in);
        int opcionMenuEliminarLibro = 0;

        System.out.println("\nMostrar libro");
        System.out.println("Ingresa el tipo de libro que deseas mostrar");
        System.out.println("1. Acción");
        System.out.println("2. Comedia");
        System.out.println("3. Terror");
        System.out.println("4. Salir");
        opcionMenuEliminarLibro = scanner.nextInt();

        try {
            switch (opcionMenuEliminarLibro) {
                case 1:
                    System.out.println("Accion");
                    Libreria.mostrarLibroAccion();
                    break;
                case 2:
                    System.out.println("Comedia");
                    Libreria.mostrarLibroComedia();
                    break;
                case 3:
                    System.out.println("Terror");
                    Libreria.mostrarLibroTerror();
                    break;

            }
        } catch (InputMismatchException e) {
            System.out.println("Error opcion invalida");
        }
    }

    private void mostrarMenuGerente() {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        System.out.println("Bienvenido al sistema del Gerente");
        do {
            System.out.println("Estas son las opciones: ");

            System.out.println("1. Registrar un cliente");
            System.out.println("2. Registrar asistente");
            System.out.println("3. Registrar gerente");
            System.out.println("4. Registrar un libro");

            System.out.println("5. Ver lista de clientes");
            System.out.println("6. Ver lista de asistentes");
            System.out.println("7. Ver lista de gerentes");
            System.out.println("8. Ver lista de libros");

            System.out.println("9. Actualizar inf cliente");
            System.out.println("10. Actualizar info asistente");
            System.out.println("11. Actializar info gerente");
            System.out.println("12. Actualizar datos de un libro");

            System.out.println("13. Eliminar cliente del sistema");
            System.out.println("14. Eliminar asistente del sistema");
            System.out.println("15. Eliminar gerente del sistema");
            System.out.println("16. Eliminar un libro del sistema");

            System.out.println("17. Rentar libro");
            System.out.println("18. Ver libros rentaddos");

            System.out.println("0. Cerrar sesion");
            opcion = scanner.nextInt();

            switch (opcion) {

                case 1:
                    libreria.registrarCliente();
                    break;
                case 2:
                    libreria.registrarAsistente();
                    break;
                case 3:
                    libreria.registrarGerente();
                    break;
                case 4:
                    menuRegistrarLibro();
                    break;
                case 5:
                    libreria.mostrarClientes();
                    break;
                case 6:
                    libreria.mostrarAsistentes();
                    break;
                case 7:
                    libreria.mostrarGerentes();
                    break;
                case 8:
                    menuMostrarLibro();
                    break;
                case 9:
                    break;
                case 10:
                    break;
                case 11:
                    break;
                case 12:
                    break;
                case 13:
                    libreria.eliminarClientes();
                    break;
                case 14:
                    libreria.eliminarAsistentes();
                    break;
                case 15:
                    libreria.eliminarGerentes();
                    break;
                case 16:
                    menuEliminarLibro();
                    break;
                case 17:
                    break;
                case 18:
                    break;
                case 0:
                    System.out.println("Cerrando sesion...");
                    UsuarioEnSesion.obtenerInstancia().cerrarSesion();
                    iniciarSesion();
                    break;
            }
        }while(opcion != 0);
    }
}