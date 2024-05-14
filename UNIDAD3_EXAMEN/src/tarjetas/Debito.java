package tarjetas;
import banco.Banco;
import tarjetas.utils.TipoTarjetaCredito;

import java.time.LocalDate;
import java.util.Scanner;

public class Debito extends Tarjeta {

    Debito(String numeroDeCuenta,  int CVV, String clabeInterbancaria, Double saldo, LocalDate fechaDeVencimiento, LocalDate fechaDeCreacion) {
        super(numeroDeCuenta, CVV, clabeInterbancaria, saldo, fechaDeVencimiento, fechaDeCreacion);
    }

    public static Debito crearTarjeta(){
        String numeroTarjeta = Tarjeta.GenerarNumeroCuenta();
        LocalDate fechaCreacion = LocalDate.now();
        int CVV = generarCVV();
        String clabe = Tarjeta.GenerarClabe();
        LocalDate fechaVencimiento = generarFechaDeVencimiento(fechaCreacion);
        Scanner leer = new Scanner(System.in);
        System.out.println("Su número de tarjeta es: " + numeroTarjeta);
        System.out.println("Fecha de creacion: " + fechaCreacion);
        System.out.println("CVV: " + CVV);
        System.out.println("Clave interbancaria: " + clabe);
        System.out.println("Saldo inicial de la cuenta: ");
        double saldo = leer.nextDouble();
        System.out.println("Su tarjeta vence: " + fechaVencimiento);
        Debito newTarjeta = new Debito(numeroTarjeta,CVV, clabe,saldo, fechaVencimiento,fechaCreacion);
        Banco.listaTarjetas.add(newTarjeta);
        return newTarjeta;
    }

    public String toString(){
        return String.format("El numero de tarjeta crédito es: %s, \nSu CVV: %d, " +
                "\nSu clabe interbancaria: %s " +
                "\nSu fecha de vencimiento: %s \nSu saldo actual es: %.2f \nSu fecha de creacion es: %s ", getNumeroDeCuenta(), getCVV(), getClabeInterbancaria(), getFechaDeVencimiento().toString(), getSaldo(), this.fechaDeCreacion);
    }
    public static void abonarDebito() {
        Scanner leer = new Scanner(System.in);
        System.out.println("Realizar abono.");
        System.out.println("Ingresar el número de tarjeta: ");
        String numeroTarjeta = leer.nextLine();

        Tarjeta tarjetaEncontrada = null;

        // Buscar la tarjeta con el número especificado
        for (Tarjeta buscarTarjeta : Banco.listaTarjetas) {
            if (buscarTarjeta.getNumeroDeCuenta().equals(numeroTarjeta)) {
                tarjetaEncontrada = buscarTarjeta;
                break;  // Detener la búsqueda una vez que se encuentre la tarjeta
            }
        }

        // Verificar si se encontró la tarjeta
        if (tarjetaEncontrada != null) {
            System.out.println("Ingrese el monto a abonar: ");
            double abono = leer.nextDouble();
            System.out.println("Abono ingresado: " + abono);

            double saldoAnterior = tarjetaEncontrada.getSaldo();
            double nuevoSaldo = saldoAnterior + abono;
            tarjetaEncontrada.setSaldo(nuevoSaldo);

            System.out.println("Abono realizado con éxito. Nuevo saldo: " + nuevoSaldo);
        } else {
            System.out.println("No se encontró ninguna tarjeta con el número ingresado: " + numeroTarjeta);
        }
    }
}