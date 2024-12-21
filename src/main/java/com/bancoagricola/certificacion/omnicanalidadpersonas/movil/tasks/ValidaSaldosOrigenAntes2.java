package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.ClickEn;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.IrAProducto;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.IrAProducto2;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.Cuentas;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.UiCuentas;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.UiGenerico;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.TomarValores;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.ValoresDe;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import java.util.List;
import java.util.Map;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Constantes.TXTSALDO_DISPONIBLE;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Constantes.TXTSALDO_RETENIDO;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Variables.SALDO_CTAORGINI;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Variables.SALDO_RETENIDO;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ValidaSaldosOrigenAntes2 implements Task {
    private final List<Cuentas> datos;
    private Map datosObtenidos;

    public ValidaSaldosOrigenAntes2(List<Cuentas> datos) {
        this.datos = datos;
    }

    @Step("{0} valida 'Saldo disponible' para cuenta 'Origen' antes de realizar la transacción")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Cuentas cu = datos.get(0);

        actor.attemptsTo(
                IrAProducto2.cuenta(cu.getCuentaOrigen()).verMas()
        );

        datosObtenidos = TomarValores.delElemento(UiGenerico.informacionDePantalla(),ValoresDe.valoresCuentasVerMas);
        actor.remember(SALDO_RETENIDO.toString(), ((String)datosObtenidos.get(TXTSALDO_RETENIDO)).replace(",", "").replace("$", "").trim());

        actor.attemptsTo(
                ClickEn.elElemento(UiCuentas.linkMasDetalles()),
                WaitUntil.the(UiGenerico.campoSelector(TXTSALDO_DISPONIBLE), isVisible()).forNoMoreThan(30).seconds()
        );

        datosObtenidos = TomarValores.delElemento(UiGenerico.informacionDePantalla(),ValoresDe.valoresCuentaDeAhorrosMasDetalle);
        actor.remember(SALDO_CTAORGINI.toString(), ((String)datosObtenidos.get(TXTSALDO_DISPONIBLE)).replace(",", "").replace("$", "").trim());

        actor.attemptsTo(
            Task.where("Usuario identifica que el saldo actual de su cuenta es "+actor.recall(SALDO_CTAORGINI.toString()))
        );

    }

    public static ValidaSaldosOrigenAntes2 para(List<Cuentas> datos) {
        return Instrumented.instanceOf(ValidaSaldosOrigenAntes2.class).withProperties(datos);
    }
}
