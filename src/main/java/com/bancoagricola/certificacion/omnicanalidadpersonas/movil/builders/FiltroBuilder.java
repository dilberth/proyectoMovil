package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.builders;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.Filtro;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks.Scroll;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.*;
import net.serenitybdd.screenplay.*;
import net.serenitybdd.screenplay.actions.*;

import java.util.*;

public class FiltroBuilder implements CamposFiltroBuilder {

    private static boolean filtroAdicional;
    private static List<Performable> acciones;
    private Map<String ,Map<String, Object>> params = new HashMap<>();
    private boolean periodoDeTiempo = false;

    public FiltroBuilder() {
        filtroAdicional = true;
        acciones = new ArrayList<>();
    }

    public static FiltroBuilder nuevo() {
        return new FiltroBuilder();
    }

    @Override
    public void periodoDeTiempo(OpcionPeriodoDeTiempo opcionPeriodoDeTiempo) {
        this.periodoDeTiempo = true;
        this.acciones.add(Click.on(UiGenerico.elementoDeTexto(opcionPeriodoDeTiempo.tomarOpcion())));
    }

    @Override
    public void rangoDeFechas(Fecha fecha) {
        if (!fecha.tomarFechaInicio().isEmpty()) {
            this.acciones.add(SeleccionarEnCalendario.laFechaDesde(fecha.tomarFechaInicio()));
        }

        if (!fecha.tomarFechaFin().isEmpty()) {
            this.acciones.add(SeleccionarEnCalendario.laFechaHasta(fecha.tomarFechaFin()));
        }
    }

    @Override
    public void tipoDeTransaccion(String tipoDeTransacion) {
        habilitarFiltroAdicional();
        acciones.add(SeleccionarLista.conCordenadasDelNombre("Tipo de transacción").laOpcion(tipoDeTransacion));
    }

    @Override
    public void estado(OpcionesDeEstado opcionDeEstado) {
        habilitarFiltroAdicional();
        this.acciones.add(SeleccionarLista.conCordenadasDelNombre("Estado").laOpcion(opcionDeEstado.toString()));
    }

    @Override
    public void rango(double minimo, double maximo) {

        if (minimo > maximo) {
            throw new IllegalArgumentException("El valor minimo debe ser menor al valor maximo");
        }

        habilitarFiltroAdicional();

        if (minimo > 0) {
            this.acciones.add(Scroll.hastaElElemento(UiFiltro.rango("Desde")));
            this.acciones.add(IngresarEn.elCampo(UiFiltro.rango("Desde")).elValor(String.valueOf(minimo)));
        }

        if (maximo > 0) {
            this.acciones.add(Scroll.hastaElElemento(UiFiltro.rango("Hasta")));
            this.acciones.add(IngresarEn.elCampo(UiFiltro.rango("Hasta")).elValor(String.valueOf(maximo)));
        }

    }

    @Override
    public void canal(String canalTransaccion) {
        habilitarFiltroAdicional();
        this.acciones.add(SeleccionarLista.conCordenadasDelNombre("Canal").laOpcion(canalTransaccion));
    }

    public Filtro tomarFiltro() {
        return new Filtro(periodoDeTiempo,filtroAdicional, acciones);
    }

    private static void habilitarFiltroAdicional() {

        if (filtroAdicional) {
            acciones.add(Click.on(UiGenerico.elementoDeTexto("Ver filtros adicionales")));
            filtroAdicional = false;
        }

    }

}
