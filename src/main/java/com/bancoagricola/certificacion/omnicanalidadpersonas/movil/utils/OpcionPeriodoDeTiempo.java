package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils;

public enum OpcionPeriodoDeTiempo{

    HOY("Hoy"),
    SEMANA_ACTUAL("Semana actual"),
    MES_ACTUAL("Mes actual"),
    MES_ANTERIOR("Mes anterior"),
    ÚLTIMOS_SEIS_MESES("Últimos seis meses");

    private String opcionPeriodo;

    OpcionPeriodoDeTiempo(String opcionPeriodo){
        this.opcionPeriodo = opcionPeriodo;
    }

    public String tomarOpcion() {
        return opcionPeriodo;
    }


}
