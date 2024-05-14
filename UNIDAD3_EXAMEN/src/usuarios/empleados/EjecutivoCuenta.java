package usuarios.empleados;

import banco.Banco;
import banco.Sucursal;
import usuarios.Usuario;
import usuarios.utils.Rol;

import java.util.ArrayList;
import java.util.Scanner;

public class EjecutivoCuenta extends Usuario {
    public EjecutivoCuenta(String nombre, String apellidoMaterno, String apellidoPaterno, String fechaDeNacimiento, String ciudad, String estado, String curp, String direccion, String RFC, double salario, Rol rol, Sucursal sucursal, String sexo, String userName, String password) {
        super(nombre, apellidoMaterno, apellidoPaterno, fechaDeNacimiento, ciudad, estado, curp, direccion, RFC, salario, Rol.EJECUTIVODECUENTA, sucursal, sexo, userName, password);
    }

    public static void registerEjecutivo(Usuario usuarioActual) {

        System.out.println("\n----- R E G I S T R O   D E   E J E C U T I V O   D E   C U E N T A -----");
        Scanner leer = new Scanner(System.in);
        ArrayList<String> datosComun = Usuario.registerUser(Rol.EJECUTIVODECUENTA);
        String nameEjecutivo = datosComun.get(0);
        String fatherLastNameEjecutivo = datosComun.get(1);
        String motherLastNameEjecutivo = datosComun.get(2);
        String fechaDeNacimiento = datosComun.get(3);
        String cityEjecutivo = datosComun.get(4);
        String estadoEjecutivo = datosComun.get(5);
        String CURPEjecutivo = datosComun.get(6);
        String direccionEjecutivo = datosComun.get(7);
        String sexoEjecutivo = datosComun.get(8);
        String RFCEjecutivo = Usuario.generateRFC(nameEjecutivo, fatherLastNameEjecutivo, motherLastNameEjecutivo, fechaDeNacimiento);
        String usuarioEjecutivo = datosComun.get(9);
        String passwordEjecutivo = datosComun.get(10);

        System.out.print("Salario: ");
        Double salaryEjecutivo = leer.nextDouble();

        if (RFCEjecutivo != null) {
            getRFCList().add(RFCEjecutivo);
            Usuario.validarRFC(RFCEjecutivo);
            EjecutivoCuenta newEjecutivoDeCuenta = new EjecutivoCuenta(nameEjecutivo, fatherLastNameEjecutivo, motherLastNameEjecutivo,
                    fechaDeNacimiento, cityEjecutivo, estadoEjecutivo, CURPEjecutivo, direccionEjecutivo, RFCEjecutivo, salaryEjecutivo, Rol.EJECUTIVODECUENTA, usuarioActual.getSucursal(), sexoEjecutivo, usuarioEjecutivo, passwordEjecutivo);
            if (usuarioActual.getSucursal().equals(Sucursal.MADERO)) {
                if (!Banco.usuariosMadero.containsKey(Rol.EJECUTIVODECUENTA)) {
                    Banco.usuariosMadero.put(Rol.EJECUTIVODECUENTA, new ArrayList<Usuario>());
                }
                Banco.usuariosMadero.get(Rol.EJECUTIVODECUENTA).add(newEjecutivoDeCuenta);
                System.out.println("Ejecutivo de venta registrado con éxito. Su rfc es:" + RFCEjecutivo + " su CURP es: " + CURPEjecutivo);

            } else {
                if (!Banco.usuariosAcueducto.containsKey(Rol.EJECUTIVODECUENTA)) {
                    Banco.usuariosAcueducto.put(Rol.EJECUTIVODECUENTA, new ArrayList<Usuario>());
                }
                Banco.usuariosAcueducto.get(Rol.EJECUTIVODECUENTA).add(newEjecutivoDeCuenta);
                System.out.println("Ejecutivo de venta registrado con éxito. Su rfc es:" + RFCEjecutivo + " su CURP es: " + CURPEjecutivo);

            }
        } else {
            System.out.println("Inténtelo de nuevo.");
        }

    }

