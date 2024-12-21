package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.*;
import net.serenitybdd.markers.*;
import net.serenitybdd.screenplay.*;
import net.serenitybdd.screenplay.actions.*;
import net.thucydides.core.annotations.*;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.UiMenuPrincipal.BANCO_AGRICOLA;

public class VolverInicio implements Interaction, IsSilent {

    @Override
    @Screenshots(beforeAndAfterEachStep = true)
    public <T extends Actor> void performAs(T actor) {

        if (TargetApp.soIsIos()) {
            ClickConJs.enLasCoordenadas(Coordenadas.centralesDelElementoXpath("Titulo banco agricola", BANCO_AGRICOLA)).performAs(actor);
        } else {
            Esperar.texto("Banco Agrícola").performAs(actor);
            Click.on(UiGenerico.elementoDeTexto("Banco Agrícola")).performAs(actor);
        }
        Esperar.pantallaDeCarga().performAs(actor);
    }

    public static VolverInicio click() {
        return Tasks.instrumented(VolverInicio.class);
    }

}
