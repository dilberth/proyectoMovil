package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils;

public enum TransaccionesTarjetas {

    TRANSFERENCIA_QR("Transferencia QR"),
    MAS_DETALLE("Más detalle"),
    PAGO_DE_TARJETA("Pago de tarjeta"),
    PAGO_DE_SERVICIOS("Pago de servicios"),
    MOVIMIENTOS("Movimientos"),
    OPCION_CONSULTA_CVV2("Consulta CVV2 y fecha de expiración");

    private String transaccion;

    TransaccionesTarjetas(String transaccion) {
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
