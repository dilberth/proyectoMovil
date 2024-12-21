package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.*;
import io.appium.java_client.android.AndroidDriver;
import net.serenitybdd.screenplay.*;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.*;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.WebElement;

import java.util.*;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.UiCuentas.BTN_ACEPTAR;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class ProcesoTransferencia365Movil implements Task {

    private final Transferencias infoTransferencia;

    public ProcesoTransferencia365Movil(List<Transferencias> datos) {
        this.infoTransferencia = datos.get(0);
    }

    public ProcesoTransferencia365Movil(Transferencias datos) {
        this.infoTransferencia = datos;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                IrAProducto.cuenta(infoTransferencia.getCuentaOrigen()).ySeleccionarLaTransaccion(TransaccionesCuentas.TRANSFER365_MOVIL.tomarTransaccion()),
                Check.whether(infoTransferencia.getNombrefavorito().isEmpty())
                        .otherwise(
                                ClickEn.elElemento(UiGenerico.elementoDeTexto(infoTransferencia.getNombrefavorito())),
                                Esperar.texto("Transfer365 Móvil")
                        )
                        .andIfSo(
                                ClickEn.elElemento(UiGenerico.accesibilityId("Transferir a un número de celular")),
                                Esperar.texto("Transfer365 Móvil"),
                                SeleccionarLista.deNombre(Constantes.INSTITUCION_DE_DESTINO).laOpcion(infoTransferencia.getInstitucionDestino()),
                                IngresarEn.elCampo(Constantes.TXTCELULAR).elValor(infoTransferencia.getCelular()),
                                IngresarEn.elCampo(Constantes.TXTNOMBRE_RECIBIDOR).elValor(infoTransferencia.getNombreRecibidor()),
                                IngresarEn.elCampo(Constantes.CORREO_OPCIONAL).elValor(infoTransferencia.getCorreo())
                        ),

                IngresarEn.elCampo(Constantes.TXTMONTO).elValor(infoTransferencia.getMonto()),
                IngresarEn.elCampo(Constantes.TXTCONCEPTO).elValor(infoTransferencia.getConcepto()));
        ClickEnBoton.elElemento(Constantes.TXTBTN_TRANSF).performAs(actor);
        AndroidDriver<WebElement> androidDriver = ((AndroidDriver<WebElement>) ((WebDriverFacade) getDriver()).getProxiedDriver());
        Set<String> contextNames = androidDriver.getContextHandles();
        for (String contextName : contextNames) {
            System.out.println("contextNames: " + contextName);
            System.out.println("contextNames: " + contextNames);
        }
        androidDriver.context("NATIVE_APP");
        Scroll.simple().performAs(actor);
        Click.on(BTN_ACEPTAR).performAs(actor);
        Esperar.texto("Transfer365 Móvil pendiente de aplicación").performAs(actor);
    }

    public static ProcesoTransferencia365Movil conLaInformacion(List<Transferencias> datos) {
        return Tasks.instrumented(ProcesoTransferencia365Movil.class, datos);
    }

    public static ProcesoTransferencia365Movil conLaInformacion(Transferencias datos) {
        return Tasks.instrumented(ProcesoTransferencia365Movil.class, datos);
    }


}
