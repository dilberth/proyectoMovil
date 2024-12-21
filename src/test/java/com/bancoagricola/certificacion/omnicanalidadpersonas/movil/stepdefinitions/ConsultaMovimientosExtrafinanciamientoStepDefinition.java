package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.Cuentas;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.*;
import cucumber.api.java.es.*;
import net.serenitybdd.screenplay.ensure.*;

import java.util.*;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Constantes.*;
import static net.serenitybdd.screenplay.actors.OnStage.*;

public class ConsultaMovimientosExtrafinanciamientoStepDefinition {

    @Entonces("^valida que se muestren de forma correcta los movimientos del extrafinanciamiento$")
    public void validaQueSeMuestrenDeFormaCorrectaLosMovimientosDelExtrafinanciamiento(List<Cuentas> datos) {
        Cuentas infoCuenta = datos.get(0);

        theActorInTheSpotlight().attemptsTo(
                IrAProducto.cuenta(infoCuenta.getReferencia()).ySeleccionarLaTransaccion(TransaccionesCuentas.MOVIMIENTOS.tomarTransaccion()),
                Filtrar.movimientosPor(CrearFiltro.movimientoRangoDeFechas(infoCuenta)),
                Ensure.that(UiGenerico.elementoQueContengaElTexto(TXTNO_MOVIMIENTOS)).isNotDisplayed(),
                Esperar.lista(),
                Esperar.informacionLista(),
                Ensure.that(Utilidades.obtenerListaDeElementos(UiGenerico.listaDeInformacion("Movimientos")).size()).isGreaterThan(CERO)
        );

    }
}