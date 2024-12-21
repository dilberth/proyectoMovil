package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.*;
import net.serenitybdd.core.steps.*;
import net.serenitybdd.screenplay.*;
import net.serenitybdd.screenplay.waits.*;
import net.thucydides.core.annotations.*;

import java.util.*;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Constantes.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class RetiroMeta implements Task {
    private final List<Ahorros> meta;

    public RetiroMeta(List<Ahorros> meta) {
        this.meta = meta;
    }

    @Step("{0} realiza el proceso para retirar a meta")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Ahorros aho = meta.get(0);

        actor.attemptsTo(
                VolverInicio.click(),
                ClickEn.elElemento(UiGenerico.accesibilityId(TXTCUENTAS)),
                ClickEn.elElemento(UiGenerico.elementoQueContengaElTexto(TXTAHORROS)),
                ClickEn.elElemento(UiGenerico.elementoDeTexto(aho.getNombreMeta())),
                ClickEn.elElemento(UiGenerico.accesibilityId("Ver más")),
                Esperar.pantallaDeCarga(),
                WaitUntil.the(UiGenerico.elementoQueContengaElTexto(TXTMONTO_ACUMULADO), isVisible()).forNoMoreThan(20).seconds(),
                ClickEn.elElemento(UiAhorros.botonRetirar()),
                WaitUntil.the(UiGenerico.elementoQueContengaElTexto(TXTRETIRO_A_META), isVisible()).forNoMoreThan(20).seconds(),
                IngresarEn.elCampo(TXTMONTO_A_RETIRAR).elValor(aho.getRetiroMeta()),
                ClickEn.elElemento(UiGenerico.elementoQueContengaElTexto(TXTRETIRAR)),
                ClickEnBoton.elElemento(TXTBTN_ACEPTAR),
                WaitUntil.the(UiGenerico.elementoQueContengaElTexto(TXTMENSAJE_CONF14), isVisible()).forNoMoreThan(45).seconds()
        );
    }

    public static RetiroMeta para(List<Ahorros> meta) {
        return Instrumented.instanceOf(RetiroMeta.class).withProperties(meta);
    }
}