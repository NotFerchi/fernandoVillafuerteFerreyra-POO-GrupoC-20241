import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

// Clase Cliente
class Cliente {
    private String nombre;
    private String telefono;
    private List<Producto> productosComprados;

    // Constructor
    public Cliente(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.productosComprados = new ArrayList<>();
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Producto> getProductosComprados() {
        return productosComprados;
    }

    // Método para realizar una compra
    public void comprar(Producto producto) {
        productosComprados.add(producto);
        System.out.println(nombre + " ha comprado: " + producto.getNombre());
    }
}