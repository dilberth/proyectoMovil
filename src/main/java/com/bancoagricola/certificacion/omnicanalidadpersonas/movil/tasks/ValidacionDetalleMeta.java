package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.Esperar;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.Ahorros;
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

import java.util.List;
import java.util.Map;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Constantes.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Variables.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ValidacionDetalleMeta implements Task {

    private final List<Ahorros> datos;
    private Map datosObtenidos;

    public ValidacionDetalleMeta(List<Ahorros> datos) {
        this.datos = datos;
    }

    @Step("{0} realiza validación de detalle de 'Meta'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Ahorros ca = datos.get(0);

        actor.attemptsTo(
                WaitUntil.the(UiCuentas.menuCuentas(), isVisible()).forNoMoreThan(30).seconds(),
                Click.on(UiAhorros.menuMetas()),
                Scroll.hastaElElemento(UiAhorros.detMontoAcumulado(ca.getNombreMeta())).elementoVisibleEnElMedioDeLaPantalla());

        datosObtenidos = TomarValores.delElemento(UiGenerico.informacionDe(ca.getNombreMeta()), ValoresDe.valoresMeta);

        actor.remember(META_ALIAS.toString(), ca.getNombreMeta());
        actor.remember(META_META.toString(), datosObtenidos.get(TXTMETA));
        actor.remember(META_MONTO_ACUM.toString(), datosObtenidos.get(TXTMONTO_ACUMULADO));
        actor.remember(META_CUOTA.toString(), datosObtenidos.get(TXTCUOTA));
        actor.remember(META_PLAZO.toString(), datosObtenidos.get(TXTPLAZO));
        actor.remember(META_CUENTA.toString(), datosObtenidos.get(NUMERO_A));

        actor.attemptsTo(
                Click.on(UiGenerico.elementoQueContengaElTexto(ca.getNombreMeta())),
                Scroll.hastaElElemento(UiCuentas.opcionVerMas()),
                Click.on(UiCuentas.opcionVerMas()),
                Esperar.texto(ca.getNombreMeta()));

        datosObtenidos = TomarValores.delElemento(UiGenerico.informacionDePantalla(), ValoresDe.valoresMetaVerMas);

        actor.attemptsTo(
                Ensure.that((String) datosObtenidos.get(TXTALIAS)).isEqualTo(actor.recall(META_ALIAS.toString())),
                Ensure.that((String) datosObtenidos.get(TXTMONTO_ACUMULADO)).isEqualTo(actor.recall(META_MONTO_ACUM.toString())),
                Ensure.that((String) datosObtenidos.get(TXTMETA)).isEqualTo(actor.recall(META_META.toString())),
                Ensure.that((String) datosObtenidos.get(TXTCUOTA)).isEqualTo(actor.recall(META_CUOTA.toString())),
                Ensure.that((String) datosObtenidos.get(TXTPORCENTAJE_CUMPLIMIENTO)).isNotEmpty(),
                Scroll.hastaElElemento(UiGenerico.campoSelector(TXTNUMERO)));

        datosObtenidos = TomarValores.delElemento(UiGenerico.informacionDePantalla(), ValoresDe.valoresMetaVerMas);

                Ensure.that((String) datosObtenidos.get(TXTPLAZO)).isEqualTo(actor.recall(META_PLAZO.toString())).performAs(actor);
                Ensure.that((String) datosObtenidos.get(TXTPLAZO_TRANSCURRIDO)).isNotEmpty().performAs(actor);
                Ensure.that((String) datosObtenidos.get(TXTDIA_RETENCION)).isEqualTo(ca.getDiaRetencion()).performAs(actor);
                Ensure.that((String) datosObtenidos.get(TXTNUMERO)).isEqualTo(actor.recall(META_CUENTA.toString())).performAs(actor);
    }

    public static ValidacionDetalleMeta con(List<Ahorros> datos) {
        return Instrumented.instanceOf(ValidacionDetalleMeta.class).withProperties(datos);
    }
}
