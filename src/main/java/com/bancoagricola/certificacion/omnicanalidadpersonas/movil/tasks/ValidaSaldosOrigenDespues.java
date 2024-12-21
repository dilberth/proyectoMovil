package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.Cuentas;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.*;
import net.serenitybdd.core.steps.*;
import net.serenitybdd.screenplay.*;
import net.serenitybdd.screenplay.ensure.*;
import net.thucydides.core.annotations.*;

import java.util.*;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Constantes.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Variables.*;

public class ValidaSaldosOrigenDespues implements Task {
    private final List<Cuentas> datos;
    private Map datosObtenidos;

    public ValidaSaldosOrigenDespues(List<Cuentas> datos) {
        this.datos = datos;
    }

    @Step("{0} valida 'Saldo disponible' para cuenta 'Origen' despues de realizar la transacción")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Cuentas cu = datos.get(0);

        Utilidades.esperar(10);

        actor.attemptsTo(
                IrAProducto.cuenta(cu.getCuentaOrigen()).ySeleccionarLaTransaccion(TransaccionesCuentas.MAS_DETALLE.tomarTransaccion()),
                Esperar.pantallaDeCarga());

        datosObtenidos = TomarValores.delElemento(UiGenerico.informacionDePantalla(),ValoresDe.valoresCuentasVerMas);

        double saldoCuentaDesD = Double.parseDouble(((String)datosObtenidos.get(TXTSALDO_DISPONIBLE)).replace(",", "").replace("$", "").trim());
        double saldoCuentaAntD = Double.parseDouble(actor.recall(SALDO_CTAORGINI.toString()).toString());
        double valorAPagar = Double.parseDouble(cu.getMonto());
        double calculo = Math.round((saldoCuentaAntD - valorAPagar) * 100.0) / 100.0;

        //todo eliminar
        System.out.println("inicial : "+saldoCuentaAntD);
        System.out.println("despues : "+saldoCuentaDesD);
        System.out.println("esperado : "+calculo);

        actor.attemptsTo(
                Ensure.that(saldoCuentaDesD).isEqualTo(calculo));
    }

    public static ValidaSaldosOrigenDespues para(List<Cuentas> datos) {
        return Instrumented.instanceOf(ValidaSaldosOrigenDespues.class).withProperties(datos);
    }
}
