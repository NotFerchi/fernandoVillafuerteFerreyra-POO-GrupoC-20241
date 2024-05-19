import libreria.Libreria;
import libreria.Menu;

public class Main {
    public static void main(String[] args) {
        Libreria libreria = new Libreria(true);
        Menu menu = new Menu();
        menu.iniciarSesion();

    }
}