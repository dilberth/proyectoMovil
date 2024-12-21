package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models;

public class InformacionCobroAmigo {

    private String cuentaOrigen;
    private String nombre;
    private String correo;
    private String celular;
    private String monto;

    public InformacionCobroAmigo(String cuentaOrigen, String nombre, String correo, String celular, String monto) {
        this.cuentaOrigen = cuentaOrigen;
        this.nombre = nombre;
        this.correo = correo;
        this.celular = celular;
        this.monto = monto;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }
}
