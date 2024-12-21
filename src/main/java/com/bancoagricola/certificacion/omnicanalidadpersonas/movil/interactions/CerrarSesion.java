package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks.SeleccionarEnMenuPrincipal;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.OpcionMenuPrincipal;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Utilidades;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.thucydides.core.annotations.Step;

public class CerrarSesion implements Interaction {

    @Step("{0} cierra su sesion")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                SeleccionarEnMenuPrincipal.laOpcion(OpcionMenuPrincipal.SALIR),
                ClickEnBoton.elElemento("CERRAR SESIÓN")
        );
        Utilidades.esperar(3);
    }

    public static CerrarSesion actual(){
        return Tasks.instrumented(CerrarSesion.class);
    }
}
