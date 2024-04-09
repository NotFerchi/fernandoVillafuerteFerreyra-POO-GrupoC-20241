package Usuario;

import utils.Rol;

import java.time.LocalDate;

public class Asistente extends Usuario {

    private LocalDate fechainicio;
    private double sueldo;
    private String INE;

    public Asistente (String nombre, String apellido, String telefono){
        super (nombre, apellido, telefono, Rol.ASISTENTE);
        this.fechainicio = LocalDate.now();
        this.sueldo = sueldo;
        this.INE = INE;


    }

    @Override
    public String mostrarInfo() {
        return String.format("%s, Fecha de inicio: %s","%s, Sueldo: %s", "%s, INE: %s,", super.mostrarInfo(),fechainicio, sueldo, INE);
    }

}