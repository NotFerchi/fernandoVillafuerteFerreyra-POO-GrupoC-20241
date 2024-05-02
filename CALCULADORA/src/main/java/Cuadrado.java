public class Cuadrado implements Shape {
  double lado;

  Cuadrado(double lado) {
    this.lado = lado;
  }

  @Override
  public double calcularArea() {
    return lado * lado;
  }

  @Override
  public double calcularPerimetro() {
    return 4 * lado;
  }
}