package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.*;
import net.serenitybdd.screenplay.targets.Target;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Scroll {

    public static ScrollHasta hastaElElemento(Target target) {
        return instrumented(ScrollHasta.class, target);
    }

    public static ScrollSimple simple() {
        return instrumented(ScrollSimple.class);
    }

}
