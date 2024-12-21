package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.*;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.ensure.*;
import net.thucydides.core.annotations.Step;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Constantes.CERO;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Constantes.TXTNO_MOVIMIENTOS;

public class ValidacionMovimientoFechaAhorros implements Task {
    private final List<Ahorros> datos;

    public ValidacionMovimientoFechaAhorros(List<Ahorros> datos) {
        this.datos = datos;
    }

    @Step("{0} valida que se muestren los movimientos para la cuenta seleccionada")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Ahorros cu = datos.get(0);

        actor.attemptsTo(
                IrAProducto.ahorros(cu.getCuentaOrigen()).ySeleccionarLaTransaccion(TransaccionesCuentas.MOVIMIENTOS.tomarTransaccion()),
                Filtrar.movimientosPor(CrearFiltro.movimientoRangoDeFechas(cu)),
                Ensure.that(UiGenerico.elementoQueContengaElTexto(TXTNO_MOVIMIENTOS)).isNotDisplayed(),
                Esperar.lista(),
                Esperar.informacionLista(),
                Ensure.that(Utilidades.obtenerListaDeElementos(UiGenerico.listaDeInformacion("Movimientos")).size()).isGreaterThan(CERO)
        );

    }

    public static ValidacionMovimientoFechaAhorros para(List<Ahorros> datos) {
        return Instrumented.instanceOf(ValidacionMovimientoFechaAhorros.class).withProperties(datos);
    }
}