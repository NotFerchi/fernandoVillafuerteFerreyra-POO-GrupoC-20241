package usuarios;

import libreria.Libreria;
import usuarios.utils.Rol;

import java.time.LocalDate;

public class Gerente extends Usuario {
    private double sueldo;
    private String INE;
    private LocalDate fechaInicio;

    public Gerente(String nombre, String apellido, String telefono, double sueldo, String INE, String nombreUsuario, String contrasena) {
        super(nombre, apellido, telefono, Rol.GERENTE, nombreUsuario, contrasena, "1990-01-01");
        this.sueldo = sueldo;
        this.fechaInicio = LocalDate.now();
        this.INE = INE;
    }

    @Override
    public String toString() {
        return String.format("%s, fecha inicio: %s, INE: %s, Sueldo: %f", super.toString(), fechaInicio, INE, sueldo);
    }

    @Override
    public void setFechaNacimiento(String fechaNacimiento) {
        // Este método no es aplicable para un Gerente, por lo que lo dejamos vacío o lanzamos una excepción
        throw new UnsupportedOperationException("El método setFechaNacimiento no es aplicable para un Gerente");
    }
}