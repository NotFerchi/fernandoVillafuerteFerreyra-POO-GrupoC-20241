import java.util.*;
public class CuentaBanco {
    Scanner scanner = new Scanner (System.in);
    private long cuentaNum;
    private double monto;
    private char cuentaTipo;
    private double empleadoDineroTotal;
    private double getEmpleadoAgregarDinero;
    private double empleadoRetirarDinero;

    public CuentaBanco(long cuentaNum) {
        this.cuentaNum = cuentaNum;
    }

    public void addDinero() {


        do {
            switch (getCuentaTipo()) {
                case 'A':
                    do {
                        System.out.println("Cantidad que deseas ingresar (máximo $50,000): ");
                        getEmpleadoAgregarDinero = scanner.nextDouble();
                        if (getEmpleadoAgregarDinero > 50000) {
                            System.out.println("Tu tipo de cuenta A no te permite ingresar más de $50,000");
                        } else {
                            empleadoDineroTotal = empleadoDineroTotal + getEmpleadoAgregarDinero;
                            System.out.println("Se ha agregado: $" + getEmpleadoAgregarDinero);
                            setMonto(empleadoDineroTotal);
                            break;
                        }
                    } while (true);
                    break;


                case 'a':
                    do {
                        System.out.println("Cantidad que deseas ingresar (máximo $50,000): ");
                        getEmpleadoAgregarDinero = scanner.nextDouble();
                        if (getEmpleadoAgregarDinero > 50000) {
                            System.out.println("Tu tipo de cuenta A no te permite ingresar más de $50,000");
                        } else {
                            empleadoDineroTotal = empleadoDineroTotal + getEmpleadoAgregarDinero;
                            System.out.println("Se ha agregado: $" + getEmpleadoAgregarDinero);
                            setMonto(empleadoDineroTotal);
                            break;
                        }
                    } while (true);
                    break;


                case 'B':
                    do {
                        System.out.println("Cantidad que deseas ingresar (máximo $100,000): ");
                        getEmpleadoAgregarDinero = scanner.nextDouble();
                        if (getEmpleadoAgregarDinero > 100000) {
                            System.out.println("Tu tipo de cuenta B no te permite ingresar más de $100,000");
                        } else {
                            empleadoDineroTotal = empleadoDineroTotal + getEmpleadoAgregarDinero;
                            System.out.println("Se ha agregado: $" + getEmpleadoAgregarDinero);
                            setMonto(empleadoDineroTotal);
                            break;
                        }
                    } while (true);
                    break;


                case 'b':
                    do {
                        System.out.println("Cantidad que deseas ingresar (máximo $100,000): ");
                        getEmpleadoAgregarDinero = scanner.nextDouble();
                        if (getEmpleadoAgregarDinero > 100000) {
                            System.out.println("Tu tipo de cuenta B no te permite ingresar más de $100,000");
                        } else {
                            empleadoDineroTotal = empleadoDineroTotal + getEmpleadoAgregarDinero;
                            System.out.println("Se ha agregado: $" + getEmpleadoAgregarDinero);
                            setMonto(empleadoDineroTotal);
                            break;
                        }
                    } while (true);
                    break;

                case 'C':
                    System.out.println("Cantidad que deseas ingresar: ");
                    getEmpleadoAgregarDinero = scanner.nextDouble();

                    empleadoDineroTotal = empleadoDineroTotal + getEmpleadoAgregarDinero;
                    System.out.println("Se ha agregado: $" + getEmpleadoAgregarDinero);
                    setMonto(empleadoDineroTotal);
                    break;


                case 'c':
                    System.out.println("Cantidad que deseas ingresar: ");
                    getEmpleadoAgregarDinero = scanner.nextDouble();

                    empleadoDineroTotal = empleadoDineroTotal + getEmpleadoAgregarDinero;
                    System.out.println("Se ha agregado: $" + getEmpleadoAgregarDinero);
                    setMonto(empleadoDineroTotal);
                    break;


                default:
                    System.out.println("Cuenta inválida. Ingresa un tipo de cuenta válida (A, B o C)");

            }
        }while (getCuentaTipo() != 'A' && getCuentaTipo() != 'B' && getCuentaTipo() != 'C' && getCuentaTipo() != 'a' && getCuentaTipo() != 'b' && getCuentaTipo() != 'c');

    }

