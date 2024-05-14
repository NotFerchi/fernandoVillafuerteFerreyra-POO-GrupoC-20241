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
        Gerente gerente = new Gerente("Aaron", "Telles", "4432198178", 23300, "TEMA050110HMNLGRA3", "AaronSex", "Gearsofwar2331");
        if (!usuarios.containsKey(Rol.GERENTE)) {
            usuarios.put(Rol.GERENTE, new ArrayList<>());
        }
        usuarios.get(Rol.GERENTE).add(gerente);

        Asistente asistente = new Asistente("Juan", "Rivera", "4433210999", 1500.0, "JUANITO1234123", "juan123") {
            @Override
            public void setFechaNacimiento(String nuevaFecha) {

            }
        };
        if (!usuarios.containsKey(Rol.ASISTENTE)) {
            usuarios.put(Rol.ASISTENTE, new ArrayList<>());
        }
        usuarios.get(Rol.ASISTENTE).add(asistente);

        Cliente cliente = new Cliente("Britany", "Ortiz", "4431611799", "BRI1234", "2345678", "1990-05-01") {
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