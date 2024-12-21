package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.*;
import net.serenitybdd.core.steps.*;
import net.serenitybdd.screenplay.*;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.*;
import net.thucydides.core.annotations.*;

import java.util.*;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.UiCuentas.BANNER_BANCO_AGRICOLA;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Constantes.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class ValidacionMovimientoMetaRetiro implements Task {
    private final List<Ahorros> meta;

    public ValidacionMovimientoMetaRetiro(List<Ahorros> meta) {
        this.meta = meta;
    }

    @Step("{0} valida que se muestre el movimiento de Retiro")
    @Override
    public <T extends Actor> void performAs(T actor) {
        String retiro = TXTRETIRO_A_META_M;
        Ahorros aho = meta.get(0);

        Utilidades.esperar(10);
        actor.attemptsTo(
                ClickEn.elElemento(UiGenerico.accesibilityId(TXTCUENTAS)),
                ClickEn.elElemento(UiGenerico.elementoQueContengaElTexto(TXTAHORROS)),
                Scroll.hastaElElemento(UiGenerico.elementoDeTexto(aho.getNombreMeta())).elementoVisibleEnElMedioDeLaPantalla(),
                ClickEn.elElemento(UiGenerico.elementoDeTexto(aho.getNombreMeta())),
                ClickEn.elElemento(UiGenerico.accesibilityId("Ver más")),
                ClickEn.elElemento(UiGenerico.accesibilityId("Movimientos")),
                Esperar.pantallaDeCarga(),
                WaitUntil.the(UiGenerico.elementoQueContengaElTexto(retiro), isCurrentlyVisible()).forNoMoreThan(30).seconds(),
                Click.on(BANNER_BANCO_AGRICOLA));
                //VolverInicio.click());
    }

    public static ValidacionMovimientoMetaRetiro para(List<Ahorros> meta) {
        return Instrumented.instanceOf(ValidacionMovimientoMetaRetiro.class).withProperties(meta);
    }
}