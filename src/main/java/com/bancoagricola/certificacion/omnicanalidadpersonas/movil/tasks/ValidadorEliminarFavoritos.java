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

import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.UiCuentas.LNK_ELIMINAR_FAVORITOS;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.UiMenuPrincipal.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Constantes.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static org.junit.Assert.assertTrue;

public class ValidadorEliminarFavoritos implements Task {
    private final List<Cuentas> datos;

    public ValidadorEliminarFavoritos(List<Cuentas> datos) {
        this.datos = datos;
    }

    @Step("{0} 'Valida si existe favorito y lo elimina'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Cuentas cu = datos.get(0);

        actor.attemptsTo(
                Click.on(MENU_PRINCIPAL),
                WaitUntil.the(UiGenerico.elementoQueContengaElTexto("Favoritos"), isVisible()).forNoMoreThan(30).seconds(),
                Click.on(FAVORITOS));
        actor.attemptsTo(
                WaitUntil.the(UiGenerico.elementoQueContengaElTexto(TXTGESTIONFAV), isVisible()).forNoMoreThan(30).seconds(),
                Scroll.hastaElElemento(UiGenerico.elementoQueContengaElTexto(cu.getOpcion())).elementoVisibleEnElMedioDeLaPantalla(),
                Click.on(UiGenerico.elementoQueContengaElTexto(cu.getOpcion())),
                WaitUntil.the(UiGenerico.elementoQueContengaElTexto(cu.getOpcion()), isVisible()).forNoMoreThan(30).seconds());

        if (UiGenerico.elementoQueContengaElTexto(TXTNO_FAVORITOS).resolveFor(actor).isVisible()) {
            actor.attemptsTo(
                    VolverInicio.click());
        } else if (LNK_ELIMINAR_FAVORITOS.resolveFor(actor).isVisible()) {
            actor.attemptsTo(
                    EliminaFavorito.con(datos));
        } else {
            assertTrue("Favor validar, se estan presentando problemas de ambiente", false);
        }
    }

    public static ValidadorEliminarFavoritos con(List<Cuentas> datos) {
        return Instrumented.instanceOf(ValidadorEliminarFavoritos.class).withProperties(datos);
    }
}