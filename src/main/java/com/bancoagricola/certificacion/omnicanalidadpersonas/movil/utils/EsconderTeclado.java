package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.ClickEn;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.UiGenerico;
import net.serenitybdd.screenplay.actors.OnStage;

public class EsconderTeclado {

    public static void enIos(){

        if(TargetApp.soIsIos()){
            //ScrollVertical.corto().desdeElMedio().ejecutar();
            ClickEn.elElemento(UiGenerico.accesibilityId("Done")).performAs(OnStage.theActorInTheSpotlight());
        }

    }

}
