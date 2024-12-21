package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils;

public enum Ambiente {

    QA("qa"),
    DEV("dev");

    String ambiente;

    Ambiente(String nombreUsuario){
        this.ambiente = ambiente;
    }

    public String getNombreUsuario() {
        return ambiente;
    }
}
