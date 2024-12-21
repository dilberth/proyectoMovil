package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models;

public class Ahorros {

    private String cuentaOrigen;
    private String monto;
    private String cuentaDestino;
    private String concepto;
    private String correo;
    private String celular;
    private String nombreMeta;
    private String montoMeta;
    private String plazoMeta;
    private String diaRetencion;
    private String cuentaARelacionar;
    private String aporteMeta;
    private String retiroMeta;
    private String periodo;
    private String fechaDesde;
    private String fechaHasta;
    private String cuotaMensual;

    public String getMonto() {
        return Colocar.valorPorDefecto("Monto").alCampo(monto);
    }
    public void setMonto(String monto) {
        this.monto = monto;
    }

    public String getCuentaOrigen() {
        return Colocar.valorPorDefecto("Hola Gabriel").alCampo(cuentaOrigen);
    }
    public void setCuentaOrigen(String cuentaOrigen) {
        this.cuentaOrigen = cuentaOrigen;
    }

    public String getCuentaDestino() {
        return cuentaDestino;
    }
    public void setCuentaDestino(String cuentaDestino) {
        this.cuentaDestino = cuentaDestino;
    }

    public String getConcepto() {
        return concepto;
    }
    public void setConcepto(String concepto) {
        this.concepto = concepto;
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

    public String getNombreMeta() {
        return nombreMeta;
    }
    public void setNombreMeta(String nombreMeta) {
        this.nombreMeta = nombreMeta;
    }

    public String getMontoMeta() {
        return TargetApp.soIsIos()?montoMeta+"00":montoMeta;
    }
    public void setMontoMeta(String montoMeta) {
        this.montoMeta = montoMeta;
    }

    public String getPlazoMeta() {
        return plazoMeta;
    }
    public void setPlazoMeta(String plazoMeta) {
        this.plazoMeta = plazoMeta;
    }

    public String getDiaRetencion() {
        return diaRetencion;
    }
    public void setDiaRetencion(String diaRetencion) { this.diaRetencion = diaRetencion; }

    public String getCuentaARelacionar() {
        return cuentaARelacionar;
    }
    public void setCuentaARelacionar(String cuentaARelacionar) { this.cuentaARelacionar = cuentaARelacionar; }

    public String getAporteMeta() {
        return TargetApp.soIsIos()?aporteMeta+"00":aporteMeta;
    }
    public void setAporteMeta(String aporteMeta) { this.aporteMeta = aporteMeta; }

    public String getRetiroMeta() {
        return TargetApp.soIsIos()?retiroMeta+"00":retiroMeta;
    }
    public void setRetiroMeta(String retiroMeta) { this.retiroMeta = retiroMeta; }

    public String getPeriodo() {
        return periodo;
    }
    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getFechaDesde() {
        return fechaDesde;
    }
    public void setFechaDesde(String fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public String getFechaHasta() {
        return fechaHasta;
    }
    public void setFechaHasta(String fechaHasta) {

        this.fechaHasta = fechaHasta;
    }

    public String getCuotaMensual() {
        return cuotaMensual;
    }

    public void setCuotaMensual(String cuotaMensual) {
        this.cuotaMensual = cuotaMensual;
    }

    public static class Colocar{

        private String defecto;

        public Colocar(String defecto) {
            this.defecto = defecto;
        }

        public static Colocar valorPorDefecto(String dato){
            return new Colocar(dato);
        }

        public String alCampo(String campo){
            return campo == null ? defecto : campo;
        }

    }


}
