import java.util.*;
class Visita {
    private static int counter = 1;
    private String id;
    private String guia;
    private List<Visitante> visitantes;
    private double costoTotal;
    private String fechaVisita;
    private int cantidadNinos;
    private int cantidadAdultos;

    public Visita(String guia, List<Visitante> visitantes, double costoTotal, String fechaVisita, int cantidadNinos, int cantidadAdultos) {
        this.id = "VIS" + counter++;
        this.guia = guia;
        this.visitantes = visitantes;
        this.costoTotal = costoTotal;
        this.fechaVisita = fechaVisita;
        this.cantidadNinos = cantidadNinos;
        this.cantidadAdultos = cantidadAdultos;
    }

    public String getId() {
        return id;
    }

    public String getGuia() {
        return guia;
    }

    public void setGuia(String guia) {
        this.guia = guia;
    }

    public List<Visitante> getVisitantes() {
        return visitantes;
    }

    public void setVisitantes(List<Visitante> visitantes) {
        this.visitantes = visitantes;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }

    public String getFechaVisita() {
        return fechaVisita;
    }

    public void setFechaVisita(String fechaVisita) {
        this.fechaVisita = fechaVisita;
    }

    public int getCantidadNinos() {
        return cantidadNinos;
    }

    public void setCantidadNinos(int cantidadNinos) {
        this.cantidadNinos = cantidadNinos;
    }

    public int getCantidadAdultos() {
        return cantidadAdultos;
    }

    public void setCantidadAdultos(int cantidadAdultos) {
        this.cantidadAdultos = cantidadAdultos;
    }
    public String toString() {
        return "Visita" +
                "Id: '" + id + '\'' +
                ", Guia: '" + guia + '\'' +
                ", Visitantes: " + visitantes +
                ", Costo Total: " + costoTotal +
                ", Fecha Visita. '" + fechaVisita + '\'' +
                ", antidad Ninos: " + cantidadNinos +
                ", Cantidad Adultos: " + cantidadAdultos;
    }
}