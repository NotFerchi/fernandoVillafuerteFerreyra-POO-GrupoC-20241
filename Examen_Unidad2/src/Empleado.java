public class Empleado {
    private String nombre;
    private String apellidos;
    private String fechaNacimiento;
    private String curp;
    private String cargo;
    private double salario;

    public Empleado(String nombre, String apellidos, String fechaNacimiento, String curp,
                    String cargo, double salario) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.curp = curp;
        this.cargo = cargo;
        this.salario = salario;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String toString() {
        return "Empleado" +
                "Nombre: '" + nombre + '\'' +
                ", Apellidos: '" + apellidos + '\'' +
                ", Fecha Nacimiento: '" + fechaNacimiento + '\'' +
                ", Curp: " + curp + '\'' +
                ", Cargo: '" + cargo + '\'' +
                ", Salario: " + salario;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
}
