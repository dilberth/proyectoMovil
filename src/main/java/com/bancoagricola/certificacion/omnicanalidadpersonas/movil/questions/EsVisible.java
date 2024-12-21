package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

public class EsVisible implements Question<Boolean> {

    private Target target;

    public EsVisible(Target target) {
        this.target = target;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return target.resolveFor(actor).isVisible();
    }


    public static EsVisible elElemento(Target target){
        return new EsVisible(target);
    }

}
