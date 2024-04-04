import java.text.SimpleDateFormat;
import java.util.*;

class Mantenimiento {
    private Empleado empleadoEncargado;
    private String idAnimal;
    private String procesoRealizado;
    private String fechaProceso;
    private String observaciones;

    public Mantenimiento(Empleado empleadoEncargado, String idAnimal, String procesoRealizado, String observaciones) {
        this.empleadoEncargado = empleadoEncargado;
        this.idAnimal = idAnimal;
        this.procesoRealizado = procesoRealizado;
        this.observaciones = observaciones;
        this.fechaProceso = obtenerFechaActual();
    }

    public Mantenimiento(String empleadoEncargado, String idAnimal, String procesoRealizado, String fechaMantenimiento) {
    }

    public Mantenimiento(String idAnimal, Empleado empleado, String procesoRealizado, String fechaMantenimiento, String observaciones) {
    }

    public Mantenimiento(String idAnimal, String empleadoEncargado, String procesoRealizado, String fechaMantenimiento, String observaciones) {
    }

    private String obtenerFechaActual() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        return formatter.format(date);
    }

    // Getters y Setters

    public Empleado getEmpleadoEncargado() {
        return empleadoEncargado;
    }

    public void setEmpleadoEncargado(Empleado empleadoEncargado) {
        this.empleadoEncargado = empleadoEncargado;
    }

    public String getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(String idAnimal) {
        this.idAnimal = idAnimal;
    }

    public String getProcesoRealizado() {
        return procesoRealizado;
    }

    public void setProcesoRealizado(String procesoRealizado) {
        this.procesoRealizado = procesoRealizado;
    }

    public String getFechaProceso() {
        return fechaProceso;
    }

    public void setFechaProceso(String fechaProceso) {
        this.fechaProceso = fechaProceso;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}