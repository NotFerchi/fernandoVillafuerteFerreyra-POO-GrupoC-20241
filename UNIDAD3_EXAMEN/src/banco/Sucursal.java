package banco;

import usuarios.Inversionista;
import usuarios.utils.Inversion;

import java.util.ArrayList;
import java.util.List;

public enum Sucursal {
    MADERO,
    ACUEDUCTO;

    private double fondos;
    private List<Inversion> inversiones;

    private Sucursal() {
        this.fondos = 0.0;
        this.inversiones = new ArrayList<>();
    }

    public void realizarInversion(double cantidad, String nombreInversionista, Inversionista inversionista) {
        this.fondos += cantidad;
        Inversion inversion = new Inversion(nombreInversionista, cantidad);
        this.inversiones.add(inversion);

    }

    public double obtenerFondos() {
        return this.fondos;
    }

    public List<Inversion> getInversiones() {
        return inversiones;
    }
}
