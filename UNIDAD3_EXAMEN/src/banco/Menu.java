package banco;
import usuarios.Cliente;
import usuarios.Usuario;
import usuarios.empleados.GerenteSucursal;
import usuarios.utils.UsuarioEnSesion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    private Banco banco = new Banco();
    public static HashMap<Sucursal, ArrayList<Cliente>> listaClientes = new HashMap<Sucursal, ArrayList<Cliente>>();

    public static void iniciarSesion() {
        Scanner scanner = new Scanner(System.in);
        boolean datosCorrectos = false;

        do {
            try {
                System.out.println("\n----- B I E N V E N I D O   A L   S I S T E M A   D E L    B A N C O   C H I L A C A S -----");
                System.out.println();
                System.out.println("Selecciona tu sucursal:");
                System.out.println("1. A C U E D U C T O");
                System.out.println("2. M A D E R O");
                System.out.println();
                System.out.print("Ingresa el número de tu sucursal: ");

                int sucursalActual = scanner.nextInt();
                scanner.nextLine();


                Sucursal sucursalSeleccionada = (sucursalActual == 1) ? Sucursal.ACUEDUCTO : Sucursal.MADERO;

                System.out.print("Ingresa tu nombre de usuario: ");
                String usuario = scanner.nextLine();

                System.out.print("Ingresa tu contraseña: ");
                String contrasena = scanner.nextLine();


                Usuario usuarioActual = Banco.verificarInicioSesion(sucursalSeleccionada, usuario, contrasena);

                if (usuarioActual != null) {
                    System.out.println("\nInicio de sesión exitoso.");

                    UsuarioEnSesion.obtenerInstancia().setUsuarioActual(usuarioActual);

                    seleccionarMenu();
                    datosCorrectos = true;
                } else {
                    System.out.println("Datos incorrectos, inténtalo de nuevo.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Ingresa un número válido para la sucursal.");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Error inesperado: " + e.getMessage());
            }
        } while (!datosCorrectos);

        scanner.close();
    }

    public static void seleccionarMenu() {
        Usuario usuario = UsuarioEnSesion.obtenerInstancia().getUsuarioActual();
        switch (usuario.getRol()) {
            case CLIENTE:
                menuCliente(usuario.getSucursal());
                break;
            case CAPTURISTA:
                menuCapturista(usuario.getSucursal());
                break;
            case INVERSIONISTA:
                menuInversionista(usuario.getSucursal());
                break;
            case EJECUTIVODECUENTA:
                menuEjecutivoCuenta(usuario.getSucursal());
                break;
            case GERENTE_SUCURSAL:
                menuGerente(usuario.getSucursal());
                break;
        }
    }

    public static void menuGerente(Sucursal sucursal) {
        Usuario usuario = UsuarioEnSesion.obtenerInstancia().getUsuarioActual();
        Scanner leer = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("\n----- M E N U   D E L   G E R E N T E   D E   S U C U R S A L -----");
            System.out.println("Acciones con:");
            System.out.println("1. Clientes");
            System.out.println("2. Capturistas");
            System.out.println("3. Ejecutivos de Cuenta");
            System.out.println("4. Inversionistas");
            System.out.println("5. Ver solicitudes de tarjetas");
            System.out.println("6. Estados de solicitudes de tarjetas.");
            System.out.println("7. Clave de seguridad para el inversionista");
            System.out.println("8. Movimientos de inversionistas");
            System.out.println("9. Cerrar sesión");

            System.out.print("\nSeleccione una categoría para gestionar: ");
            opcion = leer.nextInt();

            switch (opcion) {

                case 1:
                    menuClientes(usuario);
                    break;

                case 2:
                    menuCapturistas(usuario);
                    break;

                case 3:
                    menuEjecutivos(usuario);
                    break;

                case 4:
                    menuInversionistas(usuario);
                    break;

                case 5:
                    Banco.mostrarSolicitudes();
                    break;

                case 6:
                    Banco.autorizarSolicitud(usuario);
                    break;

                case 7:
                    GerenteSucursal.generarClaveSeguridad(usuario);
                    break;
                case 8:
                    Banco.mostrarInversiones(usuario,sucursal);

                case 9:
                    System.out.println("\nCerrando sesión...");
                    UsuarioEnSesion.obtenerInstancia().cerrarSesion();
                    iniciarSesion();
                    break;

                default:
                    System.out.println("\nOpción no válida");
            }
        } while (opcion != 9);
    }

    private static void menuClientes(Usuario usuario) {
        Scanner leer = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n----- GESTIÓN DE CLIENTES -----");
            System.out.println("1. Registrar cliente");
            System.out.println("2. Mostrar lista de clientes");
            System.out.println("3. Modificar cliente");
            System.out.println("4. Eliminar cliente");
            System.out.println("5. Volver al menú principal");

            System.out.print("\nAcción a realizar: ");
            opcion = leer.nextInt();

            switch (opcion) {
                case 1:
                    Banco.registrarCliente(usuario);
                    break;

                case 2:
                    Banco.mostrarClientes(usuario);
                    break;

                case 3:
                    Banco.modificarCliente(usuario);
                    break;

                case 4:
                    Banco.eliminarCliente(usuario);
                    break;

                case 5:
                    System.out.println("\nVolviendo al menú principal...");
                    break;

                default:
                    System.out.println("\nOpción no válida");
            }
        } while (opcion != 5);
    }

    private static void menuCapturistas(Usuario usuario) {
        Scanner leer = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n----- GESTIÓN DE CAPTURISTAS -----");
            System.out.println("1. Registrar capturista");
            System.out.println("2. Mostrar lista de capturistas");
            System.out.println("3. Modificar capturista");
            System.out.println("4. Eliminar capturista");
            System.out.println("5. Volver al menú principal");

            System.out.print("\nAcción a realizar: ");
            opcion = leer.nextInt();

            switch (opcion) {
                case 1:
                    Banco.registrarCapturista(usuario);
                    break;

                case 2:
                    Banco.mostrarCapturista(usuario);
                    break;

                case 3:
                    Banco.modificarCapturista(usuario);
                    break;

                case 4:
                    Banco.eliminarCapturista(usuario);
                    break;

                case 5:
                    System.out.println("\nVolviendo al menú principal...");
                    break;

                default:
                    System.out.println("\nOpción no válida");
            }
        } while (opcion != 5);
    }

    private static void menuEjecutivos(Usuario usuario) {
        Scanner leer = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n----- GESTIÓN DE EJECUTIVOS DE CUENTA -----");
            System.out.println("1. Registrar ejecutivo de cuenta");
            System.out.println("2. Mostrar lista de ejecutivos de cuenta");
            System.out.println("3. Modificar ejecutivo de cuenta");
            System.out.println("4. Eliminar ejecutivo de cuenta");
            System.out.println("5. Volver al menú principal");

            System.out.print("\nAcción a realizar: ");
            opcion = leer.nextInt();

            switch (opcion) {
                case 1:
                    Banco.registrarEjecutivo(usuario);
                    break;

                case 2:
                    Banco.mostrarEjecutivos(usuario);
                    break;

                case 3:
                    Banco.modificarEjecutivo(usuario);
                    break;

                case 4:
                    Banco.eliminarEjecutivo(usuario);
                    break;

                case 5:
                    System.out.println("\nVolviendo al menú principal...");
                    break;

                default:
                    System.out.println("\nOpción no válida");
            }
        } while (opcion != 5);
    }

    private static void menuInversionistas(Usuario usuario) {
        Scanner leer = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n----- GESTIÓN DE INVERSIONISTAS -----");
            System.out.println("1. Registrar inversionista");
            System.out.println("2. Mostrar lista de inversionistas");
            System.out.println("3. Modificar inversionista");
            System.out.println("4. Eliminar inversionista");
            System.out.println("5. Volver al menú principal");

            System.out.print("\nAcción a realizar: ");
            opcion = leer.nextInt();

            switch (opcion) {
                case 1:
                    Banco.registrarInversionista(usuario);
                    break;

                case 2:
                    Banco.mostrarInversionista(usuario);
                    break;

                case 3:
                    Banco.modificarInversionista(usuario);
                    break;

                case 4:
                    Banco.eliminarInversionista(usuario);
                    break;

                case 5:
                    System.out.println("\nVolviendo al menú principal...");
                    break;

                default:
                    System.out.println("\nOpción no válida");
            }
        } while (opcion != 5);
    }

    public static void menuEjecutivoCuenta(Sucursal sucursal) {
        Scanner leer = new Scanner(System.in);
        Usuario usuario = UsuarioEnSesion.obtenerInstancia().getUsuarioActual();
        int opcion;
        do {
            System.out.println("\n----- M E N U   D E L   E J E C U T I V O   D E   C U E N T A -----");
            System.out.println("1. Registrar cliente.");
            System.out.println("2. Mostrar lista de clientes");
            System.out.println("3. Modificar clientes");
            System.out.println("4. Eliminar clientes");
            System.out.println("5. Cerrar sesión.");

            System.out.println("\nAcción a realizar: ");
            opcion = leer.nextInt();
            switch (opcion) {
                case 1:
                    Banco.registrarCliente(usuario);
                    break;

                case 2:
                    Banco.mostrarClientes(usuario);
                    break;

                case 3:
                    Banco.modificarCliente(usuario);
                    break;

                case 4:
                    Banco.eliminarCliente(usuario);
                    break;

                case 5:
                    System.out.println("\nCerrando sesión");
                    UsuarioEnSesion.obtenerInstancia().cerrarSesion();
                    iniciarSesion();
                    break;

                default: System.out.println("\nOpción no válida");
            }
        } while (opcion != 5);
    }

    public static void menuCliente(Sucursal sucursal) {
        Scanner leer = new Scanner(System.in);
        Usuario usuario = UsuarioEnSesion.obtenerInstancia().getUsuarioActual();
        Cliente cliente = (Cliente) usuario;
        int opcion ;
        do {
            System.out.println("\n----- M E N U   D E L   C L I E N T E -----");
            System.out.println("1. Ver información personal.");
            System.out.println("2. Ver fondos de tarjetas");
            System.out.println("3. Solicitar tarjeta de credito");
            System.out.println("4. Ver solicitudes");
            System.out.println("5. Realizar abono");
            System.out.println("6. Cerrar sesión.");

            System.out.println("\nAcción a realizar: ");
            opcion = leer.nextInt();
            switch (opcion) {

                case 1:
                    Banco.mostrarInformacionClienteActual(usuario);
                    break;

                case 2:
                    cliente.verFondosTarjetas();
                    break;

                case 3:
                    Banco.solicitarTarjetaCredito(usuario);
                    break;

                case 4:
                    cliente.mostrarSolicitudesPropias();
                    break;
                case 5:
                    Banco.realizarAbono();
                    break;

                case 6:
                    System.out.println("\nCerrando sesión");
                    UsuarioEnSesion.obtenerInstancia().cerrarSesion();
                    iniciarSesion();
                    break;


                default: System.out.println("\nOpción no válida");
            }
        } while (opcion != 6);
    }

    public static void menuInversionista(Sucursal sucursal){
        Usuario usuario = UsuarioEnSesion.obtenerInstancia().getUsuarioActual();
        Scanner leer = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n----- M E N U   D E L   I N V E R S I O N I S T A -----");
            System.out.println("1. Ver información.");
            System.out.println("2. Realizar fondo de inversión");
            System.out.println("3. Mostrar los fondos de inverión");
            System.out.println("4. Cerrar sesión.");

            System.out.println("\nAcción a realizar: ");
            opcion = leer.nextInt();
            switch (opcion) {

                case 1:
                    Banco.mostrarDatosPersonales(usuario);
                    break;
                case 2:
                    Banco.realizarInversion(usuario);
                    break;
                case 3:
                    Banco.mostrarInversionesPropias(usuario);

                case 4:
                    System.out.println("\nCerrando sesión");
                    UsuarioEnSesion.obtenerInstancia().cerrarSesion();
                    iniciarSesion();
                    break;

                default: System.out.println("\nOpción no válida");
            }
        } while (opcion != 3);
    }

    public static void menuCapturista(Sucursal sucuarsal) {
        Scanner leer = new Scanner(System.in);
        Usuario usuario = UsuarioEnSesion.obtenerInstancia().getUsuarioActual();
        int opcion;

        do
        {
            System.out.println("\n----- M E N U   D E L   C A P T U R I S T A -----");
            System.out.println("1. Registrar ejecutivo de venta.");
            System.out.println("2. Mostrar lista de ejecutivos de cuenta");
            System.out.println("3. Modificar ejecutivo de cuenta");
            System.out.println("4. Eliminar ejecutivo de cuenta");
            System.out.println("5. Cerrar sesión");

            System.out.println("\nAcción a realizar: ");
            opcion = leer.nextInt();
            switch (opcion)
            {

                case 1:
                    Banco.registrarInversionista(usuario);
                    break;

                case 2:
                    Banco.mostrarEjecutivos(usuario);
                    break;

                case 3:
                    Banco.modificarEjecutivo(usuario);
                    break;

                case 4:
                    Banco.eliminarEjecutivo(usuario);
                    break;

                case 5:
                    System.out.println("\nCerrando sesión");
                    UsuarioEnSesion.obtenerInstancia().cerrarSesion();
                    iniciarSesion();
                    break;

                default: System.out.println("\nOpción no válida");
            }
        } while (opcion != 5);
    }

}
