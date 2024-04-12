import Usuario.Asistente;
import Usuario.Cliente;
import utils.Rol;
import Libreria.Menu;


//Cliente - Ver los libros, consultar sus rentas

//Asistente - CRUD - Clientes y libros

// C - CREATE

// R - READ

// U - UPDATE

// D - DELETE


// REALIZAR LOS MENUS Y HACER UNA OPCION PARA QUE CADA MENU TENGA LA OPCIO N PARA CERRAR SESION
// TAMBIEN DESPUES PARA VOLVER A PODER INICIAR SESION
// EJEMPLO COMO FUNCIONA FACEBOOK
// LOS MENUS NO SE LES IMPLEMENTAN LAS FUNCIONALIDADES, PUEDEN SER BRAKE
// UTILIZAR UN WHILE, UN DO WHILE

public class Main {
  public static void main (String[] args ){
    Menu menu = new Menu();
    menu.iniciarSesion();
  
  }

}