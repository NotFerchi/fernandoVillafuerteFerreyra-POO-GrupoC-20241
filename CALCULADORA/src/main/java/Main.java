import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;
      Cuadrado cuadrado = new Cuadrado(3);
      Circulo circulo = new Circulo(5);
      Rectangulo rectangulo = new Rectangulo(4, 8);
     Triangulo triangulo = new Triangulo(3, 6, 7);

        do {
            System.out.println("----Calculadora Geométrica Don Lut----\n");
            System.out.println("1. Calcular área y perímetro de triángulo equilátero");
            System.out.println("2. Calcular área y perímetro de círculo");
            System.out.println("3. Calcular área y perímetro de cuadrado");
            System.out.println("4. Calcular área y perímetro de rectángulo");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
              /*  System.out.print("Ingresa el lado 1 del triángulo: ");
                triangulo.lado1 = scanner.nextDouble();

                System.out.print("Ingresa el lado 2 del triángulo: ");
                triangulo.lado2 = scanner.nextDouble();

                System.out.print("Ingresa el lado 3 del triángulo: ");
                  triangulo.lado3 = scanner.nextDouble();
                */
                System.out.println("\nTRIANGULO:");
                    System.out.println("Area: " + triangulo.calcularArea());
                    System.out.println("Perimetro: " + triangulo.calcularPerimetro()+"\n");
                    break;
                case 2:
                System.out.println("\nCIRCULO:");
                System.out.println("Area: " + circulo.calcularArea());
                System.out.println("Perimetro: " + circulo.calcularPerimetro()+"\n");
                    break;
                case 3:
                System.out.println("\nCUADRADO:");
                    System.out.println("Area: " + cuadrado.calcularArea());
                    System.out.println("Perimetro: " + cuadrado.calcularPerimetro()+"\n");
                    break;
                case 4:
                System.out.println("\nRECTANGULO:");
                System.out.println("Area: " + rectangulo.calcularArea());
                System.out.println("Perimetro: " + rectangulo.calcularPerimetro()+"\n");
                    break;
                case 5:
                    System.out.println("¡Bye niga!");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione de nuevo.");
            }
        } while (opcion != 5);
    }
}