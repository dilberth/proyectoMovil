package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.Esperar;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.IngresarEn;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.Cuentas;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.*;
import net.serenitybdd.core.steps.*;
import net.serenitybdd.screenplay.*;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.waits.*;
import net.thucydides.core.annotations.*;

import java.util.*;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.UiCuentas.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Constantes.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class ProcesoTransferenciaTerceroCelular implements Task {
    private final List<Cuentas> datos;

    public ProcesoTransferenciaTerceroCelular(List<Cuentas> datos) {
        this.datos = datos;
    }

    @Step("{0} realiza el proceso de transferencia a un número de celular asociado a una cuenta de tercero")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Cuentas cu = datos.get(0);

        actor.attemptsTo(
                Click.on(UiTarjetas.botonVolver()),
                WaitUntil.the(MAS_DETALLE, isVisible()).forNoMoreThan(30).seconds(),
                Scroll.hastaElElemento(TRANSFERIR).elementoVisibleEnElMedioDeLaPantalla(),
                Click.on(TRANSFERIR),
                Esperar.texto("Transferencias"),
                Esperar.texto("Transferir a tercero"),
                Click.on(UiGenerico.elementoQueContengaElTexto("Transferir a tercero")),
                Esperar.texto("Transferencia a terceros"),
                Click.on(UiGenerico.elementoQueContengaElTexto(TXTCELULAR)),
                IngresarEn.elCampo(CAMPO_CELULAR_TT).elValor(cu.getCelular()),
                IngresarEn.elCampo(CAMPO_CORREO).elValor(cu.getCorreo()),
                IngresarEn.elCampo(CAMPO_MONTO_TT).elValor(cu.getMonto()),
                IngresarEn.elCampo(CAMPO_CONCEPTO).elValor(cu.getConcepto()),
                Scroll.hastaElElemento(BOTON_CONTINUAR).elementoVisibleEnElMedioDeLaPantalla(),
                Click.on(BOTON_CONTINUAR),
                Esperar.texto("¿Deseas continuar?"),
                Click.on(BOTON_ACEPTAR),
                Esperar.texto("La transferencia se realizó exitosamente"));
    }

    public static ProcesoTransferenciaTerceroCelular para(List<Cuentas> datos) {
        return Instrumented.instanceOf(ProcesoTransferenciaTerceroCelular.class).withProperties(datos);
    }
}
