package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils;

public class EstadoLogin {

    private static boolean estadoLogin = true;

    public static boolean isEstadoLogin() {
        return estadoLogin;
    }

    public static void setEstadoLogin(boolean estadoLoginNuevo) {
        estadoLogin = estadoLoginNuevo;
    }

}
