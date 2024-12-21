package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.Cuentas;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.UiCuentas;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.UiMenuPrincipal;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Coordenadas;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Utilidades;
import io.appium.java_client.touch.WaitOptions;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.waits.Wait;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.UiCuentas.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.UiMenuPrincipal.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.UiMenuPrincipal.OPC_AUDITORIA_TRX;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class IngresarAuditoriaTRX implements Interaction {
    private List<Cuentas> datos;

    public IngresarAuditoriaTRX(List<Cuentas> datos) {
        this.datos = datos;
    }

    @Step("{0} ingresa a 'Auditoria de transacciones'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Cuentas cue = datos.get(0);

        OnStage.theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(MENU_PRINCIPAL, isVisible()).forNoMoreThan(30).seconds(),
                WaitUntil.the(MENU_PRINCIPAL, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(MENU_PRINCIPAL, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(MENU_PRINCIPAL),
                WaitUntil.the(SERVICIOS, isVisible()).forNoMoreThan(30).seconds(),
                WaitUntil.the(SERVICIOS, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(SERVICIOS, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(SERVICIOS),
                WaitUntil.the(OPC_AUDITORIA_TRX, isVisible()).forNoMoreThan(30).seconds(),
                WaitUntil.the(OPC_AUDITORIA_TRX, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(OPC_AUDITORIA_TRX, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(OPC_AUDITORIA_TRX),
                WaitUntil.the(LISTA, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(LISTA, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(LISTA, isClickable()).forNoMoreThan(60).seconds());
        Utilidades.esperar(5);
        OnStage.theActorInTheSpotlight().attemptsTo(
                ClickEnEnlace.deNombre("Filtrar"),
                Esperar.texto("Período de tiempo"));
    }


    public static IngresarAuditoriaTRX para(List<Cuentas> datos) {
        return Instrumented.instanceOf(IngresarAuditoriaTRX.class).withProperties(datos);
    }
}