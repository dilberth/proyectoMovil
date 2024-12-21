package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.*;
import net.serenitybdd.screenplay.*;
import net.serenitybdd.screenplay.actors.*;
import net.serenitybdd.screenplay.matchers.*;
import net.serenitybdd.screenplay.targets.*;
import net.serenitybdd.screenplay.waits.*;
import org.openqa.selenium.*;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Constantes.*;
import static net.serenitybdd.screenplay.actors.OnStage.*;

public class Esperar {

    public static Performable lista() {
        return EsperarLista.enPantalla();
    }

    public static Performable informacionLista() {

        long timeSeg = System.currentTimeMillis() / 1000;
        long timeSegAct = timeSeg;

        do{
            if(timeSegAct-timeSeg>=45){
                break;
            }
            timeSegAct = System.currentTimeMillis() / 1000;
        }while(UiGenerico.listaDeInformacion("Movimientos").resolveAllFor(theActorInTheSpotlight()).size()>0);

        return Task.where("Esperar informa").withNoReporting();
    }

    public static Performable enlace(String nombreEnlace) {

        return Task.where("Espera enlace " + nombreEnlace,
                WaitUntil.the(UiGenerico.elementoQueContengaElTexto(nombreEnlace), WebElementStateMatchers.isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(UiGenerico.elementoQueContengaElTexto(nombreEnlace), WebElementStateMatchers.isPresent()).forNoMoreThan(60).seconds(),
                WaitUntil.the(UiGenerico.elementoQueContengaElTexto(nombreEnlace), WebElementStateMatchers.isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(UiGenerico.elementoQueContengaElTexto(nombreEnlace), WebElementStateMatchers.isClickable()).forNoMoreThan(60).seconds()
        ).withNoReporting();
    }

    public static Performable target(Target elemento) {

        long timeSeg = System.currentTimeMillis() / 1000;
        long timeSegAct = timeSeg;

        while(!elemento.resolveFor(OnStage.theActorInTheSpotlight()).isVisible()){
            if(timeSegAct-timeSeg>=30){
                break;
            }
            timeSegAct = System.currentTimeMillis() / 1000;
        }

        return Task.where("Espera enlace " + elemento.getName()).withNoReporting();

    }

    public static Performable desaparezcaTarget(Target elemento) {

        while(elemento.resolveFor(OnStage.theActorInTheSpotlight()).isVisible()){}
        return Task.where("Espera enlace " + elemento.getName()).withNoReporting();

    }

    public static Performable mensajeUsusarioBloqueado() {
        return Task.where("Espera mensaje usuario bloqueado ",
                WaitUntil.the(UiGenerico.elementoQueContengaElTexto("Estimado cliente, tu usuario está bloqueado"), WebElementStateMatchers.isVisible()).forNoMoreThan(15).seconds()
        ).withNoReporting();
    }

    public static Performable mensajeUsusarioDesbloqueado() {
        return Task.where("Espera mensaje usuario desbloqueado ",
                WaitUntil.the(UiGenerico.elementoDeTexto("Usuario desbloqueado con éxito"), WebElementStateMatchers.isVisible()).forNoMoreThan(15).seconds()
        ).withNoReporting();
    }

    public static Performable texto(String texto) {
        return Task.where("Espera el texto " + texto,
                WaitUntil.the(UiGenerico.elementoDeTextoMayusMin(texto), WebElementStateMatchers.isVisible()).forNoMoreThan(60).seconds()
        ).withNoReporting();
    }

    public static Performable texto(String texto,int tiempo) {
        return Task.where("Espera el texto " + texto,
                WaitUntil.the(UiGenerico.elementoDeTextoMayusMin(texto), WebElementStateMatchers.isVisible()).forNoMoreThan(tiempo).seconds()
        ).withNoReporting();
    }

    public static void accionLogin() {

        long timeSeg = System.currentTimeMillis() / 1000;
        long timeSegAct = timeSeg;

        while (!UiGenerico.elementoDeTexto(TXTACTIVADISP).resolveFor(OnStage.theActorInTheSpotlight()).isVisible() && !UiGenerico.elementoDeTexto(TXTCUENTAS).resolveFor(OnStage.theActorInTheSpotlight()).isVisible()) {
            if (timeSegAct - timeSeg >= 60) {
                throw new TimeoutException("El tiempo de logueo supero los 60 seg");
            }
            timeSegAct = System.currentTimeMillis() / 1000;
        }

    }

    public static Performable pantallaDeCarga() {
        return Task.where("Espera que la aplicacion cargue",
                WaitUntil.the(UiGenerico.elementoDeTextoMayusMin("CARGANDO..."), WebElementStateMatchers.isNotVisible()).forNoMoreThan(120).seconds()).withNoReporting();
    }

}
