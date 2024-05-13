package usuarios.utils;

import java.time.LocalDateTime;

public class Inversion {
    private String nombreInversionista;
    private double cantidad;
    private LocalDateTime fecha;

    public Inversion(String nombreInversionista, double cantidad) {
        this.nombreInversionista = nombreInversionista;
        this.cantidad = cantidad;
        this.fecha = LocalDateTime.now();
    }

    public String getNombreInversionista() {
        return nombreInversionista;
    }

    public double getCantidad() {
        return cantidad;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    @Override
    public String toString() {
        return String.format("\nCantidad invertida: %.4f \nFecha: %s",cantidad, fecha);
    }
}
