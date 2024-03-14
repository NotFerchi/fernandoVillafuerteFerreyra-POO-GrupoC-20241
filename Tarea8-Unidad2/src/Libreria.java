import java.util.ArrayList;
import java.util.List;

public class Libreria {

    private List<Libro> libros;
    private List<Usuario> usuarios;

    public Libreria() {
        libros = new ArrayList<>();
        usuarios = new ArrayList<>();
    }

    public void registrarUsuario(String nombre) {
        usuarios.add(new Usuario(nombre));
        System.out.println("Usuario registrado exitosamente.");
    }

    public void registrarLibro(String titulo) {
        libros.add(new Libro(titulo));
        System.out.println("Libro registrado exitosamente.");
    }

    public void rentarLibro(String titulo, String nombreUsuario) {
        Libro libro = buscarLibro(titulo);
        Usuario usuario = buscarUsuario(nombreUsuario);

        if (libro != null && usuario != null) {
            if (!libro.isRentado()) {
                libro.setRentado(true);
                System.out.println("Libro rentado exitosamente.");
            } else {
                System.out.println("El libro ya está rentado.");
            }
        } else {
            System.out.println("Libro o usuario no encontrado.");
        }
    }

    public void listarUsuarios() {
        System.out.println("Usuarios registrados:");
        for (Usuario usuario : usuarios) {
            System.out.println(usuario.getNombre());
        }
    }

    public void listarLibros() {
        System.out.println("Libros registrados:");
        for (Libro libro : libros) {
            System.out.println(libro.getTitulo());
        }
    }

    public void listarUsuariosConLibros() {
        System.out.println("Usuarios que han rentado al menos un libro:");
        for (Usuario usuario : usuarios) {
            for (Libro libro : libros) {
                if (libro.isRentado()) {
                    System.out.println(usuario.getNombre());
                    break;
                }
            }
        }
    }

    public void listarLibrosNoRentados() {
        System.out.println("Libros no rentados:");
        for (Libro libro : libros) {
            if (!libro.isRentado()) {
                System.out.println(libro.getTitulo());
            }
        }
    }

    public void listarLibrosRentados() {
        System.out.println("Libros rentados:");
        for (Libro libro : libros) {
            if (libro.isRentado()) {
                System.out.println(libro.getTitulo());
            }
        }
    }

    private Libro buscarLibro(String titulo) {
        for (Libro libro : libros) {
            if (libro.getTitulo().equals(titulo)) {
                return libro;
            }
        }
        return null;
    }

    private Usuario buscarUsuario(String nombre) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNombre().equals(nombre)) {
                return usuario;
            }
        }
        return null;
    }
}
