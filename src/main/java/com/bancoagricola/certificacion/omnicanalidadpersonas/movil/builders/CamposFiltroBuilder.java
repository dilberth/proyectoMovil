package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.builders;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Fecha;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.OpcionPeriodoDeTiempo;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.OpcionesDeEstado;

public interface CamposFiltroBuilder {

    void periodoDeTiempo(OpcionPeriodoDeTiempo opcionPeriodoDeTiempo);
    void rangoDeFechas(Fecha fecha);
    void tipoDeTransaccion(String tipoDeTransacion);
    void estado(OpcionesDeEstado opcionDeEstado);
    void rango(double minimo,double maximo);
    void canal(String canalTransaccion);

}
