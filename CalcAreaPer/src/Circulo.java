class Circulo extends Shape {
  double radio;

  Circulo(double radio) {
    this.radio = radio;
  }

  @Override
  double calcularArea() {
    return Math.PI * Math.pow(radio, 2);
  }

  @Override
  double calcularPerimetro() {
    return 2 * Math.PI * radio;
  }
}