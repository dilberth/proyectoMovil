package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.*;
import io.appium.java_client.*;
import io.appium.java_client.touch.*;
import io.appium.java_client.touch.offset.*;
import net.serenitybdd.screenplay.actors.*;
import org.openqa.selenium.*;

import java.time.*;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.*;

public class BuscarEnPantalla {

    public static boolean elTexto(String texto) {

        int contador = 0;
        Dimension size = getProxiedDriver().manage().window().getSize();
        int width = size.width;
        int height = size.height;
        int middleOfX = width / 2;
        int startYCoordinate = (int) (height * .8);
        int endYCoordinate = (int) (height * .4);
        TouchAction action = new TouchAction(getProxiedDriver());
        while (!UiGenerico.elementoDeTexto(texto).resolveFor(OnStage.theActorInTheSpotlight()).isVisible()) {
            if (contador++ > 2) {
                return false;
            }
            action.press(PointOption.point(middleOfX, startYCoordinate))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                    .moveTo(PointOption.point(middleOfX, endYCoordinate)).release().perform();
        }

        return true;
    }

}


