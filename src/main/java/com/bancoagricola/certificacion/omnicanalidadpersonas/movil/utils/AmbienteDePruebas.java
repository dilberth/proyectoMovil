package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils;

public class AmbienteDePruebas {

    private static boolean ambienteQASet = true;

    public static boolean isAmbienteQA() {
        return ambienteQASet;
    }

    public static void setAmbienteQA(boolean ambienteQA) {
        ambienteQASet = ambienteQA;
    }
}
