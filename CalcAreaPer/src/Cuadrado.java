class Cuadrado extends Shape {
  double lado;

  Cuadrado(double lado) {
    this.lado = lado;
  }

  @Override
  double calcularArea() {
    return lado * lado;
  }

  @Override
  double calcularPerimetro() {
    return 4 * lado;
  }
}