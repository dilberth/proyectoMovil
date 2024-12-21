package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils;

import io.appium.java_client.*;
import net.serenitybdd.core.pages.*;
import net.serenitybdd.screenplay.actors.*;
import net.serenitybdd.screenplay.targets.*;
import org.apache.tools.ant.taskdefs.Tar;
import org.openqa.selenium.*;

import java.util.List;

public class Coordenadas {

    private int coordenadaEnX;
    private int coordenadaEnY;
    private String nombreElemento;

    public Coordenadas(String nombreElemento,int coordenadaEnX, int coordenadaEnY) {
        this.nombreElemento = nombreElemento;
        this.coordenadaEnX = coordenadaEnX;
        this.coordenadaEnY = coordenadaEnY;
    }

    public static Coordenadas centralesDelElementoXpath(String nombreElemento, Target xpath) {

        WebElement elemento;
        int coordenadaEnX;
        int coordenadaEnY;

        elemento = xpath.resolveFor(OnStage.theActorInTheSpotlight());
        coordenadaEnX = elemento.getLocation().x + elemento.getSize().width/2;
        coordenadaEnY = elemento.getLocation().y + elemento.getSize().height/2;

        return new Coordenadas(nombreElemento,coordenadaEnX, coordenadaEnY);

    }

    public static Coordenadas esquinaInferiorDelElementoXpath(String nombreElemento, Target xpath) {

        WebElement elemento;
        int coordenadaEnX;
        int coordenadaEnY;

        elemento = xpath.resolveFor(OnStage.theActorInTheSpotlight());
        coordenadaEnX = elemento.getLocation().x + (elemento.getSize().width);
        coordenadaEnY = elemento.getLocation().y + (elemento.getSize().height);

        return new Coordenadas(nombreElemento,coordenadaEnX, coordenadaEnY);

    }

    public static Coordenadas esquinaSuperiorDerechaDelElemento(Target xpath) {

        List<WebElementFacade> elements = xpath.resolveAllFor(OnStage.theActorInTheSpotlight());
        int coordenadaEnX = 0;
        int coordenadaEnY = 0;

        if(elements.size() != 0) {
            Point elementoWeb  = elements.get(0).getLocation();
            coordenadaEnX = elementoWeb.x + elements.get(0).getSize().width;
            coordenadaEnY = elementoWeb.y;
        }
        
        return new Coordenadas(xpath.getName(),coordenadaEnX, coordenadaEnY);

    }

    public int TomarCoordenadaEnX() {
        return coordenadaEnX;
    }

    public int TomarCoordenadaEnY() {
        return coordenadaEnY;
    }

    public String tomarNombreElemento() {
        return nombreElemento;
    }
}
