import java.util.Date;

// Clase Producto que servirá como clase base para los diferentes tipos de productos
class Producto {
    private String nombre;
    private double precio;
    private String fechaImportacion;
    private String numeroSerie;
    private int stock;

    // Constructor
    public Producto(String nombre, double precio, String fechaImportacion, String numeroSerie, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.fechaImportacion = fechaImportacion;
        this.numeroSerie = numeroSerie;
        this.stock = stock;
    }

    // Getters y Setters
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

    public String getFechaImportacion() {
        return fechaImportacion;
    }

    public void setFechaImportacion(String fechaImportacion) {
        this.fechaImportacion = fechaImportacion;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    // Método para agregar al stock
    public void agregarStock(int cantidad) {
        if (cantidad > 0) {
            this.stock += cantidad;
            System.out.println(cantidad + " " + this.nombre + " agregadas al stock.");
        } else {
            System.out.println("La cantidad debe ser mayor que cero.");
        }
    }

    // Método para eliminar del stock
    public void eliminarStock(int cantidad) {
        if (cantidad > 0 && cantidad <= this.stock) {
            this.stock -= cantidad;
            System.out.println(cantidad + " " + this.nombre + " eliminadas del stock.");
        } else {
            System.out.println("La cantidad no es válida.");
        }
    }

}