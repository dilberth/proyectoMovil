package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.ClickEnEnlace;
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

public class ProcesoTransferenciaTerceroCuentaNueva implements Task {
    private final List<Cuentas> datos;

    public ProcesoTransferenciaTerceroCuentaNueva(List<Cuentas> datos) {
        this.datos = datos;
    }

    @Step("{0} realiza el proceso de transferencia a una cuenta de tercero")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Cuentas cu = datos.get(0);

        actor.attemptsTo(
                WaitUntil.the(MENU_CUENTAS, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(MENU_CUENTAS, isClickable()).forNoMoreThan(30).seconds(),
                Scroll.hastaElElemento(PRODUCTO(cu.getCuentaOrigen())).elementoVisibleEnElMedioDeLaPantalla(),
                Click.on(PRODUCTO(cu.getCuentaOrigen())),
                Scroll.hastaElElemento(VER_MAS).elementoVisibleEnElMedioDeLaPantalla(),
                WaitUntil.the(VER_MAS, isVisible()).forNoMoreThan(30).seconds(),
                WaitUntil.the(VER_MAS, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(VER_MAS, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(VER_MAS),
                WaitUntil.the(MAS_DETALLE, isVisible()).forNoMoreThan(30).seconds(),
                WaitUntil.the(MAS_DETALLE, isEnabled()).forNoMoreThan(30).seconds(),
                Scroll.hastaElElemento(TRANSFERIR).elementoVisibleEnElMedioDeLaPantalla(),
                WaitUntil.the(TRANSFERIR, isVisible()).forNoMoreThan(30).seconds(),
                WaitUntil.the(TRANSFERIR, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(TRANSFERIR, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(TRANSFERIR),
                Esperar.texto("Transferencias"),
                ClickEnEnlace.deNombre("Transferir a tercero"),
                Esperar.texto("Transferencia a terceros"),
                IngresarEn.elCampo(CAMPO_NUMERO_CUENTA).elValor(cu.getCuentaTercero()),
                IngresarEn.elCampo(CAMPO_CORREO).elValor(cu.getCorreo()),
                IngresarEn.elCampo(CAMPO_MONTO_TT).elValor(cu.getMonto()),
                IngresarEn.elCampo(CAMPO_CONCEPTO).elValor(cu.getConcepto()),
                Scroll.simple(),
                Click.on(BOTON_CONTINUAR),
                Esperar.texto("¿Deseas continuar?"),
                Click.on(BOTON_ACEPTAR));

    }

    public static ProcesoTransferenciaTerceroCuentaNueva para(List<Cuentas> datos) {
        return Instrumented.instanceOf(ProcesoTransferenciaTerceroCuentaNueva.class).withProperties(datos);
    }
}
