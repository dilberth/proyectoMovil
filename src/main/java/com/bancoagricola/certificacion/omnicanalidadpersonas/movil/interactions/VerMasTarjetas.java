package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.*;
import net.serenitybdd.core.steps.*;
import net.serenitybdd.screenplay.*;
import net.serenitybdd.screenplay.waits.*;
import net.thucydides.core.annotations.*;

import java.util.*;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class VerMasTarjetas implements Interaction {
    private List<Cuentas> datos;

    public VerMasTarjetas(List<Cuentas> datos) {
        this.datos = datos;
    }

    @Step("{0} selecciona producto e ingresa a la opción")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Cuentas cu = datos.get(0);

        actor.attemptsTo(
                IrAProducto.tarjeta(cu.getTarjetaCredito()).verMas(),
                WaitUntil.the(UiCuentas.linkMasDetalles(), isVisible()).forNoMoreThan(20).seconds());

    }

    public static VerMasTarjetas para(List<Cuentas> datos) {
        return Instrumented.instanceOf(VerMasTarjetas.class).withProperties(datos);
    }
}