package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.*;
import net.serenitybdd.screenplay.*;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

public class SeleccionarEnCalendario implements Task {

    private final String dia;
    private final String mes;
    private final String ano;
    private final Performable calendarioFecha;

    public SeleccionarEnCalendario(String fecha, Performable calendarioFecha) {
        this.dia = Fecha.consulta(fecha).get(InfoFecha.DIA);
        this.mes = Fecha.consulta(fecha).get(InfoFecha.MES).substring(0, 3);
        this.ano = Fecha.consulta(fecha).get(InfoFecha.ANO);
        this.calendarioFecha = calendarioFecha;
    }

    @Step("{0} selecciona en el calendario '#calendarioFecha' la fecha '#dia-#mes-#ano' (DD-MM-AAAA)")
    @Override
    public <T extends Actor> void performAs(T actor) {

        Utilidades.esperar(2);
        actor.attemptsTo(
                calendarioFecha,
                ClickEn.elElemento(UiCalendario.tituloCalendario("")).cantidadDeClicks(2),
                ClickEn.elElemento(UiCalendario.elementoCalendario(ano)),
                ClickEn.elElemento(UiCalendario.elementoCalendario(mes)),
                ClickEn.elElemento(UiCalendario.elementoCalendario(dia))
        );
    }

    public static SeleccionarEnCalendario laFechaDesde(String fecha) {
        return Tasks.instrumented(SeleccionarEnCalendario.class, fecha, Click.on(UiCalendario.fechaCalendarioDesde()));
    }

    public static SeleccionarEnCalendario laFechaHasta(String fecha) {
        return Tasks.instrumented(SeleccionarEnCalendario.class, fecha, Click.on(UiCalendario.fechaCalendarioHasta()));
    }

    public static SeleccionarEnCalendario fechaDeSalida(String fecha) {
        return Tasks.instrumented(SeleccionarEnCalendario.class, fecha, SeleccionarLista.conCordenadasDelNombre("Fecha de salida", TargetApp.soIsIos()).sinOpcion());
    }

    public static SeleccionarEnCalendario fechaDeRegreso(String fecha) {
        return Tasks.instrumented(SeleccionarEnCalendario.class, fecha, SeleccionarLista.conCordenadasDelNombre("Fecha de regreso", TargetApp.soIsIos()).sinOpcion());
    }

}
