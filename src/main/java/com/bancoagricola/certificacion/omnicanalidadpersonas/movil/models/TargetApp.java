package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models;

public class TargetApp {

    private static TargetApp intencia;
    private static String soAuto;


    public static void paraSO(String so){
        soAuto = so;
    }

    public static String getSoAuto() {
        return soAuto;
    }

    public static boolean soIsIos(){
        return "ios".equals(getSoAuto());
    }

    public static String parametroParaTexto(){
        return soIsIos()?"label":"text";
    }

}
