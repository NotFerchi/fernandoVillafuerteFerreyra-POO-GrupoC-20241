package usuarios;
import banco.Banco;
import banco.Sucursal;
import tarjetas.Credito;
import tarjetas.SolicitudTarjeta;
import tarjetas.utils.EstadoSolicitud;
import tarjetas.utils.TipoTarjetaCredito;
import usuarios.utils.Rol;
import tarjetas.Debito;
import tarjetas.Tarjeta;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Cliente extends Usuario {
    private Debito tarjetaDebito;
    private ArrayList<Tarjeta> listaTarjetaCredito;

    public Cliente(String nombre, String apellidoMaterno, String apellidoPaterno, String fechaDeNacimiento, String ciudad, String estado, String curp, String direccion, String RFC, Rol rol, Sucursal sucursal, String sexo, String userName, String password) {
        super(nombre, apellidoMaterno, apellidoPaterno, fechaDeNacimiento, ciudad, estado, curp, direccion, RFC, rol, sucursal, sexo, userName, password);
        this.tarjetaDebito = Debito.crearTarjeta();
        this.listaTarjetaCredito = new ArrayList<>();
    }


    public static void registerCliente(Usuario usuarioActual) {
        System.out.println("\n----- R E G I S T R O   D E L   C L I E N T E S ----");
        ArrayList<String> datosComun = Usuario.registerUser(Rol.CLIENTE);
        String nameClient = datosComun.get(0);
        String fatherLastNameClient = datosComun.get(1);
        String motherLastNameClient = datosComun.get(2);
        String fechaDeNacimiento = datosComun.get(3);
        String cityClient = datosComun.get(4);
        String estadoCliente = datosComun.get(5);
        String CURPClient = datosComun.get(6);
        String direccionClient = datosComun.get(7);
        String sexoClient = datosComun.get(8);
        String usuarioClient = datosComun.get(9);
        String passwordClient = datosComun.get(10);
        String RFCClient = Usuario.generateRFC(nameClient, fatherLastNameClient, motherLastNameClient, fechaDeNacimiento);

        if (RFCClient != null) {
            RFCList.add(RFCClient);
            Usuario.validarRFC(RFCClient);
            Cliente newCliente = new Cliente(nameClient, fatherLastNameClient, motherLastNameClient,
                    fechaDeNacimiento, cityClient, estadoCliente, CURPClient, direccionClient, RFCClient, Rol.CLIENTE, usuarioActual.getSucursal(), sexoClient, usuarioClient, passwordClient);

            if (usuarioActual.getSucursal().equals(Sucursal.MADERO)) {
                if (!Banco.usuariosMadero.containsKey(Rol.CLIENTE)) {
                    Banco.usuariosMadero.put(Rol.CLIENTE, new ArrayList<Usuario>());
                }
                Banco.usuariosMadero.get(Rol.CLIENTE).add(newCliente);
                System.out.println("\nCliente registrado con éxito.");
                System.out.println("\n Su RFC es:" + RFCClient);
                System.out.println("\n Su CURP es:" + CURPClient);


            } else {
                if (!Banco.usuariosAcueducto.containsKey(Rol.CLIENTE)) {
                    Banco.usuariosAcueducto.put(Rol.CLIENTE, new ArrayList<Usuario>());
                }
                Banco.usuariosAcueducto.get(Rol.CLIENTE).add(newCliente);

            }
        } else {
            System.out.println("\nInténtelo de nuevo.");
        }

    }

    public void verFondosTarjetas() {
        verFondosDebito();
        verTarjetasCredito();
    }
    public String verTarjeta() {
        return (this.tarjetaDebito.toString());

    }
    public void verFondosDebito() {
        System.out.println("\n--- TARJETA DE DÉBITO ---");
        System.out.println("Número de cuenta: " + tarjetaDebito.getNumeroDeCuenta());
        System.out.println("Saldo: " + tarjetaDebito.getSaldo());
    }
    public void verTarjetasCredito() {
        System.out.println("\n--- TARJETA DE CREDITO ---");
        if (listaTarjetaCredito.isEmpty()) {
            System.out.println("No hay tarjetas de crédito asociadas a este cliente.");
        } else {
            for (Tarjeta tarjeta : listaTarjetaCredito) {
                Credito credito = (Credito) tarjeta;
                System.out.println("Tipo: " + credito.getType());
                System.out.println("Número de tajeta: " + credito.getNumeroDeCuenta());
                System.out.println("Saldo: " + credito.getSaldo());
                System.out.println("\n");
            }
        }
    }

    public static void mostrarCliente(Usuario usuarioActual) {
        System.out.println("\n ----- L I S T A  D E   C L I E N T E S -----");
        if (usuarioActual.getSucursal().equals(Sucursal.MADERO)) {
            if (Banco.usuariosMadero.containsKey(Rol.CLIENTE)) {
                ArrayList<Usuario> clientesMadero = Banco.usuariosMadero.get(Rol.CLIENTE);
                for (Usuario usuario : clientesMadero) {
                    if (usuario instanceof Cliente) {
                        Cliente cliente = (Cliente) usuario;
                        System.out.println(cliente.toString());
                    }
                }
            } else {
                System.out.println("No hay clientes registrados para la sucursal Madero.");
            }
        } else if (usuarioActual.getSucursal().equals(Sucursal.ACUEDUCTO)) {
            if (Banco.usuariosAcueducto.containsKey(Rol.CLIENTE)) {
                ArrayList<Usuario> clientesAcueducto = Banco.usuariosAcueducto.get(Rol.CLIENTE);
                for (Usuario usuario : clientesAcueducto) {
                    if (usuario instanceof Cliente) {
                        Cliente cliente = (Cliente) usuario;
                        System.out.println(cliente.toString());
                    }
                }
            } else {
                System.out.println("No hay clientes registrados para la sucursal Acueducto.");
            }
        } else {
            System.out.println("Sucursal no válida.");
        }
    }

    public static void modificarCliente(Usuario usuario) {
        Scanner leer = new Scanner(System.in);
        System.out.println("\n----- M O D I F I C A R   C L I E N T E -----");
        System.out.println("Ingrese el nombre de usuario del cliente a modificar: ");
        String modificarUserName = leer.nextLine();

        boolean encontrado = false;

        if (usuario.getSucursal().equals(Sucursal.MADERO)) {
            encontrado = modificarClienteEnSucursal(Banco.usuariosMadero.get(Rol.CLIENTE), modificarUserName);
        } else if (usuario.getSucursal().equals(Sucursal.ACUEDUCTO)) {
            encontrado = modificarClienteEnSucursal(Banco.usuariosAcueducto.get(Rol.CLIENTE), modificarUserName);
        }

        if (!encontrado) {
            System.out.println("Cliente no encontrado.");
            return;
        }
    }

    private static boolean modificarClienteEnSucursal(ArrayList<Usuario> usuarios, String modificarUserName) {
        boolean encontrado = false;

        for (Usuario usuario : usuarios) {
            if (usuario instanceof Cliente) {
                Cliente cliente = (Cliente) usuario;
                if (cliente.getUserName().equals(modificarUserName)) {
                    encontrado = true;
                    modificarDatos(cliente, modificarUserName);
                    break;
                }
            }
        }

        return encontrado;
    }

    private static void modificarDatos(Cliente cliente, String modificarUserName) {
        Scanner leer = new Scanner(System.in);
        int opcionModificar;

        do {
            System.out.println("Campo que desea modificar:");
            System.out.println("1. Nombre");
            System.out.println("2. Apellido paterno");
            System.out.println("3. Apellido materno");
            System.out.println("4. Fecha de Nacimiento");
            System.out.println("5. Ciudad");
            System.out.println("6. Estado");
            System.out.println("7. Domicilio");
            System.out.println("8. Usuario");
            System.out.println("9. Contraseña");
            System.out.println("10. Salir.");

            opcionModificar = leer.nextInt();
            leer.nextLine();
            switch (opcionModificar) {
                case 1:
                    System.out.print("Ingrese el nuevo nombre: ");
                    String newName = leer.nextLine().toUpperCase();
                    cliente.setNombre(newName);
                    cliente.setRFC(Usuario.generateRFC(newName, cliente.getApellidoPaterno(), cliente.getApellidoMaterno(), cliente.getFechaDeNacimiento()));
                    cliente.setCurp(Usuario.generarCurp(newName, cliente.getApellidoPaterno(), cliente.getApellidoMaterno(), cliente.getFechaDeNacimiento(), cliente.getEstado(), cliente.getSexo()));
                    break;

                case 2:
                    System.out.print("Ingrese el nuevo apellido Paterno: ");
                    String newFatherLastName = leer.nextLine().toUpperCase();
                    cliente.setApellidoPaterno(newFatherLastName);
                    cliente.setRFC(Usuario.generateRFC(cliente.getNombre(), newFatherLastName, cliente.getApellidoMaterno(), cliente.getFechaDeNacimiento()));
                    cliente.setCurp(Usuario.generarCurp(cliente.getNombre(), newFatherLastName, cliente.getApellidoMaterno(), cliente.getFechaDeNacimiento(), cliente.getEstado(), cliente.getSexo()));
                    break;

                case 3:
                    System.out.println("Ingrese el nuevo apellido Materno");
                    String newMotherLastName = leer.nextLine().toUpperCase();
                    cliente.setApellidoMaterno(newMotherLastName);
                    cliente.setRFC(Usuario.generateRFC(cliente.getNombre(), cliente.getApellidoPaterno(), newMotherLastName, cliente.getFechaDeNacimiento()));
                    cliente.setCurp(Usuario.generarCurp(cliente.getNombre(), cliente.getApellidoPaterno(), newMotherLastName, cliente.getFechaDeNacimiento(), cliente.getEstado(), cliente.getSexo()));
                    break;

                case 4:
                    System.out.println("Ingrese la nueva Fecha de Nacimiento: ");
                    String newFechaDeNacimiento = leer.nextLine().toUpperCase();
                    cliente.setFechaDeNacimiento(newFechaDeNacimiento);
                    cliente.setRFC(Usuario.generateRFC(cliente.getNombre(), cliente.getApellidoPaterno(), cliente.getApellidoMaterno(), newFechaDeNacimiento));
                    cliente.setCurp(Usuario.generarCurp(cliente.getNombre(), cliente.getApellidoPaterno(), cliente.getApellidoMaterno(), newFechaDeNacimiento, cliente.getEstado(), cliente.getSexo()));
                    break;

                case 5:
                    System.out.println("Ingrese la ciudad: ");
                    String newCity = leer.nextLine().toUpperCase();
                    cliente.setCiudad(newCity);
                    break;

                case 6:
                    System.out.println("Ingrese el estado: ");
                    String newEstado = leer.nextLine().toUpperCase();
                    cliente.setEstado(newEstado);
                    cliente.setCurp(Usuario.generarCurp(cliente.getNombre(), cliente.getApellidoPaterno(), cliente.getApellidoMaterno(), cliente.getFechaDeNacimiento(), newEstado, cliente.getSexo()));
                    break;

                case 7:
                    System.out.println("Ingrese el domicilio: ");
                    String newDomicilio = leer.nextLine().toUpperCase();
                    cliente.setDireccion(newDomicilio);
                    break;

                case 8:
                    System.out.println("Ingrese el nuevo nombre de usuario: ");
                    String newUserName = leer.nextLine();
                    cliente.setUserName(newUserName);
                    break;

                case 9:
                    System.out.println("Ingrese la nueva contraseña: ");
                    String newPassword = leer.nextLine();
                    cliente.setPassword(newPassword);
                    break;

                case 10:
                    return;

                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (opcionModificar != 10);
    }


    public static void eliminarCliente(Usuario usuarioActual) {
        Scanner leer = new Scanner(System.in);
        System.out.println("\n ----- E L I M I N A C I O N   D E L   C L I E N T E -----");
        System.out.println("\nIngrese el nombre de usuario del cliente a eliminar:");
        String buscarUserName = leer.nextLine();

        if (usuarioActual.getSucursal().equals(Sucursal.ACUEDUCTO)) {
            ArrayList<Usuario> clienteAcueducto = Banco.usuariosAcueducto.get(Rol.CLIENTE);
            for (Usuario cliente : clienteAcueducto) {
                if (cliente instanceof Cliente) {
                    Cliente clienteObj = (Cliente) cliente;
                    if (clienteObj.getUserName().equals(buscarUserName)) {
                        clienteAcueducto.remove(cliente);
                        System.out.println("\nCliente eliminado");
                        return;
                    }
                }
            }
        } else if (usuarioActual.getSucursal().equals(Sucursal.MADERO)) {
            ArrayList<Usuario> clienteMadero = Banco.usuariosMadero.get(Rol.CLIENTE);
            for (Usuario cliente : clienteMadero) {
                if (cliente instanceof Cliente) {
                    Cliente clienteObj = (Cliente) cliente;
                    if (clienteObj.getUserName().equals(buscarUserName)) {
                        clienteMadero.remove(cliente);
                        System.out.println("\nCliente eliminado");
                        return;
                    }
                }
            }
        }
        System.out.println("Cliente no encontrado.");
    }

    public static void mostrarInformacionClienteActual(Usuario usuarioActual) {

        if (usuarioActual instanceof Cliente) {
            Cliente clienteActual = (Cliente) usuarioActual;


            if (clienteActual.getSucursal() == usuarioActual.getSucursal()) {
                System.out.println("\n----- I N F O R M A C I Ó N   D E L   C L I E N T E -----");
                System.out.println("Nombre: " + clienteActual.getNombre());
                System.out.println("Apellido Paterno: " + clienteActual.getApellidoPaterno());
                System.out.println("Apellido Materno: " + clienteActual.getApellidoMaterno());
                System.out.println("Fecha de Nacimiento: " + clienteActual.getFechaDeNacimiento());
                System.out.println("Ciudad: " + clienteActual.getCiudad());
                System.out.println("Estado: " + clienteActual.getEstado());
                System.out.println("Domicilio: " + clienteActual.getDireccion());
                System.out.println("RFC: " + clienteActual.getRFC());
                System.out.println("CURP: " + clienteActual.getCurp());
                System.out.println("Nombre de usuario: " + clienteActual.getUserName());

            } else {
                System.out.println("El cliente no pertenece a la sucursal del usuario actual.");
            }
        } else {
            System.out.println("El usuario actual no es un cliente.");
        }
    }

    public void solicitarTarjeta(Usuario usuarioActual) {
        Scanner leer = new Scanner(System.in);
        Cliente clienteSolicitar = (Cliente) usuarioActual;
        if (validarSolicitudesPendientes(clienteSolicitar)) {
            System.out.println("Tipo de tarjeta que desea solicitar: ");
            System.out.println("1. Simplicity.");
            System.out.println("2. Platinium.");
            System.out.println("3. Gold.");
            int opcionTarjetaSolicitar = leer.nextInt();
            TipoTarjetaCredito tipoTarjetaSolicitar = null;
            EstadoSolicitud estado = EstadoSolicitud.PENDIENTE;
            switch (opcionTarjetaSolicitar) {
                case 1:
                    tipoTarjetaSolicitar = TipoTarjetaCredito.SIMPLICITY;
                    break;
                case 2:
                    tipoTarjetaSolicitar = TipoTarjetaCredito.PLATINUM;
                    break;
                case 3:
                    tipoTarjetaSolicitar = TipoTarjetaCredito.GOLD;
                    break;
            }


            if (validarRequisitosParaSolicitud(tipoTarjetaSolicitar, clienteSolicitar)) {
                SolicitudTarjeta nuevaSolicitud = new SolicitudTarjeta(clienteSolicitar, tipoTarjetaSolicitar, estado, LocalDateTime.now());
                Banco.listaSolicitudes.add(nuevaSolicitud);
                Banco.listaSolicitudes.add(nuevaSolicitud);
            } else {
                System.out.println("No cuentas con el saldo requerido para este tipo de tarjeta.");
            }
        } else {
            System.out.println("Tienes solicitudes pendientes.");
        }
    }


    public boolean validarSolicitudesPendientes(Cliente clienteActual) {
        for (SolicitudTarjeta solicitudBuscar : Banco.listaSolicitudes) {
            if (solicitudBuscar.getClienteSolicitando() == clienteActual && solicitudBuscar.getStatus().equals(EstadoSolicitud.PENDIENTE)) {
                return false;
            }
        }
        return true;
    }

    public  Debito getTarjetaDebito() {
        return tarjetaDebito;
    }

    public static boolean validarRequisitosParaSolicitud(TipoTarjetaCredito tipoTarjetaASolicitar, Cliente cliente) {
        if (cliente.getTarjetaDebito().getSaldo() >= tipoTarjetaASolicitar.getSaldoMinimo()){
            return true;
        }
        return false;
    }


    public  void mostrarSolicitudesPropias(){
        System.out.println("\n--- S O L I C I T U D E S ---");
        if (Banco.listaSolicitudes.isEmpty()) {
            System.out.println("No has realizado ninguna solicitud de tarjetas de crédito.");
        } else {
            for (SolicitudTarjeta buscarSolicitud : Banco.listaSolicitudes) {
                System.out.println("\nTipo: " + buscarSolicitud.getTipoTarjeta());
                System.out.println("Num solicitud: " + buscarSolicitud.getIdSolicitud());
                System.out.println("Status: " + buscarSolicitud.getStatus());
                System.out.println("Fecha: " + buscarSolicitud.getFechaDeSolicitud());
                System.out.println("\n");

            }
        }
    }

}
