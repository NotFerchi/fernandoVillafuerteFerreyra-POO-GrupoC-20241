package Usuarios;
import Usuarios.Utils.Rol;
import java.time.LocalDate;
import Usuarios.Usuario;
public class Cliente extends Usuario {

    private LocalDate fechaRegistro;

    public Cliente (String nombre, String apellido, String telefono, String nombreUsuario, String contrasena) {
        super(nombre, apellido, telefono, Rol.CLIENTE, nombreUsuario, contrasena);
        this.fechaRegistro = LocalDate.now();
    }


    @Override
    public String toString() {
        return String.format("%s, fecha registro: %s", super.toString(), fechaRegistro);

    }


    public static class Gerente {
    }
}
