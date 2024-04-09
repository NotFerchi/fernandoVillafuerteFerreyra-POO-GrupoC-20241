import Usuario.Asistente;
import Usuario.Cliente;
import utils.Rol;

public class Main {
    public static void main (String[] args ){

        Cliente cliente = new Cliente("Fernando", "Vil","4431109960");
        System.out.println(cliente.mostrarInfo());

    }

}