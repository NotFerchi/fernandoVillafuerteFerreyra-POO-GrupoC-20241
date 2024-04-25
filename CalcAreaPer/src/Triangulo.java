class Triangulo extends Shape {
    double lado1;
    double lado2;
    double lado3;

    Triangulo(double lado1, double lado2, double lado3) {
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
    }

    @Override
    double calcularArea() {
        double s = (lado1 + lado2 + lado3) / 2;
        return Math.sqrt(s * (s - lado1) * (s - lado2) * (s - lado3));
    }

    @Override
    double calcularPerimetro() {
        return (lado1 + lado2 + lado3);
    }
}