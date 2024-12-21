package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.ClickEnEnlace;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.Esperar;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.Cuentas;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.UiAhorros.MENU_METAS;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.UiCuentas.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.UiTarjetas.MENU_TARJETAS;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class ProcesoTransferenciaTerceroCuentaNueva2 implements Task {
    private final List<Cuentas> datos;

    public ProcesoTransferenciaTerceroCuentaNueva2(List<Cuentas> datos) {
        this.datos = datos;
    }

    @Step("{0} realiza el proceso de transferencia a una cuenta de tercero")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Cuentas cu = datos.get(0);

        if (cu.getOpcion().equals("CA") || cu.getOpcion().equals("CC") || cu.getOpcion().equals("ADS")) {
            actor.attemptsTo(
                    WaitUntil.the(MENU_CUENTAS, isEnabled()).forNoMoreThan(30).seconds(),
                    WaitUntil.the(MENU_CUENTAS, isClickable()).forNoMoreThan(30).seconds());
        } else if (cu.getOpcion().equals("AP")) {
            actor.attemptsTo(
                    WaitUntil.the(MENU_METAS, isEnabled()).forNoMoreThan(30).seconds(),
                    WaitUntil.the(MENU_METAS, isClickable()).forNoMoreThan(30).seconds(),
                    Click.on(MENU_METAS));
        } else if (cu.getOpcion().equals("TDC")) {
            actor.attemptsTo(
                    WaitUntil.the(MENU_TARJETAS, isEnabled()).forNoMoreThan(30).seconds(),
                    WaitUntil.the(MENU_TARJETAS, isClickable()).forNoMoreThan(30).seconds(),
                    Click.on(MENU_TARJETAS),
                    Esperar.pantallaDeCarga());
        } else {
            System.out.println("Opción no válida");
        }

        actor.attemptsTo(
                Scroll.hastaElElemento(PRODUCTO(cu.getCuentaOrigen())).elementoVisibleEnElMedioDeLaPantalla(),
                Click.on(PRODUCTO(cu.getCuentaOrigen())),
                Scroll.hastaElElemento(VER_MAS).elementoVisibleEnElMedioDeLaPantalla(),
                Click.on(VER_MAS),
                WaitUntil.the(MAS_DETALLE, isVisible()).forNoMoreThan(30).seconds(),
                Scroll.hastaElElemento(TRANSFERIR).elementoVisibleEnElMedioDeLaPantalla(),
                WaitUntil.the(TRANSFERIR, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(TRANSFERIR, isEnabled()).forNoMoreThan(60).seconds(),
                Click.on(TRANSFERIR),
                Esperar.texto("Transferencias"),
                ClickEnEnlace.deNombre("Transferir a tercero"),
                Esperar.texto("Transferencia a terceros"),
                Task.where("Click",Click.on(CAMPO_NUMERO_CUENTA)).withNoReporting(),
                Enter.theValue(cu.getCuentaTercero()).into(CAMPO_NUMERO_CUENTA),
                Task.where("Click",Click.on(CAMPO_CORREO)).withNoReporting(),
                Enter.theValue(cu.getCorreo()).into(CAMPO_CORREO),
                Task.where("Click",Click.on(CAMPO_MONTO_TT)).withNoReporting(),
                Enter.theValue(cu.getMonto()).into(CAMPO_MONTO_TT),
                Task.where("Click",Click.on(CAMPO_CONCEPTO)).withNoReporting(),
                Enter.theValue(cu.getConcepto()).into(CAMPO_CONCEPTO),
                Scroll.hastaElElemento(BOTON_CONTINUAR).elementoVisibleEnElMedioDeLaPantalla(),
                Click.on(BOTON_CONTINUAR),
                Esperar.texto("¿Deseas continuar?"),
                Click.on(BOTON_ACEPTAR),
                Esperar.texto("La transferencia se realizó exitosamente"));
    }

    public static ProcesoTransferenciaTerceroCuentaNueva2 para(List<Cuentas> datos) {
        return Instrumented.instanceOf(ProcesoTransferenciaTerceroCuentaNueva2.class).withProperties(datos);
    }
}
