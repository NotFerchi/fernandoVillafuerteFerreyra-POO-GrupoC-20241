package Usuario;

import utils.Rol;

public class Usuario {
    private static int CANTIDAD_USUARIOS = 1;
    private int id;
    private String nombre;
    private String apellido;
    private String telefono;
    private Rol rol;
// utils ó helpers
// cliente, asistente, gerente


    public Usuario(String nombre, String apellido, String telefono, Rol rol) {
        this.id = CANTIDAD_USUARIOS ;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.rol = rol;
        CANTIDAD_USUARIOS ++;
    }

    public String mostrarInfo (){
        return String.format("id: %d, Nombre completo: %s %s, telefono: %s, rol: %s",
                id,nombre,apellido,telefono,rol);

    }
}