    public static void mostrarEjecutivo(Usuario usuarioActual)
    {
        System.out.println("\n----- L I S T A D O   D E   E J E C U T I V O S   D E   C U E N T A -----");
        if (usuarioActual.getSucursal().equals(Sucursal.MADERO)) {
            for (Usuario usuario : Banco.usuariosMadero.get(Rol.EJECUTIVODECUENTA)) {
                if (usuario.getRol() == Rol.EJECUTIVODECUENTA) {
                    EjecutivoCuenta ejecutivo = (EjecutivoCuenta) usuario;
                    System.out.println(ejecutivo.toString());
                }
            }
        }
        if (usuarioActual.getSucursal().equals(Sucursal.ACUEDUCTO)) {
            for (Usuario usuario : Banco.usuariosAcueducto.get(Rol.EJECUTIVODECUENTA)) {
                if (usuario.getRol() == Rol.EJECUTIVODECUENTA) {
                    EjecutivoCuenta ejecutivo = (EjecutivoCuenta) usuario;
                    System.out.println(ejecutivo.toString());
                }
            }
        }
    }

    public static void modificarEjecutivo(Usuario usuario) {
        Scanner leer = new Scanner(System.in);
        System.out.println("\n----- M O D I F I C A C I O N   D E   E J E C U T I V O   D E   C U E N T A -----");
        System.out.println("Ingrese el RFC del ejecutivo a modificar: ");
        String modificarRFC = leer.nextLine();

        boolean encontrado = false;

        if (usuario.getSucursal().equals(Sucursal.MADERO)) {
            encontrado = modificarEjecutivoEnSucursal(Banco.usuariosMadero.get(Rol.EJECUTIVODECUENTA), modificarRFC);
        } else if (usuario.getSucursal().equals(Sucursal.ACUEDUCTO)) {
            encontrado = modificarEjecutivoEnSucursal(Banco.usuariosAcueducto.get(Rol.EJECUTIVODECUENTA), modificarRFC);
        }

        if (!encontrado) {
            System.out.println("Ejecutivo no encontrado.");
            return;
        }
    }

    private static boolean modificarEjecutivoEnSucursal(ArrayList<Usuario> usuarios, String modificarRFC) {
        boolean encontrado = false;

        for (Usuario usuario : usuarios) {
            if (usuario.getRFC().equals(modificarRFC)) {
                encontrado = true;
                EjecutivoCuenta ejecutivo = (EjecutivoCuenta) usuario;
                modificarDatos(ejecutivo, modificarRFC);
                break;
            }
        }

        return encontrado;
    }

