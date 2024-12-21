package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.*;
import net.serenitybdd.markers.IsSilent;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;

public class EsperarLista implements Interaction, IsSilent {
    @Override
    public <T extends Actor> void performAs(T actor) {

        long timeSeg = System.currentTimeMillis()/1000;
        long timeSegAct = timeSeg;

        while(BrowseTheWeb.as(OnStage.theActorInTheSpotlight()).getDriver().findElements(
                TargetApp.soIsIos()?
                By.xpath("//XCUIElementTypeStaticText[@value=\" \"  and @accessible=\"false\"]"):
                By.xpath("//*[@class='android.widget.TextView' and @text=' ']")
        ).size() >1){
            if(timeSegAct - timeSeg >= 60){
                System.out.println(BrowseTheWeb.as(actor).getDriver().getPageSource());
                throw new TimeoutException("El tiempo de carga de la lista supero los 30 seg");
            }
            timeSegAct = System.currentTimeMillis()/1000;
        }

    }

    public static EsperarLista enPantalla(){
        return Tasks.instrumented(EsperarLista.class);
    }

}
