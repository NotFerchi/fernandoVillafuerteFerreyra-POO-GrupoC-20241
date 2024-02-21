
package com.mycompany.mavenproject2;

/**
 *
 * @author ferch
 */
public class Mavenproject2 {

    public static void main(String[] args) {
        
        Persona primeraPersona = new Persona("Anastasio", 35, "Masculino");
        Persona segundaPersona = new Persona("Ariadna", 17, "Femenino");
        Persona terceraPersona = new Persona("Vanessa", 12, "Femenino");
        
        System.out.println("Primera Persona---");
        System.out.println("Nombre: " + primeraPersona.getNombre());
        System.out.println("Edad: " + primeraPersona.getEdad());
        System.out.println("Genero: " + primeraPersona.getGenero());
        
        System.out.println("\nSegunda Persona---");
        System.out.println("Nombre: " + segundaPersona.getNombre());
        System.out.println("Edad: " + segundaPersona.getEdad());
        System.out.println("Genero: " + segundaPersona.getGenero());
        
        System.out.println("\nTerceera Persona---");
        System.out.println("Nombre: " + terceraPersona.getNombre());
        System.out.println("Edad: " + terceraPersona.getEdad());
        System.out.println("Genero: " + terceraPersona.getGenero());
    }
}
