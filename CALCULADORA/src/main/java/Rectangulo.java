public class Rectangulo implements Shape {
  double largo;
  double ancho;

  Rectangulo(double largo, double ancho) {
    this.largo = largo;
    this.ancho = ancho;
  }

  @Override
  public double calcularArea() {
    return largo * ancho;
  }

  @Override
  public double calcularPerimetro() {
    return (largo + ancho) * 2;
  }
}