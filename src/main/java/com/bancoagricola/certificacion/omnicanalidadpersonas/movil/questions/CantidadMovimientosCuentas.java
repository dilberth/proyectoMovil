package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.UiGenerico.CANTIDAD_MOVIMIENTOS_CUENTAS;


public class CantidadMovimientosCuentas implements Question <Integer> {

    @Override
    public Integer answeredBy(Actor actor) {
        return CANTIDAD_MOVIMIENTOS_CUENTAS.resolveAllFor(actor).size();
    }

    public static CantidadMovimientosCuentas tiene(){
        return new CantidadMovimientosCuentas();
    }
}
