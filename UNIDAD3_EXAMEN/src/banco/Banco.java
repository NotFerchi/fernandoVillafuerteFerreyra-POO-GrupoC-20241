package banco;

import tarjetas.SolicitudTarjeta;
import usuarios.Cliente;
import usuarios.Inversionista;
import usuarios.Usuario;
import usuarios.empleados.Capturista;
import usuarios.empleados.EjecutivoCuenta;
import usuarios.empleados.GerenteSucursal;
import usuarios.utils.Rol;
import tarjetas.Tarjeta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Banco {
    Scanner scanner = new Scanner(System.in);
    public static HashMap<Sucursal, GerenteSucursal> listaGerentes = new HashMap<Sucursal, GerenteSucursal>();
    public static HashMap<Rol, ArrayList<Usuario>> usuariosMadero = new HashMap<Rol, ArrayList<Usuario>>();
    public static HashMap<Rol, ArrayList<Usuario>> usuariosAcueducto = new HashMap<Rol, ArrayList<Usuario>>();
    public static ArrayList <Tarjeta> listaTarjetas = new ArrayList<>();
    public static ArrayList <SolicitudTarjeta> listaSolicitudes = new ArrayList<>();

    GerenteSucursal gerenteSucursalMadero = new GerenteSucursal("Dani", "dani", "Daniel", "Perez", "Carpio", "2000-20-09", "Morelia", "Michoacan", "HEMUM000920MIC09", "Av. Hidalgo", "HEMUM000920", 200000.90, Rol.GERENTE_SUCURSAL, Sucursal.MADERO, "Hombre");
    GerenteSucursal gerenteSucursalAcueducto = new GerenteSucursal("Fer", "fer", "Fernando", "Villafuerte", "Ferreyra", "1985-22-10", "Morelia", "Aguascalientes", "LOPEL851022HAGU07", "Av. Morelos", "LOPEL851022", 200000.90, Rol.GERENTE_SUCURSAL, Sucursal.ACUEDUCTO, "Hombre");

    public Banco() {
        if (!listaGerentes.containsKey(Sucursal.ACUEDUCTO)) {
            usuariosAcueducto.put(Rol.GERENTE_SUCURSAL, new ArrayList<>());
            usuariosAcueducto.get(Rol.GERENTE_SUCURSAL).add(gerenteSucursalAcueducto);
            listaGerentes.put(Sucursal.ACUEDUCTO, gerenteSucursalAcueducto);
        }

        if (!listaGerentes.containsKey(Sucursal.MADERO)) {
            usuariosMadero.put(Rol.GERENTE_SUCURSAL, new ArrayList<>());
            usuariosMadero.get(Rol.GERENTE_SUCURSAL).add(gerenteSucursalMadero);
            listaGerentes.put(Sucursal.MADERO, gerenteSucursalMadero);
        }
    }

    public static Usuario verificarInicioSesion(Sucursal sucursal, String nombreUsuario, String contrasena)
    {
        if(sucursal.equals(Sucursal.ACUEDUCTO)) {
            for (ArrayList<Usuario> usuarios : usuariosAcueducto.values()) {
                for (Usuario user : usuarios) {
                    if (user.getUserName().equals(nombreUsuario)) {
                        if (user.getPassword().equals(contrasena)) {
                            return user;
                        } else {
                            System.out.println("Contrasena incorrecta");
                        }
                    }
                }
                return null;
            }
        }
        else{
            for(ArrayList<Usuario> usuarios : usuariosMadero.values()){
                for(Usuario user: usuarios){
                    if(user.getUserName().equals(nombreUsuario)){
                        if(user.getPassword().equals(contrasena)){
                            return user;
                        }
                        else{
                            System.out.println("Contraseña incorrecta");
                        }
                    }
                }
                return null;
            }
        }
        return null;
    }
    
    public static void registrarCliente(Usuario usuarioActual) {
        Cliente.registerCliente(usuarioActual);
    }

    public static void mostrarInformacionClienteActual(Usuario usuarioActual){
        Cliente.mostrarInformacionClienteActual(usuarioActual);
    }


    public static void registrarEjecutivo(Usuario usuarioActual) {
        EjecutivoCuenta.registerEjecutivo(usuarioActual);
    }

    public static void registrarCapturista(Usuario usuarioActual) {
        Capturista.registerCapturista(usuarioActual);
    }

    public static void registrarInversionista(Usuario usuarioActual) {
        Inversionista.registarInversionista(usuarioActual);
    }

    public static void mostrarDatosPersonales(Usuario usuarioActual){
        Inversionista.mostrarDatosPersonales(usuarioActual);

    }

    public static void realizarInversion(Usuario usuarioActual){
       Inversionista.realizarInversion(usuarioActual);
    }

    public static void mostrarInversionesPropias(Usuario usuarioActual){
        Inversionista.mostrarInversionesPropias(usuarioActual);
    }



    public static void mostrarClientes(Usuario usuarioActual) {
        Cliente.mostrarCliente(usuarioActual);
    }

    public static void mostrarCapturista(Usuario usuarioActual) {
        Capturista.mostrarCapturista(usuarioActual);
    }

    public static void mostrarEjecutivos(Usuario usuarioActual) {
        EjecutivoCuenta.mostrarEjecutivo(usuarioActual);
    }

    public static void mostrarInversionista(Usuario usuarioActual) {
        Inversionista.mostrarInversionista(usuarioActual);
    }




    public static void modificarCliente(Usuario usuarioActual) {
        Cliente.modificarCliente(usuarioActual);
    }

    public static void modificarCapturista(Usuario usuarioActual) {
        Capturista.modificarCapturista(usuarioActual);
    }

    public static void modificarInversionista(Usuario usuarioActual) {
        Inversionista.modificarInversionista(usuarioActual);
    }

    public static void modificarEjecutivo(Usuario usuarioActual) {
        EjecutivoCuenta.modificarEjecutivo(usuarioActual);
    }




    public static void eliminarCliente(Usuario usuarioActual) {
        Cliente.eliminarCliente(usuarioActual);
    }
    public static void eliminarEjecutivo(Usuario usuarioActual) {
        EjecutivoCuenta.eliminarEjecutivo(usuarioActual);
    }
    public static void eliminarCapturista(Usuario usuarioActual) {
        Capturista.eliminarCapturista(usuarioActual);
    }

    public static void eliminarInversionista(Usuario usuarioActual) {
        Inversionista.eliminarInversionista(usuarioActual);
    }

    public static void solicitarTarjetaCredito(Usuario usuarioActual){
        Cliente userSolicita = (Cliente) usuarioActual;
        userSolicita.solicitarTarjeta(usuarioActual);
    }
    public static void autorizarSolicitud(Usuario usuarioActual){
        Usuario.aceptarSolicitud(usuarioActual);
    }
    public static void mostrarSolicitudes(){
        SolicitudTarjeta.mostrarListaSolicitudes();
    }

    public static void realizarAbono(){
        Tarjeta.abonar();
    }

    public static void mostrarInversiones(Usuario usuarioActual, Sucursal sucursal) {
        Inversionista.mostrarInversiones(sucursal);

    }

}
