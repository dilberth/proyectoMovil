package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface;

import io.appium.java_client.*;
import net.serenitybdd.screenplay.targets.*;

public class UiMenuServicios {

    public static Target adquirirMiCodigoQr(){return ByTarget.the("'Adquirir mi código QR'").locatedForAndroid(MobileBy.AccessibilityId("Adquirir mi código QR")).locatedForIOS(MobileBy.AccessibilityId("Adquirir mi código QR"));}
    public static Target notificacionDeViajero(){return ByTarget.the("'Notificación de viajeros'").locatedForAndroid(MobileBy.AccessibilityId("Notificación de viajeros")).locatedForIOS(MobileBy.AccessibilityId("Notificación de viajeros"));}
    public static Target extravioDeTarjetaDeCredito(){return ByTarget.the("'Extravío de Libreta'").locatedForAndroid(MobileBy.AccessibilityId("Extravío de Libreta")).locatedForIOS(MobileBy.AccessibilityId("Extravío de Libreta"));}
    public static Target bloqueoDeTarjetaDeCredito(){return ByTarget.the("'Bloqueo de tarjeta de crédito'").locatedForAndroid(MobileBy.AccessibilityId("Bloqueo de tarjeta de crédito")).locatedForIOS(MobileBy.AccessibilityId("Bloqueo de tarjeta de crédito"));}
    public static Target reservaDeCheques(){return ByTarget.the("'Reserva de cheques'").locatedForAndroid(MobileBy.AccessibilityId("Reserva de cheques")).locatedForIOS(MobileBy.AccessibilityId("Reserva de cheques"));}
    public static Target misCodigosQr(){return ByTarget.the("'Mis códigos QR'").locatedForAndroid(MobileBy.AccessibilityId("Mis códigos QR")).locatedForIOS(MobileBy.AccessibilityId("Mis códigos QR"));}
    public static Target auditoriaDeTransacciones(){return ByTarget.the("'Auditoría de transacciones'").locatedForAndroid(MobileBy.AccessibilityId("Auditoría de transacciones")).locatedForIOS(MobileBy.AccessibilityId("Auditoría de transacciones"));}
    public static Target opcionesVerMasActiva(String text){return ByTarget.the("opcion ver mas activa del elemento "+text).locatedForAndroid(MobileBy.xpath("//*[@text='{0}']//ancestor::*[1]//parent::*//child::*[@content-desc='Ver más']")).locatedForIOS(MobileBy.xpath("//*[@label='{0}']//ancestor::*[1]//parent::*//child::*[@label='Ver más']"));}

}
