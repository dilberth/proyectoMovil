package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.Cuentas;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.*;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.UiCuentas.OPCION_TRANSF_365;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Constantes.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.junit.Assert.assertTrue;

public class ProcesoTransferencia365favorito implements Task {
    private final List<Cuentas> datos;

    public ProcesoTransferencia365favorito(List<Cuentas> datos) {
        this.datos = datos;
    }

    @Step("{0} realiza el proceso telebanca transfer365 desde favorito")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Cuentas cu = datos.get(0);

        actor.attemptsTo(
                VerMasCuentasOrig.para(datos),
                Scroll.hastaElElemento(OPCION_TRANSF_365),
                WaitUntil.the(OPCION_TRANSF_365, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(OPCION_TRANSF_365),
                WaitUntil.the(UiGenerico.elementoQueContengaElTexto(TXTTRANSF_365), isVisible()).forNoMoreThan(30).seconds());
        if (UiGenerico.elementoQueContengaElTexto(cu.getNombrefavorito()).resolveFor(actor).isVisible()) {
            actor.attemptsTo(
                    Click.on(UiGenerico.elementoQueContengaElTexto(cu.getNombrefavorito())),
                    WaitUntil.the(UiGenerico.elementoQueContengaElTexto(TXTTRANSF_365), isVisible()).forNoMoreThan(10).seconds(),
                    IngresarEn.elCampo(TXTMONTO).elValor(cu.getMonto()),
                    IngresarEn.elCampo(TXTCONCEPTO).elValor(cu.getConcepto()),
                    ClickEnBoton.elElemento(TXTBTN_TRANSF),
                    Esperar.texto(TXTDESEA_CONTINUAR),
                    Scroll.simple(),
                    ClickEnBoton.elElemento(TXTBTN_ACEPTAR),
                    WaitUntil.the(UiGenerico.elementoQueContengaElTexto(TXTMENSAJE_CONF5), isVisible()).forNoMoreThan(45).seconds()
            );
        } else {
            assertTrue("No se muestra el favorito: " + UiGenerico.elementoQueContengaElTexto(cu.getNombrefavorito()) + " favor validar que haya sido creado anteriormente", false);
        }
    }

    public static ProcesoTransferencia365favorito para(List<Cuentas> datos) {
        return Instrumented.instanceOf(ProcesoTransferencia365favorito.class).withProperties(datos);
    }
}