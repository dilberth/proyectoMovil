package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.questions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.*;
import net.serenitybdd.screenplay.*;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Constantes.*;

public class LimitePorTransaccion implements Question <String> {

    @Override
    public String answeredBy(Actor actor) {
        
        return UiLimites.getLimitePorTransaccion(TXTLIMITES_BM).resolveFor(actor).getAttribute(TargetApp.parametroParaTexto()).replace(",", "");
    }

    public static LimitePorTransaccion sea(){
        return new LimitePorTransaccion();
    }
}
