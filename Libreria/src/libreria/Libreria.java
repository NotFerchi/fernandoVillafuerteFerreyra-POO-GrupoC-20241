package libreria;

import usuarios.Asistente;
import usuarios.Cliente;
import usuarios.Gerente;
import usuarios.Usuario;
import usuarios.utils.Libro;
import usuarios.utils.Rol;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Libreria {

    public static final HashMap<Rol, ArrayList<Usuario>> usuarios = new HashMap<>();

    public static final ArrayList<Libro> libros = new ArrayList<>();

    public Libreria() {
        Gerente gerente = new Gerente("FER", "VILL", "443543535", 4500, "ERFBHFG273689", "NIGGA", "117");
        if (!usuarios.containsKey(Rol.GERENTE)) {
            usuarios.put(Rol.GERENTE, new ArrayList<>());
        }
        usuarios.get(Rol.GERENTE).add(gerente);

        Asistente asistente = new Asistente("NIG", "GG", "532525255", 1500.0, "RHSDF5U1234123", "NIGA2") {
            @Override
            public void setFechaNacimiento(String nuevaFecha) {

            }
        };
        if (!usuarios.containsKey(Rol.ASISTENTE)) {
            usuarios.put(Rol.ASISTENTE, new ArrayList<>());
        }
        usuarios.get(Rol.ASISTENTE).add(asistente);

        Cliente cliente = new Cliente("GIGANIGA", "HH", "35535353553", "NIGA", "1234", "1995/10/02") {
            @Override
            public void setFechaNacimiento(String nuevaFecha) {

            }
        };
        if (!usuarios.containsKey(Rol.CLIENTE)) {
            usuarios.put(Rol.CLIENTE, new ArrayList<>());
        }
        usuarios.get(Rol.CLIENTE).add(cliente);
    }

    public Usuario verificarInicioSesion(String nombreUsuario, String contrasena) {
        for (Map.Entry<Rol, ArrayList<Usuario>> entry : usuarios.entrySet()) {
            for (Usuario usuario : entry.getValue()) {
                if (usuario.getNombreUsuario().equals(nombreUsuario) && usuario.getContrasena().equals(contrasena)) {
                    return usuario;
                }
            }
        }
        return null;
    }

    public static void registrarCliente() {
        Cliente.registrarCliente();
    }

    public static void mostrarClientes() {
        Cliente.mostrarCliente();
    }

    public static void eliminarClientes() {
        Cliente.eliminarClientes();
    }

    public static void registrarAsistente() {
        Asistente.registrarAsistente();
    }

    public static void mostrarAsistentes() {
        Asistente.mostrarAsistentes();
    }

    public static void eliminarAsistentes() {
        Asistente.eliminarAsistentes();
    }

    public static void registrarLibros() {
        Libro.registrarLibros();
    }

    public static void mostrarLibros() {
        Libro.mostrarLibros();
    }

    public void mostrarGerentes() {
    }

    public void eliminarGerentes() {
    }

    public void registrarGerente() {
    }
}
