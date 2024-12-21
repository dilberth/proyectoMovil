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

import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.UiMenuPrincipal.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Constantes.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class NotificacionViajeros1Tarjeta implements Task {
    private final List<NotificacionesDeViajeros> opcion;

    public NotificacionViajeros1Tarjeta(List<NotificacionesDeViajeros> opcion) {
        this.opcion = opcion;
    }

    @Step("{0} realiza el proceso notificación de viajeros para '1 tarjeta'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        NotificacionesDeViajeros opc = opcion.get(0);

        actor.attemptsTo(
                Click.on(MENU),
                Click.on(SERVICIOS),
                Esperar.texto(TXTSERVICIOS),
                ClickEn.elElemento(UiMenuServicios.notificacionDeViajero()),
                Esperar.texto(TXTNOTIFICACION_VIAJEROS),
                Scroll.hastaElElemento(UiGenerico.elementoQueContengaElTexto(opc.getTarjetaCredito())).elementoVisibleEnElMedioDeLaPantalla(),
                ClickEn.elElemento(UiGenerico.elementoQueContengaElTexto(opc.getTarjetaCredito())),
                Scroll.simple(),
                ClickEnBoton.elElemento(TXTBTN_CONTINUAR),
                WaitUntil.the(UiGenerico.elementoQueContengaElTexto(TXTTARJETAS), isVisible()).forNoMoreThan(30).seconds(),
                SeleccionarEnCalendario.fechaDeSalida(opc.getFechaSalida()),
                SeleccionarEnCalendario.fechaDeRegreso(opc.getFechaRegreso()),
                IngresarEn.elCampo(TXTPAISES_DESTINO).elValor(opc.getPaisDestino()),
                IngresarEn.elCampo(TXT_COMENTARIOS1).elValor(opc.getComentarios()),
                ClickEnBoton.elElemento(TXTBTN_CONTINUAR));
        ScrollVertical.medio().desdeElMedio().ejecutar();
        actor.attemptsTo(
                Scroll.simple(),
                ClickEnBoton.elElemento(TXTBTN_ACEPTAR));
        WaitUntil.the(UiTarjetas.CONFIRMACION, isVisible()).forNoMoreThan(45).seconds().performAs(actor);
    }

    public static NotificacionViajeros1Tarjeta para(List<NotificacionesDeViajeros> opcion) {
        return Instrumented.instanceOf(NotificacionViajeros1Tarjeta.class).withProperties(opcion);
    }
}