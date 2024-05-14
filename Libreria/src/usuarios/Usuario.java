package usuarios;

import usuarios.utils.Rol;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Usuario {

    private static int CANTIDAD_USUARIOS = 1;
    private String nombre;
    private String apellido;
    private int id;
    private String telefono;
    private Rol rol;
    private String nombreUsuario;
    private String contrasena;
    private LocalDate fechaNacimiento;
    private String FechaNacimiento;

    public Usuario(String nombre, String apellido, String telefono, Rol rol, String nombreUsuario, String contrasena, String fechaNacimiento) {
        this.id = CANTIDAD_USUARIOS;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.rol = rol;
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;

        // Validar el formato y la validez de la fecha de nacimiento
        this.fechaNacimiento = validarFechaNacimiento(fechaNacimiento);

        CANTIDAD_USUARIOS++;
    }

    public Usuario() {

    }


    private LocalDate validarFechaNacimiento(String fechaNacimientoString) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate fechaNacimiento = LocalDate.parse(fechaNacimientoString, formatter);
            if (fechaNacimiento.isBefore(LocalDate.now()) || fechaNacimiento.isEqual(LocalDate.now())) {
                return fechaNacimiento;
            } else {
                throw new IllegalArgumentException("La fecha de nacimiento no puede ser en el futuro.");
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Formato de fecha de nacimiento incorrecto o inválido.");
        }
    }

    @Override
    public String toString() {
        return String.format("Id: %d, Nombre completo: %s %s, Telefono: %s, Rol: %s, Fecha de nacimiento: %s",
                id, nombre, apellido, telefono, rol, fechaNacimiento);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getFechaNacimiento() {
        return FechaNacimiento;
    }

    public abstract void setFechaNacimiento(String nuevaFecha);
    //public String mostrarInfo() {
    // return String.format("Id: %d, Nombre completo: %s %s, telefono: %s, rol: %s", id, nombre, apellido, telefono, rol);
    //}

    public static class Asistente extends Usuario {
        public Asistente(String nombre, String apellido, String telefono, double sueldo, String rfc, String fechaInicio, String nombreUsuario, String contrasena, String fechaNacimiento) {
            super();
        }

        public Asistente(String nombre, String apellido, String telefono, Rol rol, String nombreUsuario, String contrasena, String fechaNacimiento) {
            super(nombre, apellido, telefono, rol, nombreUsuario, contrasena, fechaNacimiento);
        }

        @Override
        public void setFechaNacimiento(String nuevaFecha) {

        }
    }
}