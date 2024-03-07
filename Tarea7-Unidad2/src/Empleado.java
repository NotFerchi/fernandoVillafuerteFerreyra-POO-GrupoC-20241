import java.util.*;
public class Empleado{
    private String nombre;
    private int edad;
    private double salario;
    private List<CuentaBanco> cuentas;

    public Empleado(String nombre, int edad, double salario, List<CuentaBanco> cuentas) {
        this.nombre = nombre;
        this.edad = edad;
        this.salario = salario;
        this.cuentas = cuentas;
    }

    public Empleado(String nombre, int edad, double salario, long cuentaNum) {
        this.nombre = nombre;
        this.edad = edad;
        this.salario = salario;
        this.cuentas = cuentas; //Se vincula a la lista cuentas
    }

    public Empleado(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if (edad >= 18 && edad <= 65) {
            this.edad = edad;
        } else {
            System.out.println("La persona es menor de edad");
        }
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        if (salario > 0) {
            this.salario = salario;
        } else {
            System.out.println("Cantidad de salario invalido");
        }
    }

    public List<CuentaBanco> getCuenta() { //Para obtener las cuentas de la lista :))
        return cuentas;
    }

    public List<CuentaBanco> getCuentas() {
        return cuentas;
    }


    public void setCuentas(List<CuentaBanco> cuentas) {
        this.cuentas = cuentas;
    }

    public String getData() {
        return String.format("Nombre: ", this.getNombre());
    }
}
