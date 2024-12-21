package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.Limites;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.*;
import net.serenitybdd.core.steps.*;
import net.serenitybdd.screenplay.*;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.ClearBy;
import net.serenitybdd.screenplay.ensure.*;
import net.serenitybdd.screenplay.waits.*;
import net.thucydides.core.annotations.*;

import java.util.*;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Constantes.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Variables.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static org.junit.Assert.*;

public class ProcesoActualizacionLimiteTRX implements Task {
    private final List<Limites> datos;

    public ProcesoActualizacionLimiteTRX(List<Limites> datos) {
        this.datos = datos;
    }

    @Step("{0} realiza el proceso para actualización de limites por transacción")
    @Override
    public <T extends Actor> void performAs(T actor) {

        Limites lim = datos.get(0);
        actor.remember(LIMITE_TRX.toString(), lim.getLimitePorTRX() + ".00");

        actor.attemptsTo(
                SeleccionarEnMenuPrincipal.laOpcion(OpcionMenuPrincipal.GESTION_DE_LIMITES),
                WaitUntil.the(UiGenerico.elementoQueContengaElTexto(TXTGESTION_LIMITES), isVisible()).forNoMoreThan(30).seconds(),
                Clear.field(UiGenerico.LIMITE_TRX),
                IngresarEn.elCampo(UiGenerico.LIMITE_TRX).elValor(lim.getLimitePorTRX()),
                ClickEnBoton.elElemento(TXTBTN_ACEPTAR));

        Esperar.pantallaDeCarga().performAs(actor);
        Utilidades.esperar(5);

        if (UiGenerico.elementoQueContengaElTexto(TXTMSG_CONF15).resolveFor(actor).isVisible()) {
            actor.attemptsTo(Ensure.that(UiGenerico.elementoQueContengaElTexto(TXTMSG_CONF15)).isDisplayed());
        } else if (UiGenerico.elementoQueContengaElTexto(TXTMSG_ERROR).resolveFor(actor).isVisible()) {
            assertTrue("Validar que en backoffice se encuentre en 'FALSE' la variable: 'backend.vu.fraud.enabled'", false);
        } else {
            assertTrue("Error inesperado, favor validar", false);
        }

    }

    public static ProcesoActualizacionLimiteTRX para(List<Limites> datos) {
        return Instrumented.instanceOf(ProcesoActualizacionLimiteTRX.class).withProperties(datos);
    }
}