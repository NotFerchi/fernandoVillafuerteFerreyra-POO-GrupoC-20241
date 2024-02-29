import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String nombre;
        double precio;
        int stock;

        System.out.println("ABARROTES DON JUAN \n");
        System.out.println("Agregar producto-\n");
        System.out.println("Nombre: ");
        nombre = scanner.nextLine();
        System.out.println("Precio: $");
        precio = scanner.nextDouble();
        System.out.println("Stock: ");
        stock = scanner.nextInt();

        Producto producto = new Producto (nombre, precio, stock);


        int opcion;
        do {
            System.out.println("\n1) Aumentar Stock");
            System.out.println("2) Reducir Stock");
            System.out.println("3) Información");
            System.out.println("4) Salir");
            System.out.print("\nIngrese opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Cantidad ha aumentar: ");
                    int incrementoCantidad = scanner.nextInt();
                    producto.incrementarStock(incrementoCantidad);
                    System.out.println("Se ha aumentado el stock");
                    break;
                case 2:
                    System.out.print("Cantidad ha reducir: ");
                    int reduccionCantidad = scanner.nextInt();
                    producto.reducirStock(reduccionCantidad);
                    System.out.println("Se ha reducido el stock.");
                    break;
                case 3:
                    System.out.println("\nInformación del Producto:");
                    System.out.println("Nombre: " + producto.getNombre());
                    System.out.println("Precio: $" + producto.getPrecio());
                    System.out.println("Stock: " + producto.getStock());
                    break;
                case 4:
                    System.out.println("Saliste del sistema.");
                    break;
                default:
                    System.out.println("Opción incorrecta. Elige una opción válida (1-4).");
            }
        } while (opcion != 4);


    }
}