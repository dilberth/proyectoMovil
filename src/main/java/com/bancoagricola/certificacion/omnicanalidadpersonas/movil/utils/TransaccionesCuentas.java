package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils;

public enum TransaccionesCuentas {

    RETIRO_SIN_TARJETA("Retiro sin tarjeta"),
    RECARGA_DE_CELULAR("Recarga de celular"),
    TRANSFERENCIA_QR("Transferencia QR"),
    MAS_DETALLE("Más detalle"),
    TRANSFERIR("Transferir"),
    SOLICTUD_DE_CHEQUERAS("Solicitud de chequeras"),
    PAGO_PRESTAMO_TRANSFER365("Pago de préstamo Transfer365: Operaciones entre bancos"),
    PAGO_TARJETA_TRANSFER365("Pago de tarjeta Transfer365: Operaciones entre bancos"),
    PAGO_DE_PRESTRAMO("Pago de préstamo"),
    PAGO_PRESTAMO_UNI("Pago de Préstamo UNI: Operaciones entre bancos"),
    PAGO_TARJETA_UNI("Pago de tarjeta UNI: Operaciones entre bancos"),
    PAGO_DE_SERVICIOS("Pago de servicios"),
    PAGO_DE_TARJETA("Pago de tarjeta"),
    TRANSFERENCIAS_UNI("Transferencias UNI: Operaciones entre bancos"),
    TRANSFER365_MOVIL("Transfer365 Móvil"),
    MOVIMIENTOS("Movimientos"),
    COBRO_PAGO_AMIGO("Cobro/Pago a un amigo")
    ;

    private String transaccion;

    TransaccionesCuentas(String transaccion) {
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
