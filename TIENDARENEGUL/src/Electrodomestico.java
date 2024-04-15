import java.util.Date;

class Electrodomestico extends Producto {
    // Atributos y métodos específicos de Electrodomestico
    private String marca;
    private String tieneGarantia;

    // Constructor
    public Electrodomestico(String nombre, double precio, String fechaImportacion, String numeroSerie, String marca, String tieneGarantia, int stock) {
        super(nombre, precio, fechaImportacion, numeroSerie, stock);
        this.marca = marca;
        this.tieneGarantia = tieneGarantia;
    }

    // Getters y Setters
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String isTieneGarantia() {
        return tieneGarantia;
    }

    public void setTieneGarantia(String tieneGarantia) {
        this.tieneGarantia = tieneGarantia;
    }

    // Método específico para Electrodomestico
    public void realizarMantenimiento() {
        // Implementación para realizar mantenimiento
        System.out.println("Se realizó el mantenimiento del electrodoméstico: " + getNombre());
    }
}
