package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.UiGenerico.CANTIDAD_MOVIMIENTOS_AHORROS;


public class CantidadMovimientosAhorros implements Question <Integer> {

    @Override
    public Integer answeredBy(Actor actor) {
        return CANTIDAD_MOVIMIENTOS_AHORROS.resolveAllFor(actor).size();
    }

    public static CantidadMovimientosAhorros tiene(){
        return new CantidadMovimientosAhorros();
    }
}
