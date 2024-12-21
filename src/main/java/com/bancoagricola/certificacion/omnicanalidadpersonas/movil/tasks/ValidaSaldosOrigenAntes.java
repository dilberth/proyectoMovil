package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.*;
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

public class ValidaSaldosOrigenAntes implements Task {
    private final List<Cuentas> datos;
    private Map datosObtenidos;

    public ValidaSaldosOrigenAntes(List<Cuentas> datos) {
        this.datos = datos;
    }

    @Step("{0} valida 'Saldo disponible' para cuenta 'Origen' antes de realizar la transacción")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Cuentas cu = datos.get(0);

        actor.attemptsTo(
                IrAProducto.cuenta(cu.getCuentaOrigen()).verMas());

        datosObtenidos = TomarValores.delElemento(UiGenerico.informacionDePantalla(),ValoresDe.valoresCuentasVerMas);
        actor.remember(SALDO_RETENIDO.toString(), ((String)datosObtenidos.get(TXTSALDO_RETENIDO)).replace(",", "").replace("$", "").trim());

        actor.attemptsTo(
                ClickEn.elElemento(UiCuentas.linkMasDetalles()),
                WaitUntil.the(UiGenerico.campoSelector(TXTSALDO_DISPONIBLE), isVisible()).forNoMoreThan(30).seconds());

        datosObtenidos = TomarValores.delElemento(UiGenerico.informacionDePantalla(),ValoresDe.valoresCuentaDeAhorrosMasDetalle);
        actor.remember(SALDO_CTAORGINI.toString(), ((String)datosObtenidos.get(TXTSALDO_DISPONIBLE)).replace(",", "").replace("$", "").trim());

        actor.attemptsTo(
            Task.where("Usuario identifica que el saldo actual de su cuenta es: "+actor.recall(SALDO_CTAORGINI.toString())));
        System.out.println("Saldo Actual: "+actor.recall(SALDO_CTAORGINI.toString()));
    }

    public static ValidaSaldosOrigenAntes para(List<Cuentas> datos) {
        return Instrumented.instanceOf(ValidaSaldosOrigenAntes.class).withProperties(datos);
    }
}
