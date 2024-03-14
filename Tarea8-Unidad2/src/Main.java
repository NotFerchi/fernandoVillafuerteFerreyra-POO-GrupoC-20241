
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Libreria libreria = new Libreria();
        Scanner scanner = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("\nMenú:");
            System.out.println("1-- Registrar usuario");
            System.out.println("2-- Registrar libro");
            System.out.println("3-- Rentar libro");
            System.out.println("4-- Lista de usuarios");
            System.out.println("5-- Lista de libros");
            System.out.println("6-- Lista de usuarios con libros rentados");
            System.out.println("7--- Lista de libros sin rentar");
            System.out.println("8-- Lista de libros rentados");
            System.out.println("9-- Salir");
            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    scanner.nextLine();
                    System.out.print("Ingrese el nombre del usuario: ");
                    String nombreUsuario = scanner.nextLine();
                    libreria.registrarUsuario(nombreUsuario);
                    break;
                case 2:
                    scanner.nextLine();
                    System.out.print("Ingrese el título del libro: ");
                    String tituloLibro = scanner.nextLine();
                    libreria.registrarLibro(tituloLibro);
                    break;
                case 3:
                    scanner.nextLine();
                    System.out.print("Ingrese el título del libro a rentar: ");
                    String tituloRenta = scanner.nextLine();
                    System.out.print("Ingrese el nombre del usuario que rentará el libro: ");
                    String nombreRenta = scanner.nextLine();
                    libreria.rentarLibro(tituloRenta, nombreRenta);
                    break;
                case 4:
                    libreria.listarUsuarios();
                    break;
                case 5:
                    libreria.listarLibros();
                    break;
                case 6:
                    libreria.listarUsuariosConLibros();
                    break;
                case 7:
                    libreria.listarLibrosNoRentados();
                    break;
                case 8:
                    libreria.listarLibrosRentados();
                    break;
                case 9:
                    System.out.println("Usted ha salido del programa.");
                    break;
                default:
                    System.out.println("Opción inválida. Ingrese nuevamente.");
            }
        } while (opcion != 9);
    }
}
