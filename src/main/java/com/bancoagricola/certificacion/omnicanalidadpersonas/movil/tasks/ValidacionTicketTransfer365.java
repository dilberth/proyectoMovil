package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.questions.VerEnPantalla;
import net.serenitybdd.core.steps.*;
import net.serenitybdd.screenplay.*;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.thucydides.core.annotations.*;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.UiCuentas.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Constantes.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Constantes.TXTID;

public class ValidacionTicketTransfer365 implements Task {

    private final List<Transferencias> datos;
    public ValidacionTicketTransfer365(List<Transferencias> datos) {
        this.datos = datos;
    }

    @Step("{0} realiza validación de ticket")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Transferencias cu = datos.get(0);

        if (cu.getTipoTRX().equals("CEL") || cu.getTipoTRX().equals("FAV_CEL")) {
            actor.attemptsTo(
                    Ensure.that(TICKET("Monto")).isDisplayed(),
                    Ensure.that(TICKET("Institución de destino")).isDisplayed(),
                    Ensure.that(TICKET("Nombre del recibidor")).isDisplayed(),
                    Ensure.that(TICKET("Correo electrónico (opcional)")).isDisplayed(),
                    Scroll.simple(),
                    Ensure.that(TICKET("Concepto")).isDisplayed(),
                    Ensure.that(TICKET("Cuenta")).isDisplayed(),
                    Scroll.simple(),
                    Ensure.that(TICKET("Estado")).isDisplayed(),
                    Ensure.that(TICKET("Fecha de ordenanza")).isDisplayed(),
                    Ensure.that(TICKET("Fecha aplicada")).isDisplayed(),
                    Scroll.simple(),
                    Ensure.that(TICKET("ID transacción")).isDisplayed());
        } else if (cu.getTipoTRX().equals("NORMAL") || cu.getTipoTRX().equals("FAV_NORMAL")) {
            actor.attemptsTo(
                    Ensure.that(TICKET("Monto")).isDisplayed(),
                    Ensure.that(TICKET("Tipo de cuenta")).isDisplayed(),
                    Ensure.that(TICKET("Institución destino")).isDisplayed(),
                    Ensure.that(TICKET("Tipo de cliente recibidor")).isDisplayed(),
                    Ensure.that(TICKET("Nombre del recibidor")).isDisplayed(),
                    Scroll.simple(),
                    Ensure.that(TICKET("Apellido del recibidor")).isDisplayed(),
                    Ensure.that(TICKET("Correo electrónico")).isDisplayed(),
                    Ensure.that(TICKET("Concepto")).isDisplayed(),
                    Ensure.that(TICKET("Cuenta")).isDisplayed(),
                    Scroll.simple(),
                    Ensure.that(TICKET("Estado")).isDisplayed(),
                    Ensure.that(TICKET("Fecha de ordenanza")).isDisplayed(),
                    Ensure.that(TICKET("Fecha aplicada")).isDisplayed(),
                    Ensure.that(TICKET("ID transacción")).isDisplayed());

        } else if (cu.getTipoTRX().equals("CA-RD") || cu.getTipoTRX().equals("FAV_CA-RD")) {
            actor.attemptsTo(
                    Ensure.that(TICKET("Monto de comisión")).isDisplayed(),
                    Ensure.that(TICKET("Cuenta")).isDisplayed(),
                    Ensure.that(TICKET("Tipo de pago")).isDisplayed(),
                    Ensure.that(TICKET("Concepto")).isDisplayed(),
                    Ensure.that(TICKET("Descripción")).isDisplayed(),
                    Scroll.simple(),
                    Ensure.that(TICKET("País del banco beneficiario")).isDisplayed(),
                    Ensure.that(TICKET("Banco beneficiario")).isDisplayed(),
                    Ensure.that(TICKET("Tipo de producto")).isDisplayed(),
                    Ensure.that(TICKET("Número de Cuenta o IBAN")).isDisplayed(),
                    Ensure.that(TICKET("Nombre completo de la persona que recibirá la transferencia.")).isDisplayed(),
                    //Ensure.that(TICKET("Número de documento de identificación de la persona que recibirá la transferencia.")).isDisplayed(),
                    //Ensure.that(TICKET("Cuidad donde se encuentra la persona que recibirá la transferencia.")).isDisplayed(),
                    //Ensure.that(TICKET("Dirección")).isDisplayed(),
                    //Ensure.that(TICKET("Estado")).isDisplayed(),
                    //Ensure.that(TICKET("Fecha de ordenanza")).isDisplayed(),
                    //Ensure.that(TICKET("Fecha aplicada")).isDisplayed(),
                    //Ensure.that(TICKET("ID transacción")).isDisplayed());
                    Scroll.simple());

        } else {
            System.out.println("Opción no válida");
        }
        actor.attemptsTo(
                Click.on(BANNER_BANCO_AGRICOLA));

    }

    public static ValidacionTicketTransfer365 elementos(List < Transferencias > datos) {
        return Instrumented.instanceOf(ValidacionTicketTransfer365.class).withProperties(datos);
    }
}