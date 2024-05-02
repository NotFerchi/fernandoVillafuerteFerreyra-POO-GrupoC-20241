package Usuarios;
import Usuarios.Utils.Rol;
import Usuarios.Usuario;
import Libreria.Libreria;
import Libreria.Utils.DatosComun;
import Usuarios.Asistente;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Asistente extends Usuario implements EmpleadoUtils  {

    private double sueldo;
    private String RFC;
    private LocalDate fechaInicio;

  
    public Asistente(String nombre, String apellido, String telefono, double sueldo, String RFC, String nombreUsuario, String contrasena) {
        super(nombre, apellido, telefono, Rol.ASISTENTE, nombreUsuario, contrasena);
        this.fechaInicio = LocalDate.now();
        this.RFC = RFC;
        this.sueldo = sueldo;
    }
    @Override
    public String toString() {
        return String.format("%s , fecha inicio: %s, INE: %s, Sueldo del asistente: %.2f", super.toString(), fechaInicio, RFC, sueldo);
    }

  @Override
  public void checarEntrada(){
    System.out.println("por correo");
  }
  @Override
  public void checarSalida(){
    System.out.println("por correo");
  }

  public static void registrarAsistente() {
      Scanner scanner = new Scanner(System.in);
      ArrayList<String> datosComun = DatosComun.ObtenerDatosComun(Rol.ASISTENTE);

      String nombre = datosComun.get(0);
      String apellido = datosComun.get(1);
      String telefono = datosComun.get(2);
      String nombreUsuario = datosComun.get(3);
      String contrasena = datosComun.get(4);

      System.out.println("Ingresa el sueldo: ");
      double sueldo = scanner.nextDouble();

      System.out.println("Ingresa tu RFC: ");
      String RFC = scanner.nextLine();

      Usuarios.Asistente asistente = new Usuarios.Asistente(nombre, apellido, telefono, sueldo, RFC, nombreUsuario, contrasena);
      if (!Libreria.usuarios.containsKey(Rol.ASISTENTE)) {
          Libreria.usuarios.put(Rol.ASISTENTE, new ArrayList<Usuario>());
      }

      Libreria.usuarios.get(Rol.ASISTENTE).add(asistente);

      System.out.println("\nAsistente Registrado Exitosamente\n");
  }

  public static void mostrarAsistentes() {
      System.out.println("\nAsistentes en la biblioteca");
      for (Usuario Usuario : Libreria.usuarios.get(Rol.ASISTENTE)) {
          Usuarios.Asistente asistente = (Usuarios.Asistente) Usuario;
          System.out.println(asistente.toString());
          System.out.println(" ");
      }
  }

  public static void eliminarAsistentes() {
      int eliminarAsistente = 0;
      boolean asistenteExistente = true;
      Scanner scanner = new Scanner(System.in);
      System.out.println("\nEliminar asistentes del sistema");
      System.out.println("Esta es la lista de asistentes registrados: ");
      for (Usuario usuario : Libreria.usuarios.get(Rol.ASISTENTE)) {
         Usuarios.Asistente asistente = (Usuarios.Asistente) usuario;
          System.out.println(usuario.toString());
          System.out.println(" ");
      }

      do {
          System.out.println("Ingrese el ID del cliente que desee eliminar del sistema: ");
          eliminarAsistente = scanner.nextInt();
          asistenteExistente = false;

          ArrayList<Usuario> eliminar = Libreria.usuarios.get(Rol.ASISTENTE);
          for (int i = 0; i < eliminar.size(); i++) {
              Usuario usuarioEliminar = eliminar.get(i);
              if (usuarioEliminar.getId() == eliminarAsistente) {
                  asistenteExistente = true;
                  eliminar.remove(i);
                  System.out.println("El asistente: " + usuarioEliminar.getNombre() + " se ha eliminado correctamente del sistema");
                  System.out.println(" ");
                  break;
              }
          }
          if (!asistenteExistente) {
              System.out.println("El id que ingreso no pertecene a ningun asistente registrado. Intenta de nuevo.");
              System.out.println(" ");
              break;
          }
      } while (asistenteExistente);
  }
}