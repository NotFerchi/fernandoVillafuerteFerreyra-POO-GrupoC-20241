package Libreria;
import java.util.Scanner;

public class Menu{

  private Scanner scanner = new Scanner(System.in);
  private Libreria libreria = new Libreria();
  
  
  public void iniciarSesion(){
    
    boolean datosCorrectos = false;
do{
  System.out.println("\nBienvenido a la libreria");
    System.out.println("Para continuar inicia sesion \n");
  
    System.out.println("Ingrese su nombre de usuario");
    String usuario = scanner.nextLine();

    System.out.println("Ingrese su contraseña");
    String contrasena = scanner.nextLine();

  if (Libreria.verificarInicioSesion(usuario, contrasena)){
      Usuario usuarioActual = Libreria.verificarInicioSesion(usuario, contrasena);
      if (usuarioActual != null){
        datosCorrectos = true;
        seleccionarMenu(usuarioActual);

      }else{
        Syste.out.println("Datos incorrectos, Intenta de nuevo");
        }
  }
}while(!datosCorrectos);
      }

  private void seleccionarMenu(Usuario usuario){
    switch(usuario.getRol()){
      case CLIENTE -> mostrarMenuCliente();
      case ASISTENTE -> mostrarMenuAsistente();
      case GERENTE -> mostrarMenuGerente();
    }
  }
    
  private void mostrarMenuCliente(){
    System.out.println("Bienvenido al sistema de cliente");
        System.out.println("1. Ver libros disponibles");
        System.out.println("2. Consultar rentas");
        System.out.println("E. Cerrar sesión");
        System.out.println("0. Salir");
        System.out.print("Por favor, seleccione una opción: ");

        String opcion = scanner.nextLine().toUpperCase();

        switch (opcion) {
            case 1:
                
                break;
            case 2:
                
                break;
            case 3:
                System.out.println("Sesión cerrada. ¡Hasta luego!");
                iniciarSesion();
                break;
            case 4:
                System.out.println("Saliendo del sistema...");
            default:
                System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                mostrarMenuCliente();
                break;
        }

    }
  
  
  private void mostrarMenuAsistente(){
    System.out.println("Bienvenido al sistema de asistente");
    System.out.println("1. Registro de clientes");
    System.out.println("2. Consulta de clientes");
    System.out.println("3. Modificación de clientes");
    System.out.println("4. Eliminación de clientes");
    System.out.println("5. Registro de libros");
    System.out.println("6. Consulta de libros");
    System.out.println("7. Modificación de libros");
    System.out.println("8. Eliminación de libros");
    System.out.println("9. Consultar rentas");
    System.out.println("E. Cerrar sesión");
    System.out.println("0. Salir");

    String opcion = scanner.nextLine().toUpperCase();

    switch (opcion) {
        case "1":

            break;
        case "2":

            break;
        case "3":

            break;
        case "4":

            break;
        case "5":

            break;
        case "6":

            break;
        case "7":

            break;
        case "8":

            break;
        case "9":

            break;
        case "E":
            System.out.println("Sesión cerrada. ¡Hasta luego!");
            iniciarSesion();
            break;
        case "0":
            System.out.println("Saliendo del sistema...");
            break;
        default:
            System.out.println("Opción invalida. Por favor, seleccione una opcion valida.");
            mostrarMenuAsistente();
            break;
    }
    
  }
  
  private void mostrarMenuGerente(){

    System.out.println("Bienvenido al sistema de gerente");
        System.out.println("1. Registro de clientes");
        System.out.println("2. Consulta de clientes");
        System.out.println("3. Modificación de clientes");
        System.out.println("4. Eliminación de clientes");
        System.out.println("5. Registro de libros");
        System.out.println("6. Consulta de libros");
        System.out.println("7. Modificación de libros");
        System.out.println("8. Eliminación de libros");
        System.out.println("9. Registro de asistentes");
        System.out.println("10. Consulta de asistentes");
        System.out.println("11. Modificación de asistentes");
        System.out.println("12. Eliminación de asistentes");
        System.out.println("13. Consultar rentas");
        System.out.println("E. Cerrar sesión");
        System.out.println("0. Salir");

        String opcion = scanner.nextLine().toUpperCase();

        switch (opcion) {
            case "1":

                break;
            case "2":

                break;
            case "3":

                break;
            case "4":

                break;
            case "5":

                break;
            case "6":

                break;
            case "7":

                break;
            case "8":

                break;
            case "9":

                break;
            case "10":

                break;
            case "11":

                break;
            case "12":

                break;
            case "13":

                break;
            case "E":
                System.out.println("Sesión cerrada. ¡Hasta luego!");
                iniciarSesion();
                break;
            case "0":
                System.out.println("Saliendo del sistema...");
                break;
            default:
                System.out.println("Opción invalida. Por favor, seleccione una opcion valida.");
                mostrarMenuGerente();
                break;
        }
    }
  
}