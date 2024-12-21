package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks;

import net.serenitybdd.core.steps.*;
import net.serenitybdd.screenplay.*;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.thucydides.core.annotations.*;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.UiCuentas.BANNER_BANCO_AGRICOLA;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.UiCuentas.TICKET;

public class ValidacionTicketTeleton implements Task {

    @Step("{0} realiza validación de ticket")
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Ensure.that(TICKET("Monto total debitado")).isDisplayed(),
                Ensure.that(TICKET("Cuenta a abonar")).isDisplayed(),
                Ensure.that(TICKET("Nombre del destinatario")).isDisplayed(),
                Scroll.hastaElElemento(TICKET("Concepto")).elementoVisibleEnElMedioDeLaPantalla(),
                Ensure.that(TICKET("Concepto")).isDisplayed(),
                Scroll.hastaElElemento(TICKET("Cuenta a cargar")).elementoVisibleEnElMedioDeLaPantalla(),
                Ensure.that(TICKET("Cuenta a cargar")).isDisplayed(),
                Scroll.simple(),
                Ensure.that(TICKET("Estado")).isDisplayed(),
                Ensure.that(TICKET("Fecha de ordenanza")).isDisplayed(),
                Ensure.that(TICKET("Fecha aplicada")).isDisplayed(),
                Ensure.that(TICKET("ID transacción")).isDisplayed(),
                Click.on(BANNER_BANCO_AGRICOLA));
    }

    public static ValidacionTicketTeleton elementos() {
        return Instrumented.instanceOf(ValidacionTicketTeleton.class).withProperties();
    }
}