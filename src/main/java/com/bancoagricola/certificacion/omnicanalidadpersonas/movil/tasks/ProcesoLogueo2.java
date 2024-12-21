package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.IngresarEn;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.Cuentas;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Ambiente;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Usuario;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.UiCuentas.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Ambiente.QA;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Constantes.CLAVE_QA;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Constantes.TXTCLAVE;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ProcesoLogueo2 implements Task {

    private final List<Cuentas> datos;

    public ProcesoLogueo2(List<Cuentas> datos) {
        this.datos = datos;
    }

    @Step("{0} realiza proceso de logueo")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Cuentas cu = datos.get(0);

        actor.attemptsTo(
                WaitUntil.the(BIENVENIDO, isVisible()).forNoMoreThan(30).seconds(),
                Enter.theValue(cu.getUsuario()).into(CAMPO_USUARIO));
        if (cu.getAmbiente().equals("QA")) {
            actor.attemptsTo(
                    Click.on(CAMPO_CLAVE),
                    Enter.theValue("Agricola2$").into(CAMPO_CLAVE));
        }


        /*
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
                    //WaitUntil.the(MENU_CUENTAS, isEnabled()).forNoMoreThan(60).seconds());
        }
        EstadoLogin.setEstadoLogin(false);

         */
    }

    public static ProcesoLogueo2 con(List<Cuentas> datos) {
        return Instrumented.instanceOf(ProcesoLogueo2.class).withProperties(datos);
    }
}