package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.*;
import net.serenitybdd.screenplay.*;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Constantes.*;

public class ProcesoDesbloqueo implements Task {

    private final Usuario usuario;

    public ProcesoDesbloqueo(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                ClickEn.elElemento(UiGenerico.elementoDeTexto(TXTOLVIDASTE)),
                IngresarEn.elCampo(TXTUSUARIO).elValor(usuario.getNombreUsuario()),
                ClickEnBoton.elElemento(TXTBTN_CONTINUAR),
                Esperar.texto(TXTDESBLOQUEAR_USUARIO),
                ClickEnBoton.elElemento(TXTDESBLOQUEAR_USUARIO),
                Esperar.pantallaDeCarga(),
                ClickEn.elElemento(UiGenerico.elementoDeTexto(TXTOBTENERCODIGO)),
                Esperar.texto(TXTCODIGOCONF),
                IngresarEn.elCampo(TXTCODIGOCONF).elValor(TXTCODIGO),
                ClickEnBoton.elElemento(TXTBTN_CONTINUAR),
                Esperar.pantallaDeCarga(),
                Esperar.mensajeUsusarioDesbloqueado(),
                ClickEnBoton.elElemento(TXTBTN_ACEPTAR)
        );
    }

    public static ProcesoDesbloqueo delUsuario(Usuario usuario) {
        return Tasks.instrumented(ProcesoDesbloqueo.class, usuario);
    }
}