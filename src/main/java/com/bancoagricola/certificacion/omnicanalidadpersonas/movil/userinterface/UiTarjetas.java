package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface;

import io.appium.java_client.*;
import net.serenitybdd.screenplay.targets.*;

public class UiTarjetas {

    public static Target menuTarjetas(){return ByTarget.the("menú 'Tarjetas'").locatedForAndroid(MobileBy.AccessibilityId("Tarjetas")).locatedForIOS(MobileBy.AccessibilityId("Tarjetas"));}
    public static Target botonVolver(){return ByTarget.the("botón 'Volver'").locatedForAndroid(MobileBy.AccessibilityId("Volver")).locatedForIOS(MobileBy.AccessibilityId("Volver"));}
    public static Target transferenciasPuntoBaLifemiles(){return ByTarget.the("opción 'Transferencia de Puntos a LifeMiles'").locatedForAndroid(MobileBy.AccessibilityId("Transferencia de Puntos a LifeMiles")).locatedForIOS(MobileBy.AccessibilityId("Transferencia de Puntos a LifeMiles"));}
    public static Target pagarOtraTarjeta(){return ByTarget.the("'Pagar otra tarjeta'").locatedForAndroid(MobileBy.AccessibilityId("Pagar otra tarjeta")).locatedForIOS(MobileBy.AccessibilityId("Pagar otra tarjeta"));}
    public static Target pagarTarjetaATerceros(){return ByTarget.the("'Pagar tarjeta a terceros'").locatedForAndroid(MobileBy.AccessibilityId("Pagar tarjeta a terceros")).locatedForIOS(MobileBy.AccessibilityId("Pagar tarjeta a terceros"));}

    public static final Target OPCION_REDENCION_DONACION = Target.the("opción 'Redención y donación de CashBac'").located(MobileBy.AccessibilityId("Redención y donación de CashBac"));
    public static final Target OPCION_MOVIMIENTOS = Target.the("opción 'Movimientos'").located(MobileBy.AccessibilityId("Movimientos"));
    public static final Target OPCION_OTROS = Target.the("opción 'Otros'").located(MobileBy.AccessibilityId("Otros"));
    public static final Target OTROS = Target.the("'Registros de {0}'").locatedBy("//*[@text='{0}']/following::*[@class='android.view.View' and @text!='']");
    public static final Target CANTIDAD_TARJETAS_SELECCIONADAS = Target.the("'Cantidad de tarjetas seleccionadas'").locatedBy("//*[@class='android.widget.ListView']//following-sibling::*[@class='android.widget.TextView']");
    public static final Target CONSULTA_PUNTOS = Target.the("'Consulda de puntos'").locatedBy("//*[@text='Consulta de puntos']");
    public static final Target CONFIRMACION = Target.the("'La solicitud se realizó exitosamente'").locatedBy("//*[@text='La solicitud se realizó exitosamente']");

    //Actualización
    public static Target MENU_TARJETAS = Target.the("menu 'Tarjetas'")
            .locatedForAndroid(MobileBy.AccessibilityId("Tarjetas")).locatedForIOS(MobileBy.AccessibilityId("Tarjetas"));

    public static final Target VER_MAS_TARJ = Target.the("link 'Ver más tarjetas'").located(MobileBy.AccessibilityId("Ver más tarjetas"));
    public static final Target PRODUCTOABONAR = Target.the("'Producto a abonar'")
            .locatedBy("//*[@text='Producto a abonar']");



}
