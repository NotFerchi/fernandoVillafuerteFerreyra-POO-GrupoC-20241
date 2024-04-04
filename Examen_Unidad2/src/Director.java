import java.util.*;
public class Director {
        private static final String CONTRASENA_DIRECTOR = "123456789@";

        public static boolean autenticarDirector() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Ingrese la contraseña del director:");
            String input = scanner.nextLine();
            return input.equals(CONTRASENA_DIRECTOR);
        }
    }

