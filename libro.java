
package com.mycompany.mavenproject1;

public class libro {
    
    String titulo = "Padre Rico, Padre Pobre";
    String autor = "Robert Kiyosaki";
    int anioPublicacion = 1997;
    int anioPublicación;
    
    public void mostrarInformacion() {
        System.out.println("Titulo: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Año de Publicacion: " + anioPublicacion);
    }
}