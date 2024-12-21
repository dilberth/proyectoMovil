package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.Esperar;
import cucumber.api.java.ast.Cuando;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.UiMenuPrincipal.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class CerrarSesionStepDefinition {

    @Cuando("^el usuario se encuentra logueado y cierra su sesion$")
    public void elUsuarioSeEncuentraLogueadoYCierraSuSesion() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(MENU_PRINCIPAL, isVisible()).forNoMoreThan(30).seconds(),
                WaitUntil.the(MENU_PRINCIPAL, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(MENU_PRINCIPAL, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(MENU_PRINCIPAL),
                WaitUntil.the(SALIR, isVisible()).forNoMoreThan(30).seconds(),
                WaitUntil.the(SALIR, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(SALIR, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(SALIR),
                Click.on(BOTON_CERRAR),
                Esperar.texto("Bienvenido a la aplicación de Banco Agrícola")
        );
    }


    @Entonces("^el usuario ve la pantalla de logueo$")
    public void elUsuarioVeLaPantallaDeLogueo() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(INICIO).isDisplayed());
    }

}
