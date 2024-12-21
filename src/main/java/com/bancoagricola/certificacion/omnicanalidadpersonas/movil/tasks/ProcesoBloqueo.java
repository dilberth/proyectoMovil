package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.*;
import net.serenitybdd.core.steps.*;
import net.serenitybdd.screenplay.*;
import net.thucydides.core.annotations.*;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Constantes.*;

public class ProcesoBloqueo implements Task {

    public Usuario usuario;

    public ProcesoBloqueo(Usuario usuario) {
        this.usuario = usuario;
    }

    @Step("{0} realiza proceso de logueo")
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                IngresarEn.elCampo(TXTUSUARIO).elValor(usuario.getNombreUsuario()),
                IngresarEn.elCampo(TXTCLAVE).elValor("1"),
                ClickEnBoton.elElemento(TXTBTN_CONTINUAR),
                ClickEnBoton.elElemento(TXTBTN_CONTINUAR),
                ClickEnBoton.elElemento(TXTBTN_CONTINUAR),
                ClickEnBoton.elElemento(TXTBTN_CONTINUAR),
                IngresarEn.elCampo(TXTCLAVE).elValor(TXTCLAVEA),
                ClickEnBoton.elElemento(TXTBTN_CONTINUAR),
                Esperar.mensajeUsusarioBloqueado());
    }

    public static ProcesoBloqueo delUsuario(Usuario usuario) {
        return Instrumented.instanceOf(ProcesoBloqueo.class).withProperties(usuario);
    }
}