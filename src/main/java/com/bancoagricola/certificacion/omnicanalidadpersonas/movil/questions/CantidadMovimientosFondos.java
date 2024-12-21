package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.questions;

import net.serenitybdd.screenplay.*;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.UiGenerico.CANTIDAD_MOVIMIENTOS_FONDOS_INVERSION;

public class CantidadMovimientosFondos implements Question <Integer> {

    @Override
    public Integer answeredBy(Actor actor) {
        return CANTIDAD_MOVIMIENTOS_FONDOS_INVERSION.resolveAllFor(actor).size();
    }

    public static CantidadMovimientosFondos tiene(){
        return new CantidadMovimientosFondos();
    }
}
