import java.util.Date;
class Alimento extends Producto {
    // Atributos y métodos específicos de Alimento
    private String fechaCaducidad;
    private int calorias;

    // Constructor
    public Alimento(String nombre, double precio, String fechaImportacion, String numeroSerie, String fechaCaducidadint, int calorias, int stock) {
        super(nombre, precio, fechaImportacion, numeroSerie, stock);
        this.fechaCaducidad = fechaCaducidad;
        this.calorias = calorias;
    }

    // Getter y Setter específicos
    public String getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(String fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public int getCalorias() {
        return calorias;
    }

    public void setCalorias(int calorias) {
        this.calorias = calorias;
    }
    /* Método específico para Alimento
    public void informacionNutricional() {
        // Implementación para mostrar información nutricional del alimento
        System.out.println("Información nutricional de " + getNombre() + ": " + getCalorias() + " calorías");
    }*/
}