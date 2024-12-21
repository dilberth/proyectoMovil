package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.Esperar;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.IngresarEn;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.Cuentas;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.*;
import net.serenitybdd.core.steps.*;
import net.serenitybdd.screenplay.*;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.waits.*;
import net.thucydides.core.annotations.*;

import java.util.*;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.UiCuentas.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class ProcesoTransferenciaCP implements Task {
    private final List<Cuentas> datos;
    public ProcesoTransferenciaCP(List<Cuentas> datos) {
        this.datos = datos;
    }

    @Step("{0} realiza el proceso de transferencia")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Cuentas cu = datos.get(0);

        actor.attemptsTo(
                Click.on(UiTarjetas.botonVolver()),
                WaitUntil.the(MAS_DETALLE, isVisible()).forNoMoreThan(30).seconds(),
                WaitUntil.the(MAS_DETALLE, isEnabled()).forNoMoreThan(30).seconds(),
                Scroll.hastaElElemento(TRANSFERIR).elementoVisibleEnElMedioDeLaPantalla(),
                WaitUntil.the(TRANSFERIR, isVisible()).forNoMoreThan(30).seconds(),
                WaitUntil.the(TRANSFERIR, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(TRANSFERIR, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(TRANSFERIR),
                Esperar.texto("Transferencias"),
                Scroll.hastaElElemento(SEL_CUENTA(cu.getCuentaDestino())).elementoVisibleEnElMedioDeLaPantalla(),
                WaitUntil.the(SEL_CUENTA(cu.getCuentaDestino()), isVisible()).forNoMoreThan(30).seconds(),
                WaitUntil.the(SEL_CUENTA(cu.getCuentaDestino()), isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(SEL_CUENTA(cu.getCuentaDestino()), isClickable()).forNoMoreThan(30).seconds(),
                Click.on(SEL_CUENTA(cu.getCuentaDestino())),
                Esperar.texto("Transferencia Cuentas Propias"),
                IngresarEn.elCampo(CAMPO_MONTO).elValor(cu.getMonto()),
                IngresarEn.elCampo(CAMPO_CONCEPTO).elValor(cu.getConcepto()),
                Click.on(BOTON_TRANSFERIR));
        if (cu.getTipoTRX().equals("CA") || cu.getTipoTRX().equals("CC")) {
            actor.attemptsTo(
                    Esperar.texto("La transferencia se realizó exitosamente"));
        } else if (cu.getTipoTRX().equals("TDC")) {
            actor.attemptsTo(
                    Esperar.texto("¿Deseas continuar?"),
                    Click.on(BOTON_ACEPTAR),
                    Esperar.texto("La transferencia se realizó exitosamente"));
        } else {
            System.out.println("Opción no válida");
        }
    }

    public static ProcesoTransferenciaCP para(List<Cuentas> datos) {
        return Instrumented.instanceOf(ProcesoTransferenciaCP.class).withProperties(datos);
    }
}
