package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.*;
import net.serenitybdd.core.steps.*;
import net.serenitybdd.screenplay.*;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.waits.*;
import net.thucydides.core.annotations.*;

import java.util.*;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Constantes.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class ProcesoTransferenciaAP_Tercero implements Task {
    private final List<Ahorros> datos;

    public ProcesoTransferenciaAP_Tercero(List<Ahorros> datos) {
        this.datos = datos;
    }

    @Step("{0} realiza el proceso de transferencia a una cuenta de tercero")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Ahorros aho = datos.get(0);

        actor.attemptsTo(
                Click.on(UiTarjetas.botonVolver()),
                WaitUntil.the(UiCuentas.linkMasDetalles(), isVisible()).forNoMoreThan(30).seconds(),
                Scroll.hastaElElemento(UiGenerico.elementoQueContengaElTexto(TXTOPC_TRANSF)),
                ClickEn.elElemento(UiGenerico.elementoQueContengaElTexto(TXTOPC_TRANSF)),
                WaitUntil.the(UiGenerico.elementoQueContengaElTexto(TXTTRANSFERENCIAS), isVisible()).forNoMoreThan(30).seconds(),
                ClickEn.elElemento(UiGenerico.elementoQueContengaElTexto(TXTOPC_TRANSF_TERC)),
                WaitUntil.the(UiGenerico.elementoQueContengaElTexto(TXTTRANSFERENCIAATERCE), isVisible()).forNoMoreThan(30).seconds(),
                IngresarEn.elCampo(TXTNUM_CUENTA).elValor(aho.getCuentaDestino()),
                IngresarEn.elCampo(TXTCORREO).elValor(aho.getCorreo()),
                IngresarEn.elCampo(TXTMONTO).elValor(aho.getMonto()+ (TargetApp.soIsIos()?"00":"")),
                IngresarEn.elCampo(TXTCONCEPTO).elValor(aho.getConcepto()),
                ClickEnBoton.elElemento(TXTBTN_CONTINUAR),
                Esperar.texto(TXTDESEA_CONTINUAR),
                ClickEnBoton.elElemento(TXTBTN_ACEPTAR),
                WaitUntil.the(UiGenerico.elementoQueContengaElTexto(TXTMENSAJE_CONF1), isVisible()).forNoMoreThan(45).seconds()
        );

    }

    public static ProcesoTransferenciaAP_Tercero para(List<Ahorros> datos) {
        return Instrumented.instanceOf(ProcesoTransferenciaAP_Tercero.class).withProperties(datos);
    }
}
