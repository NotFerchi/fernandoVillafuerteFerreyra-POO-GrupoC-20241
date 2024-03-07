import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
/**
 *
 * @author ferch
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Empleado> empleados = new ArrayList<>();

        System.out.println("LE BANK");
        int op;
        do {
            Empleado Empleado = new Empleado(null, 0, 0, new ArrayList<>());

            System.out.println("Ingresar Nombre de Empleado: ");
            String empleadoNombre = scanner.nextLine();
            Empleado.setNombre(empleadoNombre);

            System.out.println("¿Cuántas cuentas desea agregar para " + empleadoNombre + "?");
            int numCuentas= scanner.nextInt();
            scanner.nextLine();
            for (int i = 0; i < numCuentas; i++) {
                System.out.println("Ingresar Número de Cuenta: ");
                long cuentaNum = scanner.nextLong();

                System.out.println("Ingresar Tipo de Cuenta (A, B o C): ");
                System.out.println("(A: máximo ingreso $50,000)");
                System.out.println("(B: máximo ingreso $100,000) ");
                System.out.println("(C: sin limite) ");
                char cuentaTipo = scanner.next().charAt(0);
                scanner.nextLine();

                CuentaBanco cuenta = new CuentaBanco(cuentaNum);
                cuenta.setCuentaTipo(cuentaTipo);
                Empleado.getCuentas().add(cuenta);
            }

            empleados.add(Empleado); // Para agregar un empleado al ArrayList

            System.out.println("\n¿Deseas agregar otro empleado? \n1.- Si  \n2.- No");
            op = scanner.nextInt();
            scanner.nextLine();
        } while (op == 1);


        int continuarOp;
        do {
            System.out.println("Seleccione un empleado:");
            for (int i = 0; i < empleados.size(); i++) {
                System.out.println((i+1) + ". " + empleados.get(i).getNombre());
            }
            int selected = scanner.nextInt() - 1;
            scanner.nextLine();
            Empleado selecccionarEmpleado = empleados.get(selected);

            System.out.println("Seleccione una cuenta:");
            for (int i = 0; i < selecccionarEmpleado.getCuentas().size(); i++) {
                CuentaBanco cuenta = selecccionarEmpleado.getCuentas().get(i);
                System.out.println((i+1) + ". Número de Cuenta: " + cuenta.getCuentaNum() + ", Tipo de Cuenta: " + cuenta.getCuentaTipo() + ", Saldo: $" + cuenta.getMonto());
            }
            int cuentaSeleccionada = scanner.nextInt() - 1;
            scanner.nextLine();
            CuentaBanco seleccionarCuenta = selecccionarEmpleado.getCuentas().get(cuentaSeleccionada);

            System.out.println("¿Qué desea hacer en la cuenta?");
            System.out.println("1) Agregar Dinero");
            System.out.println("2) Retirar Dinero");
            System.out.println("3) Salir");
            op = scanner.nextInt();
            scanner.nextLine();
            switch (op) {
                case 1:
                    seleccionarCuenta.addDinero();
                    System.out.println("Nuevo Saldo: $" + seleccionarCuenta.getMonto());
                    break;
                case 2:
                    seleccionarCuenta.retirarDinero();
                    System.out.println("Nuevo Saldo: $" + seleccionarCuenta.getMonto());
                    break;
                case 3:
                    System.out.println("Ha salido del sistema.");
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }

            System.out.println("¿Desea realizar otro movimiento? \n1.- Sí  \n2.- No");
            continuarOp = scanner.nextInt();
            scanner.nextLine();

            if (continuarOp == 2) {
                System.out.println("Ha salido del sistema.");
            }
        } while (continuarOp == 1);
    }
}