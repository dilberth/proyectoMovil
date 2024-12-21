package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.Cuentas;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.*;
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

public class ProcesoTransferenciaUNI implements Task {
    private final List<Cuentas> datos;

    public ProcesoTransferenciaUNI(List<Cuentas> datos) {
        this.datos = datos;
    }

    @Step("{0} realiza el proceso de transferencia UNI")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Cuentas cu = datos.get(0);


        actor.attemptsTo(
                Click.on(UiTarjetas.botonVolver()),
                WaitUntil.the(MAS_DETALLE, isVisible()).forNoMoreThan(30).seconds(),
                WaitUntil.the(MAS_DETALLE, isEnabled()).forNoMoreThan(30).seconds(),
                Scroll.hastaElElemento(OPCION_TRANSF_UNI).elementoVisibleEnElMedioDeLaPantalla(),
                WaitUntil.the(OPCION_TRANSF_UNI, isVisible()).forNoMoreThan(30).seconds(),
                WaitUntil.the(OPCION_TRANSF_UNI, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(OPCION_TRANSF_UNI, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(OPCION_TRANSF_UNI),
                Esperar.texto("Transferencias UNI: Operaciones entre bancos",30));
                //WaitUntil.the(TITULO_TUNI, isVisible()).forNoMoreThan(30).seconds(),
                //WaitUntil.the(TITULO_TUNI, isEnabled()).forNoMoreThan(30).seconds());

        if (cu.getTipoTRX().equals("NORMAL")) {
            actor.attemptsTo(
                    WaitUntil.the(OPCION_TRANSF_OC, isVisible()).forNoMoreThan(30).seconds(),
                    WaitUntil.the(OPCION_TRANSF_OC, isEnabled()).forNoMoreThan(30).seconds(),
                    WaitUntil.the(OPCION_TRANSF_OC, isClickable()).forNoMoreThan(30).seconds(),
                    Click.on(OPCION_TRANSF_OC),
                    Esperar.texto("Transferencias UNI: Operaciones entre bancos",30),
                    //WaitUntil.the(TITULO_TUNI, isVisible()).forNoMoreThan(30).seconds(),
                    //WaitUntil.the(TITULO_TUNI, isEnabled()).forNoMoreThan(30).seconds(),
                    SeleccionarLista.conCordenadasDelNombre(TXTTIPOCUENTA, TargetApp.soIsIos()).laOpcion(cu.getTipoCuenta()),
                    SeleccionarLista.conCordenadasDelNombre(TXTBANCO, TargetApp.soIsIos()).laOpcion(cu.getBanco()),
                    IngresarEn.elCampo(CAMPO_CUENTA_TRANSFERIR).elValor(cu.getCuentaDestino()),
                    SeleccionarLista.conCordenadasDelNombre(TXTTIPODOCUMEN, TargetApp.soIsIos()).laOpcion(cu.getTipoIdentificacion()),
                    IngresarEn.elCampo(CAMPO_NUMERO_DOCUMENTO).elValor(cu.getNumeroIdentificacion()),
                    IngresarEn.elCampo(CAMPO_NOMBRE_DE_RECIBIDOR).elValor(cu.getNombreRecibidor()),
                    IngresarEn.elCampo(CAMPO_CORREO_T365_N).elValor(cu.getCorreo()));

        } else if (cu.getTipoTRX().equals("FAV")) {
            actor.attemptsTo(
                    Scroll.hastaElElemento(UiGenerico.elementoQueContengaElTexto(cu.getNombrefavorito())).elementoVisibleEnElMedioDeLaPantalla(),
                    WaitUntil.the(UiGenerico.elementoQueContengaElTexto(cu.getNombrefavorito()), isVisible()).forNoMoreThan(30).seconds(),
                    WaitUntil.the(UiGenerico.elementoQueContengaElTexto(cu.getNombrefavorito()), isEnabled()).forNoMoreThan(30).seconds(),
                    WaitUntil.the(UiGenerico.elementoQueContengaElTexto(cu.getNombrefavorito()), isClickable()).forNoMoreThan(30).seconds(),
                    Click.on(UiGenerico.elementoQueContengaElTexto(cu.getNombrefavorito())),
                    Esperar.texto("Transferencias UNI: Operaciones entre bancos",30));
                    //WaitUntil.the(TITULO_TUNI, isVisible()).forNoMoreThan(30).seconds(),
                    //WaitUntil.the(TITULO_TUNI, isEnabled()).forNoMoreThan(30).seconds());

        } else {
            System.out.println("Opción no válida");
        }

        actor.attemptsTo(
                Scroll.simple(),
                IngresarEn.elCampo(CAMPO_MONTO_T365).elValor(cu.getMonto()),
                Enter.theValue(cu.getConcepto()).into(CAMPO_CONCEPTO),
                WaitUntil.the(BOTON_TRANSFERIR, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(BOTON_TRANSFERIR, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(BOTON_TRANSFERIR),
                Esperar.texto("¿Deseas continuar?"),
                Scroll.simple(),
                Click.on(BOTON_ACEPTAR),
                Esperar.texto("Transferencias UNI: Operaciones entre bancos pendiente de aplicación",60));
                //WaitUntil.the(UiGenerico.elementoQueContengaElTexto(CONFIRMACION_UNI), isVisible()).forNoMoreThan(45).seconds(),
                //WaitUntil.the(UiGenerico.elementoQueContengaElTexto(CONFIRMACION_UNI), isEnabled()).forNoMoreThan(45).seconds());

        if (cu.getTipoTRX().equals("NORMAL")) {
            actor.attemptsTo(
                    //AgregaFavorito.con(datos),
                    ValidacionTicketUNI.elementos());
        } else if (cu.getTipoTRX().equals("FAV")) {
            actor.attemptsTo(
                    ValidacionTicketUNI.elementos());
        } else {
            System.out.println("Opción no válida");
        }
    }

    public static ProcesoTransferenciaUNI para(List<Cuentas> datos) {
        return Instrumented.instanceOf(ProcesoTransferenciaUNI.class).withProperties(datos);
    }
}
