package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.Filtro;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.thucydides.core.annotations.Step;

import java.util.List;

public class Filtrar implements Task {

    private final boolean camposFiltroAdicional;
    private final List<Performable> acciones;
    private final String botonBuscar;
    private final boolean periodoDeTiempo;

    public Filtrar(Filtro filtro,String botonBuscar) {

        this.camposFiltroAdicional = filtro.tomarFiltroAdicional();
        this.acciones = filtro.tomarAcciones();
        this.periodoDeTiempo = filtro.isPeriodoDeTiempo();
        this.botonBuscar = botonBuscar;
    }

    @Step("{0} utiliza la opcion de filtrado")
    @Override
    public <T extends Actor> void performAs(T actor) {

        Esperar.lista().performAs(actor);
        //WaitUntil.the(UiGenerico.campoSelector("Filtrar"), isEnabled()).forNoMoreThan(30).seconds().performAs(actor);
        ClickEnEnlace.deNombre("Filtrar").performAs(actor);
        Esperar.texto("Período de tiempo").performAs(actor);
        actor.attemptsTo(acciones.toArray(new Performable[]{}));
        ClickEnBoton.elElemento(botonBuscar).performAs(actor);
    }

    public static Filtrar por(Filtro filtro) {
        return Tasks.instrumented(Filtrar.class, filtro,"BUSCAR");
    }

    public static Filtrar movimientosPor(Filtro filtro) {
        return Tasks.instrumented(Filtrar.class, filtro,"BUSCAR MOVIMIENTOS");
    }
}
