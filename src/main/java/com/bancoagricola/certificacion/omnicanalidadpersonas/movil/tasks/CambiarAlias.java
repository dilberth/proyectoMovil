package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.ClickEn;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.ClickEnBoton;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.IngresarEn;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.VolverInicio;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.UiGenerico;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Variables;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class CambiarAlias implements Task {

    private final String alias;

    public CambiarAlias(String alias) {
        this.alias = alias;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ClickEn.elElemento(UiGenerico.accesibilityId("creditCard.details.editAlias")),
                IngresarEn.elCampo("Nuevo alias").elValor(alias),
                ClickEnBoton.elElemento("CAMBIAR"),
                VolverInicio.click()
        );

        Variables.NUEVO_ALIAS.guardarValor(alias);

    }

    public static CambiarAlias porElNuevoAlias(String alias){
        return Tasks.instrumented(CambiarAlias.class,alias);
    }
}
