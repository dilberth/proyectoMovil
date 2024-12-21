package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks;


import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.Esperar;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.IngresarEn;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.Cuentas;
import net.serenitybdd.core.steps.*;
import net.serenitybdd.screenplay.*;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.*;
import net.thucydides.core.annotations.*;

import java.util.*;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.UiCuentas.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.UiCuentas.VER_MAS;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class ProcesoRetiroSinTarjeta implements Task {
    private final List<Cuentas> datos;

    public ProcesoRetiroSinTarjeta(List<Cuentas> datos) {
        this.datos = datos;
    }

    @Step("{0} realiza el proceso para generar código de retiro sin tarjeta")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Cuentas cu = datos.get(0);

        actor.attemptsTo(
                WaitUntil.the(MENU_CUENTAS, isEnabled()).forNoMoreThan(10).seconds(),
                WaitUntil.the(MENU_CUENTAS, isClickable()).forNoMoreThan(10).seconds(),
                Scroll.hastaElElemento(PRODUCTO(cu.getCuentaOrigen())).elementoVisibleEnElMedioDeLaPantalla(),
                Click.on(PRODUCTO(cu.getCuentaOrigen())),
                Scroll.hastaElElemento(VER_MAS).elementoVisibleEnElMedioDeLaPantalla(),
                WaitUntil.the(VER_MAS, isVisible()).forNoMoreThan(30).seconds(),
                WaitUntil.the(VER_MAS, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(VER_MAS, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(VER_MAS),
                WaitUntil.the(MAS_DETALLE, isVisible()).forNoMoreThan(30).seconds(),
                Scroll.hastaElElemento(RETIRO_SIN_TARJETA).elementoVisibleEnElMedioDeLaPantalla(),
                Click.on(RETIRO_SIN_TARJETA),
                Esperar.texto("Retirar dinero de manera rápida y segura",30),
                IngresarEn.elCampo(CAMPO_MONTO).elValor(cu.getMonto()),
                //Enter.theValue(cu.getMonto()).into(CAMPO_MONTO),
                Scroll.hastaElElemento(BOTON_GENERAR_CODIGO).elementoVisibleEnElMedioDeLaPantalla(),
                Click.on(BOTON_GENERAR_CODIGO),
                Esperar.texto("¿Deseas continuar?",30),
                Click.on(BOTON_ACEPTAR),
                Esperar.texto("La solicitud de código de retiro se realizó exitosamente", 30));

    }

    public static ProcesoRetiroSinTarjeta para(List<Cuentas> datos) {
        return Instrumented.instanceOf(ProcesoRetiroSinTarjeta.class).withProperties(datos);
    }
}
