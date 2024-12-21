package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface;

import io.appium.java_client.*;
import net.serenitybdd.screenplay.targets.*;

public class UiGenerico {

    public static Target lista() {
        return ByTarget.the("'lista de elementos'").locatedForAndroid(MobileBy.xpath("//android.view.View")).locatedForIOS(MobileBy.xpath(""));
    }

    public static Target elementoQueContengaElTexto(String texto) {
        return ByTarget.the("'" + texto + "'").locatedForAndroid(MobileBy.xpath("(//*[contains(@text,'" + texto + "')])[1]")).locatedForIOS(MobileBy.xpath("//*[contains(@label,'" + texto + "')]"));
    }

    public static Target campoSelector(String texto) {
        return ByTarget.the("'" + texto + "'").locatedForAndroid(MobileBy.xpath("//*[@text='" + texto + "']/following::*[1]")).locatedForIOS(MobileBy.xpath("//*[@label='" + texto + "']/following::*[1]"));
    }

    public static Target campoSelector3(String texto) {
        return ByTarget.the("'" + texto + "'").locatedForAndroid(MobileBy.xpath("//*[@text='" + texto + "']/preceding::*[1]")).locatedForIOS(MobileBy.xpath("//*[@label='" + texto + "']/preceding::*[1]"));
    }

    public static Target campoEditableDespuesDelTexto(String texto) {
        return ByTarget.the("'" + texto + "'").locatedForAndroid(MobileBy.xpath("//*[@text='" + texto + "']/following::android.widget.EditText[1]")).locatedForIOS(MobileBy.xpath("//XCUIElementTypeSecureTextField"));
    }

