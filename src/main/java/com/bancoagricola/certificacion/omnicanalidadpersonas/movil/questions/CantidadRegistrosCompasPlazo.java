package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.UiTarjetas.OTROS;
public class CantidadRegistrosCompasPlazo implements Question <Integer> {

    @Override
    public Integer answeredBy(Actor actor) { return OTROS.of("Compras a plazo").resolveAllFor(actor).size();}

    public static CantidadRegistrosCompasPlazo tiene(){
        return new CantidadRegistrosCompasPlazo();
    }
}