package tarjetas;

import banco.Banco;
import tarjetas.utils.TipoTarjetaCredito;
import usuarios.Usuario;

import java.time.LocalDate;
import java.util.Scanner;

public class Credito extends Tarjeta
{
    private double creditoMaximo;
    private double creditoMinimo;

    public Credito(String numeroDeCuenta, int CVV, String clabeInterbancaria, Double saldo,
                   LocalDate fechaDeVencimiento, LocalDate fechaDeCreacion, TipoTarjetaCredito type) {
        super(numeroDeCuenta, CVV, clabeInterbancaria, saldo, fechaDeVencimiento, fechaDeCreacion);
        this.type = type;
        this.creditoMaximo = creditoMaximo;
        this.creditoMinimo = creditoMinimo;
    }

    public static Credito crearTarjetaCredito(TipoTarjetaCredito tipoTarjeta, Usuario usuario) {
        String numeroTarjeta = Tarjeta.GenerarNumeroCuenta();
        LocalDate fechaCreacion = LocalDate.now();
        int CVV = generarCVV();
        String clabe = Tarjeta.GenerarClabe();
        LocalDate fechaVencimiento = generarFechaDeVencimiento(fechaCreacion);
        Scanner leer = new Scanner(System.in);
        System.out.println("Su número de tarjeta es: " + numeroTarjeta);
        System.out.println("Fecha de Creación: " + fechaCreacion);
        System.out.println("CVV: " + CVV);
        System.out.println("Clave interbancaria: " + clabe);
        System.out.println("Fecha de vencimiento: " + fechaVencimiento);
        System.out.println("Tipo de tarjeta: " + tipoTarjeta);
        double saldo = tipoTarjeta.getSaldoMinimo();
        System.out.println("Su saldo es de: " + saldo);
        Credito newTarjeta = new Credito(numeroTarjeta, CVV, clabe, saldo, fechaVencimiento, fechaCreacion, tipoTarjeta);
        Banco.listaTarjetas.add(newTarjeta);
        return newTarjeta;
    }


    public TipoTarjetaCredito getType() {
        return type;
    }

    @Override
    public String toString(){
        return String.format("El numero de tarjeta crédito es: %s \nSu CVV: %d" +
                "\nSu clabe interbancaria: %s" +
                "\nsu fecha de vencimiento: %s \nSu saldo actual es: %.2f", getNumeroDeCuenta(), getCVV(), getClabeInterbancaria(), getFechaDeVencimiento().toString(), getSaldo());
    }
}

