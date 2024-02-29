public class Producto {

    private String nombre;
    private double precio;
    private int stock;

    public Producto (String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }
    public Producto (String nombre, double precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }
    public void incrementarStock(int cantidad) {
        if (cantidad > 0) {
            stock = stock + cantidad;
        }
    }
    public void reducirStock(int cantidad) {
        if (cantidad > 0 && cantidad <= stock) {
            stock = stock - cantidad;
        }
    }


    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
}
