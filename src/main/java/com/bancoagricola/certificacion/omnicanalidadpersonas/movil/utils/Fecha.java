package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Fecha {

    private String fechaInicio;
    private String fechaFin;

    public Fecha(String fechaInicio, String fechaFin) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public static Map<InfoFecha,String> consulta(String fecha){

        Map<InfoFecha,String> infoFecha = new HashMap<>();

        try {
            infoFecha.put(InfoFecha.DIA,new SimpleDateFormat("d", Locale.forLanguageTag("ES")).format(new SimpleDateFormat("dd/MM/yyyy", Locale.forLanguageTag("ES")).parse(fecha)));
            infoFecha.put(InfoFecha.MES,new SimpleDateFormat("MMMM", Locale.forLanguageTag("ES")).format(new SimpleDateFormat("dd/MM/yyyy", Locale.forLanguageTag("ES")).parse(fecha)));
            infoFecha.put(InfoFecha.ANO,new SimpleDateFormat("yyyy", Locale.forLanguageTag("ES")).format(new SimpleDateFormat("dd/MM/yyyy", Locale.forLanguageTag("ES")).parse(fecha)));
        } catch (ParseException e) {
            throw new IllegalArgumentException("dateFormatter(): " + e.getMessage());
        }

        return infoFecha;

    }

    public static Fecha rango(String fechaInicio, String fechaFin){
        return new Fecha(fechaInicio,fechaFin);
    }

    public static Fecha desde(String fechaInicio){
        return new Fecha(fechaInicio,"");
    }

    public static Fecha hasta(String fechaFin){
        return new Fecha("",fechaFin);
    }

    public static String tomarFecha(){
        return new SimpleDateFormat("ddMMYYhhmmss").format(new Date());
    }

    public String tomarFechaInicio() {
        return fechaInicio;
    }

    public String tomarFechaFin() {
        return fechaFin;
    }
}
