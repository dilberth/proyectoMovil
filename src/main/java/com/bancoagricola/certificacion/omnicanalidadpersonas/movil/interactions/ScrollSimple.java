package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import net.serenitybdd.markers.IsSilent;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import org.openqa.selenium.Dimension;

import java.time.Duration;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getProxiedDriver;

public class ScrollSimple implements Interaction, IsSilent {

    PointOption pointOptionStart, pointOptionEnd;
    final int PRESS_TIME = 1000;

    @Override
    public <T extends Actor> void performAs(T actor) {

        Dimension dims = ThucydidesWebDriverSupport.getProxiedDriver().manage().window().getSize();

        pointOptionStart = PointOption.point(dims.width / 2, (dims.height * 70)/100);
        pointOptionEnd = PointOption.point(dims.width / 2, (dims.height * 20)/100 );

        new TouchAction(ThucydidesWebDriverSupport.getProxiedDriver())
                .press(pointOptionStart)
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME)))
                .moveTo(pointOptionEnd)
                .release().perform();

    }
}