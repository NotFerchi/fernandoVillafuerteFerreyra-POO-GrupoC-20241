package usuarios;
import banco.Banco;
import banco.Menu;
import banco.Sucursal;
import usuarios.utils.Inversion;
import usuarios.utils.Rol;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Inversionista extends Usuario {

    private double fondoInversion;
    private static String llaveSeguridad = null;
    List<Inversion> inversionesPropias;

    public Inversionista(String nombre, String apellidoPaterno, String apellidoMaterno, String fechaDeNacimiento, String ciudad, String estado, String curp, String direccion, String RFC, double salario, Rol rol, Sucursal sucursal, String sexo, String userName, String password, double fondoInversion) {
        super(nombre, apellidoMaterno, apellidoPaterno, fechaDeNacimiento, ciudad, estado, curp, direccion, RFC, salario, rol, sucursal, sexo, userName, password);
        this.fondoInversion = fondoInversion;
        this.llaveSeguridad = llaveSeguridad;
        this.inversionesPropias = new ArrayList<>();
    }

    public String getLlaveSeguridad() {
        return llaveSeguridad;
    }

    public void setLlaveSeguridad(String llaveSeguridad) {
        this.llaveSeguridad = llaveSeguridad;
    }

    public double getFondoInversion() {
        return fondoInversion;
    }

    public void setFondoInversion(double fondoInversion) {
        this.fondoInversion = fondoInversion;
    }

    public List<Inversion> getInversionesPropias() {
        return inversionesPropias;
    }

    public void setInversionesPropias(List<Inversion> inversionesPropias) {
        this.inversionesPropias = inversionesPropias;
    }

    public static void registarInversionista(Usuario usuarioActual) {
        Scanner leer = new Scanner(System.in);

        System.out.println("\n----- R E G I S T R O   D E L   I N V E R S I O N I S T A -----");
        ArrayList<String> datosComun = Usuario.registerUser(Rol.INVERSIONISTA);
        String nameInversionista = datosComun.get(0);
        String fatherLastNameInversionista = datosComun.get(1);
        String motherLastNameInversionista = datosComun.get(2);
        String fechaDeNacimiento = datosComun.get(3);
        String cityInversionista = datosComun.get(4);
        String estadoIinversionista = datosComun.get(5);
        String CURPInversionista = datosComun.get(6);
        String direccionInversionista = datosComun.get(7);
        String sexoInversionista = datosComun.get(8);
        String usuarioCInversionista = datosComun.get(9);
        String passwordIinversionista = datosComun.get(10);
        String RFCInversionista = Usuario.generateRFC(nameInversionista, fatherLastNameInversionista, motherLastNameInversionista, fechaDeNacimiento);

        System.out.print("Salario: ");
        Double salary = leer.nextDouble();

        System.out.print("Ingrese el fondo de inversión: ");
        double fondo = leer.nextDouble();

        if (RFCInversionista != null) {
            RFCList.add(RFCInversionista);
            Usuario.validarRFC(RFCInversionista);
            Inversionista newInversionista = new Inversionista(nameInversionista, fatherLastNameInversionista, motherLastNameInversionista, fechaDeNacimiento, cityInversionista, estadoIinversionista, CURPInversionista, direccionInversionista, RFCInversionista, salary, Rol.INVERSIONISTA, usuarioActual.getSucursal(), sexoInversionista, usuarioCInversionista, passwordIinversionista, fondo);

            if (usuarioActual.getSucursal().equals(Sucursal.MADERO)) {
                if (!Banco.usuariosMadero.containsKey(Rol.INVERSIONISTA)) {
                    Banco.usuariosMadero.put(Rol.INVERSIONISTA, new ArrayList<Usuario>());
                }
                Banco.usuariosMadero.get(Rol.INVERSIONISTA).add(newInversionista);
                System.out.println("\nInversionista registrado con éxito.");
                System.out.println("\n Su RFC es:" + RFCInversionista.toUpperCase());
                System.out.println("\n Su CURP es:" + CURPInversionista);

            } else {
                if (!Banco.usuariosAcueducto.containsKey(Rol.INVERSIONISTA)) {
                    Banco.usuariosAcueducto.put(Rol.INVERSIONISTA, new ArrayList<Usuario>());
                }
                Banco.usuariosAcueducto.get(Rol.INVERSIONISTA).add(newInversionista);
                System.out.println("\nInversionista registrado con éxito.");
                System.out.println("\n Su RFC es:" + RFCInversionista.toUpperCase());
                System.out.println("\n Su CURP es:" + CURPInversionista);

            }
        } else {
            System.out.println("Inténtelo de nuevo.");
        }

    }
    @Override
    public String toString() {
        return String.format("%s \nSalario: %.4f \nFondo de inversion: %.4f \nFecha de registro: %s", super.toString(), salario, fondoInversion, super.fechaRegistro);
    }

    public static void mostrarInversionista(Usuario usuarioActual) {
        System.out.println("\n ----- L I S T A  D E  I N V E R S I O N I S T A S -----");
        try {
            if (usuarioActual.getSucursal().equals(Sucursal.MADERO)) {
                for (Usuario usuario : Banco.usuariosMadero.get(Rol.INVERSIONISTA)) {
                    if (usuario.getRol() == Rol.INVERSIONISTA) {
                        Inversionista newInversionista = (Inversionista) usuario;
                        System.out.println(newInversionista.toString());
                    }
                }
            }
            if (usuarioActual.getSucursal().equals(Sucursal.ACUEDUCTO)) {
                for (Usuario usuario : Banco.usuariosAcueducto.get(Rol.INVERSIONISTA)) {
                    if (usuario.getRol() == Rol.INVERSIONISTA) {
                        Inversionista newInversionista = (Inversionista) usuario;
                        System.out.println(newInversionista.toString());
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("\nLa lista está vacía");
        }
    }

    public static void modificarInversionista(Usuario usuario) {
        Scanner leer = new Scanner(System.in);
        System.out.println("\n----- M O D I F I C A R   I N V E R S I O N I S T A -----");
        System.out.println("\nIngrese el nombre de usuario del inversionista a modificar: ");
        String modificarUserName = leer.nextLine();

        boolean encontrado = false;

        if (usuario.getSucursal().equals(Sucursal.MADERO)) {
            encontrado = modificarInversionistaEnSucursal(Banco.usuariosMadero.get(Rol.INVERSIONISTA), modificarUserName);
        } else if (usuario.getSucursal().equals(Sucursal.ACUEDUCTO)) {
            encontrado = modificarInversionistaEnSucursal(Banco.usuariosAcueducto.get(Rol.INVERSIONISTA), modificarUserName);
        }

        if (!encontrado) {
            System.out.println("Inversionista no encontrado.");

            // Obtener la sucursal del usuario actual
            Sucursal sucursal = usuario.getSucursal();

            // Llamar al método menuGerente() con la sucursal correspondiente
            Menu.menuGerente(sucursal);
        }
        leer.close();
    }

    private static boolean modificarInversionistaEnSucursal(ArrayList<Usuario> usuarios, String modificarUserName) {
        boolean encontrado = false;

        for (Usuario usuario : usuarios) {
            if (usuario instanceof Inversionista) {
                Inversionista inversionista = (Inversionista) usuario;
                if (inversionista.getUserName().equals(modificarUserName)) {
                    encontrado = true;
                    modificarDatos(inversionista, modificarUserName);
                    break;
                }
            }
        }

        return encontrado;
    }

    private static void modificarDatos(Inversionista inversionista, String modificarUserName) {
        Scanner leer = new Scanner(System.in);
        int opcionModificar;

        do {
            System.out.println("Campo que desea modificar:");
            System.out.println("1. Nombre");
            System.out.println("2. Apellido paterno");
            System.out.println("3. Apellido materno");
            System.out.println("4. Fecha de nacimiento");
            System.out.println("5. Ciudad");
            System.out.println("6. Estado");
            System.out.println("7. Domicilio");
            System.out.println("8. Salario");
            System.out.println("9. Nombre de usuario");
            System.out.println("10. Contraseña");
            System.out.println("11. Fondo de inversión");
            System.out.println("12. Salir.");

            opcionModificar = leer.nextInt();
            leer.nextLine();
            switch (opcionModificar) {
                case 1:
                    System.out.print("Ingrese el nuevo nombre: ");
                    String newName = leer.nextLine().toUpperCase();
                    inversionista.setNombre(newName);
                    break;

                case 2:
                    System.out.print("Ingrese el nuevo apellido paterno: ");
                    String newFatherLastName = leer.nextLine().toUpperCase();
                    inversionista.setApellidoPaterno(newFatherLastName);
                    break;

                case 3:
                    System.out.print("Ingrese el nuevo apellido materno: ");
                    String newMotherLastName = leer.nextLine().toUpperCase();
                    inversionista.setApellidoMaterno(newMotherLastName);
                    break;

                case 4:
                    System.out.print("Ingrese la nueva fecha de nacimiento: ");
                    String newFechaDeNacimiento = leer.nextLine().toUpperCase();
                    inversionista.setFechaDeNacimiento(newFechaDeNacimiento);
                    break;

                case 5:
                    System.out.print("Ingrese la nueva ciudad: ");
                    String newCity = leer.nextLine().toUpperCase();
                    inversionista.setCiudad(newCity);
                    break;

                case 6:
                    System.out.print("Ingrese el nuevo estado: ");
                    String newEstado = leer.nextLine().toUpperCase();
                    inversionista.setEstado(newEstado);
                    break;

                case 7:
                    System.out.print("Ingrese el nuevo domicilio: ");
                    String newDomicilio = leer.nextLine().toUpperCase();
                    inversionista.setDireccion(newDomicilio);
                    break;

                case 8:
                    System.out.print("Ingrese el nuevo salario: ");
                    double newSalary = leer.nextDouble();
                    inversionista.setSalario(newSalary);
                    break;

                case 9:
                    System.out.print("Ingrese el nuevo nombre de usuario: ");
                    String newUserName = leer.nextLine();
                    inversionista.setUserName(newUserName);
                    break;

                case 10:
                    System.out.print("Ingrese la nueva contraseña: ");
                    String newPassword = leer.nextLine();
                    inversionista.setPassword(newPassword);
                    break;

                case 11:
                    System.out.print("Ingrese el nuevo fondo de inversión: ");
                    double newFondo = leer.nextDouble();
                    inversionista.setFondoInversion(newFondo);
                    break;

                case 12:
                    return;

                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (opcionModificar != 12);
    }

    public static void eliminarInversionista(Usuario usuarioActual) {
        System.out.println("\n----- E L I M I N A C I O N    D E L   I N V E R S I O N I S T A -----");
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese el nombre de usuario del inversionista a eliminar:");
        String buscarUserName = leer.nextLine();

        if (usuarioActual.getSucursal().equals(Sucursal.ACUEDUCTO)) {
            ArrayList<Usuario> inversionistasAcueducto = Banco.usuariosAcueducto.get(Rol.INVERSIONISTA);
            for (Usuario inversionista : inversionistasAcueducto) {
                if (inversionista.getUserName().equals(buscarUserName)) {
                    inversionistasAcueducto.remove(inversionista);
                    System.out.println("\nInversionista eliminado");
                    return;
                }
            }
        } else if (usuarioActual.getSucursal().equals(Sucursal.MADERO)) {
            ArrayList<Usuario> inversionistasMadero = Banco.usuariosMadero.get(Rol.INVERSIONISTA);
            for (Usuario inversionista : inversionistasMadero) {
                if (inversionista.getUserName().equals(buscarUserName)) {
                    inversionistasMadero.remove(inversionista);
                    System.out.println("\nInversionista eliminado");
                    return;
                }
            }
        }
        System.out.println("Usuario no encontrado.");
    }

    public static void realizarInversion(Usuario usuarioActual) {
        Scanner leer = new Scanner(System.in);
        int opcion = 0;

        if (usuarioActual instanceof Inversionista) {
            Inversionista inversionista = (Inversionista) usuarioActual;

            do {
                System.out.println("\n---- I N V E R S I O N  E N  S U C U R S A L ----");
                System.out.println("\n\tSucursales");
                System.out.println("1) Sucursal Madero");
                System.out.println("2) Sucursal Acueducto");
                System.out.println("3) Salir");

                System.out.print("\nSeleccione la sucursal en la que desea invertir: ");
                opcion = leer.nextInt();
                leer.nextLine();

                switch (opcion) {
                    case 1:
                        System.out.print("\nDigite la contraseña de seguridad: ");
                        String claveMadero = leer.nextLine();

                        if (claveMadero.equals(inversionista.getLlaveSeguridad())) {
                            System.out.print("Ingrese la cantidad a invertir en la sucursal Madero: ");
                            double cantidadMadero = leer.nextDouble();

                            Inversion inversionAcueducto = new Inversion(inversionista.getNombre(), cantidadMadero);
                            inversionista.agregarInversionPropia(inversionAcueducto);

                            Sucursal.MADERO.realizarInversion(cantidadMadero, inversionista.getNombre(), inversionista);

                            System.out.println("Inversión realizada con éxito en la sucursal Madero.");

                        } else {
                            System.out.println("Clave incorrecta");
                        }
                        break;
                    case 2:
                        System.out.print("\nDigite la contraseña de seguridad: ");
                        String claveAcueducto = leer.nextLine();
                        if (claveAcueducto.equals(inversionista.getLlaveSeguridad())) {
                            System.out.print("Ingrese la cantidad a invertir en la sucursal Acueducto: ");
                            double cantidadAcueducto = leer.nextDouble();

                            leer.nextLine();

                            Inversion inversionAcueducto = new Inversion(inversionista.getNombre(), cantidadAcueducto);
                            inversionista.agregarInversionPropia(inversionAcueducto);
                            Sucursal.ACUEDUCTO.realizarInversion(cantidadAcueducto, inversionista.getNombre(), inversionista);

                            System.out.println("Inversión realizada con éxito en la sucursal Acueducto.");

                        } else {
                            System.out.println("Clave incorrecta");
                        }
                        break;
                    case 3:
                        System.out.println("Saliendo...");
                        return;
                    default:
                        System.out.println("Opción no válida");
                }
            } while (opcion != 3);

        } else {
            System.out.println("Acceso no autorizado. No eres inversionista para realizar esta operación.");
        }

    }

    public void agregarInversionPropia(Inversion inversion) {
        inversionesPropias.add(inversion);
    }

    public static void mostrarInversionesPropias(Usuario usuarioActual) {
        Inversionista inversionista = (Inversionista) usuarioActual;
        System.out.println("Tus inversiones:");
        for (Inversion inversion : inversionista.getInversionesPropias()) {
            System.out.println(inversion.toString());
        }
    }

    public static void mostrarInversiones(Sucursal sucursal) {
        System.out.println("\n---- INVERSIONES EN LA SUCURSAL " + sucursal.name() + "----");
        mostrarInversionesSucursal(sucursal);
    }


    private static void mostrarInversionesSucursal(Sucursal sucursal) {
        List<Inversion> inversiones = sucursal.getInversiones();

        if (inversiones.isEmpty()) {
            System.out.println("No se han realizado inversiones en esta sucursal.");
        } else {
            System.out.println("\n---- L I S T A  D E  I N V E R S I O N E S ----");
            for (Inversion inversion : inversiones) {
                System.out.println("\nFecha: " + inversion.getFecha() + "\nInversionista: " + inversion.getNombreInversionista() + "\nCantidad: " + inversion.getCantidad());
            }
        }
    }

    public static void mostrarDatosPersonales(Usuario usuarioActual) {

        Inversionista inversionista = (Inversionista) usuarioActual;
        System.out.println("\nDatos personales:");
        System.out.println("Nombre: " + inversionista.getNombre());
        System.out.println("Apellido paterno: " + inversionista.getApellidoPaterno());
        System.out.println("Apellido materno: " + inversionista.getApellidoMaterno());
        System.out.println("Fecha de nacimiento: " + inversionista.getFechaDeNacimiento());
        System.out.println("Ciudad: " + inversionista.getCiudad());
        System.out.println("Estado: " + inversionista.getEstado());
        System.out.println("CURP: " + inversionista.getCurp());
        System.out.println("RFC: %s" + inversionista.getRFC());
        System.out.println("Fondo de inversión: " + inversionista.getFondoInversion());
        System.out.println("Salario: " + inversionista.getSalario());
        System.out.println("Usuario: " + inversionista.getUserName());
        System.out.println("Contraseña:" + inversionista.getPassword());
        System.out.println("Llave de seguridad: " + inversionista.getLlaveSeguridad());

    }

}





