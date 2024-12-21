package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.*;
import com.openhtmltopdf.css.parser.property.PrimitivePropertyBuilders;
import net.serenitybdd.core.steps.*;
import net.serenitybdd.screenplay.*;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.ClearBy;
import net.serenitybdd.screenplay.waits.*;
import net.thucydides.core.annotations.*;

import java.util.*;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Constantes.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class ModificacionMeta implements Task {
    private final List<Ahorros> meta;

    public ModificacionMeta(List<Ahorros> meta) {
        this.meta = meta;
    }

    @Step("{0} realiza el proceso para modificar meta")
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
                ClickEn.elElemento(UiAhorros.linkModificar()),
                WaitUntil.the(UiGenerico.elementoQueContengaElTexto(TXTMODIFICAR_META), isVisible()).forNoMoreThan(20).seconds(),
                IngresarEn.elCampo(MONTO_TOTAL_DE_META).elValor(aho.getMontoMeta()),
                IngresarEn.elCampo(TXTPLAZO_META).elValor(aho.getPlazoMeta()),
                SeleccionarLista.conCordenadasDelNombre(TXTDIA_RETENCION, TargetApp.soIsIos()).laOpcion(aho.getDiaRetencion()),
                ClickEn.elElemento(UiGenerico.elementoQueContengaElTexto(TXTGUARDAR)),
                Esperar.texto(TXTDESEA_CONTINUAR),
                ClickEnBoton.elElemento(TXTBTN_CONTINUAR),
                WaitUntil.the(UiGenerico.elementoQueContengaElTexto(TXTMENSAJE_CONF11), isVisible()).forNoMoreThan(45).seconds()
                );

    }

    public static ModificacionMeta para(List<Ahorros> meta) {
        return Instrumented.instanceOf(ModificacionMeta.class).withProperties(meta);
    }
}