    public void retirarDinero() {

        do {
            switch (getCuentaTipo()) {
                case 'A':
                    do {
                        System.out.println("Cantidad que deseas retirar (mínimo en cuenta $1,000): ");
                        empleadoRetirarDinero = scanner.nextDouble();
                        if (empleadoDineroTotal < 1000) {
                            System.out.println("No tienes suficiente para retirar.");
                        } else {
                            empleadoDineroTotal = empleadoDineroTotal - empleadoRetirarDinero;
                            System.out.println("Se ha retirado: $" + empleadoRetirarDinero);
                            setMonto(empleadoDineroTotal);
                            break;
                        }
                    } while (true);
                    break;


                case 'a':
                    do {
                        System.out.println("Cantidad que deseas retirar (mínimo en cuenta $1,000): ");
                        empleadoRetirarDinero = scanner.nextDouble();
                        if (empleadoDineroTotal < 1000) {
                            System.out.println("No tienes suficiente para retirar.");
                        } else {
                            empleadoDineroTotal = empleadoDineroTotal - empleadoRetirarDinero;
                            System.out.println("Se ha retirado: $" + empleadoRetirarDinero);
                            setMonto(empleadoDineroTotal);
                            break;
                        }
                    } while (true);
                    break;


                case 'B':
                    do {
                        System.out.println("Cantidad que deseas retirar (mínimo en cuenta $5,000): ");
                        empleadoRetirarDinero = scanner.nextDouble();
                        if (empleadoDineroTotal < 1000) {
                            System.out.println("No tienes suficiente para retirar.");
                        } else {
                            empleadoDineroTotal = empleadoDineroTotal - empleadoRetirarDinero;
                            System.out.println("Se ha retirado: $" + empleadoRetirarDinero);
                            setMonto(empleadoRetirarDinero);
                            break;
                        }
                    } while (true);
                    break;


                case 'b':
                    do {
                        System.out.println("Cantidad que deseas retirar (mínimo en cuenta $5,000): ");
                        empleadoRetirarDinero = scanner.nextDouble();
                        if (empleadoDineroTotal < 1000) {
                            System.out.println("No tienes suficiente para retirar.");
                        } else {
                            empleadoDineroTotal = empleadoDineroTotal - empleadoRetirarDinero;
                            System.out.println("Se ha retirado: $" + empleadoRetirarDinero);
                            setMonto(empleadoDineroTotal);
                            break;
                        }
                    } while (true);
                    break;


                case 'C':
                    do {
                        System.out.println("Cantidad que deseas retirar (mínimo en cuenta $10,000): ");
                        empleadoRetirarDinero = scanner.nextDouble();
                        if (empleadoDineroTotal < 1000) {
                            System.out.println("No tienes suficiente para retirar.");
                        } else {
                            empleadoDineroTotal = empleadoDineroTotal - empleadoRetirarDinero;
                            System.out.println("Se ha retirado: $" + empleadoRetirarDinero);
                            setMonto(empleadoDineroTotal);
                            break;
                        }
                    } while (true);
                    break;


                case 'c':
                    do {
                        System.out.println("Cantidad que deseas retirar (mínimo en cuenta $10,000): ");
                        empleadoRetirarDinero = scanner.nextDouble();
                        if (empleadoDineroTotal < 1000) {
                            System.out.println("No tienes suficiente para retirar.");
                        } else {
                            empleadoDineroTotal = empleadoDineroTotal - empleadoRetirarDinero;
                            System.out.println("Se ha retirado: $" + empleadoRetirarDinero);
                            setMonto(empleadoDineroTotal);
                            break;
                        }
                    } while (true);
                    break;
            }
        }while (getCuentaTipo() != 'A' && getCuentaTipo() != 'B' && getCuentaTipo() != 'C' && getCuentaTipo() != 'a' && getCuentaTipo() != 'b' && getCuentaTipo() != 'c');
    }

    public char getCuentaTipo() {
        return cuentaTipo;
    }

    public void setCuentaTipo(char CuentaTipo) {
        this.cuentaTipo = CuentaTipo;
    }


    public long getCuentaNum() {
        return cuentaNum;
    }

    public void setCuentaNum(long cuentaNum) {
        this.cuentaNum = cuentaNum;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
}
