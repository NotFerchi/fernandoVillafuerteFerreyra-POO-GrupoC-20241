
package com.mycompany.mavenproject2;

/**
 *
 * @author ferch
 */
public class Persona {
    String nombre;
    int edad;
    String genero;
    
    public Persona(String nombre, int edad, String genero) {
        this.nombre = nombre;
        this.edad = edad;
        this.genero = genero;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public int getEdad() {
        return edad;
    }
    
    public String getGenero() {
        return genero;
    }
}
