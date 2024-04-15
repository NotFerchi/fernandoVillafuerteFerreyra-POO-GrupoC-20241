import java.util.Date;
// Clase Belleza que extiende de Producto
class Belleza extends Producto {
    // Atributos y métodos específicos de Belleza
    private String esOrganico;

    // Constructor
    public Belleza(String nombre, double precio, String fechaImportacion, String numeroSerie, String esOrganico, int stock) {
        super(nombre, precio, fechaImportacion, numeroSerie, stock);
        this.esOrganico = esOrganico;
    }

    // Getter y Setter específicos
    public String getEsOrganico() {
        return esOrganico;
    }

    public void setEsOrganico(String esOrganico) {
        this.esOrganico = esOrganico;
    }

}