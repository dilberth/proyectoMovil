package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.Cuentas;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.*;
import net.serenitybdd.core.steps.*;
import net.serenitybdd.screenplay.*;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.*;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.*;

import java.util.*;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Constantes.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ProcesoConsultaCVV2 implements Task {
    private final List<Cuentas> datos;
    private Map datosObtenidos;

    public ProcesoConsultaCVV2(List<Cuentas> datos) {
        this.datos = datos;
    }

    @Step("{0} realiza la consulta CVV2 y fecha de expiración ")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Cuentas cu = datos.get(0);

        actor.attemptsTo(
                IrAProducto.tarjeta(cu.getTarjetaCredito()).ySeleccionarLaTransaccion(TransaccionesTarjetas.OPCION_CONSULTA_CVV2.tomarTransaccion()),
                Esperar.texto(TXTCONSULTA_CVV2));

        datosObtenidos = TomarValores.delElemento(UiGenerico.informacionDePantalla(), ValoresDe.cvv2YFechaDeExpitacionEcard);

        Utilidades.esperar(3);

        actor.attemptsTo(
                Ensure.that((String) datosObtenidos.get(TXTTARJETA_TITULAR)).isNotEmpty(),
                Ensure.that((String) datosObtenidos.get(TXTTARJETA_ECARD)).isNotEmpty(),
                Ensure.that((String) datosObtenidos.get(TXTCONDIGO_SEGURIDAD)).isNotEmpty(),
                Ensure.that((String) datosObtenidos.get(TXTFECHA_VENCIMIENTO)).isNotEmpty());

    }

    public static ProcesoConsultaCVV2 para(List<Cuentas> datos) {
        return Instrumented.instanceOf(ProcesoConsultaCVV2.class).withProperties(datos);
    }
}