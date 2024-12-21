package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public enum Variables {

    SALDO_CTAORGINI,
    SALDO_CTADESINI,
    CA_ALIAS1,
    CA_TIPO_CUENTA1,
    CA_SALDO1,
    CA_NUMERO_CUENTA,
    CA_NUMERO_CUENTA1,
    CA_NUMERO_CUENTAP2,
    AP_ALIAS1,
    AP_META1,
    AP_AHORRO_ACUMULADO1,
    AP_NUMERO_CUENTA1,
    AP_TIPO_CUENTA2,
    AP_FECHA_VENCIMIENTO2,
    PBA_PUNTOS_ACUMULADOS,
    SALDO_TARJETACREDITO,
    AHORRO_ACUMULADO_ANTES,
    AHORRO_ACUMULADO_DESPUES,
    DAP_FECHA_VENCIMIENTO2,
    DAP_NUMERO_CUENTA2,
    DAP_SALDO_PRINCIPAL,
    EF_DEUDA_TOTAL,
    EF_FECHA_PAGO,
    EF_NUMERO_CUENTA2,
    EF_DEUDA_TOTAL2,
    FI_TIPO_FONDO,
    FI_NUMERO_CUENTA,
    FI_MONTO_MAX_RETIRO,
    FI_SALDO,
    PBA_ALIAS,
    PBA_TIPO,
    PBA_SALDO_EN_DOLARES,
    TDC_ALIAS,
    TDC_PRODUCTO,
    TDC_SALDO_DISPONIBLE,
    TDC_TIPO,
    TDC_NUMERO,
    TDC_FECHA_PAGO,
    TDC_SALDO_A_PAGAR,
    TDC_NUMERO2,
    META_APORTE,
    META_ALIAS,
    META_META,
    META_MONTO_ACUM,
    META_CUOTA,
    META_PLAZO,
    META_CUENTA,
    SALDO_RETENIDO,
    TARJETAS_SELECCIONADAS,
    LIMITE_TRX,
    LIMITE_CAN,
    NUEVO_ALIAS,
    SALDOEN,
    SALDO_ORIGEN_ANTES,
    SALDO_DESTINO_ANTES,
    SALDO_ORIGEN_DESPUES,
    SALDO_DESTINO_DESPUES,
    SALDO_PUNTOS_ANTES,
    SALDO_PUNTOS_DESPUES,
    NUM_CUEN3;


    public void guardarValor(Object valorGuardado) {
        theActorInTheSpotlight().remember(this.name(), valorGuardado);
    }

    public Object obtenerValorGuardado() {
        return theActorInTheSpotlight().recall(this.name());
    }

}
