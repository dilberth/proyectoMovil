package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.BuscarEnPantalla;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Constantes;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Coordenadas;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Set;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.UiCuentas.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.UiMenuPrincipal.BANCO_AGRICOLA;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Constantes.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class ProcesoTransfer365 implements Task {
    private final List<Transferencias> datos;

    public ProcesoTransfer365(List<Transferencias> datos) {
        this.datos = datos;
    }

    @Step("{0} realiza el proceso para transfer365")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Transferencias cu = datos.get(0);

        actor.attemptsTo(
                Click.on(UiTarjetas.botonVolver()),
                WaitUntil.the(MAS_DETALLE, isVisible()).forNoMoreThan(30).seconds(),
                WaitUntil.the(MAS_DETALLE, isEnabled()).forNoMoreThan(30).seconds());

        if (cu.getTipoTRX().equals("CEL")) {
            actor.attemptsTo(
                    Scroll.hastaElElemento(OPCION_TRANSFER365_MOVIL).elementoVisibleEnElMedioDeLaPantalla(),
                    WaitUntil.the(OPCION_TRANSFER365_MOVIL, isVisible()).forNoMoreThan(30).seconds(),
                    WaitUntil.the(OPCION_TRANSFER365_MOVIL, isEnabled()).forNoMoreThan(30).seconds(),
                    WaitUntil.the(OPCION_TRANSFER365_MOVIL, isClickable()).forNoMoreThan(30).seconds(),
                    Click.on(OPCION_TRANSFER365_MOVIL),
                    Esperar.texto("Transfer365 Móvil"),
                    WaitUntil.the(LINK_TRANSFERIR_CELULAR, isEnabled()).forNoMoreThan(30).seconds(),
                    WaitUntil.the(LINK_TRANSFERIR_CELULAR, isClickable()).forNoMoreThan(30).seconds(),
                    Click.on(LINK_TRANSFERIR_CELULAR),
                    Esperar.texto("Transfer365 Móvil"),
                    SeleccionarLista.deNombre(Constantes.INSTITUCION_DE_DESTINO).laOpcion(cu.getInstitucionDestino()),
                    IngresarEn.elCampo(CAMPO_CELULAR_TT).elValor(cu.getCelular()),
                    IngresarEn.elCampo(CAMPO_NOMBRE_RECIB).elValor(cu.getNombreRecibidor()),
                    IngresarEn.elCampo(CAMPO_MONTO_TT).elValor(cu.getMonto()),
                    IngresarEn.elCampo(CAMPO_CORREO_T365).elValor(cu.getCorreo()),
                    IngresarEn.elCampo(CAMPO_CONCEPTO).elValor(cu.getConcepto()));
        } else if (cu.getTipoTRX().equals("FAV_CEL")) {
            actor.attemptsTo(
                    Scroll.hastaElElemento(OPCION_TRANSFER365_MOVIL).elementoVisibleEnElMedioDeLaPantalla(),
                    WaitUntil.the(OPCION_TRANSFER365_MOVIL, isVisible()).forNoMoreThan(30).seconds(),
                    WaitUntil.the(OPCION_TRANSFER365_MOVIL, isEnabled()).forNoMoreThan(30).seconds(),
                    WaitUntil.the(OPCION_TRANSFER365_MOVIL, isClickable()).forNoMoreThan(30).seconds(),
                    Click.on(OPCION_TRANSFER365_MOVIL),
                    Esperar.texto("Transfer365 Móvil"),
                    Scroll.hastaElElemento(UiGenerico.elementoQueContengaElTexto(cu.getNombrefavorito())).elementoVisibleEnElMedioDeLaPantalla(),
                    WaitUntil.the(UiGenerico.elementoQueContengaElTexto(cu.getNombrefavorito()), isVisible()).forNoMoreThan(30).seconds(),
                    WaitUntil.the(UiGenerico.elementoQueContengaElTexto(cu.getNombrefavorito()), isEnabled()).forNoMoreThan(30).seconds(),
                    WaitUntil.the(UiGenerico.elementoQueContengaElTexto(cu.getNombrefavorito()), isClickable()).forNoMoreThan(30).seconds(),
                    Click.on(UiGenerico.elementoQueContengaElTexto(cu.getNombrefavorito())),
                    Esperar.texto("Transfer365 Móvil"),
                    IngresarEn.elCampo(CAMPO_MONTO).elValor(cu.getMonto()),
                    IngresarEn.elCampo(CAMPO_CONCEPTO).elValor(cu.getConcepto()));
        } else if (cu.getTipoTRX().equals("NORMAL")) {
            actor.attemptsTo(
                    Scroll.hastaElElemento(OPCION_TRANSFER365).elementoVisibleEnElMedioDeLaPantalla(),
                    WaitUntil.the(OPCION_TRANSFER365, isVisible()).forNoMoreThan(30).seconds(),
                    WaitUntil.the(OPCION_TRANSFER365, isEnabled()).forNoMoreThan(30).seconds(),
                    WaitUntil.the(OPCION_TRANSFER365, isClickable()).forNoMoreThan(30).seconds(),
                    Click.on(OPCION_TRANSFER365),
                    Esperar.texto("Transferencias Transfer365: Operaciones entre bancos"),
                    WaitUntil.the(LINK_TRANSFERIR_OTRA_CUENTA, isEnabled()).forNoMoreThan(30).seconds(),
                    WaitUntil.the(LINK_TRANSFERIR_OTRA_CUENTA, isClickable()).forNoMoreThan(30).seconds(),
                    Click.on(LINK_TRANSFERIR_OTRA_CUENTA),
                    Esperar.texto("Transferencias Transfer365: Operaciones entre bancos"),
                    SeleccionarLista.conCordenadasDelNombre(TXTTIPOCUENTA, TargetApp.soIsIos()).laOpcion(cu.getTipoCuenta()),
                    SeleccionarLista.conCordenadasDelNombre(TXTINSTITUCION_DESTINO, TargetApp.soIsIos()).laOpcion(cu.getBanco()),
                    IngresarEn.elCampo(CAMPO_CUENTA_TRANSFERIR).elValor(cu.getCuentaDestino()),
                    SeleccionarLista.conCordenadasDelNombre(TXTTIPO_CLIENTE_RECIBIDOR, TargetApp.soIsIos()).laOpcion(cu.getTipoCliente()),
                    IngresarEn.elCampo(CAMPO_NOMBRE_RECIBIDOR).elValor(cu.getNombreRecibidor()),
                    Scroll.simple(),
                    IngresarEn.elCampo(CAMPO_APELLIDO_RECIBIDOR).elValor(cu.getApellidoRecibidor()),
                    IngresarEn.elCampo(CAMPO_CORREO_T365_N).elValor(cu.getCorreo()),
                    IngresarEn.elCampo(CAMPO_MONTO_T365).elValor(cu.getMonto()),
                    IngresarEn.elCampo(CAMPO_CONCEPTO).elValor(cu.getConcepto()));

        } else if (cu.getTipoTRX().equals("FAV_NORMAL")) {
            actor.attemptsTo(
                    Scroll.hastaElElemento(OPCION_TRANSFER365).elementoVisibleEnElMedioDeLaPantalla(),
                    WaitUntil.the(OPCION_TRANSFER365, isVisible()).forNoMoreThan(30).seconds(),
                    WaitUntil.the(OPCION_TRANSFER365, isEnabled()).forNoMoreThan(30).seconds(),
                    WaitUntil.the(OPCION_TRANSFER365, isClickable()).forNoMoreThan(30).seconds(),
                    Click.on(OPCION_TRANSFER365),
                    Esperar.texto("Transferencias Transfer365: Operaciones entre bancos"),
                    Scroll.hastaElElemento(UiGenerico.elementoQueContengaElTexto(cu.getNombrefavorito())).elementoVisibleEnElMedioDeLaPantalla(),
                    WaitUntil.the(UiGenerico.elementoQueContengaElTexto(cu.getNombrefavorito()), isVisible()).forNoMoreThan(30).seconds(),
                    WaitUntil.the(UiGenerico.elementoQueContengaElTexto(cu.getNombrefavorito()), isEnabled()).forNoMoreThan(30).seconds(),
                    WaitUntil.the(UiGenerico.elementoQueContengaElTexto(cu.getNombrefavorito()), isClickable()).forNoMoreThan(30).seconds(),
                    Click.on(UiGenerico.elementoQueContengaElTexto(cu.getNombrefavorito())),
                    Esperar.texto("Transferencias Transfer365: Operaciones entre bancos"),
                    Scroll.simple(),
                    IngresarEn.elCampo(CAMPO_MONTO_T365).elValor(cu.getMonto()),
                    IngresarEn.elCampo(CAMPO_CONCEPTO).elValor(cu.getConcepto()));

        } else if (cu.getTipoTRX().equals("CA-RD")) {
            actor.attemptsTo(
                    Scroll.hastaElElemento(OPCION_TRANSFER365_CARD).elementoVisibleEnElMedioDeLaPantalla(),
                    WaitUntil.the(OPCION_TRANSFER365_CARD, isVisible()).forNoMoreThan(30).seconds(),
                    WaitUntil.the(OPCION_TRANSFER365_CARD, isEnabled()).forNoMoreThan(30).seconds(),
                    WaitUntil.the(OPCION_TRANSFER365_CARD, isClickable()).forNoMoreThan(30).seconds(),
                    Click.on(OPCION_TRANSFER365_CARD),
                    Esperar.texto("Transfer365 CA-RD"),
                    WaitUntil.the(LINK_TRANSFERIR_OTRA_CUENTA, isEnabled()).forNoMoreThan(30).seconds(),
                    WaitUntil.the(LINK_TRANSFERIR_OTRA_CUENTA, isClickable()).forNoMoreThan(30).seconds(),
                    Click.on(LINK_TRANSFERIR_OTRA_CUENTA),
                    Esperar.texto("Transfer365 CA-RD"));
            //agregar llenado
            actor.attemptsTo(
                    SeleccionarLista.conCordenadasDelNombre(TXTTIPOPAGO, TargetApp.soIsIos()).laOpcion(cu.getTipoPago()),
                    IngresarEn.elCampo(MONTO).elValor(cu.getMonto()),
                    Task.where("Click", Click.on(MONTO)).withNoReporting(),
                    IngresarEn.elCampo(DESCRIPCION).elValor(cu.getDescripcion()),
                    SeleccionarLista.conCordenadasDelNombre(TXTPAISBAN_BENEFICIARIO, TargetApp.soIsIos()).laOpcion(cu.getPaisBanBen()),
                    SeleccionarLista.conCordenadasDelNombre(TXTBANCO_BENEFICIARIO, TargetApp.soIsIos()).laOpcion(cu.getBancoBen()),
                    IngresarEn.elCampo(CAMPO_CUENTA_TRANSFERIR).elValor(cu.getCuentaDestino()),
                    SeleccionarLista.conCordenadasDelNombre(TXTTIPO_CLIENTE_RECIBIDOR, TargetApp.soIsIos()).laOpcion(cu.getTipoCliente()),
                    IngresarEn.elCampo(CAMPO_NOMBRE_RECIBIDOR).elValor(cu.getNombreRecibidor()),
                    Scroll.simple(),
                    IngresarEn.elCampo(CAMPO_APELLIDO_RECIBIDOR).elValor(cu.getApellidoRecibidor()),
                    IngresarEn.elCampo(CAMPO_CORREO_T365_N).elValor(cu.getCorreo()),
                    IngresarEn.elCampo(CAMPO_MONTO_T365).elValor(cu.getMonto()),
                    IngresarEn.elCampo(CAMPO_CONCEPTO).elValor(cu.getConcepto()));

        } else if (cu.getTipoTRX().equals("FAV_CA-RD")) {
            actor.attemptsTo(
                    Scroll.hastaElElemento(OPCION_TRANSFER365_CARD).elementoVisibleEnElMedioDeLaPantalla(),
                    WaitUntil.the(OPCION_TRANSFER365_CARD, isVisible()).forNoMoreThan(30).seconds(),
                    WaitUntil.the(OPCION_TRANSFER365_CARD, isEnabled()).forNoMoreThan(30).seconds(),
                    WaitUntil.the(OPCION_TRANSFER365_CARD, isClickable()).forNoMoreThan(30).seconds(),
                    Click.on(OPCION_TRANSFER365_CARD),
                    Esperar.texto("Transfer365 CA-RD"),
                    Scroll.hastaElElemento(UiGenerico.elementoQueContengaElTexto(cu.getNombrefavorito())).elementoVisibleEnElMedioDeLaPantalla(),
                    WaitUntil.the(UiGenerico.elementoQueContengaElTexto(cu.getNombrefavorito()), isVisible()).forNoMoreThan(30).seconds(),
                    WaitUntil.the(UiGenerico.elementoQueContengaElTexto(cu.getNombrefavorito()), isEnabled()).forNoMoreThan(30).seconds(),
                    WaitUntil.the(UiGenerico.elementoQueContengaElTexto(cu.getNombrefavorito()), isClickable()).forNoMoreThan(30).seconds(),
                    Click.on(UiGenerico.elementoQueContengaElTexto(cu.getNombrefavorito())),
                    Esperar.texto("Transfer365 CA-RD"),
                    Scroll.hastaElElemento(MONTO).elementoVisibleEnElMedioDeLaPantalla(),
                    IngresarEn.elCampo(MONTO).elValor(cu.getMonto()),
                    Task.where("Click", Click.on(MONTO)).withNoReporting(),
                    IngresarEn.elCampo(DESCRIPCION).elValor(cu.getDescripcion()));

        } else {
            System.out.println("Opción no válida");
        }

        if (cu.getTipoTRX().equals("CEL") || cu.getTipoTRX().equals("FAV_CEL")) {
            actor.attemptsTo(
                    Scroll.simple(),
                    WaitUntil.the(BOTON_TRANSFERIR, isEnabled()).forNoMoreThan(30).seconds(),
                    WaitUntil.the(BOTON_TRANSFERIR, isClickable()).forNoMoreThan(30).seconds(),
                    Click.on(BOTON_TRANSFERIR),
                    Esperar.texto("¿Deseas continuar?"),
                    Scroll.simple(),
                    Click.on(BOTON_ACEPTAR),
                    Esperar.texto("Transfer365 Móvil pendiente de aplicación"));

        } else if (cu.getTipoTRX().equals("NORMAL") || cu.getTipoTRX().equals("FAV_NORMAL")) {
            actor.attemptsTo(
                    Scroll.simple(),
                    WaitUntil.the(BOTON_TRANSFERIR, isEnabled()).forNoMoreThan(30).seconds(),
                    WaitUntil.the(BOTON_TRANSFERIR, isClickable()).forNoMoreThan(30).seconds(),
                    Click.on(BOTON_TRANSFERIR),
                    Esperar.texto("¿Deseas continuar?"),
                    Scroll.simple(),
                    Click.on(BOTON_ACEPTAR),
                    Esperar.texto("Transferencia Transfer365: Operaciones entre bancos pendiente de aplicación"));

        } else if (cu.getTipoTRX().equals("CA-RD") || cu.getTipoTRX().equals("FAV_CA-RD")) {
            actor.attemptsTo(
                    Scroll.simple(),
                    Scroll.simple(),
                    Scroll.simple(),
                    //Click.on(BOTON_TRANSFERIR_CARD),
                    //ClickEnBoton.elElemento("TRANSFERIR"),
                    Esperar.texto("¿Deseas continuar?"),
                    Scroll.simple(),
                    Click.on(BOTON_ACEPTAR),
                    Esperar.texto("Transfer365 CA-RD pendiente de aplicación"));

        } else {
            System.out.println("Opción no válida");
        }
    }

    public static ProcesoTransfer365 para(List<Transferencias> datos) {
        return Instrumented.instanceOf(ProcesoTransfer365.class).withProperties(datos);
    }
}