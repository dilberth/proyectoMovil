package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.*;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.UiCuentas.MAS_DETALLE;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.UiTarjetas.PRODUCTOABONAR;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Constantes.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class ProcesoRedencionCashBac implements Task {
    private final List<Tarjetas> datos;

    public ProcesoRedencionCashBac(List<Tarjetas> datos) {
        this.datos = datos;
    }

    @Step("{0} realiza el proceso de redención de CashBac")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Tarjetas tarj = datos.get(0);

        actor.attemptsTo(
                Click.on(UiTarjetas.botonVolver()),
                WaitUntil.the(MAS_DETALLE, isVisible()).forNoMoreThan(30).seconds(),
                WaitUntil.the(MAS_DETALLE, isEnabled()).forNoMoreThan(30).seconds(),
                Scroll.hastaElElemento(UiGenerico.accesibilityId(TXTREDENCION_DONACION)).elementoVisibleEnElMedioDeLaPantalla(),
                WaitUntil.the(UiGenerico.accesibilityId(TXTREDENCION_DONACION), isVisible()).forNoMoreThan(30).seconds(),
                WaitUntil.the(UiGenerico.accesibilityId(TXTREDENCION_DONACION), isClickable()).forNoMoreThan(30).seconds(),
                ClickEn.elElemento(UiTarjetas.OPCION_REDENCION_DONACION),
                Esperar.texto(TXTTIPO_OPERACION),
                WaitUntil.the(UiGenerico.elementoQueContengaElTexto(TXTTIPO_OPERACION),isVisible()).forNoMoreThan(10).seconds(),
                SeleccionarLista.conCordenadasDelNombre(TXTTIPO_OPERACION, TargetApp.soIsIos()).laOpcion(tarj.getTipoOperacion()),
                SeleccionarLista.conCordenadasDelNombre(TXTPRODUCTO_A_ABONAR,TargetApp.soIsIos()).laOpcion(tarj.getCuentaDestino()),
                SeleccionarLista.conCordenadasDelNombre(TXTTIPO_COBRO,TargetApp.soIsIos()).laOpcion(tarj.getTipoCobro()),
                IngresarEn.elCampo(TXTMONTO).elValor(tarj.getMonto()),
                IngresarEn.elCampo(TXTCONCEPTO).elValor(tarj.getConcepto()),
                ClickEnBoton.elElemento(TXTBTN_CONTINUAR),
                WaitUntil.the(UiGenerico.elementoQueContengaElTexto(TXTDESEA_CONTINUAR),isVisible()).forNoMoreThan(30).seconds(),
                Esperar.texto(TXTDESEA_CONTINUAR),
                WaitUntil.the(UiGenerico.elementoQueContengaElTexto(TXTBTN_ACEPTAR), isVisible()).forNoMoreThan(30).seconds(),
                ClickEnBoton.elElemento(TXTBTN_ACEPTAR),
                WaitUntil.the(UiGenerico.elementoQueContengaElTexto(TXTREDENCION_CB),isVisible()).forNoMoreThan(30).seconds()
        );

    }

    public static ProcesoRedencionCashBac para(List<Tarjetas> datos) {
        return Instrumented.instanceOf(ProcesoRedencionCashBac.class).withProperties(datos);
    }
}
