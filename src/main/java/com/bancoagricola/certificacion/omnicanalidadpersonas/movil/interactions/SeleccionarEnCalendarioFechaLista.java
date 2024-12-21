package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.Cuentas;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.UiCalendario.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class SeleccionarEnCalendarioFechaLista implements Interaction {
    private List<Cuentas> datos;

    public SeleccionarEnCalendarioFechaLista(List<Cuentas> datos) {
        this.datos = datos;
    }

    @Step("{0} 'selecciona fechas en el calendario'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Cuentas ca = datos.get(0);

        actor.attemptsTo(
                WaitUntil.the(CALENDARIO_DESDE2, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(CALENDARIO_DESDE2, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(CALENDARIO_DESDE2, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(CALENDARIO_DESDE2));

        String dia1 = ca.getFechaDesde().substring(0, 2).trim();
        String mesanio1 = ca.getFechaDesde().substring(2).trim();
        String fechaActual1 = FECHA_ACTUAL1_2.resolveFor(actor).getText();

        while (!fechaActual1.equals(mesanio1)) {
            if (!fechaActual1.equals(mesanio1)) {
                FLECHA_ATRAS2.resolveFor(actor).click();
                fechaActual1 = FECHA_ACTUAL1_2.resolveFor(actor).getText();
            }
        }

        //Selecciona Dia 1
        int valordia = CAL_DIA.resolveAllFor(actor).size();
        String elemento = "";
        for (int i = 0; i < valordia; i++) {
            elemento = CAL_DIA.resolveAllFor(actor).get(i).getText();
            if (elemento.equals(String.valueOf(dia1)) && CAL_DIA.resolveAllFor(actor).get(i).isEnabled() && CAL_DIA.resolveAllFor(actor).get(i).isClickable()) {
                System.out.println("Dia seleccionado1: "+elemento);
                CAL_DIA.resolveAllFor(actor).get(i).click();
                break;
            }
        }

        actor.attemptsTo(
                WaitUntil.the(CALENDARIO_HASTA2, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(CALENDARIO_HASTA2, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(CALENDARIO_HASTA2, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(CALENDARIO_HASTA2));

        String dia2 = ca.getFechaHasta().substring(0, 2).trim();
        String mesanio2 = ca.getFechaHasta().substring(2).trim();
        String fechaActual2 = FECHA_ACTUAL2_2.resolveFor(actor).getText();

        //Selecciona Mes 2
        while (!fechaActual2.equals(mesanio2)) {
            if (!fechaActual2.equals(mesanio2)) {
                FLECHA_ATRAS2.resolveFor(actor).click();
                fechaActual2 = FECHA_ACTUAL2_2.resolveFor(actor).getText();
            }
        }

        //Selecciona Dia 2
        int valordia2 = CAL_DIA.resolveAllFor(actor).size();
        String elemento2 = "";
        for (int i = 0; i < valordia2; i++) {
            elemento2 = CAL_DIA.resolveAllFor(actor).get(i).getText();
            if (elemento2.equals(String.valueOf(dia2)) && CAL_DIA.resolveAllFor(actor).get(i).isEnabled() && CAL_DIA.resolveAllFor(actor).get(i).isClickable()) {
                System.out.println("Dia seleccionado1: "+elemento2);
                CAL_DIA.resolveAllFor(actor).get(i).click();
                break;
            }
        }
    }

    public static SeleccionarEnCalendarioFechaLista laFecha(List<Cuentas> datos) {
        return Instrumented.instanceOf(SeleccionarEnCalendarioFechaLista.class).withProperties(datos);
    }
}
