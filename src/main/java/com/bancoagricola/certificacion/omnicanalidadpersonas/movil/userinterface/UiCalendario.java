package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface;

import io.appium.java_client.*;
import net.serenitybdd.screenplay.targets.*;

public class UiCalendario {

    public static Target fechaCalendarioDesde(){return ByTarget.the("'Fecha desde'").locatedForAndroid(MobileBy.xpath("//android.view.View[@resource-id='datesWrapper']//*[1]")).locatedForIOS(MobileBy.xpath("//XCUIElementTypeOther[@label='Rango de fechas']//following-sibling::*[1]"));}
    public static Target fechaCalendarioHasta(){return ByTarget.the("'Fecha hasta'").locatedForAndroid(MobileBy.xpath("//android.view.View[@resource-id='datesWrapper']//*[3]")).locatedForIOS(MobileBy.xpath("//XCUIElementTypeOther[@label='Rango de fechas']//following-sibling::*[3]"));}
    public static Target tituloCalendario(String etiqueta){return ByTarget.the("'"+etiqueta+"'").locatedForAndroid(MobileBy.xpath("//android.view.View[@text='«']/following::*[1]")).locatedForIOS(MobileBy.xpath("//XCUIElementTypeStaticText[@label='«']/following::*[1]"));}
    public static Target elementoCalendario(String etiqueta){return ByTarget.the("'"+etiqueta+"'").locatedForAndroid(MobileBy.xpath("//android.view.View[@text='"+etiqueta+"']")).locatedForIOS(MobileBy.xpath("//XCUIElementTypeStaticText[@label='"+etiqueta+"']"));}

    //Calendario2
    public static Target CALENDARIO_DESDE = Target.the("'Fecha desde'").locatedForAndroid(MobileBy.xpath("//*[@resource-id='datesWrapper']//*[1]")).locatedForIOS(MobileBy.xpath("//XCUIElementTypeOther[@label='Rango de fechas']//following-sibling::*[1]"));
    public static Target CALENDARIO_DESDE2 = Target.the("'Fecha desde'").locatedForAndroid(MobileBy.xpath("//*[@text='Rango de fechas']/following::*[2]")).locatedForIOS(MobileBy.xpath("//XCUIElementTypeOther[@label='Rango de fechas']//following-sibling::*[1]"));

    public static Target CALENDARIO_HASTA = Target.the("'Fecha hasta'").locatedForAndroid(MobileBy.xpath("//*[@resource-id='datesWrapper']//*[3]")).locatedForIOS(MobileBy.xpath("//XCUIElementTypeOther[@label='Rango de fechas']//following-sibling::*[3]"));
    public static Target CALENDARIO_HASTA2 = Target.the("'Fecha hasta'").locatedForAndroid(MobileBy.xpath("//*[@text='Rango de fechas']/following::*[4]")).locatedForIOS(MobileBy.xpath("//XCUIElementTypeOther[@label='Rango de fechas']//following-sibling::*[3]"));

    public static Target FECHA_ACTUAL1 = Target.the("'Fecha actual'").locatedForAndroid(MobileBy.xpath("(//android.view.View[@resource-id='datesWrapper']//*[@class='android.view.View'])[8]")).locatedForIOS(MobileBy.xpath(""));
    public static Target FECHA_ACTUAL1_2 = Target.the("'Fecha actual'").locatedForAndroid(MobileBy.xpath("//*[@text='Rango de fechas']/following::*[9]")).locatedForIOS(MobileBy.xpath(""));
    public static Target FECHA_ACTUAL2 = Target.the("'Fecha actual'").locatedForAndroid(MobileBy.xpath("(//android.view.View[@resource-id='datesWrapper']//*[@class='android.view.View'])[8]")).locatedForIOS(MobileBy.xpath(""));

    public static Target FECHA_ACTUAL2_2 = Target.the("'Fecha actual'").locatedForAndroid(MobileBy.xpath("//*[@text='Rango de fechas']/following::*[9]")).locatedForIOS(MobileBy.xpath(""));

    public static Target FLECHA_ATRAS = Target.the("'<'").locatedForAndroid(MobileBy.xpath("(//android.view.View[@resource-id='datesWrapper']//*[@class='android.view.View'])[7]")).locatedForIOS(MobileBy.xpath(""));
    public static Target FLECHA_ATRAS2 = Target.the("'<'").locatedForAndroid(MobileBy.xpath("//*[@text='Rango de fechas']/following::*[8]")).locatedForIOS(MobileBy.xpath(""));

    public static Target CAL_DIA = Target.the("'Dia'").locatedForAndroid(MobileBy.xpath("//*[@class='android.widget.GridView']/*[@class='android.view.View']/*[@class='android.view.View']")).locatedForIOS(MobileBy.xpath(""));
}
