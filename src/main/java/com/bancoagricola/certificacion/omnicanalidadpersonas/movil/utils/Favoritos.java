package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.*;

public enum Favoritos {

    PAGO_TARJETA_UNI(Favorito.pagoTarjetaUni()),
    PAGO_PRESTAMO_TRANSFER365(Favorito.pagoPrestamoTransfer365()),
    PAGO_TARJETA_TRANSFER365(Favorito.pagoTarjetaTransfer365()),
    PAGO_TARJETA_TERCERO(Favorito.pagoTarjetaTercero()),
    PAGO_PRESTAMO_UNI(Favorito.pagoPrestamouni()),
    TRANSFERENCIA_TRANSFER365_MOVIL(Favorito.pagoPrestamouni()),
    PAGO_PRESTAMO_TERCERO(Favorito.pagoPrestamoTercero());

    private Favorito informacionFavorito;

    Favoritos(Favorito informacionFavorito) {
        this.informacionFavorito = informacionFavorito;
    }

    public Favorito tomarInformacionFavorito() {
        return this.informacionFavorito;
    }


}
