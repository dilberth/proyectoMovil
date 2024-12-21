package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models;

public class InformacionFavorito {

    public static Transferencias pagoPrestamoTerceros() {
        Transferencias informacionFavorito = new Transferencias();
        informacionFavorito.setCuentaOrigen("3111466124 Cuenta de ahorro");
        informacionFavorito.setNumeroPrestamo("8094512503");
        informacionFavorito.setMonto("1");
        informacionFavorito.setConcepto("pago prestamo terceros automatico");
        informacionFavorito.setCorreo("eguevara@bancoagricola.com.sv");
        return informacionFavorito;
    }

    public static Transferencias pagoTarjetaUni() {
        Transferencias informacionFavorito = new Transferencias();
        informacionFavorito.setCuentaOrigen("31320008506 Cuenta de ahorro");
        informacionFavorito.setBanco("DAVIVIENDA");
        informacionFavorito.setTarjetaOtroBanco("4295185516887952");
        informacionFavorito.setTipoIdentificacion("DUI");
        informacionFavorito.setNumeroIdentificacion("000205901");
        informacionFavorito.setNombreRecibidor("LUIS LOPEZ");
        informacionFavorito.setMonto("1");
        informacionFavorito.setCorreo("eguevara@bancoagricola.com.sv");
        informacionFavorito.setConcepto("Pago tarjeta UNI Nuevo");
        return informacionFavorito;
    }

    public static Transferencias pagoTarjetaTransfer365() {
        Transferencias informacionFavorito = new Transferencias();
        informacionFavorito.setCuentaOrigen("3670258771 Cuenta de ahorro");
        informacionFavorito.setBanco("B. DAVIVIENDA SALVADORENO S.A.");
        informacionFavorito.setCuentaDestino("4295185516887952");
        informacionFavorito.setTipoCliente("Natural");
        informacionFavorito.setNombreRecibidor("LUIS");
        informacionFavorito.setApellidoRecibidor("LOPEZ");
        informacionFavorito.setMonto("1");
        informacionFavorito.setCorreo("eguevara@bancoagricola.com.sv");
        informacionFavorito.setConcepto("transfer365");
        return informacionFavorito;
    }

    public static Transferencias pagoPrestamoTransfer365() {
        Transferencias informacionFavorito = new Transferencias();
        informacionFavorito.setCuentaOrigen("3111466124 Cuenta de ahorro");
        informacionFavorito.setBanco("BANCO CUSCATLAN DE EL SALVADOR, S.A.");
        informacionFavorito.setCuentaDestino("1065605");
        informacionFavorito.setTipoCliente("Jurídico");
        informacionFavorito.setApellidoRecibidor("LOPEZ");
        informacionFavorito.setNombreRecibidor("LUIS");
        informacionFavorito.setMonto("1");
        informacionFavorito.setConcepto("transfer365");
        informacionFavorito.setCorreo("eguevara@bancoagricola.com.sv");
        return informacionFavorito;
    }

    public static Transferencias pagoPrestamoUni() {
        Transferencias informacionFavorito = new Transferencias();
        informacionFavorito.setCuentaOrigen("31320008506 Cuenta de ahorro");
        informacionFavorito.setBanco("BANCO HIPOTECARIO");
        informacionFavorito.setNumeroPrestamo("PH0284781");
        informacionFavorito.setTipoIdentificacion("Pasaporte");
        informacionFavorito.setNumeroIdentificacion("123456789");
        informacionFavorito.setNombreRecibidor("Juan Perez");
        informacionFavorito.setCorreo("eguevara@bancoagricola.com.sv");
        informacionFavorito.setMonto("1");
        informacionFavorito.setConcepto("PruebaUNI");
        return informacionFavorito;
    }

    public static Transferencias pagoTarjetaTercero() {
        Transferencias informacionFavorito = new Transferencias();
        informacionFavorito.setCuentaOrigen("3220194022 Cuenta de ahorro");
        informacionFavorito.setTarjetaCreditoTercero("4567940322869458");
        informacionFavorito.setMonto("1");
        informacionFavorito.setConcepto("pagar tarjeta a terceros automatico");
        informacionFavorito.setCorreo("eguevara@bancoagricola.com.sv");
        return informacionFavorito;
    }

    public static Transferencias transferenciaTransfer365Movil() {
        Transferencias informacionFavorito = new Transferencias();
        informacionFavorito.setCuentaOrigen("3000787435 Cuenta de ahorro");
        informacionFavorito.setCelular("76156451");
        informacionFavorito.setInstitucionDestino("BANCOVI");
        informacionFavorito.setNombreRecibidor("Jose Perez");
        informacionFavorito.setMonto("1");
        informacionFavorito.setConcepto("pagar tarjeta a terceros automatico");
        informacionFavorito.setCorreo("eguevara@bancoagricola.com.sv");
        return informacionFavorito;
    }
}
