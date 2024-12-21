package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.Cuentas;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.*;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.ensure.*;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Constantes.CERO;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Constantes.TXTNO_MOVIMIENTOS;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ConsultaMovimientosTarjetaCreditoStepDefinition {

    @Entonces("^valida los movimientos de tarjeta de crédito para una fecha especifica$")
    public void validaLosMovimientosDeTarjetaDeCréditoParaUnaFechaEspecifica(List<Cuentas> datos) {
        Cuentas infoCuenta = datos.get(0);

        theActorInTheSpotlight().attemptsTo(
                IrAProducto.tarjeta(infoCuenta.getTarjetaCredito()).ySeleccionarLaTransaccion(TransaccionesCuentas.MOVIMIENTOS.tomarTransaccion()),
                Filtrar.movimientosPor(CrearFiltro.movimientoRangoDeFechas(infoCuenta)),
                Ensure.that(UiGenerico.elementoQueContengaElTexto(TXTNO_MOVIMIENTOS)).isNotDisplayed(),
                Esperar.lista(),
                Esperar.informacionLista(),
                Ensure.that(Utilidades.obtenerListaDeElementos(UiGenerico.listaDeInformacion("Movimientos")).size()).isGreaterThan(CERO)
        );
    }
}