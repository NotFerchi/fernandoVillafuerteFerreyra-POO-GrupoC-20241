package usuarios;

import banco.Banco;
import banco.Sucursal;
import tarjetas.Credito;
import tarjetas.SolicitudTarjeta;
import tarjetas.utils.EstadoSolicitud;
import usuarios.utils.Estados;
import usuarios.utils.Rol;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Usuario {
    String nombre;
    String apellidoMaterno;
    String apellidoPaterno;
    String fechaDeNacimiento;
    String ciudad;
    String estado;
    String curp;
    String direccion;
    String RFC;
    String sexo;
    String userName;
    String password;
    double salario;
    Rol rol;
    LocalDate fechaRegistro;
    Sucursal sucursal;
    static ArrayList<String> RFCList = new ArrayList<>();

    public Usuario(String nombre, String apellidoMaterno, String apellidoPaterno, String fechaDeNacimiento, String ciudad, String estado, String curp, String direccion, String RFC, double salario, Rol rol, Sucursal sucursal, String sexo, String userName, String password) {
        this.nombre = nombre;
        this.apellidoMaterno = apellidoMaterno;
        this.apellidoPaterno = apellidoPaterno;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.ciudad = ciudad;
        this.estado = estado;
        this.curp = curp;
        this.direccion = direccion;
        this.sexo = sexo;
        this.userName = userName;
        this.password = password;
        this.RFC = RFC;
        this.salario = salario;
        this.rol = rol;
        this.sucursal = sucursal;
        this.fechaRegistro = LocalDate.now();
    }

    public Usuario(String nombre, String apellidoMaterno, String apellidoPaterno, String fechaDeNacimiento, String ciudad, String estado, String curp, String direccion, String RFC, Rol rol, Sucursal sucursal, String sexo, String userName, String password) {
        this.nombre = nombre;
        this.apellidoMaterno = apellidoMaterno;
        this.apellidoPaterno = apellidoPaterno;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.ciudad = ciudad;
        this.estado = estado;
        this.curp = curp;
        this.direccion = direccion;
        this.sexo = sexo;
        this.userName = userName;
        this.password = password;
        this.RFC = RFC;
        this.rol = rol;
        this.sucursal = sucursal;
        this.fechaRegistro = LocalDate.now();
    }

    @Override
    public String toString() {
        return String.format("\nNombre completo: %s %s %s \nRol: %s \nFecha de nacimiento: %s \nEstado: %s \nCiudad: %s \nDirección: %s \nCurp: %s \nRFC: %s \nNombre de usuario: %s \nContraseña: %s" ,
                nombre, apellidoPaterno, apellidoMaterno, rol, fechaDeNacimiento, estado, ciudad, direccion, curp, RFC.toUpperCase(), userName, password);
    }

    public static String generateRFC(String name, String fatherLastName, String motherLastName, String fechaDeNacimiento)
    {
        try {
            String nombre = name.substring(0, 2);
            String lastNameFather = fatherLastName.substring(0, 2);
            String lastNameMother = motherLastName.substring(0, 2);
            String diaNacimiento  = fechaDeNacimiento.substring(2, 4);
            String añoNacimiento = fechaDeNacimiento.substring(8, 10);
            String mesNacimiento = fechaDeNacimiento.substring(5, 7);
            String newRFC =  lastNameFather + lastNameMother + nombre + añoNacimiento + mesNacimiento +
                    diaNacimiento;
            newRFC.toUpperCase();
            return newRFC.toUpperCase();
        } catch (Exception e) {
            System.out.println("No fue posible generar su RFC. Ingrese los datos completos");
        }
        return null;
    }

    public static boolean validarRFC(String RFC) {
        while (RFCList.contains(RFC)) {
            System.out.println();
            return false;
        }
        return true;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public Rol getRol() {
        return rol;
    }


    public static ArrayList<String> registerUser(Rol userRol) {
        Scanner leer = new Scanner(System.in);
        ArrayList<String> datosComun = new ArrayList<String>();
        System.out.print("Ingrese el nombre: ");
        String name = leer.nextLine();
        name.toUpperCase();
        System.out.print("Ingrese el apellido paterno: ");
        String fatherLastName = leer.nextLine();
        fatherLastName.toUpperCase();
        System.out.print("Ingrese el apellido materno: ");
        String motherLastName = leer.nextLine();
        motherLastName.toUpperCase();
        System.out.print("Ingrese la fecha de nacimiento formato DD-MM-YYYY: ");
        String fechaNacimiento = leer.nextLine();
        System.out.print("Ciudad: ");
        String city = leer.nextLine();
        city.toUpperCase();
        System.out.print("Estado: ");
        String estado = leer.nextLine();
        estado.toUpperCase();
        System.out.print("Sexo: ");
        String sexo = leer.nextLine();
        String curp = generarCurp(name, fatherLastName, motherLastName, fechaNacimiento, sexo, estado);
        System.out.print("Domicilio: ");
        String direccion = leer.nextLine();
        System.out.print("Nombre de Usuario: ");
        String userName = leer.nextLine();
        System.out.print("Contraseña: ");
        String password = leer.nextLine();
        datosComun.addAll(Arrays.asList(name, fatherLastName, motherLastName, fechaNacimiento, city, estado, curp, direccion, sexo, userName, password));
        return datosComun;
    }

    public static String generarCurp(String name, String fatherLastName, String motherLastName,
                                     String fechaDeNacimiento, String sexo, String estado) {
        try {
            String nombre = name.substring(0, 1);
            String apellidoPaterno = fatherLastName.substring(0, 2);
            String apellidoMaterno = motherLastName.substring(0, 2);
            String diaNacimiento  = fechaDeNacimiento.substring(2, 4);
            String añoNacimiento = fechaDeNacimiento.substring(8, 10);
            String mesNacimiento = fechaDeNacimiento.substring(5, 7);
            String Sexo = sexo.substring(0, 1);

            String estadoAbreviatura = obtenerAbreviaturaEstado(estado);

            String newCURP = apellidoPaterno + apellidoMaterno + nombre +
                    añoNacimiento + mesNacimiento + diaNacimiento +
                    Sexo + estadoAbreviatura;

            return newCURP.toUpperCase();
        } catch (Exception e) {
            System.out.println("No fue posible generar su CURP. Ingrese los datos completos");
            return null;
        }
    }


    private static String obtenerAbreviaturaEstado(String estado) {
        for (Estados entidad : Estados.values()) {
            if (entidad.getNombre().equalsIgnoreCase(estado)) {
                return entidad.getAbreviatura();
            }
        }
        return "";
    }
    private static boolean esAutorizado(Usuario usuarioActual){
        if (usuarioActual.getRol().equals(Rol.GERENTE_SUCURSAL) || usuarioActual.getRol().equals(Rol.EJECUTIVODECUENTA)){
            return true;
        } else {
            return false;
        }
    }

    public static void aceptarSolicitud(Usuario usuarioActual) {
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese el Num de la solicitud: ");
        int idSolicitud = leer.nextInt();

        for (SolicitudTarjeta buscarSolicitud : Banco.listaSolicitudes) {
            if (buscarSolicitud.getIdSolicitud() == idSolicitud) {
                System.out.println("1. Aceptar");
                System.out.println("2. Rechazar");
                System.out.print("Ingrese la opción: ");
                int opcionStatus = leer.nextInt();

                if (opcionStatus == 1) {
                    buscarSolicitud.setStatus(EstadoSolicitud.APROBADA);
                    Credito.crearTarjetaCredito(buscarSolicitud.getTipoTarjeta(), buscarSolicitud.getClienteSolicitando());
                    Banco.listaSolicitudes.remove(buscarSolicitud);
                    System.out.println("La solicitud fue acptada y ya ceunta con su tarjeta.");
                } else if (opcionStatus == 2) {
                    buscarSolicitud.setStatus(EstadoSolicitud.RECHAZADA);
                    Banco.listaSolicitudes.remove(buscarSolicitud);
                    System.out.println("La solicitud fue rechazada.");
                } else {
                    System.out.println("Opción inválida. La solicitud permanece igual.");
                }
                return;
            }
        }
        System.out.println("No se encontró ninguna solicitud con el Num inndicado.");
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(String fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getRFC() {
        return RFC;
    }

    public void setRFC(String RFC) {
        this.RFC = RFC;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public static ArrayList<String> getRFCList() {
        return RFCList;
    }

    public static void setRFCList(ArrayList<String> RFCList) {
        Usuario.RFCList = RFCList;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

