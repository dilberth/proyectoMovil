package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils;

public enum OpcionesDeEstado {

    FINALIZADO,
    PENDIENTE_DE_APLICAR,
    AGENDADA,
    PENDIENTE,
    BORRADOR,
    CANCELADO,
    FALLIDO;

    @Override
    public String toString() {
        return super.toString().replace("_"," ");
    }

}
