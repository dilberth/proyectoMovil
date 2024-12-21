package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models;

import net.serenitybdd.screenplay.Performable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Filtro {

    private boolean periodoDeTiempo;
    private boolean filtroAdicional;
    private List<Performable> acciones ;

    public Filtro(boolean periodoDeTiempo ,boolean filtroAdicional, List<Performable> acciones) {
        this.periodoDeTiempo = periodoDeTiempo;
        this.filtroAdicional = filtroAdicional;
        this.acciones = acciones;
    }

    public boolean isPeriodoDeTiempo() {
        return filtroAdicional;
    }

    public boolean tomarFiltroAdicional() {
        return filtroAdicional;
    }

    public List<Performable> tomarAcciones() {
        return acciones;
    }
}
