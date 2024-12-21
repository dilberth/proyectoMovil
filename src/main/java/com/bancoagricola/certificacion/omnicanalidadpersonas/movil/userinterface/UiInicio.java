package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface;

import io.appium.java_client.*;
import net.serenitybdd.screenplay.targets.Target;

public class UiInicio {

    public static Target linkObtenerCodigoTelebanca(){
        return Target.the("link 'Obtener mi código por Telebanca'").located(MobileBy.AccessibilityId("Obtener mi código por Telebanca"));
    };

    public static Target CODIGO_CONFIRMACION = Target.the("campo 'Código de confirmación'")
            .locatedForAndroid(MobileBy.xpath("//android.view.View[@text='Código de confirmación']/following::*[1]")).locatedForIOS(MobileBy.xpath(""));

}
