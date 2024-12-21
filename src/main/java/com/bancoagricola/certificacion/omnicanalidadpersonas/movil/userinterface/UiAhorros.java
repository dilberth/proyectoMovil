package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface;

import io.appium.java_client.*;
import net.serenitybdd.screenplay.targets.*;

public class UiAhorros {

    //todo cambio de Ahorros por Metas
    public static Target menuMetas(){
        return ByTarget.the("menú 'Metas'").locatedForAndroid(MobileBy.AccessibilityId("Metas")).locatedForIOS(MobileBy.AccessibilityId("Metas"));
    }
    
    public static Target meta(String info){
        return ByTarget.the("'Meta'").locatedForAndroid(MobileBy.xpath("//*[@text='"+info+"']/following::*[5]")).locatedForIOS(MobileBy.xpath("//*[@label='"+info+"']/following::*[@label='Meta']"));
    }

    public static Target numeroDeCuenta(String info){
        return ByTarget.the("'Número de cuenta'").locatedForAndroid(MobileBy.xpath("//*[@text='"+info+"']/following::*[1]")).locatedForIOS(MobileBy.xpath("//XCUIElementTypeStaticText[@name='"+info+"']"));
    }
    
    public static Target linkModificar(){
        return ByTarget.the("link 'Modificar'").locatedForAndroid(MobileBy.AccessibilityId("Modificar")).locatedForIOS(MobileBy.AccessibilityId("Modificar"));
    }
    
    public static Target linkEliminar(){
        return ByTarget.the("link 'Eliminar'").locatedForAndroid(MobileBy.AccessibilityId("Eliminar")).locatedForIOS(MobileBy.AccessibilityId("Eliminar"));
    }
    
    public static Target botonAportar(){
        return ByTarget.the("opción 'Aportar'").locatedForAndroid(MobileBy.AccessibilityId("Aportar")).locatedForIOS(MobileBy.AccessibilityId("Aportar"));
    }
    
    public static Target botonRetirar(){
        return ByTarget.the("opción 'Retirar'").locatedForAndroid(MobileBy.AccessibilityId("Retirar")).locatedForIOS(MobileBy.AccessibilityId("Retirar"));
    }

    public static Target detMontoAcumulado(String info){
        return ByTarget.the("'Monto acumulado'").locatedForAndroid(MobileBy.xpath("//*[@text='"+info+"']/following::*[7]")).locatedForIOS(MobileBy.xpath("//*[@label='"+info+"']/following::*[7]"));
    }

    //Actualización

    public static Target MENU_METAS = Target.the("menu 'Metas'")
            .locatedForAndroid(MobileBy.AccessibilityId("Metas")).locatedForIOS(MobileBy.AccessibilityId("Metas"));



}
