package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.questions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.TargetApp;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.*;
import net.serenitybdd.screenplay.*;
import net.serenitybdd.screenplay.actors.*;

public class VerEnPantalla {

    public static Performable elTexto(String texto){

    return Task.where(
                OnStage.theActorInTheSpotlight().getName() +" observa que en la pantalla  se encuentre el texto '"+texto+"'",
                Scroll.hastaElElemento(UiGenerico.elementoDeTexto(texto))
        );
    }

    public static Performable contengaTexto(String texto){

        return Task.where(
                OnStage.theActorInTheSpotlight().getName() +" observa que en la pantalla  se encuentre el texto '"+texto+"'",
                Scroll.hastaElElemento(UiGenerico.elementoQueContengaElTexto(texto))
        );
    }

}
