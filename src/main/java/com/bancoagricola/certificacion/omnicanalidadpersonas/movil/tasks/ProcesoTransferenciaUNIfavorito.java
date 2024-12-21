package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.Cuentas;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.*;
import net.serenitybdd.core.steps.*;
import net.serenitybdd.screenplay.*;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.waits.*;
import net.thucydides.core.annotations.*;

import java.util.*;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Constantes.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static org.junit.Assert.*;

public class ProcesoTransferenciaUNIfavorito implements Task {
    private final List<Cuentas> datos;

    public ProcesoTransferenciaUNIfavorito(List<Cuentas> datos) {
        this.datos = datos;
    }

    @Step("{0} realiza el proceso telebanca transferencia UNI desde favorito")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Cuentas cu = datos.get(0);

        actor.attemptsTo(
                IrAProducto.cuenta(cu.getCuentaOrigen()).ySeleccionarLaTransaccion(TransaccionesCuentas.TRANSFERENCIAS_UNI.tomarTransaccion()),
                WaitUntil.the(UiGenerico.elementoQueContengaElTexto(TXTTRANSF_UNI), isVisible()).forNoMoreThan(30).seconds()
        );

        if (UiGenerico.elementoQueContengaElTexto(cu.getNombrefavorito()).resolveFor(actor).isVisible()) {
            actor.attemptsTo(
                    Click.on(UiGenerico.elementoQueContengaElTexto(cu.getNombrefavorito())),
                    WaitUntil.the(UiGenerico.elementoQueContengaElTexto(TXTTRANSF_UNI), isVisible()).forNoMoreThan(10).seconds(),
                    IngresarEn.elCampo(TXTMONTO).elValor(cu.getMonto()),
                    IngresarEn.elCampo(TXTCONCEPTO).elValor(cu.getConcepto()),
                    ClickEnBoton.elElemento(TXTBTN_TRANSF),
                    Esperar.texto(TXTDESEA_CONTINUAR),
                    Scroll.simple(),
                    ClickEnBoton.elElemento(TXTBTN_ACEPTAR),
                    WaitUntil.the(UiGenerico.elementoQueContengaElTexto(TXTMENSAJE_CONF9), isVisible()).forNoMoreThan(45).seconds()
            );

        } else {
            assertTrue("No se muestra el favorito: " + UiGenerico.elementoQueContengaElTexto(cu.getNombrefavorito()) + " favor validar que haya sido creado anteriormente", false);
        }
    }

    public static ProcesoTransferenciaUNIfavorito para(List<Cuentas> datos) {
        return Instrumented.instanceOf(ProcesoTransferenciaUNIfavorito.class).withProperties(datos);
    }
}
