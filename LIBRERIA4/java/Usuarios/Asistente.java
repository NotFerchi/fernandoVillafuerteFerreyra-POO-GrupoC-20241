package Usuarios;
import Usuarios.Utils.Rol;
import Usuarios.Usuario;
import java.time.LocalDate;

public class Asistente extends Usuario {

    private double sueldo;
    private String RFC;
    private LocalDate fechaInicio;

  
    public Asistente(String nombre, String apellido, String telefono, double sueldo, String RFC, String nombreUsuario, String contrasena) {
        super(nombre, apellido, telefono, Rol.ASISTENTE, nombreUsuario, contrasena);
        this.fechaInicio = LocalDate.now();
        this.RFC = RFC;
        this.sueldo = sueldo;
    }
    @Override
    public String toString() {
        return String.format("%s , fecha inicio: %s, INE: %s, Sueldo del asistente: %.2f", super.toString(), fechaInicio, RFC, sueldo);
    }
}