package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Coordenadas;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.OpcionMenuPrincipal;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

public class SeleccionarEnMenuPrincipal implements Task {

    private final OpcionMenuPrincipal opcionMenuPrincipal;

    public SeleccionarEnMenuPrincipal(OpcionMenuPrincipal opcionMenuPrincipal) {
        this.opcionMenuPrincipal = opcionMenuPrincipal;
    }

    @Step("{0} selects the #opcionMenuPrincipal option in the PRINCIPAL menu")
    @Override
    public <T extends Actor> void performAs(T actor) {

        ClickConJs
                .enLasCoordenadas(Coordenadas.centralesDelElementoXpath("Menu principal", UiMenuPrincipal.menuPrincipal()))
                .cantidadDeClicks(TargetApp.soIsIos() ? 1 : 3)
                .performAs(actor);
        Esperar.target(UiMenuPrincipal.datosPersonales()).performAs(actor);
        ClickEn.elElemento(opcionMenuPrincipal.tomarOpcion()).performAs(actor);

    }

    public static SeleccionarEnMenuPrincipal laOpcion(OpcionMenuPrincipal opcionMenuPrincipal) {
        return Tasks.instrumented(SeleccionarEnMenuPrincipal.class, opcionMenuPrincipal);
    }

}
