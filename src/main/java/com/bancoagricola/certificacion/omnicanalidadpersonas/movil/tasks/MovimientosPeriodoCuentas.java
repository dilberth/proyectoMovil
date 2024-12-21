package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.Cuentas;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.*;
import net.serenitybdd.core.steps.*;
import net.serenitybdd.screenplay.*;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.ensure.*;
import net.serenitybdd.screenplay.waits.*;
import net.thucydides.core.annotations.*;

import java.util.*;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Constantes.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class MovimientosPeriodoCuentas implements Task {
    private final List<Cuentas> datos;

    public MovimientosPeriodoCuentas(List<Cuentas> datos) {
        this.datos = datos;
    }

    @Step("{0} valida movimientos")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Cuentas cu = datos.get(0);

        actor.attemptsTo(
                Esperar.texto(TXTFILTAR),
                ClickEnEnlace.deNombre(TXTFILTAR),
                WaitUntil.the(UiGenerico.elementoQueContengaElTexto(cu.getPeriodo()), isVisible()).forNoMoreThan(20).seconds(),
                Click.on(UiGenerico.elementoQueContengaElTexto(cu.getPeriodo())),
                Scroll.hastaElElemento(UiGenerico.elementoQueContengaElTexto(TXTBTNBUSCAR_MOVIMIENTOS)),
                Click.on(UiGenerico.elementoQueContengaElTexto(TXTBTNBUSCAR_MOVIMIENTOS)),
                Ensure.that(UiGenerico.elementoQueContengaElTexto(TXTNO_MOVIMIENTOS)).isNotDisplayed(),
                Esperar.lista(),
                Ensure.that(Utilidades.obtenerListaDeElementos(UiGenerico.listaDeInformacion("Movimientos")).size()).isGreaterThan(CERO)
        );

    }

    public static MovimientosPeriodoCuentas para(List<Cuentas> datos) {
        return Instrumented.instanceOf(MovimientosPeriodoCuentas.class).withProperties(datos);
    }
}