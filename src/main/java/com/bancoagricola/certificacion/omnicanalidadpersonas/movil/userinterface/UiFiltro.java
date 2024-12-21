package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface;

import io.appium.java_client.*;
import net.serenitybdd.screenplay.targets.*;

public class UiFiltro {

    public static Target elemento(String elemento){
        return ByTarget.the("'"+elemento+"'").locatedForAndroid(MobileBy.xpath("//android.widget.TextView[@text='"+elemento+"']")).locatedForIOS(MobileBy.xpath("//android.widget.TextView[@label='"+elemento+"']"));
    };
    public static Target rango(String rango){
        return ByTarget.the("'Rango "+rango+"'").locatedForAndroid(MobileBy.xpath("//*[@text='"+rango+"']//following::*[1]//child::*[contains(@class,'Edit')]")).locatedForIOS(MobileBy.xpath("//*[@label=\""+rango+"\"]//following-sibling::*[@type='XCUIElementTypeTextField'][1]"));
    };

}
