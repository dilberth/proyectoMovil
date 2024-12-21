package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.*;
import net.serenitybdd.core.steps.*;
import net.serenitybdd.screenplay.*;
import net.serenitybdd.screenplay.waits.*;
import net.thucydides.core.annotations.*;

import java.util.*;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Constantes.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class ValidacionMovimientoMetaAporte implements Task {
    private final List<Ahorros> meta;

    public ValidacionMovimientoMetaAporte(List<Ahorros> meta) {
        this.meta = meta;
    }

    @Step("{0} valida que se muestre el movimiento de Aporte")
    @Override
    public <T extends Actor> void performAs(T actor) {
        String aporte = TXTAPORTE_MANUAL_A_META;
        Ahorros aho = meta.get(0);

        actor.attemptsTo(
                VolverInicio.click(),
                ClickEn.elElemento(UiGenerico.accesibilityId(TXTCUENTAS)),
                ClickEn.elElemento(UiGenerico.elementoQueContengaElTexto(TXTAHORROS)),
                Scroll.hastaElElemento(UiGenerico.elementoDeTexto(aho.getNombreMeta())).elementoVisibleEnElMedioDeLaPantalla(),
                ClickEn.elElemento(UiGenerico.elementoDeTexto(aho.getNombreMeta())),
                ClickEn.elElemento(UiGenerico.accesibilityId("Ver más")),
                ClickEn.elElemento(UiGenerico.accesibilityId("Movimientos")),
                Esperar.pantallaDeCarga(),
                WaitUntil.the(UiGenerico.elementoQueContengaElTexto(aporte), isCurrentlyVisible()).forNoMoreThan(30).seconds(),
                VolverInicio.click()
        );
    }

    public static ValidacionMovimientoMetaAporte para(List<Ahorros> meta) {
        return Instrumented.instanceOf(ValidacionMovimientoMetaAporte.class).withProperties(meta);
    }
}