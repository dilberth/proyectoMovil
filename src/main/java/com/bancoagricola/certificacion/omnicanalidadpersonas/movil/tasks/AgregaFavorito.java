package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.ClickEn;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.ClickEnBoton;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.Esperar;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.IngresarEn;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.Cuentas;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.UiGenerico;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Utilidades;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.UiCuentas.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Constantes.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.junit.Assert.assertTrue;

public class AgregaFavorito implements Task {

    private final String nombreFavorito;

    public AgregaFavorito(List<Cuentas> datos) {
        this.nombreFavorito = datos.get(0).getNombrefavorito();
    }

    public AgregaFavorito(String favorito) {
        this.nombreFavorito = favorito;
    }

    @Step("{0} 'agrega favorito'")
    @Override
    public <T extends Actor> void performAs(T actor) {

        Esperar.target(UiGenerico.elementoQueContengaElTexto(TXTANADIRFAV)).performAs(actor);
        if (UiGenerico.elementoQueContengaElTexto(TXTANADIRFAV).resolveFor(actor).isVisible()) {
            ClickEn.elElemento(UiGenerico.elementoQueContengaElTexto(TXTANADIRFAV)).performAs(actor);
            Utilidades.esperar(5);
            //WaitUntil.the(GUARDARCOMO, isVisible()).forNoMoreThan(45).seconds().performAs(actor);
            Esperar.texto("Guardar como:").performAs(actor);
            //IngresarEn.elCampo(CAMPO_GUARDARCOMO).elValor(nombreFavorito).performAs(actor);
            IngresarEn.elCampo("Guardar como:").elValor(nombreFavorito).performAs(actor);
            ClickEnBoton.elElemento(TXTBTN_CONFIRMAR).performAs(actor);
            WaitUntil.the(UiGenerico.elementoQueContengaElTexto(TXTMENSAJE_CONF3), isVisible()).forNoMoreThan(30).seconds().performAs(actor);
            System.out.println("Guardó Favorito exitosamente");
        } else {
            assertTrue("Favorito ya se encuentra registrado (Cuenta, Nombre de favorito o Numero de telefono), favor validar", false);
        }
    }

    public static AgregaFavorito con(List<Cuentas> datos) {
        return Instrumented.instanceOf(AgregaFavorito.class).withProperties(datos);
    }

    public static AgregaFavorito con(String datos) {
        return Instrumented.instanceOf(AgregaFavorito.class).withProperties(datos);
    }
}
