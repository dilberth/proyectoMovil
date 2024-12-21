package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.markers.IsSilent;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;

import java.time.Duration;
import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Constantes.RANGO_CENTRO;

public class ScrollHasta implements Interaction, IsSilent {
    private Target target;
    private long timeSeg;
    private int tiempo = 30;
    private double rangoPermitido = 1;

    public ScrollHasta(Target target) {
        this.target = target;
    }

    @Step("{0} scroll to '#target'")
    @Override
    public <T extends Actor> void performAs(T actor) {

        List<WebElementFacade> elements = target.resolveAllFor(actor);
        final int PRESS_TIME = 1000;
        int edgeBorder = 10;
        int margin = 100;
        PointOption pointOptionStart, pointOptionEnd;
        Dimension dims = ThucydidesWebDriverSupport.getProxiedDriver().manage().window().getSize();
        boolean ciclo = elements.size() != 0 && (elements.get(0).getLocation().y < dims.height - margin);
        boolean cicloExtra = true;
        timeSeg = System.currentTimeMillis() / 1000;

        while (!ciclo) {

            if (ciclo) {
                Point element = target.resolveFor(actor).getLocation();
                pointOptionStart = PointOption.point(element.x + dims.width / 2,
                        element.y + dims.height - edgeBorder);
                pointOptionEnd = PointOption.point(element.x + dims.width / 2,
                        element.y + edgeBorder);
                cicloExtra = (target.resolveFor(actor).getLocation().y < dims.height - margin);
            } else {
                pointOptionStart = PointOption.point(dims.width / 2, (dims.height * 70)/100);
                pointOptionEnd = PointOption.point(dims.width / 2, (dims.height * 20)/100 );
            }

            new TouchAction(ThucydidesWebDriverSupport.getProxiedDriver())
                    .press(pointOptionStart)
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME)))
                    .moveTo(pointOptionEnd)
                    .release().perform();

            ciclo = target.resolveAllFor(actor).size() != 0 && cicloExtra;

            if (((System.currentTimeMillis() / 1000) - timeSeg >= this.tiempo)) {
                throw new NoSuchElementException("No se muestra el elemento: " + target.getName());
            }
        }
    }

    public ScrollHasta tiempoMaximoScroll(int tiempo) {
        this.tiempo = tiempo;
        return this;
    }

    public ScrollHasta elementoVisibleEnElMedioDeLaPantalla() {
        this.rangoPermitido = RANGO_CENTRO;
        return this;
    }
}


