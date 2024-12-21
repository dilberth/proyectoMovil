package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface;

import io.appium.java_client.*;
import net.serenitybdd.screenplay.targets.*;

public class UiMenuPrincipal {

    public static Target menuPrincipal(){return ByTarget.the("'Menu principal'").locatedForAndroid(MobileBy.AccessibilityId("main.menu.title")).locatedForIOS(MobileBy.xpath("//XCUIElementTypeStaticText[@name=\"main.menu.title\"]/parent::*"));}
    public static Target datosPersonales(){return ByTarget.the("'Datos personales'").locatedForAndroid(MobileBy.AccessibilityId("Datos personales")).locatedForIOS(MobileBy.AccessibilityId("Datos personales"));}
    public static Target actualizacionDeInformacion(){return ByTarget.the("'Actualización de información'").locatedForAndroid(MobileBy.AccessibilityId("Actualización de información")).locatedForIOS(MobileBy.AccessibilityId("Actualización de información"));}
    public static Target claveDeAcceso(){return ByTarget.the("'Clave de acceso'").locatedForAndroid(MobileBy.xpath("//*[contains(@text,'Clave de acceso')]")).locatedForIOS(MobileBy.AccessibilityId("Clave de acceso"));}
    public static Target seguridadAvanzada(){return ByTarget.the("'Seguridad avanzada'").locatedForAndroid(MobileBy.AccessibilityId("Seguridad avanzada")).locatedForIOS(MobileBy.AccessibilityId("Seguridad avanzada"));}
    public static Target notificaciones(){return ByTarget.the("'Notificaciones'").locatedForAndroid(MobileBy.AccessibilityId("Notificaciones")).locatedForIOS(MobileBy.AccessibilityId("Notificaciones"));}
    public static Target favoritos(){return ByTarget.the("'Favoritos'").locatedForAndroid(MobileBy.AccessibilityId("Favoritos")).locatedForIOS(MobileBy.AccessibilityId("Favoritos"));}
    public static Target gestionDeLimites(){return ByTarget.the("'Gestión de límites'").locatedForAndroid(MobileBy.AccessibilityId("Gestión de límites")).locatedForIOS(MobileBy.AccessibilityId("Gestión de límites"));}
    public static Target servicios(){return ByTarget.the("'Servicios'").locatedForAndroid(MobileBy.AccessibilityId("Servicios")).locatedForIOS(MobileBy.AccessibilityId("Servicios"));}
    public static Target salir(){return ByTarget.the("'Salir'").locatedForAndroid(MobileBy.AccessibilityId("Salir")).locatedForIOS(MobileBy.AccessibilityId("Salir"));}

    public static final Target BANCO_AGRICOLA = Target.the("'Menu principal'").locatedBy("//android.view.View[@text='Banco Agrícola']");
    public static final Target CLAVE_ACCESO = Target.the("'Clave de acceso'").locatedBy("//*[contains(@text,'Clave de acceso')]");

    public static Target FAVORITOS = Target.the("Favoritos")
            .locatedForAndroid(MobileBy.xpath("//*[contains(@text,'Favoritos')]")).locatedForIOS(MobileBy.xpath("//*[contains(@text,'Favoritos')]"));

    public static Target MENU = Target.the("Menu")
            .locatedForAndroid(MobileBy.xpath("//android.view.View[@content-desc='main.menu.title']")).locatedForIOS(MobileBy.xpath("//android.view.View[@content-desc='main.menu.title']"));


    //Modificaciones
    public static Target MENU_PRINCIPAL = Target.the("'...'")
            .locatedForAndroid(MobileBy.AccessibilityId("main.menu.title")).locatedForIOS(MobileBy.xpath("//XCUIElementTypeStaticText[@name='main.menu.title']/parent::*"));
    public static Target SERVICIOS = Target.the("opción 'Servicios'")
            .locatedForAndroid(MobileBy.xpath("//android.view.View[@content-desc='Servicios']/android.widget.TextView")).locatedForIOS(MobileBy.xpath(""));
    public static Target OPC_AUDITORIA_TRX = Target.the("opción 'Auditoría de transacciones'")
            .locatedForAndroid(MobileBy.AccessibilityId("Auditoría de transacciones")).locatedForIOS(MobileBy.AccessibilityId("Auditoría de transacciones"));
    public static Target VER_FILTROS_ADIC = Target.the("link 'Ver filtros adicionales'")
            .locatedForAndroid(MobileBy.xpath("//android.view.View[@content-desc='Ver filtros adicionales']/android.widget.TextView")).locatedForIOS(MobileBy.xpath(""));
    public static Target TIPO_TRX = Target.the("selector 'Tipo de transacción'")
            .locatedForAndroid(MobileBy.xpath("//*[contains(@text,'Tipo de transacción')]/following::*[1]")).locatedForIOS(MobileBy.xpath(""));
    public static Target SELECTOR_OPC(String texto) {
        return ByTarget.the("'" + texto + "'").locatedForAndroid(MobileBy.xpath("//*[contains(@text,'" + texto + "')]")).locatedForIOS(MobileBy.xpath("//*[contains(@label,'" + texto + "')]"));}
    public static Target CANAL = Target.the("selector 'Canal'")
            .locatedForAndroid(MobileBy.xpath("//*[contains(@text,'Canal')]/following::*[1]")).locatedForIOS(MobileBy.xpath(""));
    public static Target BTN_BUSCAR = Target.the("botón 'BUSCAR'")
            .locatedForAndroid(MobileBy.xpath("//android.widget.Button[contains(@text,'BUSCAR')]")).locatedForIOS(MobileBy.xpath(""));
    public static Target DESDE = Target.the("campo 'Desde'")
            .locatedForAndroid(MobileBy.xpath("(//android.widget.EditText)[1]")).locatedForIOS(MobileBy.xpath(""));
    public static Target HASTA = Target.the("campo 'Hasta'")
            .locatedForAndroid(MobileBy.xpath("(//android.widget.EditText)[2]")).locatedForIOS(MobileBy.xpath(""));
    public static Target ESTADO = Target.the("selector 'Estado'")
            .locatedForAndroid(MobileBy.xpath("//*[contains(@text,'Estado')]/following::*[1]")).locatedForIOS(MobileBy.xpath(""));
    public static Target SALIR = Target.the("opción 'Servicios'")
            .locatedForAndroid(MobileBy.xpath("//android.view.View[@content-desc='Salir']/android.widget.TextView")).locatedForIOS(MobileBy.xpath(""));
    public static Target INICIO = Target.the("titulo 'iniical'")
        .locatedForAndroid(MobileBy.xpath("//android.view.View[@text='Bienvenido a la aplicación de Banco Agrícola']")).locatedForIOS(MobileBy.xpath(""));
    public static Target BOTON_CERRAR = Target.the("botón 'CERRAR'")
            .locatedForAndroid(MobileBy.xpath("//android.widget.Button[@text='CERRAR SESIÓN']")).locatedForIOS(MobileBy.xpath(""));


}
