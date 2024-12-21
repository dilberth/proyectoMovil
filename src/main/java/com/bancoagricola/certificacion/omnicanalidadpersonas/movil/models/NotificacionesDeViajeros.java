package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models;

public class NotificacionesDeViajeros {

    private String tarjetaCredito;
    private String fechaSalida;
    private String fechaRegreso;
    private String paisDestino;
    private String comentarios;

    public String getTarjetaCredito() {
        return tarjetaCredito;
    }
    public void setTarjetaCredito(String tarjetaCredito) {
        this.tarjetaCredito = tarjetaCredito;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }
    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getFechaRegreso() {
        return fechaRegreso;
    }
    public void setFechaRegreso(String fechaRegreso) {
        this.fechaRegreso = fechaRegreso;
    }

    public String getPaisDestino() {
        return paisDestino;
    }
    public void setPaisDestino(String v) {
        this.paisDestino = paisDestino;
    }

    public String getComentarios() {
        return comentarios;
    }
    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

}
