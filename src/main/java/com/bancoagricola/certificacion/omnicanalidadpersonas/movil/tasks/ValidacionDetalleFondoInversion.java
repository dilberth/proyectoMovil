package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.ClickEn;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.Cuentas;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.TomarValores;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.ValoresDe;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Constantes.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Variables.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ValidacionDetalleFondoInversion implements Task {

    private final List<Cuentas> datos;
    private Map datosObtenidos;

    public ValidacionDetalleFondoInversion(List<Cuentas> datos) {
        this.datos = datos;
    }

    @Step("{0} realiza validación de detalle de 'Fondo de inversión'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Cuentas cu = datos.get(0);

        actor.attemptsTo(
                WaitUntil.the(UiCuentas.menuCuentas(), isVisible()).forNoMoreThan(20).seconds(),
                Scroll.hastaElElemento(UiGenerico.elementoQueContengaElTexto(cu.getFondoInversion())).elementoVisibleEnElMedioDeLaPantalla()
        );

        datosObtenidos = TomarValores.delElemento(UiGenerico.informacionDe(cu.getFondoInversion()), ValoresDe.valoresFondoDeInversion);

        actor.remember(CA_ALIAS1.toString(), cu.getFondoInversion());
        actor.remember(FI_TIPO_FONDO.toString(), datosObtenidos.get(TXTTIPO_FONDO_INVERSION));
        actor.remember(FI_NUMERO_CUENTA.toString(), datosObtenidos.get(NUMERO_A));
        actor.remember(CA_SALDO1.toString(), datosObtenidos.get(TXTSALDO_DISPONIBLE));

        actor.attemptsTo(
                Click.on(UiGenerico.elementoQueContengaElTexto(cu.getFondoInversion())),
                ClickEn.elElemento(UiCuentas.opcionVerMas())
        );

        datosObtenidos = TomarValores.delElemento(UiGenerico.informacionDe(cu.getFondoInversion()).waitingForNoMoreThan(Duration.ofSeconds(10)), ValoresDe.valoresFondoDeInversionVerMas);

        actor.attemptsTo(
                //Ensure.that((String) datosObtenidos.get(TXTSALDO_DISPONIBLE)).isEqualTo(actor.recall(CA_SALDO1.toString()).toString()),
                Ensure.that((String) datosObtenidos.get(TXTNUMERO_CUENTA)).isEqualTo(actor.recall(FI_NUMERO_CUENTA.toString()).toString()),
                Ensure.that((String) datosObtenidos.get(TXTTIPO_FONDO_INVERSION)).isEqualTo(actor.recall(FI_TIPO_FONDO.toString()).toString()),
                Ensure.that((String) datosObtenidos.get(TXTMONTO_MAXIMO_RETIRO)).isNotEmpty()
        );

        actor.remember(FI_SALDO.toString(), datosObtenidos.get(TXTSALDO_DISPONIBLE));
        actor.remember(FI_MONTO_MAX_RETIRO.toString(), datosObtenidos.get(TXTMONTO_MAXIMO_RETIRO));

        actor.attemptsTo(
                ClickEn.elElemento(UiCuentas.linkMasDetalles())
        );

        datosObtenidos = TomarValores.delElemento(UiGenerico.informacionDePantalla().waitingForNoMoreThan(Duration.ofSeconds(10)), ValoresDe.valoresFondoDeInversionMasDetalle);

        actor.attemptsTo(
                Ensure.that((String)datosObtenidos.get(TXTALIAS)).isEqualTo(actor.recall(CA_ALIAS1.toString()).toString()),
                Ensure.that((String)datosObtenidos.get(TXTNUMERO_REFERENCIA)).isEqualTo(actor.recall(FI_NUMERO_CUENTA.toString()).toString()),
                Ensure.that((String)datosObtenidos.get(TXTTIPO_FONDO_INVERSION)).isEqualTo(actor.recall(FI_TIPO_FONDO.toString()).toString()),
                Ensure.that((String)datosObtenidos.get(TXTSALDO_DISPONIBLE)).isEqualTo(actor.recall(FI_SALDO.toString()).toString()),
                Scroll.hastaElElemento(UiGenerico.campoSelector(TXTSALDO_POR_EFECTIVIZAR))
        );

        datosObtenidos = TomarValores.delElemento(UiGenerico.informacionDePantalla(), ValoresDe.valoresFondoDeInversionMasDetalle);

        actor.attemptsTo(
                Ensure.that((String)datosObtenidos.get(TXTMONTO_MAXIMO_RETIRO)).isEqualTo(actor.recall(FI_MONTO_MAX_RETIRO.toString()).toString()),
                Ensure.that((String)datosObtenidos.get(TXTFECHA)).isNotEmpty(),
                Ensure.that((String)datosObtenidos.get(TXTSALDO_POR_EFECTIVIZAR)).isNotEmpty(),
                Ensure.that((String)datosObtenidos.get(TXTSALDO_PROTEGIDO)).isNotEmpty()
        );
    }

    public static ValidacionDetalleFondoInversion con(List<Cuentas> datos) {
        return Instrumented.instanceOf(ValidacionDetalleFondoInversion.class).withProperties(datos);
    }
}