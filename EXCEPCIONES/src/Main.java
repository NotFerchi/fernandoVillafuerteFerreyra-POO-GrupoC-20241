public class Main {
    public static void main(String[] args) {
        try {
            // Intentamos llamar al método length() en una cadena que es nula
            String str = null;
            System.out.println(str.length());
        } catch (NullPointerException e) {
            // Capturamos la NullPointerException y proporcionamos un mensaje descriptivo
            System.out.println("Se ha producido una NullPointerException: " + e.getMessage());
        }

        try {
            // Intentamos dividir un número entre cero
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            // Capturamos la ArithmeticException y proporcionamos un mensaje descriptivo
            System.out.println("Se ha producido una ArithmeticException: " + e.getMessage());
        }

        try {
            // Intentamos acceder a un índice fuera del rango del arreglo
            int[] arr = new int[5];
            System.out.println(arr[10]);
        } catch (ArrayIndexOutOfBoundsException e) {
            // Capturamos la ArrayIndexOutOfBoundsException y proporcionamos un mensaje descriptivo
            System.out.println("Se ha producido una ArrayIndexOutOfBoundsException: " + e.getMessage());
        }

        try {
            // Intentamos abrir un archivo que no existe
            File file = new File("archivo.txt");
            FileReader fr = new FileReader(file);
        } catch (IOException e) {
            // Capturamos la IOException y proporcionamos un mensaje descriptivo
            System.out.println("Se ha producido una IOException: " + e.getMessage());
        }

        try {
            // StackOverflowError
            recursiveMethod(); // Método recursivo sin caso base.
        } catch (StackOverflowError e) {
            System.out.println("Error: Se excedió el límite de profundidad de la pila de llamadas.");
            e.printStackTrace();
        }

        try {
            // InterruptedException
            Thread.sleep(1000); // Interrupción mientras se espera.
        } catch (InterruptedException e) {
            System.out.println("Error: Se interrumpió el hilo mientras estaba en espera.");
            e.printStackTrace();
        }

        try {
            // FileNotFoundException
            java.io.FileInputStream fis = new java.io.FileInputStream("archivo.txt"); // Intentando abrir un archivo que no existe.
        } catch (java.io.FileNotFoundException e) {
            System.out.println("Error: No se encontró el archivo especificado.");
            e.printStackTrace();
        }

        try {
            // ConcurrentModificationException
            //        La excepción ConcurrentModificationException se produce en Java cuando se intenta modificar una colección
            List<String> lista = new ArrayList<>();
            lista.add("A");
            lista.add("B");
            for (String item : lista) {
                lista.remove(item);
            }
        } catch (ConcurrentModificationException e) {
            System.out.println("ConcurrentModificationException: " + e.getMessage());
        }

        //  SecurityException
//        La excepción SecurityException se produce en Java cuando se intenta realizar una operación de seguridad que
//        está restringida por el Administrador de Seguridad de Java.
        try {
            System.setProperty("java.home", "/nuevo/directorio");
        } catch (SecurityException e) {
            System.out.println("SecurityException: " + e.getMessage());
        }

        //  NumberFormatException
//        La excepción NumberFormatException se produce en Java cuando se intenta convertir una cadena a un tipo numérico.

        try {
            String str2 = "abc";
            int num = Integer.parseInt(str2);
            System.out.println(num);
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException: " + e.getMessage());
        }
    }
}
