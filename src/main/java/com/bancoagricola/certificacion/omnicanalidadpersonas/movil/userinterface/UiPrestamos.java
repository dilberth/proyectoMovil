package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface;

import io.appium.java_client.*;
import net.serenitybdd.screenplay.targets.*;

public class UiPrestamos {

    public static Target pagarOtrosPrestamo(){return ByTarget.the("'Pagar otro prestamo'").locatedForAndroid(MobileBy.AccessibilityId("Pagar otro préstamo")).locatedForIOS(MobileBy.AccessibilityId("Pagar otro préstamo"));
    }
    public static Target pagarPrestamoTerceros(){return ByTarget.the("'Pagar prestamo a terceros'").locatedForAndroid(MobileBy.AccessibilityId("Pagar préstamo a terceros")).locatedForIOS(MobileBy.AccessibilityId("Pagar préstamo a terceros"));}

}
