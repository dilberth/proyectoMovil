package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.*;
import net.serenitybdd.core.steps.*;
import net.serenitybdd.screenplay.*;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.waits.*;
import net.thucydides.core.annotations.*;

import java.util.*;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.UiTarjetas.CANTIDAD_TARJETAS_SELECCIONADAS;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Constantes.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Variables.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class NotificacionViajerosTodasTarjetas implements Task {
    private final List<NotificacionesDeViajeros> opcion;

    public NotificacionViajerosTodasTarjetas(List<NotificacionesDeViajeros> opcion) {
        this.opcion = opcion;
    }

    @Step("{0} realiza el proceso notificación de viajeros para 'todas las tarjetas'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        NotificacionesDeViajeros opc = opcion.get(0);

        actor.attemptsTo(
                SeleccionarEnMenuPrincipal.laOpcion(OpcionMenuPrincipal.SERVICIOS),
                Esperar.texto(TXTSERVICIOS),
                ClickEn.elElemento(UiMenuServicios.notificacionDeViajero()),
                Esperar.texto(TXTNOTIFICACION_VIAJEROS),
                ClickEn.elElemento(UiGenerico.elementoQueContengaElTexto(TXTSELECCIONAR_TODAS))
        );

        actor.remember(TARJETAS_SELECCIONADAS.toString(), CANTIDAD_TARJETAS_SELECCIONADAS.resolveAllFor(actor).size());

        actor.attemptsTo(
                ClickEnBoton.elElemento(TXTBTN_CONTINUAR),
                WaitUntil.the(UiGenerico.elementoQueContengaElTexto(TXTTARJETAS), isVisible()).forNoMoreThan(30).seconds(),
                SeleccionarEnCalendario.fechaDeSalida(opc.getFechaSalida()),
                Scroll.simple(),
                SeleccionarEnCalendario.fechaDeRegreso(opc.getFechaRegreso()),
                IngresarEn.elCampo(TXTPAISES_DESTINO).elValor(opc.getPaisDestino()),
                IngresarEn.elCampo(TargetApp.soIsIos() ? TXT_COMENTARIOS1 : TXT_COMENTARIOS2).elValor(opc.getComentarios()),
                ClickEnBoton.elElemento(TXTBTN_CONTINUAR),
                Esperar.texto(TXTMSG_EMERG1));

        ScrollVertical.largo().desdeElMedio().ejecutar();

        actor.attemptsTo(
                Click.on(UiGenerico.elementoQueContengaElTexto(TXTBTN_ACEPTAR)));
        WaitUntil.the(UiTarjetas.CONFIRMACION, isVisible()).forNoMoreThan(45).seconds().performAs(actor);

    }

    public static NotificacionViajerosTodasTarjetas para(List<NotificacionesDeViajeros> opcion) {
        return Instrumented.instanceOf(NotificacionViajerosTodasTarjetas.class).withProperties(opcion);
    }
}