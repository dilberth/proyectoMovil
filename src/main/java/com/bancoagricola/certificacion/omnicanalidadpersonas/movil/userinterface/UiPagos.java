package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface;

import io.appium.java_client.*;
import net.serenitybdd.screenplay.targets.*;

public class UiPagos {

    public static Target pagoConFactura(){return ByTarget.the("'Pago con factura'").locatedForAndroid(MobileBy.AccessibilityId("Pago con factura")).locatedForIOS(MobileBy.AccessibilityId("Pago con factura")); }
    public static Target codigoNPE(){return ByTarget.the("'Codigo NPE'").locatedForAndroid(MobileBy.xpath("//android.widget.EditText")).locatedForIOS(MobileBy.xpath("//XCUIElementTypeTextView"));}

}
