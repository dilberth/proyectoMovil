package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils;

public enum CodigoConfirmacion {

    QA("111111"),
    DEV("1234");

    String codigoConf;

    CodigoConfirmacion(String codigoConf){
        this.codigoConf = codigoConf;
    }

    public String getCodigoConf() {
        return codigoConf;
    }
}
