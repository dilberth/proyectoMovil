package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Utilidades;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import net.serenitybdd.core.steps.*;
import net.serenitybdd.screenplay.*;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.ClickOnElement;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.*;
import net.thucydides.core.annotations.*;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.*;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.UiCuentas.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Boton.CONTINUAR;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Constantes.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class CreacionMeta implements Task {
    private final List<Ahorros> meta;

    public CreacionMeta(List<Ahorros> meta) {
        this.meta = meta;
    }

    @Step("{0} realiza el proceso para añadir meta")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Ahorros aho = meta.get(0);

        actor.attemptsTo(
                WaitUntil.the(UiCuentas.menuCuentas(), isVisible()).forNoMoreThan(20).seconds(),
                ClickEn.elElemento(UiAhorros.menuMetas()),
                ClickEn.elElemento(UiGenerico.elementoQueContengaElTexto(TXTANADE_META)),
                ClickEn.elElemento(UiGenerico.boton(TXTBTN_CONTINUAR)),
                WaitUntil.the(UiGenerico.elementoQueContengaElTexto(TXTNOMBRE_META), isCurrentlyVisible()),
                IngresarEn.elCampo(TXTNOMBRE_META).elValor(aho.getNombreMeta()),
                IngresarEn.elCampo(MONTO_TOTAL_DE_META).elValor(aho.getMontoMeta()),
                IngresarEn.elCampo(TXTPLAZO_META).elValor(aho.getPlazoMeta()),
                SeleccionarLista.conCordenadasDelNombre(TXTDIA_RETENCION).laOpcion(aho.getDiaRetencion()),
                SeleccionarLista.conCordenadasDelNombre(TXTCUENTA_A_RELACIONAR).laOpcion(aho.getCuentaARelacionar()),
                ClickEn.elElemento(UiGenerico.elementoQueContengaElTexto(TXTCREAR)));
                Utilidades.esperar(5);
        actor.attemptsTo(
                ClickEn.elElemento(BTN_CONTINUAR).cantidadDeClicks(1),
                //Click.on(BTN_CONTINUAR),
                Esperar.pantallaDeCarga(),
                Ensure.that(UiGenerico.elementoQueContengaElTexto(TXT_MENSAJE_CONFIRMACION_META).waitingForNoMoreThan(Duration.ofSeconds(60))).isDisplayed()
        );

    }

    public static CreacionMeta para(List<Ahorros> meta) {
        return Instrumented.instanceOf(CreacionMeta.class).withProperties(meta);
    }
}
