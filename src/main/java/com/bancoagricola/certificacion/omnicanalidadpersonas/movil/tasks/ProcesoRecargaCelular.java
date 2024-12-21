package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.Cuentas;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Utilidades;
import net.serenitybdd.core.steps.*;
import net.serenitybdd.screenplay.*;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.*;
import net.thucydides.core.annotations.*;

import java.util.*;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.UiCuentas.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Constantes.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class ProcesoRecargaCelular implements Task {
    private final List<Cuentas> datos;

    public ProcesoRecargaCelular(List<Cuentas> datos) {
        this.datos = datos;
    }

    @Step("{0} realiza el proceso de recarga de celular")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Cuentas cu = datos.get(0);

        actor.attemptsTo(
                Click.on(UiTarjetas.botonVolver()),
                WaitUntil.the(MAS_DETALLE, isVisible()).forNoMoreThan(30).seconds(),
                WaitUntil.the(MAS_DETALLE, isEnabled()).forNoMoreThan(30).seconds(),
                Scroll.hastaElElemento(RECARGA_CELULAR).elementoVisibleEnElMedioDeLaPantalla(),
                WaitUntil.the(RECARGA_CELULAR, isVisible()).forNoMoreThan(30).seconds(),
                WaitUntil.the(RECARGA_CELULAR, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(RECARGA_CELULAR, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(RECARGA_CELULAR),
                Esperar.texto("Recarga de celular"));

        if (cu.getTipoTRX().equals("NORMAL")) {
            actor.attemptsTo(
                    Scroll.hastaElElemento(RECARGA_OTRO_NUMERO).elementoVisibleEnElMedioDeLaPantalla(),
                    WaitUntil.the(RECARGA_OTRO_NUMERO, isVisible()).forNoMoreThan(30).seconds(),
                    WaitUntil.the(RECARGA_OTRO_NUMERO, isEnabled()).forNoMoreThan(30).seconds(),
                    WaitUntil.the(RECARGA_OTRO_NUMERO, isClickable()).forNoMoreThan(30).seconds(),
                    Click.on(RECARGA_OTRO_NUMERO),
                    Esperar.texto("Recarga de celular"));
            Utilidades.esperar(5);
            actor.attemptsTo(
                    IngresarEn.elCampo(CAMPO_CELULAR).elValor(cu.getCelular()),
                    SeleccionarLista.conCordenadasDelNombre(TXTCOMPANIA, TargetApp.soIsIos()).laOpcion(cu.getCompania()),
                    SeleccionarLista.conCordenadasDelNombre(TXTPAQUETEMONTO, TargetApp.soIsIos()).laOpcion(cu.getMontopaquete()),
                    Enter.theValue(cu.getConcepto()).into(CAMPO_CONCEPTO));
        } else if (cu.getTipoTRX().equals("FAV")) {
            actor.attemptsTo(
                    Scroll.hastaElElemento(UiGenerico.elementoQueContengaElTexto(cu.getNombrefavorito())).elementoVisibleEnElMedioDeLaPantalla(),
                    WaitUntil.the(UiGenerico.elementoQueContengaElTexto(cu.getNombrefavorito()), isVisible()).forNoMoreThan(30).seconds(),
                    WaitUntil.the(UiGenerico.elementoQueContengaElTexto(cu.getNombrefavorito()), isEnabled()).forNoMoreThan(30).seconds(),
                    WaitUntil.the(UiGenerico.elementoQueContengaElTexto(cu.getNombrefavorito()), isClickable()).forNoMoreThan(30).seconds(),
                    Click.on(UiGenerico.elementoQueContengaElTexto(cu.getNombrefavorito())),
                    Esperar.texto("Recarga de celular"));
            Utilidades.esperar(5);
            actor.attemptsTo(
                    SeleccionarLista.conCordenadasDelNombre(TXTPAQUETEMONTO, TargetApp.soIsIos()).laOpcion(cu.getMontopaquete()));
        } else {
            System.out.println("Opción no válida");
        }

        actor.attemptsTo(
                Scroll.hastaElElemento(BOTON_CONTINUAR).elementoVisibleEnElMedioDeLaPantalla(),
                Click.on(BOTON_CONTINUAR),
                Esperar.texto("¿Deseas continuar?"),
                Click.on(BOTON_ACEPTAR),
                Esperar.texto("La recarga de celular ha sido completada exitosamente"));
    }

    public static ProcesoRecargaCelular para(List<Cuentas> datos) {
        return Instrumented.instanceOf(ProcesoRecargaCelular.class).withProperties(datos);
    }
}
