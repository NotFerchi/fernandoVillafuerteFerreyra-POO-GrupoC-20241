
package com.mycompany.mavenproject1;

/**
 *
 * @author ferch
 */
public class Mavenproject1 {

public static void main(String[] args) {
   
    libro libro1 = new libro();
    
    System.out.println("Informacion del primer libro:");
    libro1.mostrarInformacion();
    
    libro libro2 = new libro();
    libro libro3 = new libro();
    libro libro4 = new libro();
    
    libro2.titulo = "Harry Potter";
    libro2.autor = "J. K. Rowling";
    libro2.anioPublicación = 1997;
    
    libro3.titulo = "El viejo y el mar";
    libro3.autor = "Ernest Hemingway";
    libro3.anioPublicación = 1951;
    
    libro4.titulo = "El libro vaquero";
    libro4.autor = "Rafael Márquez ";
    libro4.anioPublicación = 1978;
    
    
    System.out.println("\nInformacion de los libros modificados:");
    System.out.println("Segundo Libro:");
    libro2.mostrarInformacion();
    
    System.out.println("\nTercer Libro:");
    libro3.mostrarInformacion();
    
    System.out.println("\nCuarto Libro:");
    libro4.mostrarInformacion();

}
}
