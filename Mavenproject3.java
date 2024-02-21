package com.mycompany.mavenproject3;
/**
 *
 * @author ferch
 */
public class Mavenproject3 {

    public static void main(String[] args) {
        rectangulo rectangulo = new rectangulo(3.0, 7.0);
        System.out.println("DATOS---");
        System.out.println("Area: " + rectangulo.calcularArea());
        
        System.out.println("Perimetro: " + rectangulo.calcularPerimetro());
    }
}
