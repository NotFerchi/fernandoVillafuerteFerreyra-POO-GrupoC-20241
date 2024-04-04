import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        Scanner scanner = new Scanner(System.in);
        String password;

        System.out.println("----- BIENVENIDOS AL ZOOLOGICO DE MORELIA -----");
        do {
            System.out.println("Ingrese la contraseña:");
            password = scanner.nextLine();
        } while (!password.equals("123456789@"));

        int opcion;
        do {
            System.out.println("Por favor, selecciona una opción:");
            System.out.println("1. Registrar Empleado");
            System.out.println("2. Registrar Visitante");
            System.out.println("3. Registrar Visita");
            System.out.println("4. Registrar Animal");
            System.out.println("5. Registrar Mantenimiento");
            System.out.println("6. Modificar Registro (Empleado, Visitante, Animal)");
            System.out.println("7. Eliminar Registro (Empleado, Visitante, Animal)");
            System.out.println("8. Consultar Registros");
            System.out.println("9. Salir");
            System.out.println("Seleccione una opción:");

            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer de entrada

            switch (opcion) {
                case 1:
                    sistema.registrarEmpleado();
                    break;
                case 2:
                    sistema.registrarVisitante();
                    break;
                case 3:
                    sistema.registrarVisita();
                    break;
                case 4:
                    sistema.registrarAnimal();
                    break;
                case 5:
                    sistema.registrarMantenimiento();
                    break;
                case 6:
                    sistema.modificarRegistro();
                    break;
                case 7:
                    sistema.eliminarRegistro();
                    break;
                case 8:
                    sistema.consultarRegistros();
                    break;
                case 9:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intenta de nuevo.");
            }
        } while (opcion != 9);

        scanner.close();
    }
}