package Libreria;
import java.util.Scanner;
import Usuarios.Usuario;
import Util.UsuarioEnSesion;

public class Menu{
    private Libreria libreria = new Libreria();

    public void iniciarSesion(){
        Scanner scanner = new Scanner(System.in);
        boolean datosCorrectos = false;
        do{
            System.out.println("\n-----------BIENVENIDO A LA LIBRERIA-----------\n");
            System.out.println("Para continuar inicia sesion... \n");

            System.out.println("Ingrese su nombre de usuario:");
            String usuario = scanner.nextLine();

            System.out.println("Ingrese su contraseña:");
            String contrasena = scanner.nextLine();

            Usuario usuarioActual = libreria.verificarInicioSesion(usuario, contrasena) ;
            if(usuarioActual != null) {
                datosCorrectos = true;
                UsuarioEnSesion.obtenerInstancia().setUsuarioActual(usuarioActual);
                seleccionarMenu();
            } else {
                System.out.printf("\nUsuario o contrasena incorrectos. Intenta de nuevo.\n");
            }
        }while(!datosCorrectos);
    }

    private void seleccionarMenu() {
        Usuario usuario = UsuarioEnSesion.obtenerInstancia().getUsuarioActual();
        switch (usuario.getRol()) {
            case CLIENTE -> mostrarMenuCliente();
            case ASISTENTE -> mostrarMenuAsistente();
            case GERENTE -> mostrarMenuGerente();
        }
    }

    private void mostrarMenuCliente() {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        System.out.println("Bienvenido al sistema del Cliente");
        do {
            System.out.println("Estas son las opciones: ");
            System.out.println("1. Ver lista de libros");
            System.out.println("2. Consultar las rentas");
            System.out.println("3. Mostrar mis datos");
            System.out.println("4. Editar mi informacion");
            System.out.println("0. Cerrar sesion");
            opcion = scanner.nextInt();

            switch (opcion) {

                case 1:
                    System.out.println("Elegiste la opcion 1");
                    libreria.mostrarLibros();
                    break;
                case 2:
                    System.out.println("Elegiste la opcion 2");
                    break;
                case 3:
                    System.out.println("Elegiste la opcion 3");
                    break;
                case 4:
                    System.out.println("Elegiste la opcion 4");
                    break;
                case 0:
                    System.out.println("Elegiste la opcion 5");
                    System.out.println("Cerrando sesion...");
                    UsuarioEnSesion.obtenerInstancia().cerrarSesion();
                    iniciarSesion();
                    break;
            }
        }while(opcion != 0);
    }


    private void mostrarMenuAsistente() {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        System.out.println("Bienvenido al sistema del Asistente");
        do {
            System.out.println("Estas son las opciones: ");

            System.out.println("1. Registrar un cliente");
            System.out.println("2. Registrar un libro");

            System.out.println("3. Ver lista de clientes");
            System.out.println("4. Ver lista de libros");

            System.out.println("5. Actualizar info cliente");
            System.out.println("6. Actualizar info libro");

            System.out.println("7. Eliminar cliente del sistema");
            System.out.println("8. Eliminar libro del sistema");

            System.out.println("9. Ver libros rentaddos");

            System.out.println("0. Cerrar sesion");
            opcion = scanner.nextInt();

            switch (opcion) {

                case 1:
                    System.out.println("Elegiste la opcion 1");
                    libreria.registrarCliente();
                    break;
                case 2:
                    System.out.println("Elegiste la opcion 2");
                    libreria.registrarLibros();
                    break;
                case 3:
                    System.out.println("Elegiste la opcion 3");
                    libreria.mostrarClientes();
                    break;
                case 4:
                    System.out.println("Elegiste la opcion 4");
                    libreria.mostrarLibros();
                    break;
                case 5:
                    System.out.println("Elegiste la opcion 5");
                    break;
                case 6:
                    System.out.println("Elegiste la opcion 6");
                    break;
                case 7:
                    System.out.println("Elegiste la opcion 7");
//                   libreria.eliminarClientes();
                    break;
                case 8:
                    System.out.println("Elegiste la opcion 8");
                    break;
                case 9:
                    System.out.println("Elegiste la opcion 9");
                    break;
                case 0:
                    System.out.println("Elegiste la opcion 0");
                    System.out.println("Cerrando sesion...");
                    UsuarioEnSesion.obtenerInstancia().cerrarSesion();
                    iniciarSesion();
                    break;
            }
        }while(opcion != 0);
    }

