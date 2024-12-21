package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.questions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Constantes.TXTLIMITES_BM;

public class LimiteAcumulableSemanal implements Question <String> {

    @Override
    public String answeredBy(Actor actor) {
        return UiLimites.getLimiteAcumulableSemanal(TXTLIMITES_BM).resolveFor(actor).getAttribute(TargetApp.parametroParaTexto()).replace(",", "");
    }

    public static LimiteAcumulableSemanal sea(){
        return new LimiteAcumulableSemanal();
    }
}
