
package Usuario;

import utils.Rol;

import java.time.LocalDate;

public class Cliente extends Usuario {

    private LocalDate fechaRegistro;

    public Cliente(String nombre, String apellido, String telefono) {
        super(nombre, apellido, telefono, Rol.CLIENTE);
        this.fechaRegistro = LocalDate.now();
    }


    @Override
    public String mostrarInfo() {
        return String.format("%s, fecha registro: %s", super.mostrarInfo(), fechaRegistro);

    }
}
