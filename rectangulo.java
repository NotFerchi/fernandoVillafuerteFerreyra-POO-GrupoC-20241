package com.mycompany.mavenproject3;

/**
 *
 * @author ferch
 */
public class rectangulo {
    double ancho;
    double altura;
    
    public rectangulo(double ancho, double altura) {
        this.ancho = ancho;
        this.altura = altura;
    }
    
    public double calcularArea() {
        return ancho * altura;
    }
    
    public double calcularPerimetro() {
        return 2 * (ancho + altura);
    }
}