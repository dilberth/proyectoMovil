package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.Cuentas;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.*;
import net.serenitybdd.core.steps.*;
import net.serenitybdd.screenplay.*;
import net.serenitybdd.screenplay.waits.*;
import net.thucydides.core.annotations.*;

import java.util.*;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Constantes.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Variables.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class ValidaSaldosDestinoAntes implements Task {
    private final List<Cuentas> datos;
    private Map datosObtenidos;

    public ValidaSaldosDestinoAntes(List<Cuentas> datos) {
        this.datos = datos;
    }

    @Step("{0} valida 'Saldo disponible' para cuenta 'Destino' antes de realizar la transacción")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Cuentas cu = datos.get(0);

        actor.attemptsTo(
                IrAProducto.cuenta(cu.getCuentaDestino()).ySeleccionarLaTransaccion(TransaccionesCuentas.MAS_DETALLE.tomarTransaccion()),
                WaitUntil.the(UiGenerico.campoSelector(TXTSALDO_DISPONIBLE), isVisible()).forNoMoreThan(20).seconds()
        );

        datosObtenidos = TomarValores.delElemento(UiGenerico.informacionDePantalla(),ValoresDe.valoresCuentaDeAhorrosMasDetalle);

        actor.remember(SALDO_CTADESINI.toString(), ((String)datosObtenidos.get(TXTSALDO_DISPONIBLE)).replace(",", "").replace("$", "").trim());

        actor.attemptsTo(
                Task.where("El Usuario observa que su saldo dispobible es igual a "+actor.recall(SALDO_CTADESINI.toString())),
                VolverInicio.click()
        );

    }

    public static ValidaSaldosDestinoAntes para(List<Cuentas> datos) {
        return Instrumented.instanceOf(ValidaSaldosDestinoAntes.class).withProperties(datos);
    }
}
