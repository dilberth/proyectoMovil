package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Utilidades {

    private static final Logger LOGGER=Logger.getLogger(Utilidades.class.getName());
    private static int contador = 0;

    private Utilidades() {
    }

    public static void esperar(int segundos){
        try {
            Thread.sleep(1000 * segundos);
        } catch (InterruptedException e) {
            LOGGER.log(Level.SEVERE,e.getMessage());
        }
    }

    public static void esperarMilis(long milisegundos){
        try {
            Thread.sleep(milisegundos);
        } catch (InterruptedException e) {
            LOGGER.log(Level.SEVERE,e.getMessage());
        }
    }

    public static void esperar2(){
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            LOGGER.log(Level.SEVERE,e.getMessage());
        }
    }

    public static String obtenerPropiedad(String propiedad) {
        EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
        return variables.getProperty(propiedad);
    }

    public static String obtenerDeTargetLaPropiedad(Target elemento, String propiedad){
        return elemento.resolveFor(OnStage.theActorInTheSpotlight()).getAttribute(propiedad);
    }

    public static List<String> obtenerDeListaDeTargetLaPropiedad(Target elemento, String propiedad){

        List<String> propiedades = new ArrayList<>();
        obtenerListaDeElementos(elemento).forEach(element -> propiedades.add(element.getAttribute(propiedad)));
        return propiedades;

    }

    public static List<String> iosObtenerDeListaElCampo(int numeroDelCampo){

        List<String> propiedades = new ArrayList<>();
        obtenerListaDeElementos(Target.the("").locatedBy("//XCUIElementTypeOther[@name=\"article\"]/XCUIElementTypeOther[4]/XCUIElementTypeOther/*["+numeroDelCampo+"]")).forEach(element -> propiedades.add(element.getAttribute("value")));
        return propiedades;

    }

    public static List<String> androidObtenerDeListaElCampo(int numeroDelCampo){

        List<String> propiedades = new ArrayList<>();

        obtenerListaDeElementos(Target.the("").locatedBy("//XCUIElementTypeOther[@name=\"article\"]/XCUIElementTypeOther[4]/XCUIElementTypeOther/*["+numeroDelCampo+"]")).forEach(element ->
                {

                    String nombre = "";
                    String estado = "";
                    String valor = "";
                    String fecha = "";

                    nombre = element.getAttribute("text").split("(?=\\p{Upper})")[0];
                    String words = element.getAttribute("text").substring(nombre.length());

                    if(words.contains("$")) {
                        estado = words.split("\\$")[0];
                        words = words.substring(estado.length());
                        fecha = words.substring(words.indexOf("/")-2);
                        valor = words.substring(0,words.length() - fecha.length());
                    }else{
                        fecha = words.substring(words.indexOf("/")-2);
                        estado = words.substring(0,words.length() - fecha.length());
                    }

                    switch (numeroDelCampo){
                        case 1:
                            propiedades.add(nombre);
                            break;
                        case 2:
                            propiedades.add(estado);
                            break;
                        case 3:
                            propiedades.add(valor);
                            break;
                        case 4:
                            propiedades.add(fecha);
                            break;
                    }
                }

                );
        return propiedades;
    }

    public static List<WebElementFacade> obtenerListaDeElementos(Target elemento){
        return elemento.resolveAllFor(OnStage.theActorInTheSpotlight());
    }

    public static Map<ValoresAuditoriaDeTrasacciones, Object> informacionRegistroAuditoriaDeTransacciones(String dato){

        Map<ValoresAuditoriaDeTrasacciones,Object> valores = new HashMap<>();
        boolean letraAntes = false;
        boolean letraSig;
        int posicion = 0;
        int tamano = dato.length();

        valores.put(ValoresAuditoriaDeTrasacciones.FECHA,dato.substring(tamano-10));

        int valor = dato.indexOf('$');

        if (valor >= 0){
            valores.put(ValoresAuditoriaDeTrasacciones.VALOR_DE_LA_TRANSACCON,Double.parseDouble(dato.substring(valor+1,tamano-10)));
        }else{
            valor = tamano - 10;
        }

        for (char letra : dato.toCharArray()) {

            letraSig = Character.isUpperCase(letra);
            if(letraAntes && letraSig && posicion>0){
                posicion--;
                break;
            }
            posicion++;
            letraAntes = letraSig;
        }

        valores.put(ValoresAuditoriaDeTrasacciones.ESTADO_DE_LA_TRANSACCION,dato.substring(posicion,valor));
        valores.put(ValoresAuditoriaDeTrasacciones.TIPO_DE_TRANSACCION,dato.substring(0,posicion));

        return valores;

    }

    public static boolean valorEntre(double valor, double min, double max){
        return valor >= min && valor <= max;
    }

    public static List<String> tomarInformacionListaAuditoriaDeTransacciones(){

        List<String> informacionAuditoriaDeTransacciones = new ArrayList<>();
        List<WebElementFacade> elementos = BrowseTheWeb.as(OnStage.theActorInTheSpotlight()).findAll(By.xpath("//XCUIElementTypeOther[@label=\"article\"]/XCUIElementTypeOther[4]/XCUIElementTypeOther"));
        contador = 0;

        elementos.forEach(
                elemento -> informacionAuditoriaDeTransacciones.add(contador++,
                        BrowseTheWeb.as(OnStage.theActorInTheSpotlight()).find(By.xpath("//XCUIElementTypeOther[@label=\"article\"]/XCUIElementTypeOther[4]/XCUIElementTypeOther["+contador+"]/XCUIElementTypeOther[1]/XCUIElementTypeStaticText")).getAttribute("label")+
                                BrowseTheWeb.as(OnStage.theActorInTheSpotlight()).find(By.xpath("//XCUIElementTypeOther[@label=\"article\"]/XCUIElementTypeOther[4]/XCUIElementTypeOther["+contador+"]/XCUIElementTypeOther[2]/XCUIElementTypeStaticText")).getAttribute("label")+
                                BrowseTheWeb.as(OnStage.theActorInTheSpotlight()).find(By.xpath("//XCUIElementTypeOther[@label=\"article\"]/XCUIElementTypeOther[4]/XCUIElementTypeOther["+contador+"]/XCUIElementTypeOther[3]/XCUIElementTypeStaticText")).getAttribute("label")+
                                BrowseTheWeb.as(OnStage.theActorInTheSpotlight()).find(By.xpath("//XCUIElementTypeOther[@label=\"article\"]/XCUIElementTypeOther[4]/XCUIElementTypeOther["+contador+"]/XCUIElementTypeOther[3]/XCUIElementTypeStaticText[2]")).getAttribute("label")+
                                BrowseTheWeb.as(OnStage.theActorInTheSpotlight()).find(By.xpath("//XCUIElementTypeOther[@label=\"article\"]/XCUIElementTypeOther[4]/XCUIElementTypeOther["+contador+"]/XCUIElementTypeOther[4]/XCUIElementTypeStaticText")).getAttribute("label")
                )
        );

        return informacionAuditoriaDeTransacciones;

    }



}
