package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.questions.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.*;
import cucumber.api.java.es.*;
import net.serenitybdd.screenplay.actors.*;

import java.util.*;

public class PagoTarjetaUniStepDefinition {

    @Dado("^que existe el favorito (.*) para el usuario (.*)$")
    public void existeEnElPagoDeTarjetasEntreBancosUsandoUNIExisteElFavorito(Favoritos favorito, Usuario usuario) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ProcesoLogueo.con(usuario)
                //CrearFavorito.paraLaTransaccion(favorito.tomarInformacionFavorito())
        );

    }

    @Cuando("^realiza el pago de tarjetas nueva entre bancos usando UNI$")
    public void realizaElPagoDeTarjetasNuevaEntreBancosUsandoUNI(List<Transferencias> informacionPago) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ProcesoPagoTarjetaUni.conLaInformacion(informacionPago)
        );
    }

    @Cuando("^realiza el pago de tarjetas guardada como favorito entre bancos usando UNI$")
    public void realizaElPagoDeTarjetasGuardadaComoFavoritoEntreBancosUsandoUNI(List<Transferencias> informacionPago) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ProcesoPagoTarjetaUni.conLaInformacion(informacionPago)
        );
    }

    @Entonces("^debo observar que la transaccion de pago de tarjeta de credito de otros bancos mediante UNI fue exitosa y el saldo fue descontado correctamente$")
    public void deboObservarQueLaTransaccionDePagoDeTarjetaDeCreditoDeOtrosBancosMedianteUNIFueExitosaYElSaldoFueDescontadoCorrectamente(List<Cuentas> informacionPago) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Esperar.texto("Pago de tarjeta UNI: Operaciones entre bancos pendiente de aplicación"),
                ValidarTicketPagoTarjetaUni.enPantalla(),
                ValidaSaldosOrigenDespues.para(informacionPago)
        );
    }

}
