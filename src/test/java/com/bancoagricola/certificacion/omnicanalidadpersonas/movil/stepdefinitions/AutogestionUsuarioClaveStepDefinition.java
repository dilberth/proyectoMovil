package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Usuario;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;

import java.util.List;

public class AutogestionUsuarioClaveStepDefinition {
    @Dado("^que esta bloqueado el usuario (.*)$")
    public void queEstaBloqueadElUsuario(Usuario usuario) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ProcesoBloqueo.delUsuario(usuario));
    }

    @Cuando("^realiza proceso de desbloqueo del usuario (.*)$")
    public void realizaProcesoDeDesbloqueoDelUsuario(Usuario usuario) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ProcesoDesbloqueo.delUsuario(usuario));
    }

    @Entonces("^valida que el usuario (.*) se encuentre desbloqueado$")
    public void validaQueElUsuarioSeEncuentreDesbloqueado(Usuario usuario) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ProcesoLogueo.con(usuario));
    }

    @Cuando("^se realiza la gestion de cambio de Clave de acceso$")
    public void seRealizaLaGestionDeCambioDeClaveDeAcceso(List<String> pass) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ProcesoLogueo.con(Usuario.FELDOUSER7),
                ProcesoCambioDeClave.alUsuarioConLasClaves(pass),
                ProcesoDeDeslogueo.deLaApp());
    }

    @Entonces("^el usuario (.*) podra acceder al aplicativo correctamente$")
    public void elUsuarioProdraAccederAlAplicativoCorrectamente(Usuario usuario) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ProcesoLogueo.con(usuario));
    }

    @Cuando("^realiza la gestion de ¿Olvidaste o bloqueaste tu usuario o clave\\?$")
    public void realizaLaGestionDeOlvidasteOBloqueasteTuUsuarioOClave(List<String> informacionClaves) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ProcesoDeRecuperacionYCambioDeClave.conLaInformacion(informacionClaves));
    }
}