package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.*;
import net.serenitybdd.core.steps.*;
import net.serenitybdd.screenplay.*;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.thucydides.core.annotations.*;

import java.util.*;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.UiCuentas.TICKET;

public class ValidacionTicketRetiroSinTarjeta implements Task {
    private final List<Cuentas> datos;

    public ValidacionTicketRetiroSinTarjeta(List<Cuentas> datos) {
        this.datos = datos;
    }

    @Step("{0} realiza validación de ticket")
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Ensure.that(TICKET("Código de autorización")).isDisplayed(),
                Ensure.that(TICKET("Monto")).isDisplayed(),
                Ensure.that(TICKET("Cuenta de débito")).isDisplayed(),
                Scroll.hastaElElemento(TICKET("Estado")).elementoVisibleEnElMedioDeLaPantalla(),
                Ensure.that(TICKET("Estado")).isDisplayed(),
                Scroll.simple(),
                Ensure.that(TICKET("Fecha de ordenanza")).isDisplayed(),
                Ensure.that(TICKET("Fecha aplicada")).isDisplayed(),
                Ensure.that(TICKET("ID transacción")).isDisplayed());

    }

    public static ValidacionTicketRetiroSinTarjeta de(List<Cuentas> datos) {
        return Instrumented.instanceOf(ValidacionTicketRetiroSinTarjeta.class).withProperties(datos);
    }
}