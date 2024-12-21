package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.*;

public enum TipoElemento {

    TITULO_UNO(0),
    VALOR_DINERO(1),
    POSICION_LATERAL(TargetApp.soIsIos()?1:0),
    POSICION_ABAJO(1),
    POSICION_ARRIBA(1);

    private Object value;

    TipoElemento(Object value){
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

}
