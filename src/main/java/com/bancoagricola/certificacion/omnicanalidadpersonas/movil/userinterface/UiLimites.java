package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface;

import io.appium.java_client.*;
import net.serenitybdd.screenplay.targets.*;

public class UiLimites {

    public static Target getLimiteAcumulableSemanal(String var){
        return ByTarget.the("'Límite acumulable semanal'").locatedForAndroid(MobileBy.xpath("//*[@text='"+var+"']/following::*[3]")).locatedForIOS(MobileBy.xpath("(//*[@label='"+var+"'])[1]/following::XCUIElementTypeStaticText[not(contains(@label,'$'))][1]"));
    }
    public static Target getLimitePorTransaccion(String var){
        return ByTarget.the("'Límite por transacción'").locatedForAndroid(MobileBy.xpath("//*[@text='"+var+"']/following::*[6]")).locatedForIOS(MobileBy.xpath("(//*[@label='"+var+"'])[1]/following::XCUIElementTypeStaticText[not(contains(@label,'$'))][1]"));
    }

}
