package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.ClickEnBoton;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.Esperar;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.OpcionMenuPrincipal;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class ProcesoDeDeslogueo implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                SeleccionarEnMenuPrincipal.laOpcion(OpcionMenuPrincipal.SALIR),
                Esperar.texto("Cerrar sesión"),
                ClickEnBoton.elElemento("CERRAR SESIÓN")
        );

    }

    public static ProcesoDeDeslogueo deLaApp(){
        return Tasks.instrumented(ProcesoDeDeslogueo.class);
    }

}
