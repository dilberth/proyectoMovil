package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.Ahorros;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.questions.*;
import net.serenitybdd.core.steps.*;
import net.serenitybdd.screenplay.*;
import net.thucydides.core.annotations.*;

import java.util.List;

public class ValidacionTicketCreacionMeta implements Task {

    private final List<Ahorros> meta;

    public ValidacionTicketCreacionMeta(List<Ahorros> meta) {
        this.meta = meta;
    }

    @Step("{0} realiza validación de ticket")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Ahorros aho = meta.get(0);

        actor.attemptsTo(
                VerEnPantalla.elTexto("¡Tu meta se creó exitosamente!"));
        if (aho.getPlazoMeta().equals("1")) {
            actor.attemptsTo(
            VerEnPantalla.contengaTexto("La cuota de tu meta \""+aho.getNombreMeta()+"\" se retendrá todos los "+aho.getDiaRetencion()+" del mes por un plazo de 1 mes."));
        } else {
            actor.attemptsTo(
            VerEnPantalla.contengaTexto("La cuota de tu meta \""+aho.getNombreMeta()+"\" se retendrá todos los "+aho.getDiaRetencion()+" del mes por un plazo de "+aho.getPlazoMeta()+" meses"));
        }
        actor.attemptsTo(
                VerEnPantalla.elTexto("Monto total: $" + aho.getMontoMeta()),
                VerEnPantalla.contengaTexto("Cuota mensual: $" + aho.getCuotaMensual()),
                VolverInicio.click());
    }

    public static ValidacionTicketCreacionMeta elementos(List<Ahorros> meta) {
        return Instrumented.instanceOf(ValidacionTicketCreacionMeta.class).withProperties(meta);
    }
}