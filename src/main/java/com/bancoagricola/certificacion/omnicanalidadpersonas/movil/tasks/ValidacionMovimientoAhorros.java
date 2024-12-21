package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.*;
import net.serenitybdd.core.steps.*;
import net.serenitybdd.screenplay.*;
import net.serenitybdd.screenplay.ensure.*;
import net.thucydides.core.annotations.*;

import java.util.*;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Constantes.*;

public class ValidacionMovimientoAhorros implements Task {
    private final Ahorros datosAhorros;

    public ValidacionMovimientoAhorros(List<Ahorros> datos) {
        this.datosAhorros = datos.get(0);
    }

    @Step("{0} valida que se muestren los movimientos para la cuenta seleccionada")
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                IrAProducto.ahorros(datosAhorros.getCuentaOrigen()).ySeleccionarLaTransaccion(TransaccionesCuentas.MOVIMIENTOS.tomarTransaccion()),
                Filtrar.movimientosPor(CrearFiltro.movimientoPeriodoDeTiempo(datosAhorros.getPeriodo())),
                Ensure.that(UiGenerico.elementoQueContengaElTexto(TXTNO_MOVIMIENTOS)).isNotDisplayed(),
                Esperar.informacionLista()
        );

        actor.attemptsTo(
                Ensure.that(Utilidades.obtenerListaDeElementos(UiGenerico.listaDeInformacion("Movimientos")).size()).isGreaterThan(CERO)
        );

    }

    public static ValidacionMovimientoAhorros para(List<Ahorros> datos) {
        return Instrumented.instanceOf(ValidacionMovimientoAhorros.class).withProperties(datos);
    }
}