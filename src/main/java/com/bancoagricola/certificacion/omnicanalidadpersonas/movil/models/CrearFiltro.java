package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.builders.FiltroBuilder;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.*;

import java.util.*;

public class CrearFiltro {

    public static Filtro periodoDeTiempo_TipoDeTransaccion_Canal_AuditoriaDeTransacciones(Map<DatosFiltro, Object> datosFiltro) {
        FiltroBuilder filtroCreado = FiltroBuilder.nuevo();
        filtroCreado.rangoDeFechas(Fecha.rango((String) datosFiltro.get(DatosFiltro.FECHA_INICIO), (String) datosFiltro.get(DatosFiltro.FECHA_FIN)));
        filtroCreado.tipoDeTransaccion((String) datosFiltro.get(DatosFiltro.TIPO_DE_TRANSACCION));
        filtroCreado.canal((String) datosFiltro.get(DatosFiltro.NOMBRE_CANAL));
        return filtroCreado.tomarFiltro();
    }

    public static Filtro periodoDeTiempo_TipoDeTransaccion_RangoDeMontos_Canal_AuditoriaDeTransacciones(Map<DatosFiltro, Object> datosFiltro) {
        FiltroBuilder filtroCreado = FiltroBuilder.nuevo();
        filtroCreado.rangoDeFechas(Fecha.rango((String) datosFiltro.get(DatosFiltro.FECHA_INICIO), (String) datosFiltro.get(DatosFiltro.FECHA_FIN)));
        filtroCreado.tipoDeTransaccion((String) datosFiltro.get(DatosFiltro.TIPO_DE_TRANSACCION));
        filtroCreado.rango(Double.parseDouble((String) datosFiltro.get(DatosFiltro.RANGO_MONTO_MINIMO)), Double.parseDouble((String) datosFiltro.get(DatosFiltro.RANGO_MONTO_MAXIMO)));
        filtroCreado.canal((String) datosFiltro.get(DatosFiltro.NOMBRE_CANAL));
        return filtroCreado.tomarFiltro();
    }

    public static Filtro periodoDeTiempo_TipoDeTransaccion_EstadoDeTransaccion_Canal_AuditoriaDeTransacciones(Map<DatosFiltro, Object> datosFiltro) {
        FiltroBuilder filtroCreado = FiltroBuilder.nuevo();
        filtroCreado.rangoDeFechas(Fecha.rango((String) datosFiltro.get(DatosFiltro.FECHA_INICIO), (String) datosFiltro.get(DatosFiltro.FECHA_FIN)));
        filtroCreado.tipoDeTransaccion((String) datosFiltro.get(DatosFiltro.TIPO_DE_TRANSACCION));
        filtroCreado.estado(OpcionesDeEstado.valueOf(datosFiltro.get(DatosFiltro.ESTADO_TRANSACCION).toString()));
        filtroCreado.canal((String) datosFiltro.get(DatosFiltro.NOMBRE_CANAL));
        return filtroCreado.tomarFiltro();
    }

    public static Filtro movimientoRangoDeFechas(Cuentas datos) {
        FiltroBuilder filtroCreado = FiltroBuilder.nuevo();
        filtroCreado.rangoDeFechas(Fecha.rango(datos.getFechaDesde(), datos.getFechaHasta()));
        return filtroCreado.tomarFiltro();
    }

    public static Filtro movimientoRangoDeFechas(Ahorros datos) {
        FiltroBuilder filtroCreado = FiltroBuilder.nuevo();
        filtroCreado.rangoDeFechas(Fecha.rango(datos.getFechaDesde(), datos.getFechaHasta()));
        return filtroCreado.tomarFiltro();
    }

    public static Filtro movimientoPeriodoDeTiempo(String datos) {
        FiltroBuilder filtroCreado = FiltroBuilder.nuevo();
        filtroCreado.periodoDeTiempo(OpcionPeriodoDeTiempo.valueOf(datos.toUpperCase().replace(" ","_")));
        return filtroCreado.tomarFiltro();
    }

}
