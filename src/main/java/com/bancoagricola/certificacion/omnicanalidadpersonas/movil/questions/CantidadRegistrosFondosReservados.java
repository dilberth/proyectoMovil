package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.UiTarjetas.OTROS;

public class CantidadRegistrosFondosReservados implements Question <Integer> {

    @Override
    public Integer answeredBy(Actor actor) { return OTROS.of("Fondos reservados").resolveAllFor(actor).size();}

    public static CantidadRegistrosFondosReservados tiene(){
        return new CantidadRegistrosFondosReservados();
    }
}