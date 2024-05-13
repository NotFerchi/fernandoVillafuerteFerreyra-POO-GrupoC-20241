package tarjetas;
import tarjetas.utils.TipoTarjetaCredito;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import banco.Banco;

public abstract class Tarjeta {
    private String numeroDeCuenta;
    LocalDateTime fechaYHoraUltimoMovimiento;
    int CVV;
    String clabeInterbancaria;
    Double saldo;
    LocalDate fechaDeVencimiento;
    LocalDate fechaDeCreacion;
    TipoTarjetaCredito type;

    private static ArrayList<String> cuentasAsignadas = new ArrayList<>();


    Tarjeta(String numeroDeCuenta,  int CVV, String clabeInterbancaria, Double saldo, LocalDate fechaDeVencimiento, LocalDate fechaDeCreacion) {
        this.numeroDeCuenta = numeroDeCuenta;
        this.fechaYHoraUltimoMovimiento = LocalDateTime.now();
        this.CVV = CVV;
        this.clabeInterbancaria = clabeInterbancaria;
        this.saldo = saldo;
        this.fechaDeVencimiento = fechaDeVencimiento;
        this.fechaDeCreacion = fechaDeCreacion;
    }

    public Tarjeta(String numeroTarjeta, LocalDate fechaCreacion, int cvv, String clabeInterbancaria, double saldo, LocalDate fechaVencimiento, TipoTarjetaCredito type) {
        this.numeroDeCuenta = numeroDeCuenta;
        this.CVV = CVV;
        this.type = type;
        this.clabeInterbancaria = clabeInterbancaria;
        this.saldo = saldo;
        this.fechaDeVencimiento = fechaDeVencimiento;
        this.fechaDeCreacion = fechaDeCreacion;
    }

    protected static String GenerarNumeroCuenta() {
        int longitud = 16;
        StringBuilder numeroCuenta = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < longitud; i++) {
            numeroCuenta.append(random.nextInt(10));
        }
        cuentasAsignadas.add(numeroCuenta.toString());
        return numeroCuenta.toString();

    }

    protected static String GenerarClabe() {
        int longitud = 10;
        StringBuilder numeroCuenta = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < longitud; i++) {
            numeroCuenta.append(random.nextInt(10));
        }
        cuentasAsignadas.add(numeroCuenta.toString());
        return numeroCuenta.toString();
    }


    protected static int generarCVV() {
        Set<Integer> listaCVV = new HashSet<Integer>();
        Random alea = new Random();
        while (true) {
            int CVV = alea.nextInt(999) + 1;
            if (CVV < 1000 && !listaCVV.contains(CVV)) {
                listaCVV.add(CVV);
                return CVV;
            }
        }
    }

    protected static LocalDate generarFechaDeVencimiento(LocalDate fechaDeCreacion) {
        DateTimeFormatter fechaInicial = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String registroAño = fechaInicial.format(fechaDeCreacion).substring(6, 10);
        int añoRegistro = Integer.valueOf(registroAño);
        String registroDia = fechaInicial.format(fechaDeCreacion).substring(0, 2);
        int diaRegistro = Integer.valueOf(registroDia);
        String registroMes = fechaInicial.format(fechaDeCreacion).substring(3, 5);
        int mesRegistro = Integer.valueOf(registroMes);
        int añoVencimiento = añoRegistro + 5;
        LocalDate fechaDeVencimiento = LocalDate.of(añoVencimiento, mesRegistro, diaRegistro);
        return fechaDeVencimiento;
    }

    public static void abonar() {
        Scanner leer = new Scanner(System.in);
        System.out.println("\n----- A B O N O  D E  T A R J E T A -----");
        System.out.println("Ingresar el número de su tarjeta: ");
        String numeroTarjeta = leer.nextLine();

        boolean tarjetaEncontrada = false;

        for (Tarjeta buscarTarjeta : Banco.listaTarjetas) {
            if (buscarTarjeta.getNumeroDeCuenta().equals(numeroTarjeta)) {
                tarjetaEncontrada = true;

                System.out.println("Cantidad a abonar: ");
                double abono = leer.nextDouble();
                leer.nextLine(); // Consumir la nueva línea después de leer el número

                double saldoMinimo = buscarTarjeta.getType().getSaldoMaximo();
                System.out.println("Saldo mínimo: " + saldoMinimo);
                System.out.println("Cantidad abonada ingresada: " + abono);

                if (abono > 0 && abono + buscarTarjeta.getSaldo() > saldoMinimo) {
                    double nuevoSaldo = buscarTarjeta.getSaldo() + abono;
                    buscarTarjeta.setSaldo(nuevoSaldo);
                    System.out.println("Abono realizado. Nuevo saldo: " + nuevoSaldo);
                } else {
                    System.out.println("La cantidad abonada es negativa o excede el límite. Intente de nuevo.");
                }

                break; // Salir del bucle una vez que se ha encontrado la tarjeta
            }
        }

        if (!tarjetaEncontrada) {
            System.out.println("No se encontró la tarjeta con el número ingresado.");
        }
    }



    public String getNumeroDeCuenta() {
        return numeroDeCuenta != null ? numeroDeCuenta : "";
    }


    public void setNumeroDeCuenta(String numeroDeCuenta) {
        this.numeroDeCuenta = numeroDeCuenta;
    }

    public int getCVV() {
        return CVV;
    }

    public void setCVV(int CVV) {
        this.CVV = CVV;
    }

    public String getClabeInterbancaria() {
        return clabeInterbancaria;
    }

    public void setClabeInterbancaria(String clabeInterbancaria) {
        this.clabeInterbancaria = clabeInterbancaria;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
    public LocalDate getFechaDeVencimiento() {
        return fechaDeVencimiento;
    }

    public TipoTarjetaCredito getType() {
        return type;
    }
}
