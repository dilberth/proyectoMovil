package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils;

public enum TransaccionesPrestamos {


    PAGO_DE_PRESTRAMO("Pago de préstamo"),
    PAGAR_EXTRA_FINANCIAMIENTO("Pagar extra- financimiento"),
    MOVIMIENTOS("Movimientos");

    private String transaccion;

    TransaccionesPrestamos(String transaccion) {
        this.transaccion = transaccion;
    }

    public String tomarTransaccion() {
        return transaccion;
    }

    @Override
    public String toString() {
        return transaccion;
    }
}