    private static void modificarDatos(EjecutivoCuenta ejecutivo, String modificarRFC) {
        Scanner leer = new Scanner(System.in);
        int opcionModificar;

        do {
            System.out.println("Campo que desea modificar: ");
            System.out.println("1. Nombre");
            System.out.println("2. Apellido paterno");
            System.out.println("3. Apellido materno");
            System.out.println("4. Fecha de nacimiento");
            System.out.println("5. Ciudad");
            System.out.println("6. Estado");
            System.out.println("7. Domicilio");
            System.out.println("8. Salario");
            System.out.println("9. Usuario");
            System.out.println("10. Contraseña");
            System.out.println("11. Salir.");

            opcionModificar = leer.nextInt();
            leer.nextLine();
            switch (opcionModificar) {
                case 1:
                    System.out.print("Ingrese el nuevo nombre: ");
                    String newName = leer.nextLine().toUpperCase();
                    ejecutivo.setNombre(newName);
                    ejecutivo.setRFC(Usuario.generateRFC(newName, ejecutivo.getApellidoPaterno(), ejecutivo.getApellidoMaterno(), ejecutivo.getFechaDeNacimiento()));
                    ejecutivo.setCurp(Usuario.generarCurp(newName, ejecutivo.getApellidoPaterno(), ejecutivo.getApellidoMaterno(), ejecutivo.getFechaDeNacimiento(), ejecutivo.getEstado(), ejecutivo.getSexo()));
                    break;

                case 2:
                    System.out.print("Ingrese el nuevo apellido Paterno: ");
                    String newFatherLastName = leer.nextLine().toUpperCase();
                    ejecutivo.setApellidoPaterno(newFatherLastName);
                    ejecutivo.setRFC(Usuario.generateRFC(ejecutivo.getNombre(), newFatherLastName, ejecutivo.getApellidoMaterno(), ejecutivo.getFechaDeNacimiento()));
                    ejecutivo.setCurp(Usuario.generarCurp(ejecutivo.getNombre(), newFatherLastName, ejecutivo.getApellidoMaterno(), ejecutivo.getFechaDeNacimiento(), ejecutivo.getEstado(), ejecutivo.getSexo()));
                    break;

                case 3:
                    System.out.println("Ingrese el nuevo apellido Materno");
                    String newMotherLastName = leer.nextLine().toUpperCase();
                    ejecutivo.setApellidoMaterno(newMotherLastName);
                    ejecutivo.setRFC(Usuario.generateRFC(ejecutivo.getNombre(), ejecutivo.getApellidoPaterno(), newMotherLastName, ejecutivo.getFechaDeNacimiento()));
                    ejecutivo.setCurp(Usuario.generarCurp(ejecutivo.getNombre(), ejecutivo.getApellidoPaterno(), newMotherLastName, ejecutivo.getFechaDeNacimiento(), ejecutivo.getEstado(), ejecutivo.getSexo()));
                    break;

                case 4:
                    System.out.println("Ingrese la nueva Fecha de Nacimiento: ");
                    String newFechaDeNacimiento = leer.nextLine().toUpperCase();
                    ejecutivo.setFechaDeNacimiento(newFechaDeNacimiento);
                    ejecutivo.setRFC(Usuario.generateRFC(ejecutivo.getNombre(), ejecutivo.getApellidoPaterno(), ejecutivo.getApellidoMaterno(), newFechaDeNacimiento));
                    ejecutivo.setCurp(Usuario.generarCurp(ejecutivo.getNombre(), ejecutivo.getApellidoPaterno(), ejecutivo.getApellidoMaterno(), newFechaDeNacimiento, ejecutivo.getEstado(), ejecutivo.getSexo()));
                    break;

                case 5:
                    System.out.println("Ingrese la ciudad: ");
                    String newCity = leer.nextLine().toUpperCase();
                    ejecutivo.setCiudad(newCity);
                    break;

                case 6:
                    System.out.println("Ingrese el estado: ");
                    String newEstado = leer.nextLine().toUpperCase();
                    ejecutivo.setEstado(newEstado);
                    ejecutivo.setCurp(Usuario.generarCurp(ejecutivo.getNombre(), ejecutivo.getApellidoPaterno(), ejecutivo.getApellidoMaterno(), ejecutivo.getFechaDeNacimiento(), newEstado, ejecutivo.getSexo()));
                    break;

                case 7:
                    System.out.println("Ingrese el domicilio: ");
                    String newDomicilio = leer.nextLine().toUpperCase();
                    ejecutivo.setDireccion(newDomicilio);
                    break;

                case 8:
                    System.out.println("Ingrese el salario: ");
                    double newSalary = leer.nextDouble();
                    ejecutivo.setSalario(newSalary);
                    break;

                case 9:
                    System.out.println("Ingrese el nuevo nombre de usuario: ");
                    String newUserName = leer.nextLine();
                    ejecutivo.setUserName(newUserName);
                    break;

                case 10:
                    System.out.println("Ingrese la nueva contraseña: ");
                    String newPassword = leer.nextLine();
                    ejecutivo.setPassword(newPassword);
                    break;

                case 11:
                    return;

                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (opcionModificar != 11);
    }

    @Override
    public String toString() {
        return String.format("%s \nSalario: %.4f \nFecha de registro: %s", super.toString());
    }

    public static void eliminarEjecutivo(Usuario usuarioActual) {
        Scanner leer = new Scanner(System.in);
        System.out.println("\n----- E L I M I N A C I O N   D E   E J E C U T I V O   D E   C U E N T A -----");
        System.out.println("\nIngrese el nombre de usuario del ejecutivo a eliminar:");
        String buscarUserName = leer.nextLine();

        if (usuarioActual.getSucursal().equals(Sucursal.ACUEDUCTO)) {
            ArrayList<Usuario> ejecutivosAcueducto = Banco.usuariosAcueducto.get(Rol.EJECUTIVODECUENTA);
            for (Usuario ejecutivo : ejecutivosAcueducto) {
                if (ejecutivo.getUserName().equals(buscarUserName)) {
                    ejecutivosAcueducto.remove(ejecutivo);
                    System.out.println("\nEjecutivo de cuenta eliminado");
                    return;
                }
            }
        } else if (usuarioActual.getSucursal().equals(Sucursal.MADERO)) {
            ArrayList<Usuario> ejecutivosMadero = Banco.usuariosMadero.get(Rol.EJECUTIVODECUENTA);
            for (Usuario ejecutivo : ejecutivosMadero) {
                if (ejecutivo.getUserName().equals(buscarUserName)) {
                    ejecutivosMadero.remove(ejecutivo);
                    System.out.println("\nEjecutivo de cuenta eliminado");
                    return;
                }
            }
        }
        System.out.println("Ejecutivo de cuenta no encontrado.");
    }
}

