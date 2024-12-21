package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models;

public class InformacionPagoAmigo {

    private String cuentaOrigen;
    private String nombre;
    private String monto;
    private String concepto;

    public InformacionPagoAmigo(String cuentaOrigen, String nombre, String monto, String concepto) {
        this.cuentaOrigen = cuentaOrigen;
        this.nombre = nombre;
        this.monto = monto;
        this.concepto = concepto;
    }

    public String getCuentaOrigen() {
        return cuentaOrigen;
    }

    public void setCuentaOrigen(String cuentaOrigen) {
        this.cuentaOrigen = cuentaOrigen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }
}
