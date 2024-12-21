package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.*;
import net.serenitybdd.screenplay.*;

public class Favorito {

    public Transferencias infoPago;
    public String transaccion;
    public String nombreFavorito;
    public Task tareaDePago;

    public Favorito(Transferencias infoPago, String tituloPantallaPago,String nombreFavorito, Task tareaDePago) {
        this.infoPago = infoPago;
        this.transaccion = tituloPantallaPago;
        this.tareaDePago = tareaDePago;
        this.nombreFavorito = nombreFavorito;
    }

    public static Favorito pagoTarjetaUni(){
        return new Favorito(
                InformacionFavorito.pagoTarjetaUni(),
                TransaccionesCuentas.PAGO_TARJETA_UNI.tomarTransaccion(),
                "PagoTarjetaUni",
                ProcesoPagoTarjetaUni.conLaInformacion(InformacionFavorito.pagoTarjetaUni())
        );
    }

    public static Favorito pagoPrestamoTercero(){
        return new Favorito(
                InformacionFavorito.pagoPrestamoTerceros(),
                TransaccionesCuentas.PAGO_DE_PRESTRAMO.tomarTransaccion(),
                "FavoritoPagoTercero",
                ProcesoPagoPrestamoATercero.conLaInformacion(InformacionFavorito.pagoPrestamoTerceros())
        );
    }

    public static Favorito pagoPrestamoTransfer365(){
        return new Favorito(
                InformacionFavorito.pagoPrestamoTransfer365(),
                TransaccionesCuentas.PAGO_PRESTAMO_TRANSFER365.tomarTransaccion(),
                "cliente favorito",
                ProcesoPagoDePrestamoTransfer365.conLaInformacion(InformacionFavorito.pagoPrestamoTransfer365())
        );
    }

    public static Favorito pagoTarjetaTransfer365(){
        return new Favorito(
                InformacionFavorito.pagoTarjetaTransfer365(),
                TransaccionesCuentas.PAGO_TARJETA_TRANSFER365.tomarTransaccion(),
                "tdc transfer365",
                ProcesoPagoDeTarjetaTransfer365.conLaInformacion(InformacionFavorito.pagoTarjetaTransfer365())
        );
    }

    public static Favorito pagoPrestamouni(){
        return new Favorito(
                InformacionFavorito.pagoPrestamoUni(),
                TransaccionesCuentas.PAGO_PRESTAMO_UNI.tomarTransaccion(),
                "FavoritoPRCUS",
                ProcesoPagoPrestamoUni.conLaInformacion(InformacionFavorito.pagoPrestamoUni())

        );

    }    public static Favorito pagoTarjetaTercero(){
        return new Favorito(
                InformacionFavorito.pagoTarjetaTercero(),
                TransaccionesCuentas.PAGO_DE_TARJETA.tomarTransaccion(),
                "Tarjeta tercero",
                ProcesoPagoTarjetaTercero.conLaInformacion(InformacionFavorito.pagoTarjetaTercero())
        );
    }

    public static Favorito transferenciaTransfer365Movil() {
        return new Favorito(
                InformacionFavorito.transferenciaTransfer365Movil(),
                TransaccionesCuentas.TRANSFER365_MOVIL.tomarTransaccion(),
                "Transfer365Movil",
                ProcesoTransferencia365Movil.conLaInformacion(InformacionFavorito.transferenciaTransfer365Movil())
        );
    }
}
