import java.util.Date;

// Clase Limpieza que extiende de Producto
class Limpieza extends Producto {
    // Atributos y métodos específicos de Limpieza
    private String tipo;//jabon, cloro, desinfecttante etc

    // Constructor
    public Limpieza(String nombre, double precio, String fechaImportacion, String numeroSerie, String tipo, int stock) {
        super(nombre, precio, fechaImportacion, numeroSerie, stock);
        this.tipo = tipo;
    }

    // Getter y Setter específico
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    // Método específico para Limpieza

}