package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.CerrarSesion;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.Cuentas;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.InformacionCobroAmigo;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.InformacionPagoAmigo;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Usuario;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;

import java.util.List;

public class PagoCobroAmigoStepDefinitions {
    @Cuando("^realiza el proceso de Cobro a un amigo$")
    public void realizaElProcesoDeCobroAUnAmigo(List<Cuentas> datos) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ProcesoCobroAmigo.conLaInformacion(datos));
    }

    @Entonces("^el sistema le informa que la solicitud de cobro fue enviada de manera exitosa$")
    public void elSistemaLeInformaQueLaSolicitudDeCobroFueEnviadaDeManeraExitosa() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ValidacionTicketCobroAUnAmigo.elementos()
        );
    }

    @Dado("^que el usuario (.*) envia una solicitud de pago$")
    public void queElUsuarioPRIVADOEnviaUnaSolicitudDePago(Usuario usuario, List<InformacionCobroAmigo> cobroAmigo) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ProcesoLogueo.con(usuario),
                //ProcesoCobroAmigo.conLaInformacion(cobroAmigo),
                CerrarSesion.actual()
        );
    }

    @Entonces("^el usuario (.*) realiza el pago a su amigo$")
    public void elUsuarioPRIVADORealizaElPagoASuAmigo(Usuario usuario, List<InformacionPagoAmigo> pagoAmigo) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ProcesoLogueo.con(usuario),
                ProcesoPagoAmigo.conLaInformacion(pagoAmigo)
        );
    }

    @Entonces("^el sistema le informa que la solicitud de pago fue realizada de manera exitosa$")
    public void elSistemaLeInformaQueLaSolicitudDePagoFueRealizadaDeManeraExitosa() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ValidacionTicketPagoAUnAmigo.elementos()
        );
    }
}
