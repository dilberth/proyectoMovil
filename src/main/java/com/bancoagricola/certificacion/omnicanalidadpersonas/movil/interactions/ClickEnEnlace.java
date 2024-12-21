package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.*;
import io.appium.java_client.*;
import net.serenitybdd.core.pages.*;
import net.serenitybdd.screenplay.*;
import net.serenitybdd.screenplay.actors.*;
import net.thucydides.core.annotations.*;
import net.thucydides.core.webdriver.*;
import org.openqa.selenium.*;

import java.util.*;

public class ClickEnEnlace implements Interaction {

    private String nombreEnlace;
    private WebElementFacade enlace;
    private TouchAction accion;
    private long timeSeg;
    private long timeSegAct;
    private double width;

    public ClickEnEnlace(String nombreEnlace) {
        this.nombreEnlace = nombreEnlace;
    }

    @Step("{0} clicks on link '#nombreEnlace'")
    @Override
    public <T extends Actor> void performAs(T actor) {

        if(UiGenerico.accesibilityId(nombreEnlace).resolveFor(actor).isVisible()){
            actor.attemptsTo(ClickEn.elElemento(UiGenerico.accesibilityId(nombreEnlace)));
        } else {
            actor.attemptsTo(Esperar.enlace(nombreEnlace));
            enlace = UiGenerico.elementoQueContengaElTexto(nombreEnlace).resolveFor(OnStage.theActorInTheSpotlight());
            accion = new TouchAction(ThucydidesWebDriverSupport.getProxiedDriver());
            timeSeg = System.currentTimeMillis() / 1000;
            timeSegAct = timeSeg;
            width = ((MobileElement)enlace.getWrappedElement()).getCenter().x + (enlace.getSize().width*0.47);

            Map<String, Object> params = new HashMap<>();
            params.put("x",width );
            params.put("y", ((MobileElement)enlace.getWrappedElement()).getCenter().y);

            System.out.println("X: "+width);
            System.out.println("Y: "+((MobileElement)enlace.getWrappedElement()).getCenter().y);

            do {
                ((JavascriptExecutor) ThucydidesWebDriverSupport.getProxiedDriver()).executeScript(TargetApp.soIsIos() ? "mobile: tap" : "mobile: longClickGesture", params);
                if (timeSegAct - timeSeg >= 45) {
                    throw new TimeoutException("No fue posible interactuar con el link '" + nombreEnlace +"'");
                }
                timeSegAct = System.currentTimeMillis() / 1000;
                width = width - 5;
                params.put("x", width);
                Utilidades.esperar2();
            } while (UiGenerico.elementoQueContengaElTexto(nombreEnlace).resolveFor(actor).isCurrentlyVisible());
        }
    }

    public static ClickEnEnlace deNombre(String nombreEnlace) {
        return Tasks.instrumented(ClickEnEnlace.class, nombreEnlace);
    }

}
