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

import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.UiCuentas.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Constantes.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class ProcesoTransferenciaPuntosBALifemiles implements Task {
    private final List<Cuentas> datos;

    public ProcesoTransferenciaPuntosBALifemiles(List<Cuentas> datos) {
        this.datos = datos;
    }

    @Step("{0} realiza el proceso de transferencia de PuntosBA a Lifemiles")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Cuentas cu = datos.get(0);

        actor.attemptsTo(
                Click.on(UiTarjetas.botonVolver()),
                WaitUntil.the(MAS_DETALLE, isVisible()).forNoMoreThan(30).seconds(),
                WaitUntil.the(MAS_DETALLE, isEnabled()).forNoMoreThan(30).seconds(),
                Scroll.hastaElElemento(TRANSFERIR_PBA_LFM).elementoVisibleEnElMedioDeLaPantalla(),
                WaitUntil.the(TRANSFERIR_PBA_LFM, isVisible()).forNoMoreThan(30).seconds(),
                WaitUntil.the(TRANSFERIR_PBA_LFM, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(TRANSFERIR_PBA_LFM, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(TRANSFERIR_PBA_LFM),
                Esperar.texto("Transferencias de Puntos a LifeMiles"),
                WaitUntil.the(TRANSF_OC, isVisible()).forNoMoreThan(30).seconds(),
                WaitUntil.the(TRANSF_OC, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(TRANSF_OC, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(TRANSF_OC),
                Esperar.texto("Transferencias de Puntos a LifeMiles"),
                IngresarEn.elCampo(TXTPRIMER_NOMBRE).elValor(cu.getPrimerNombre()),
                IngresarEn.elCampo(TXTSEGUNDO_NOMBRE).elValor(cu.getSegundoNombre()),
                IngresarEn.elCampo(TXTPRIMER_APELLIDO).elValor(cu.getPrimerApellido()),
                IngresarEn.elCampo(TXSEGUNDO_APELLIDO).elValor(cu.getSegundoApellido()),
                IngresarEn.elCampo(TXTNUMERO_TARJ_LM).elValor(cu.getNumeroLifemiles()),
                IngresarEn.elCampo(TXTPUNTOS_A_TRANSF).elValor(cu.getPuntos()),
                Scroll.simple(),
                Click.on(UiGenerico.campoSelector(TXTCODIGO_PAIS)),
                Click.on(UiGenerico.elementoDeTexto(cu.getCodigoPais())),
                IngresarEn.elCampo(TXTNUMERO_TELEFONICO).elValor(cu.getNumeroTelefono()),
                Scroll.simple(),
                WaitUntil.the(BOTON_CONTINUAR, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(BOTON_CONTINUAR, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(BOTON_CONTINUAR),
                Esperar.texto("¿Deseas continuar?"),
                Scroll.simple(),
                WaitUntil.the(BOTON_ACEPTAR, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(BOTON_ACEPTAR, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(BOTON_ACEPTAR),
                Esperar.texto("La solicitud se realizó exitosamente", 45));
                //WaitUntil.the(CONFIRMACION_LM, isVisible()).forNoMoreThan(30).seconds(),
                //WaitUntil.the(CONFIRMACION_LM, isEnabled()).forNoMoreThan(30).seconds());

    }

    public static ProcesoTransferenciaPuntosBALifemiles para(List<Cuentas> datos) {
        return Instrumented.instanceOf(ProcesoTransferenciaPuntosBALifemiles.class).withProperties(datos);
    }
}