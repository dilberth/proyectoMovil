package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.Limites;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.*;
import net.serenitybdd.core.steps.*;
import net.serenitybdd.screenplay.*;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.waits.*;
import net.thucydides.core.annotations.*;

import java.util.*;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.UiGenerico.LIMITE_ACU;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Constantes.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Variables.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class ProcesoActualizacionLimiteAcu implements Task {
    private final List<Limites> datos;

    public ProcesoActualizacionLimiteAcu(List<Limites> datos) {
        this.datos = datos;
    }

    @Step("{0} realiza el proceso para actualización de limite acumulado y por transacción")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Limites lim = datos.get(0);
        actor.remember(LIMITE_TRX.toString(), lim.getLimitePorTRX() + ".00");
        actor.remember(LIMITE_CAN.toString(), lim.getLimiteSem() + ".00");

        actor.attemptsTo(
                SeleccionarEnMenuPrincipal.laOpcion(OpcionMenuPrincipal.GESTION_DE_LIMITES),
                WaitUntil.the(UiGenerico.elementoQueContengaElTexto(TXTGESTION_LIMITES), isVisible()).forNoMoreThan(30).seconds(),
                Task.where("Click", Clear.field(LIMITE_ACU)).withNoReporting(),
                IngresarEn.elCampo(LIMITE_ACU).elValor(lim.getLimiteSem()),
                Task.where("Click", Clear.field(UiGenerico.LIMITE_TRX)).withNoReporting(),
                IngresarEn.elCampo(UiGenerico.LIMITE_TRX).elValor(lim.getLimitePorTRX()),
                ClickEnBoton.elElemento(TXTBTN_ACEPTAR),
                Esperar.desaparezcaTarget(UiGenerico.boton(TXTBTN_ACEPTAR)),
                WaitUntil.the(UiGenerico.elementoQueContengaElTexto(TXTMSG_CONF15), isVisible()).forNoMoreThan(30).seconds());

    }

    public static ProcesoActualizacionLimiteAcu para(List<Limites> datos) {
        return Instrumented.instanceOf(ProcesoActualizacionLimiteAcu.class).withProperties(datos);
    }
}