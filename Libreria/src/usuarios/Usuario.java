package usuarios;

import usuarios.utils.Rol;

public abstract class Usuario {

    private static int CANTIDAD_USUARIOS = 1;
    private String nombre;
    private String apellido;
    private int id;
    private String telefono;
    private Rol rol;
    private String nombreUsuario;
    private String contrasena;
    private String fechaNacimiento;

    public Usuario(String nombre, String apellido, String fechaNacimiento, String telefono, Rol rol, String nombreUsuario, String contrasena) {
        this.id = CANTIDAD_USUARIOS;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.rol = rol;
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.fechaNacimiento = fechaNacimiento;
        CANTIDAD_USUARIOS++;
    }
    @Override
    public String toString() {
        return String.format("Id: %d, Nombre completo: %s %s, Fecha de nacimiento: %s telefono: %s, rol: %s",
                id, nombre, apellido, fechaNacimiento,telefono, rol);
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

    public static class Asistente {
    }
}