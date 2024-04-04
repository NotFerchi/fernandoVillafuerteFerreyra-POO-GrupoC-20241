public class Visitante {
    private static int counter = 1;
    private String id;
    private String nombre;
    private String apellidos;
    private String fechaNacimiento;
    private String curp;

    public Visitante(String nombre, String apellidos, String fechaNacimiento, String curp) {
        this.id = "V" + counter++;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.curp = curp;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    @Override
    public String toString() {
        return "Visitante" +
                "Id:'" + id + '\'' +
                ", Nombre:'" + nombre + '\'' +
                ", Apellidos:'" + apellidos + '\'' +
                ", Fecha Nacimiento:'" + fechaNacimiento + '\'' +
                ", Curp:'" + curp + '\'';
    }
}