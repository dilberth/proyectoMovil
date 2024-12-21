package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils;

import io.appium.java_client.MobileBy;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getProxiedDriver;

public class ScrollHastaTextoExacto {

    public static void elTexto(String elemento) {

        getProxiedDriver().findElement(MobileBy.AndroidUIAutomator
                ("new UiScrollable(new UiSelector().scrollable(true))" + ""
                        + ".scrollIntoView(new UiSelector().text(\"" + elemento + "\"));"));
    }
}
