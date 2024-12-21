package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.thucydides.core.annotations.Step;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.UiCuentas.BANNER_BANCO_AGRICOLA;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.UiCuentas.TICKET;

public class ValidacionTicketTercerosCuenta implements Task {

    @Step("{0} realiza validación de ticket")
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Ensure.that(TICKET("Monto total debitado")).isDisplayed(),
                Ensure.that(TICKET("Nombre del destinatario")).isDisplayed(),
                Ensure.that(TICKET("Número de cuenta")).isDisplayed(),
                Ensure.that(TICKET("Correo electrónico")).isDisplayed(),
                Scroll.hastaElElemento(TICKET("Concepto")).elementoVisibleEnElMedioDeLaPantalla(),
                Ensure.that(TICKET("Concepto")).isDisplayed(),
                Ensure.that(TICKET("Impuesto de Operaciones Financieras")).isDisplayed(),
                Ensure.that(TICKET("Cuenta débito")).isDisplayed(),
                Ensure.that(TICKET("Concepto")).isDisplayed(),
                Scroll.simple(),
                Ensure.that(TICKET("Estado")).isDisplayed(),
                Ensure.that(TICKET("Fecha de ordenanza")).isDisplayed(),
                Ensure.that(TICKET("Fecha aplicada")).isDisplayed(),
                Scroll.simple(),
                Ensure.that(TICKET("ID transacción")).isDisplayed(),
                Click.on(BANNER_BANCO_AGRICOLA));
    }

    public static ValidacionTicketTercerosCuenta elementos() {
        return Instrumented.instanceOf(ValidacionTicketTercerosCuenta.class).withProperties();
    }
}