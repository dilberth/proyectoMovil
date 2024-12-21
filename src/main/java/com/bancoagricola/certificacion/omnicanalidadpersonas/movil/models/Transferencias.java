package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models;

public class Transferencias {

    private String cuentaOrigen;
    private String cuentaDestino;
    private String monto;
    private String concepto;
    private String correo;
    private String tipoCliente;
    private String apellidoRecibidor;
    private String tarjetaCredito;
    private String cuentaTercero;
    private String numeroPrestamo;
    private String tarjetaCreditoTercero;
    private String tarjetaOtroBanco;
    private String nombreRecibidor;
    private String periodo;
    private String fechaDesde;
    private String fechaHasta;
    private String banco;
    private String compania;
    private String montopaquete;
    private String celular;
    private String nombrefavorito = "";
    private String tipoIdentificacion;
    private String numeroIdentificacion;
    private String tipoCuenta;
    private String nombreAhorroProgramado;
    private String tipoOperacion;
    private String institucionOng;
    private String tipoCobro;
    private String productoAbonar;
    private String fechaSalida;
    private String fechaRegreso;
    private String paisDestino;
    private String comentarios;
    private String compraPlazo;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private String numeroLifemiles;
    private String puntos;
    private String codigoPais;
    private String numeroTelefono;
    private String cargo;
    private String extrafinanciamiento;
    private String limitePorTRX;
    private String limiteSem;
    private String npe;
    private String ads;
    private String usuario;
    private String permisos;
    private String opcion;
    private String vigencia;
    private String tipoChequera;
    private String cantidadCheques;
    private String departamentoEntrega;
    private String agenciaEntrega;
    private String chequera;
    private String estadoCheques;
    private String fondoInversion;
    private String tipoTRX;
    private String canal;
    private String montoDesde;
    private String montoHasta;
    private String estadoTRX;
    private String contrato;
    private String qrComercio;
    private String institucionDestino;
    private String tipoPago;
    private String descripcion;
    private String paisBanBen;
    private String bancoBen;
    private String iBAN;
    private String nombreRec;
    private String docRec;
    private String ciudadRec;
    private String direccion;
    private String tipoProd;




    public Transferencias() {
    }

    public String getInstitucionDestino() {
        return institucionDestino;
    }

    public void setInstitucionDestino(String institucionDestino) {
        this.institucionDestino = institucionDestino;
    }

    public String getApellidoRecibidor() {
        return apellidoRecibidor;
    }

