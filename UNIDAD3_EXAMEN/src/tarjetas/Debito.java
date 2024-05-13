package tarjetas;

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
        System.out.println("Creacion de la tarjeta: " + fechaCreacion);
        System.out.println("CVV es: " + CVV);
        System.out.println("Clave interbancaria: " + clabe);
        System.out.println("Saldo inicial de la cuenta: ");
        double saldo = leer.nextDouble();
        System.out.println("Fecha de caducacion: " + fechaVencimiento);
        Debito newTarjeta = new Debito(numeroTarjeta,CVV, clabe,saldo, fechaVencimiento,fechaCreacion);

        return newTarjeta;
    }

    public String toString(){
        return String.format("El numero de tarjeta crédito es: %s, \nSu CVV: %d, " +
                "\nSu clabe interbancaria: %s " +
                "\nSu fecha de vencimiento: %s \nSu saldo actual es: %.2f \nSu fecha de creacion es: %s ", getNumeroDeCuenta(), getCVV(), getClabeInterbancaria(), getFechaDeVencimiento().toString(), getSaldo(), this.fechaDeCreacion);
    }
}