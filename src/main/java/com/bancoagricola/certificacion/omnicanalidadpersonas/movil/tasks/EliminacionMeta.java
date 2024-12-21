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

public class EliminacionMeta implements Task {
    private final List<Ahorros> meta;

    public EliminacionMeta(List<Ahorros> meta) {
        this.meta = meta;
    }

    @Step("{0} realiza el proceso para eliminar meta")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Ahorros aho = meta.get(0);

        actor.attemptsTo(
                VolverInicio.click(),
                ClickEn.elElemento(UiGenerico.accesibilityId(TXTCUENTAS)),
                ClickEn.elElemento(UiGenerico.elementoQueContengaElTexto(TXTAHORROS)),
                Scroll.hastaElElemento(UiGenerico.elementoDeTexto(aho.getNombreMeta())).elementoVisibleEnElMedioDeLaPantalla(),
                ClickEn.elElemento(UiGenerico.elementoDeTexto(aho.getNombreMeta())),
                ClickEn.elElemento(UiGenerico.accesibilityId("Ver más")),
                Esperar.pantallaDeCarga(),
                WaitUntil.the(UiGenerico.elementoQueContengaElTexto(TXTMONTO_ACUMULADO), isVisible()).forNoMoreThan(20).seconds(),
                ClickEn.elElemento(UiAhorros.linkEliminar()),
                Esperar.texto(TXTDESEA_CONTINUAR),
                ClickEnBoton.elElemento(TXTBTN_ACEPTAR),
                WaitUntil.the(UiGenerico.elementoQueContengaElTexto(TXTMENSAJE_CONF12), isVisible()).forNoMoreThan(45).seconds()
        );

    }

    public static EliminacionMeta para(List<Ahorros> meta) {
        return Instrumented.instanceOf(EliminacionMeta.class).withProperties(meta);
    }
}