    private void mostrarMenuGerente() {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        System.out.println("Bienvenido al sistema del Gerente");
        do {
            System.out.println("Estas son las opciones: ");

            System.out.println("1. Registrar un cliente");
            System.out.println("2. Registrar asistente");
            System.out.println("3. Registrar gerente");
            System.out.println("4. Registrar un libro");

            System.out.println("5. Ver lista de clientes");
            System.out.println("6. Ver lista de asistentes");
            System.out.println("7. Ver lista de gerentes");
            System.out.println("8. Ver lista de libros");

            System.out.println("9. Actualizar inf cliente");
            System.out.println("10. Actualizar info asistente");
            System.out.println("11. Actializar info gerente");
            System.out.println("12. Actualizar datos de un libro");

            System.out.println("13. Eliminar cliente del sistema");
            System.out.println("14. Eliminar asistente del sistema");
            System.out.println("15. Eliminar gerente del sistema");
            System.out.println("16. Eliminar un libro del sistema");

            System.out.println("17. Rentar libro");
            System.out.println("18. Ver libros rentaddos");

            System.out.println("0. Cerrar sesion");
            opcion = scanner.nextInt();

            switch (opcion) {

                case 1:
                    System.out.println("Elegiste la opcion 1");
                    libreria.registrarCliente();
                    break;
                case 2:
                    System.out.println("Elegiste la opcion 2");
                    libreria.registrarAsistente();
                    break;
                case 3:
                    System.out.println("Elegiste la opcion 3");
                    libreria.registrarGerente();
                    break;
                case 4:
                    System.out.println("Elegiste la opcion 4");
                    libreria.registrarLibros();
                    break;
                case 5:
                    System.out.println("Elegiste la opcion 5");
                    libreria.mostrarClientes();
                    break;
                case 6:
                    System.out.println("Elegiste la opcion 6");
                    libreria.mostrarAsistentes();
                    break;
                case 7:
                    System.out.println("Elegiste la opcion 7");
                    libreria.mostrarGerentes();
                    break;
                case 8:
                    System.out.println("Elegiste la opcion 8");
                    libreria.mostrarLibros();
                    break;
                case 9:
                    System.out.println("Elegiste la opcion 9");
                    break;
                case 10:
                    System.out.println("Elegiste la opcion 10");
                    break;
                case 11:
                    System.out.println("Elegiste la opcion 11");
                    break;
                case 12:
                    System.out.println("Elegiste la opcion 12");
                    break;
                case 13:
                    System.out.println("Elegiste la opcion 13");
//                   libreria.eliminarClientes();
                    break;
                case 14:
                    System.out.println("Elegiste la opcion 14");
//                    libreria.eliminarAsistentes();
                    break;
                case 15:
                    System.out.println("Elegiste la opcion 15");
//                    libreria.eliminarGerentes();
                    break;
                case 16:
                    System.out.println("Elegiste la opcion 16");
                    break;
                case 17:
                    System.out.println("Elegiste la opcion 17");
                    break;
                case 18:
                    System.out.println("Elegiste la opcion 18");
                    break;
                case 0:
                    System.out.println("Elegiste la opcion 0");
                    System.out.println("Cerrando sesion...");
                    UsuarioEnSesion.obtenerInstancia().cerrarSesion();
                    iniciarSesion();
                    break;
            }
        }while(opcion != 0);
    }

}