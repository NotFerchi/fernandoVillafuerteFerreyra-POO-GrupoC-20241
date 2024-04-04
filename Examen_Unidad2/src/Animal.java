import java.util.*;

class Animal {
    private String id;
    private String tipoAnimal;
    private String fechaNacimiento;
    private String fechaLlegada;
    private double peso;
    private List<String> enfermedades;
    private String frecuenciaAlimentacion;
    private String tipoAlimentacion;
    private boolean vacunas;

    public Animal(String tipoAnimal, String fechaNacimiento, String fechaLlegada, String llegada, double peso, List<String> enfermedades,
                  String frecuenciaAlimentacion, String tipoAlimentacion, boolean vacunas) {
        this.id = generarIdAleatorio();
        this.tipoAnimal = tipoAnimal;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaLlegada = fechaLlegada;
        this.peso = peso;
        this.enfermedades = enfermedades;
        this.frecuenciaAlimentacion = frecuenciaAlimentacion;
        this.tipoAlimentacion = tipoAlimentacion;
        this.vacunas = vacunas;
    }

    private String generarIdAleatorio() {
        Random random = new Random();
        int num = random.nextInt(1000) + 1;
        return "A" + num;
    }

    public String getId() {
        return id;
    }

    public String getTipoAnimal() {
        return tipoAnimal;
    }

    public void setTipoAnimal(String tipoAnimal) {
        this.tipoAnimal = tipoAnimal;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(String fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public List<String> getEnfermedades() {
        return enfermedades;
    }

    public void setEnfermedades(List<String> enfermedades) {
        this.enfermedades = enfermedades;
    }

    public String getFrecuenciaAlimentacion() {
        return frecuenciaAlimentacion;
    }

    public void setFrecuenciaAlimentacion(String frecuenciaAlimentacion) {
        this.frecuenciaAlimentacion = frecuenciaAlimentacion;
    }

    public String getTipoAlimentacion() {
        return tipoAlimentacion;
    }

    public void setTipoAlimentacion(String tipoAlimentacion) {
        this.tipoAlimentacion = tipoAlimentacion;
    }

    public boolean isVacunas() {
        return vacunas;
    }

    public void setVacunas(boolean vacunas) {
        this.vacunas = vacunas;
    }

    @Override
    public String toString() {
        return "Animal" +
                "Id: '" + id + '\'' +
                ", Tipo Animal: '" + tipoAnimal + '\'' +
                ", Fecha Nacimiento: '" + fechaNacimiento + '\'' +
                ", Fecha Llegada: '" + fechaLlegada + '\'' +
                ", Peso: " + peso +
                ", Enfermedades: " + enfermedades +
                ", Frecuencia Alimentacion: ' " + frecuenciaAlimentacion + '\'' +
                ", Tipo Alimentacion:'" + tipoAlimentacion + '\'' +
                ", Vacunas:" + vacunas;
    }
}