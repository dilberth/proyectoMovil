package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils;

import io.appium.java_client.AppiumDriver;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;

public class Cerrar {

    public static void app(){
        ((AppiumDriver) ThucydidesWebDriverSupport.getProxiedDriver()).terminateApp("com.bancoagricola.bancamovil");
    }

}
