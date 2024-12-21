package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.*;
import net.serenitybdd.screenplay.targets.Target;

public enum OpcionMenuServicios {

    ADQUIRI_MI_CODIGO_QR(UiMenuServicios.adquirirMiCodigoQr()),
    NOTIFICACION_DE_VIAJEROS(UiMenuServicios.notificacionDeViajero()),
    EXTRAVIO_DE_LIBRETA(UiMenuServicios.extravioDeTarjetaDeCredito()),
    BLOQUEO_DE_TARJETA_DE_CREDITO(UiMenuServicios.bloqueoDeTarjetaDeCredito()),
    RESERVA_DE_CHEQUES(UiMenuServicios.reservaDeCheques()),
    MIS_CODIGOS_QR(UiMenuServicios.misCodigosQr()),
    AUDITORIA_DE_TRANSACCIONES(UiMenuServicios.auditoriaDeTransacciones());

    private Target opcionMenuServicios;

    OpcionMenuServicios(Target opcionMenuServicios){
        this.opcionMenuServicios = opcionMenuServicios;
    }

    public Target tomarOpcion() {
        return opcionMenuServicios;
    }
}