    public void setApellidoRecibidor(String apellidoRecibidor) {
        this.apellidoRecibidor = apellidoRecibidor;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public String getCuentaOrigen() {
        return cuentaOrigen;
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

    public String getMonto() {
        return TargetApp.soIsIos()?(String.valueOf(Integer.parseInt(monto)*100)):monto;
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

    public String getTarjetaCredito() {
        return tarjetaCredito;
    }

    public void setTarjetaCredito(String tarjetaCredito) {
        this.tarjetaCredito = tarjetaCredito;
    }

    public String getCuentaTercero() {
        return cuentaTercero;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNumeroPrestamo() {
        return numeroPrestamo;
    }

    public void setNumeroPrestamo(String numeroPrestamo) {
        this.numeroPrestamo = numeroPrestamo;
    }

    public String getTarjetaCreditoTercero() {
        return tarjetaCreditoTercero;
    }

    public void setTarjetaCreditoTercero(String tarjetaCreditoTercero) {
        this.tarjetaCreditoTercero = tarjetaCreditoTercero;
    }

    public String getfechaDesde() {
        return getFechaDesde();
    }

    public String getfechaHasta() {
        return getFechaHasta();
    }

    public String getperiodo() {
        return getPeriodo();
    }

    public String getNombreRecibidor() {
        return nombreRecibidor;
    }

    public void setNombreRecibidor(String nombreRecibidor) {
        this.nombreRecibidor = nombreRecibidor;
    }

    public String getPeriodo() {
        return periodo;
    }

    public String getFechaDesde() {
        return fechaDesde;
    }

    public String getFechaHasta() {
        return fechaHasta;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getTarjetaOtroBanco() {
        return tarjetaOtroBanco;
    }

    public void setTarjetaOtroBanco(String tarjetaOtroBanco) {
        this.tarjetaOtroBanco = tarjetaOtroBanco;
    }

    public String getCompania() {
        return compania;
    }

    public String getMontopaquete() {
        return montopaquete;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getNombrefavorito() {
        return nombrefavorito;
    }

    public void setNombrefavorito(String favorito) {
        this.nombrefavorito = favorito;
    }

    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public String getnombreAhorroProgramado() {
        return nombreAhorroProgramado;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public String getTipoCobro() {
        return tipoCobro;
    }

    public String getInstitucionOng() {
        return institucionOng;
    }

    public String getProductoAbonar() {
        return productoAbonar;
    }

    public String getfechaSalida() {
        return fechaSalida;
    }

    public String getfechaRegreso() {
        return fechaRegreso;
    }

    public String getpaisDestino() {
        return paisDestino;
    }

    public String getcomentarios() {
        return comentarios;
    }

    public String getcompraPlazo() {
        return compraPlazo;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public String getNumeroLifemiles() {
        return numeroLifemiles;
    }

    public String getPuntos() {
        return puntos;
    }

    public String getCodigoPais() {
        return codigoPais;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public String getCargo() {
        return cargo;
    }

    public String getExtrafinanciamiento() {
        return extrafinanciamiento;
    }

    public String getLimitePorTRX() {
        return limitePorTRX;
    }

    public void setLimitePorTRX(String limitePorTRX) {
        this.limitePorTRX = limitePorTRX;
    }

    public String getLimiteSem() {
        return limiteSem;
    }

    public void setLimiteSem(String limiteSem) {
        this.limiteSem = limiteSem;
    }

    public String getNpe() {
        return npe;
    }

    public void setNpe(String npe) {
        this.npe = npe;
    }

    public String getAds() {
        return ads;
    }

    public void setAds(String ads) {
        this.ads = ads;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPermisos() {
        return permisos;
    }

    public void setPermisos(String permisos) {
        this.permisos = permisos;
    }

    public String getOpcion() {
        return opcion;
    }

    public void setOpcion(String opcion) {
        this.opcion = opcion;
    }

    public String getVigencia() {
        return vigencia;
    }

    public String getTipoChequera() {
        return tipoChequera;
    }

    public void setTipoChequera(String tipoChequera) {
        this.tipoChequera = tipoChequera;
    }

    public String getCantidadCheques() {
        return cantidadCheques;
    }

    public void setCantidadCheques(String cantidadCheques) {
        this.cantidadCheques = cantidadCheques;
    }

    public String getDepartamentoEntrega() {
        return departamentoEntrega;
    }

    public void setDepartamentoEntrega(String departamentoEntrega) {
        this.departamentoEntrega = departamentoEntrega;
    }

    public String getAgenciaEntrega() {
        return agenciaEntrega;
    }

    public void setAgenciaEntrega(String agenciaEntrega) {
        this.agenciaEntrega = agenciaEntrega;
    }

    public String getChequera() {
        return chequera;
    }

    public void setChequera(String chequera) {
        this.chequera = chequera;
    }

    public String getEstadoCheques() {
        return estadoCheques;
    }

    public void setEstadoCheques(String estadoCheques) {
        this.estadoCheques = estadoCheques;
    }

    public String getFondoInversion() {
        return fondoInversion;
    }

    public String getTipoTRX() {
        return tipoTRX;
    }
    public void setTipoTRX(String tipoTRX) {
        this.tipoTRX = tipoTRX;
    }

    public String getCanal() {
        return canal;
    }
    public void setCanal(String canal) {
        this.canal = canal;
    }

    public String getMontoDesde() {
        return montoDesde;
    }
    public void setMontoDesde(String montoDesde) {
        this.montoDesde = montoDesde;
    }

    public String getMontoHasta() {
        return montoHasta;
    }
    public void setMontoHasta(String montoHasta) {
        this.montoHasta = montoHasta;
    }

    public String getEstadoTRX() {
        return estadoTRX;
    }
    public void setEstadoTRX(String estadoTRX) {
        this.estadoTRX = estadoTRX;
    }

    public String getContrato() { return contrato; }
    public void setContrato(String contrato) {
        this.contrato = contrato;
    }

    public String getQrComercio() {
        return qrComercio;
    }

    public void setQrComercio(String qrComercio) {
        this.qrComercio = qrComercio;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPaisBanBen() {
        return paisBanBen;
    }

    public void setPaisBanBen(String paisBanBen) {
        this.paisBanBen = paisBanBen;
    }

    public String getBancoBen() {
        return bancoBen;
    }

    public void setBancoBen(String bancoBen) {
        this.bancoBen = bancoBen;
    }

    public String getiBAN() {
        return iBAN;
    }

    public void setiBAN(String iBAN) {
        this.iBAN = iBAN;
    }

    public String getNombreRec() {
        return nombreRec;
    }

    public void setNombreRec(String nombreRec) {
        this.nombreRec = nombreRec;
    }

    public String getDocRec() {
        return docRec;
    }

    public void setDocRec(String docRec) {
        this.docRec = docRec;
    }

    public String getCiudadRec() {
        return ciudadRec;
    }

    public void setCiudadRec(String ciudadRec) {
        this.ciudadRec = ciudadRec;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTipoProd() {
        return tipoProd;
    }

    public void setTipoProd(String tipoProd) {
        this.tipoProd = tipoProd;
    }
}
