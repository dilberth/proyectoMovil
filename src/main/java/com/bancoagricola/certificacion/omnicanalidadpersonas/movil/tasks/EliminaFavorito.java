package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.Cuentas;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Utilidades;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.WebElement;

import java.util.*;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.UiCuentas.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Constantes.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class EliminaFavorito implements Task {

    private final List<Cuentas> datos;

    public EliminaFavorito(List<Cuentas> datos) {
        this.datos = datos;
    }

    @Step("{0} 'elimina favorito'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Cuentas cu = datos.get(0);

        actor.attemptsTo(
                Click.on(LNK_ELIMINAR_FAVORITOS));
        if (UiGenerico.elementoQueContengaElTexto(cu.getNombrefavorito()).resolveFor(actor).isVisible()) {

            actor.attemptsTo(
                    Scroll.hastaElElemento(UiGenerico.elementoQueContengaElTexto(cu.getNombrefavorito())).elementoVisibleEnElMedioDeLaPantalla(),
                    Click.on(UiGenerico.elementoQueContengaElTexto(cu.getNombrefavorito())),
                    Scroll.hastaElElemento(UiGenerico.elementoQueContengaElTexto(TXTBTN_ELIMINAR)).elementoVisibleEnElMedioDeLaPantalla(),
                    Click.on(UiGenerico.elementoQueContengaElTexto(TXTBTN_ELIMINAR)));
                    Utilidades.esperar(3);

            actor.attemptsTo(
                    WaitUntil.the(BTON_ACEPTAR, isClickable()).forNoMoreThan(15).seconds(),
                    Click.on(BTON_ACEPTAR),
                    WaitUntil.the(UiGenerico.elementoQueContengaElTexto(TXTMENSAJE_CONF4), isVisible()).forNoMoreThan(60).seconds(),
                    Ensure.that(UiGenerico.elementoQueContengaElTexto(TXTMENSAJE_CONF4)).isDisplayed(),
                    VolverInicio.click());
        } else {
            actor.attemptsTo(
                    VolverInicio.click());
        }
    }

    public static EliminaFavorito con(List<Cuentas> datos) {
        return Instrumented.instanceOf(EliminaFavorito.class).withProperties(datos);
    }
}