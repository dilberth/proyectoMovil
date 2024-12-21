package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils;

public enum Usuario {

    PRIVADO01("privado01"),
    PRIVADO02("privado02"),
    PRIVADO03("privado03"),
    PRIVADO04("privado04"),
    AUTOMATIZADA01("automatizada01"),
    AUTOMATIZADA05("automatizada05"),
    USR_PASS1("usr_pass1"),
    USR_PASS2("usr_pass2"),
    GRANADAUSR("granadausr"),
    FELDOUSER7("Feldouser7"),
    USRCERT9("usrcert9"),
    USRBILLETE20("usrbillete20"),
    AHORRO2020("ahorro2020"),
    FELDOUSER1("feldouser1"),
    USRPAY01("usr_Pay01"),
    USRPAY02("usr_Pay02"),
    CODE01("code01"),
    AUTOMATIZADAGOLIVE1("automatizadagolive1"),
    USRCERT1("usrcert1"),
    CLIENTEPAY01("clientepay01"),
    CANCUN("cancun"),
    FPOLIO("fpolio"),
    JAVIERROSALES("javierrosales"),
    GRANADAUSRGO5("granadausrgo5"),
    AHORRO2023("ahorro2023"),
    GRANADAUSRGO1("granadausrgo1"),
    PRUEBASDESA("ogirdor24"),
    ACTADS4("activar.ads002"),
    MIGUELSABAL("miguelsabal");

    String nombreUsuario;

    Usuario(String nombreUsuario){
        this.nombreUsuario = nombreUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }
}