    public static Target elementoDeTexto(String texto) {
        return ByTarget.the("'" + texto + "'").locatedForAndroid(MobileBy.xpath("(//*[@text='" + texto + "'])[last()]")).locatedForIOS(MobileBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == \""+texto+"\"`]"));
    }

    public static Target elementoDeTextoMayusMin(String texto) {
        return ByTarget.the("'" + texto + "'").locatedForAndroid(MobileBy.xpath("(//*[@text='" + texto.toUpperCase() + "' or @text='" + texto + "'])[last()]")).locatedForIOS(MobileBy.xpath("(//*[@label=\"" + texto + "\" or @label=\"" + texto + "\"])[last()]"));
    }

    public static Target selectorFormulario(String texto) {
        return ByTarget.the("'" + texto + "'").locatedForAndroid(MobileBy.xpath("(descendant-or-self::*[@text='" + texto + "' or @content-desc='?'][1])//following::*[not(@content-desc)][1]")).locatedForIOS(MobileBy.xpath("(//*[@label=\"" + texto + "\"]//following::*[1])[@visible=\"true\"]"));
    }

    public static Target campoEditableFormulario(String texto) {
        return ByTarget.the("'" + texto + "'").locatedForAndroid(MobileBy.xpath("(descendant-or-self::*[@text='" + texto + "' or @text='" + texto + "' or @text='" + texto + "?' or @text='" + texto + " ?'])//following::*[contains(@class,'Edit') and (@text='' or not(@text=''))][1]")).locatedForIOS(MobileBy.xpath("//*[@label='" + texto + "']//following::*[@type='XCUIElementTypeTextView' or @type='XCUIElementTypeTextField' or @type='XCUIElementTypeSecureTextField'][1]"));
    }

    public static Target campoEditableFormularioNumero(String texto, int numero) {
        return ByTarget.the("'" + texto + "'").locatedForAndroid(MobileBy.xpath("(descendant-or-self::*[@text='" + texto + "' or @text='" + texto + "' or @text='" + texto + "?' or @text='" + texto + " ?' or @content-desc='?'])//following::*[contains(@class,'Edit') and (@text='' or not(@text=''))][" + numero + "]")).locatedForIOS(null);
    }

    public static Target boton(String texto) {
        return ByTarget.the("'" + texto + "'").locatedForAndroid(MobileBy.xpath("//android.widget.Button[@text='" + texto + "']")).locatedForIOS(MobileBy.AccessibilityId(texto));
    }

    public static Target listaDeInformacion(String texto) {
        return ByTarget.the("'" + texto + "'").locatedForAndroid(MobileBy.xpath("(//*[@class='android.widget.ListView'])[2]//*")).locatedForIOS(MobileBy.xpath("//XCUIElementTypeOther[@name=\"article\"]/XCUIElementTypeOther[4]//*"));
    }

    public static Target radioButton(String texto) {
        return ByTarget.the("'" + texto + "'").locatedForAndroid(MobileBy.xpath("//*[@text='" + texto + "']//preceding::*[1]")).locatedForIOS(MobileBy.AccessibilityId(texto));
    }

    public static Target informacionDe(String texto) {
        return ByTarget.the("Informacion del elemento '" + texto + "'").locatedForAndroid(MobileBy.xpath("(//*[@text='" + texto + "']//..//*[@text])[position()>1]")).locatedForIOS(MobileBy.xpath("//*[@type='XCUIElementTypeStaticText' and @label=\"" + texto + "\"]/../following-sibling::*//*[@type=\"XCUIElementTypeStaticText\"]"));
    }

    public static Target informacionDePantalla() {
        return ByTarget.the("Informacion de la pantalla").locatedForAndroid(MobileBy.xpath("//*[@text!='']")).locatedForIOS(MobileBy.xpath("//*[@label!='' and @visible='true']"));
    }

    public static Target accesibilityId(String id) {
        return ByTarget.the("'" + id + "'").located(MobileBy.AccessibilityId(id));
    }

    public static Target id(String id) {
        return ByTarget.the("'" + id + "'").located(MobileBy.id(id));
    }

    //Movimientos Cuentas
    public static final Target CANTIDAD_MOVIMIENTOS_CUENTAS = Target.the("'Movimientos'").locatedBy("//*[@class='android.widget.ListView']//child::*[@class='android.widget.TextView' and @text!='Otros' and @text!='Movimientos']");

    //Movimientos Ahorros
    public static final Target CANTIDAD_MOVIMIENTOS_AHORROS = Target.the("'Movimientos'").locatedBy("//*[@class='android.widget.ListView']//child::*[@class='android.widget.TextView' and @text!='Movimientos de ahorro programado']");

    //Movimientos Prestamos
    public static final Target CANTIDAD_MOVIMIENTOS_PRESTAMOS = Target.the("'Movimientos'").locatedBy("//*[@class='android.widget.ListView']//child::*[@class='android.widget.TextView' and @text!='Movimientos']");

    //Movimientos Prestamos
    public static final Target CANTIDAD_MOVIMIENTOS_FONDOS_INVERSION = Target.the("'Movimientos'").locatedBy("//*[@class='android.widget.ListView']//child::*[@class='android.view.View' and @text!='Movimientos de fondo de inversión' and @text!='']");

    public static final Target LIMITE_ACU = Target.the("Límite acumulable semanal").locatedBy("//*[@text='Límites para Banca Móvil']//following::*[@text='Límite acumulable semanal']//following::*[contains(@class,'Edit') and (@text='' or not(@text=''))][1]");
    public static final Target LIMITE_TRX = Target.the("Límite por transacción").locatedBy("//*[@text='Límites para Banca Móvil']//following::*[@text='Límite por transacción']//following::*[contains(@class,'Edit') and (@text='' or not(@text=''))][1]");

    public static final Target FAVORITO = Target.the("'{0}'")
            .locatedBy("//*[@text='{0}']");
    public static final Target N_CUENTA = Target.the("'{0}'")
            .locatedBy("(//*[@text='{0}']/following::android.view.View[3])[1]");
    public static final Target FECHA_PAGO = Target.the("'{0}'")
            .locatedBy("(//*[@text='{0}']/following::android.view.View[5])[1]");
    public static final Target TIPO = Target.the("'Tipo'")
            .locatedBy( "(//*[@text='{0}']//following::*[1])[1]");
    public static final Target PUNTOS_ACUM = Target.the("'Puntos acumulados'")
            .locatedBy( "(//*[@text='{0}']//following::*[1])[2]");
    public static final Target ALIAS = Target.the("'Alias'")
            .locatedBy( "(//*[@text='Puntos BA']/preceding::*[1])[2]");
    public static final Target PUNTOS_ACUM2 = Target.the("'Puntos acumulados'")
            .locatedBy("//*[@text='Puntos acumulados']/preceding::*[1]");
    public static final Target SALDO_EN2 = Target.the("'Saldo en $'")
            .locatedBy("//*[@text='Saldo en $']/preceding::*[1]");
    public static final Target ACUE = Target.the("'Alias de la cuenta'")
            .locatedBy("//*[@text='Alias de la cuenta']/preceding::*[1]");
    public static final Target PROXV = Target.the("'Próximos a vencer'")
            .locatedBy("//*[@text='Próximos a vencer']/preceding::*[1]");
    public static final Target TIPO2 = Target.the("'Tipo'")
            .locatedBy("//*[@text='Tipo']/preceding::*[1]");

    public static final Target VARIABLE = Target.the("'{0}'")
            .locatedBy("//*[@text='{0}']/preceding::*[1]");
    public static final Target VARIABLE2 = Target.the("'Nº'")
            .locatedBy("//*[@text='{0}']/preceding::*[1]");

    public static final Target VARIABLE3 = Target.the("'Nº'")
            .locatedBy( "(//*[@text='{0}']//following::*[1])[1]");
    public static final Target VARIABLE4 = Target.the("'Nº'")
            .locatedBy( "(//*[@text='{0}']/following::android.widget.TextView[7])[1]");

    public static final Target VARIABLE5 = Target.the("'Nº'")
            .locatedBy( "//*[@text='{0}']/following::*[5]");




}
