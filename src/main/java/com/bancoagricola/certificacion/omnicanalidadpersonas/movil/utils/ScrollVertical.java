package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils;

import io.appium.java_client.*;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import net.serenitybdd.screenplay.actors.*;
import net.serenitybdd.screenplay.targets.*;
import org.openqa.selenium.Dimension;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getProxiedDriver;

public class ScrollVertical {

    private static TouchAction action;
    private static Dimension size;
    private Map<String, Object> params;

    public ScrollVertical(Map<String, Object> params) {
        this.params = params;
        action = new TouchAction(getProxiedDriver());
    }

    public static PuntoScroll mini() { return new PuntoScroll(0.1);}

    public static PuntoScroll corto() {return new PuntoScroll(0.2);}

    public static PuntoScroll medio() {return new PuntoScroll(0.4);}

    public static PuntoScroll largo() {
        return new PuntoScroll(1);
    }

    public static PuntoScroll porcentaje(double porcentaje) {
        return new PuntoScroll(porcentaje);
    }

    public void ejecutar() {
        action.press(PointOption.point((int) params.get("center"), (int) params.get("top")))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(800)))
                .moveTo(PointOption.point((int) params.get("center"), (int) params.get("puntoFinal"))).release().perform();
    }


    public static class PuntoScroll {

        private Map<String, Object> params;
        private double movimiento;

        public PuntoScroll(double movimiento) {

            this.movimiento = movimiento;

            action = new TouchAction(getProxiedDriver());
            size = getProxiedDriver().manage().window().getSize();
            params = new HashMap<>();
            params.put("center", Double.valueOf(size.width / 2).intValue());

        }

        public ScrollVertical desdeAbajo() {
            params.put("puntoFinal", Double.valueOf((size.height * .9) * (1-movimiento)).intValue());
            params.put("top", Double.valueOf(size.height * .9).intValue());
            return new ScrollVertical(params);
        }

        public ScrollVertical desdeElMedio() {
            params.put("puntoFinal", Double.valueOf((size.height / 2) * (1-movimiento)).intValue());
            params.put("top", Double.valueOf(size.height / 2).intValue());
            return new ScrollVertical(params);
        }

        public void ejecutar() {
            params.put("puntoFinal", Double.valueOf((size.height / 2) * (1-movimiento)).intValue());
            params.put("top", Double.valueOf(size.height / 2).intValue());
            action.press(PointOption.point((int) params.get("center"), (int) params.get("top")))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(800)))
                    .moveTo(PointOption.point((int) params.get("center"), (int) params.get("puntoFinal")))
                    .release().perform();

        }

    }


}

