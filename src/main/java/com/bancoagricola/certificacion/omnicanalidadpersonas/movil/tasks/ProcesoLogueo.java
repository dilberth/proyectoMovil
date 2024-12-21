package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.ClickEn;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.Esperar;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.IngresarEn;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.*;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import net.thucydides.core.annotations.Step;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Constantes.*;

public class ProcesoLogueo implements Task {

    public Usuario usuario;

    public ProcesoLogueo(Usuario usuario) {
        this.usuario = usuario;
    }

    @Step("{0} realiza proceso de logueo")
    @Override
    public <T extends Actor> void performAs(T actor) {

        if (EstadoLogin.isEstadoLogin()) {
            actor.attemptsTo(
                    Esperar.texto("Bienvenido a la aplicación de Banco Agrícola"),
                    IngresarEn.elCampo(TXTUSUARIO).elValor(usuario.getNombreUsuario()),
                    IngresarEn.elCampo(TXTCLAVE).elValor(TXTCLAVEA),
                    ClickEn.elElemento(UiGenerico.elementoQueContengaElTexto(TXTBTN_CONTINUAR)));
            Esperar.accionLogin();
            if (UiGenerico.elementoQueContengaElTexto(TXTACTIVADISPOSITIVO).resolveFor(actor).isVisible()) {
                actor.attemptsTo(IngresarCodigoConfirmación.para());
            }
            actor.attemptsTo(
                    Esperar.pantallaDeCarga(),
                    Esperar.texto(TXTCUENTAS));
        }
        EstadoLogin.setEstadoLogin(false);

    }

    public static ProcesoLogueo con(Usuario usuario) {
        return Instrumented.instanceOf(ProcesoLogueo.class).withProperties(usuario);
    }
}