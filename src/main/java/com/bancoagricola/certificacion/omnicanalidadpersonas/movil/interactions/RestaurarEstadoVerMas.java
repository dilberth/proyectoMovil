package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.*;
import net.serenitybdd.screenplay.*;
import net.serenitybdd.screenplay.targets.*;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Constantes.*;
import static net.serenitybdd.screenplay.Tasks.*;

public class RestaurarEstadoVerMas extends SilentInteraction {

    private Target elemento;

    public RestaurarEstadoVerMas(Target elemento) {
        this.elemento = elemento;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        if (TXTCUENTAS.equals(elemento.getName().replace("'", ""))) {
            if(UiGenerico.accesibilityId(TXTTARJETAS).resolveAllFor(actor).size() != 0){
                ClickEn.elElemento(UiGenerico.accesibilityId(TXTTARJETAS)).performAs(actor);
            } else {
                ClickEn.elElemento(UiGenerico.accesibilityId(TXTAHORROS)).performAs(actor);
            }
        }else{
            ClickEn.elElemento(UiGenerico.accesibilityId(TXTCUENTAS)).performAs(actor);
        }

    }

    public static RestaurarEstadoVerMas dandoClick(Target elemento) {
        return instrumented(RestaurarEstadoVerMas.class, elemento);
    }

}
