package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks;

import net.serenitybdd.core.steps.*;
import net.serenitybdd.screenplay.*;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.thucydides.core.annotations.*;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.UiCuentas.BANNER_BANCO_AGRICOLA;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.UiCuentas.TICKET;

public class ValidacionTicketCP implements Task {

    @Step("{0} realiza validación de ticket")
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Ensure.that(TICKET("Monto total debitado")).isDisplayed(),
                Ensure.that(TICKET("Cuenta crédito")).isDisplayed(),
                Ensure.that(TICKET("Concepto")).isDisplayed(),
                Ensure.that(TICKET("Desde")).isDisplayed(),
                Scroll.simple(),
                Ensure.that(TICKET("Estado")).isDisplayed(),
                Ensure.that(TICKET("Fecha de ordenanza")).isDisplayed(),
                Ensure.that(TICKET("Fecha aplicada")).isDisplayed(),
                Scroll.simple(),
                Ensure.that(TICKET("ID transacción")).isDisplayed(),
                Click.on(BANNER_BANCO_AGRICOLA));
    }

    public static ValidacionTicketCP elementos() {
        return Instrumented.instanceOf(ValidacionTicketCP.class).withProperties();
    }
}