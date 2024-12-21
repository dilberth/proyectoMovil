package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.Tarjetas;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Utilidades;
import net.serenitybdd.core.steps.*;
import net.serenitybdd.screenplay.*;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.*;
import net.thucydides.core.annotations.*;

import java.util.*;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.UiCuentas.MAS_DETALLE;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.UiCuentas.SELECTOR2;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Constantes.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class ProcesoDonacionCashBac implements Task {
    private final List<Tarjetas> datos;

    public ProcesoDonacionCashBac(List<Tarjetas> datos) {
        this.datos = datos;
    }

    @Step("{0} realiza el proceso de donación de CashBac")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Tarjetas tarj = datos.get(0);

        actor.attemptsTo(
                Click.on(UiTarjetas.botonVolver()),
                WaitUntil.the(MAS_DETALLE, isVisible()).forNoMoreThan(30).seconds(),
                WaitUntil.the(MAS_DETALLE, isEnabled()).forNoMoreThan(30).seconds(),
                Scroll.hastaElElemento(UiGenerico.accesibilityId(TXTREDENCION_DONACION)).elementoVisibleEnElMedioDeLaPantalla(),
                WaitUntil.the(UiGenerico.accesibilityId(TXTREDENCION_DONACION), isVisible()).forNoMoreThan(30).seconds(),
                ClickEn.elElemento(UiGenerico.accesibilityId(TXTREDENCION_DONACION)),
                Esperar.texto(TXTTIPO_OPERACION),
                SeleccionarLista.conCordenadasDelNombre(TXTTIPO_OPERACION,TargetApp.soIsIos()).laOpcion(tarj.getTipoOperacion()),
                SeleccionarLista.conCordenadasDelNombre(TXTINSTITUCION,TargetApp.soIsIos()).laOpcion(tarj.getInstitucionOng()),
                SeleccionarLista.conCordenadasDelNombre(TXTTIPO_COBRO,TargetApp.soIsIos()).laOpcion(tarj.getTipoCobro()),
                IngresarEn.elCampo(TXTMONTO).elValor(tarj.getMonto()),
                IngresarEn.elCampo(TXTCONCEPTO).elValor(tarj.getConcepto()),
                ClickEnBoton.elElemento(TXTBTN_CONTINUAR),
                WaitUntil.the(UiGenerico.elementoQueContengaElTexto(TXTBTN_ACEPTAR), isVisible()).forNoMoreThan(30).seconds(),
                ClickEnBoton.elElemento(TXTBTN_ACEPTAR),
                WaitUntil.the(UiGenerico.elementoQueContengaElTexto(TXTDONACION_CB), isVisible()).forNoMoreThan(30).seconds()
        );

    }

    public static ProcesoDonacionCashBac para(List<Tarjetas> datos) {
        return Instrumented.instanceOf(ProcesoDonacionCashBac.class).withProperties(datos);
    }
}