package tarjetas.utils;

public enum TipoTarjetaCredito {
    SIMPLICITY(0, 60000),
    PLATINUM(60001, 150000),
    GOLD(150001, 400000);

    private final double saldoMaximo;
    private final double saldoMinimo;

    TipoTarjetaCredito(double saldoMaximo, double saldoMinimo) {
        this.saldoMaximo = saldoMaximo;
        this.saldoMinimo = saldoMinimo;
    }
    public Double getSaldoMaximo() {
        return saldoMaximo;
    }
    public Double getSaldoMinimo() {
        return saldoMinimo;
    }

    public enum tipoTarjetas{
        CREDITO,
        DEBITO;
    }
}
