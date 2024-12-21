package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks.Scroll;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.*;
import net.serenitybdd.core.steps.*;
import net.serenitybdd.screenplay.*;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.waits.*;
import net.thucydides.core.annotations.*;

import java.util.*;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class VerMasPuntosBA implements Interaction {
    public String element;
    private List<Cuentas> datos;

    public VerMasPuntosBA(List<Cuentas> datos) {
        this.datos = datos;
    }

    @Step("{0} selecciona producto e ingresa a la opción")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Cuentas cu = datos.get(0);

        actor.attemptsTo(
                WaitUntil.the(UiTarjetas.menuTarjetas(), isVisible()).forNoMoreThan(30).seconds(),
                WaitUntil.the(UiTarjetas.menuTarjetas(), isClickable()).forNoMoreThan(30).seconds(),
                Click.on(UiTarjetas.menuTarjetas()),
                Scroll.hastaElElemento(UiGenerico.elementoQueContengaElTexto(cu.getAlias())),
                Click.on(UiGenerico.elementoQueContengaElTexto(cu.getAlias())));
        ScrollVertical.medio().ejecutar();
        if(!UiMenuServicios.opcionesVerMasActiva(cu.getAlias()).resolveFor(actor).isVisible()){
            actor.attemptsTo(
                    Click.on(UiGenerico.elementoQueContengaElTexto(cu.getAlias())));
        }
        actor.attemptsTo(
                Scroll.hastaElElemento(UiCuentas.opcionVerMas()));
        ScrollVertical.mini().ejecutar();
        actor.attemptsTo(
                Click.on(UiCuentas.opcionVerMas()),
                WaitUntil.the(UiCuentas.linkMasDetalles(), isVisible()).forNoMoreThan(30).seconds());
    }

    public static VerMasPuntosBA para(List<Cuentas> datos) {
        return Instrumented.instanceOf(VerMasPuntosBA.class).withProperties(datos);
    }
}