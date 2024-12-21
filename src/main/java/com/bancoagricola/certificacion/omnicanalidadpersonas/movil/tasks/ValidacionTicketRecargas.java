package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.Cuentas;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.questions.*;
import net.serenitybdd.core.steps.*;
import net.serenitybdd.screenplay.*;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.*;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.UiCuentas.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Constantes.*;

public class ValidacionTicketRecargas implements Task {

    private final List<Cuentas> datos;
    public ValidacionTicketRecargas(List<Cuentas> datos) {
        this.datos = datos;
    }

    @Step("{0} realiza validación de ticket")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Cuentas cu = datos.get(0);

        if (cu.getTipoTRX().equals("NORMAL")) {
            actor.attemptsTo(
                    VerEnPantalla.elTexto(TXTCELULAR),
                    VerEnPantalla.elTexto(TXTCOMPANIA),
                    VerEnPantalla.elTexto(TXTPAQUETEMONTO),
                    //VerEnPantalla.elTexto(TXTCONCEPTO),
                    VerEnPantalla.elTexto(TXTDESDE),
                    VerEnPantalla.elTexto(TXTESTADO),
                    VerEnPantalla.elTexto(TXTFECHA_ORDENANZA),
                    VerEnPantalla.elTexto(TXTFECHA_APLICADA),
                    VerEnPantalla.elTexto(TXTID));
        } else if (cu.getTipoTRX().equals("FAV")) {
            actor.attemptsTo(
                    VerEnPantalla.elTexto(TXTCELULAR),
                    VerEnPantalla.elTexto(TXTCOMPANIA),
                    VerEnPantalla.elTexto(TXTPAQUETEMONTO),
                    VerEnPantalla.elTexto(TXTDESDE),
                    VerEnPantalla.elTexto(TXTESTADO),
                    VerEnPantalla.elTexto(TXTFECHA_ORDENANZA),
                    VerEnPantalla.elTexto(TXTFECHA_APLICADA),
                    VerEnPantalla.elTexto(TXTID));
        } else {
            System.out.println("Opción no válida");
        }

        actor.attemptsTo(
                Click.on(BANNER_BANCO_AGRICOLA));

    }

    public static ValidacionTicketRecargas elementos(List<Cuentas> datos) {
        return Instrumented.instanceOf(ValidacionTicketRecargas.class).withProperties(datos);
    }
}
