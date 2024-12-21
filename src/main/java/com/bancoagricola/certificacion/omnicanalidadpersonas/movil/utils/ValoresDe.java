package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.*;

import java.util.LinkedHashMap;
import java.util.Map;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Constantes.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.TipoElemento.*;

public class ValoresDe {

    public static Map<String, TipoElemento> elementosValoresAhorros = new LinkedHashMap<String, TipoElemento>() {{
        put(TXTMETA, VALOR_DINERO);
        put(TXTAHORRO_ACUMULADO, VALOR_DINERO);
        put(NUMERO_A, POSICION_LATERAL);
    }};

    public static Map<String, TipoElemento> elementosValoresAhorrosVerMas = new LinkedHashMap<String, TipoElemento>() {
        {
            put(TITULO_AHORRO, TITULO_UNO);
            put(TXTAHORRO_ACUMULADO, VALOR_DINERO);
            put(TXTMETA, VALOR_DINERO);
            put(TXTNUMERO, POSICION_ABAJO);
            put(TXTFECHA_VENCIMIENTO, POSICION_ABAJO);
        }
    };

    public static Map<String, TipoElemento> elementoValoresAhorrosDetalles = new LinkedHashMap<String, TipoElemento>() {
        {
            put(TXTALIAS_CUENTA, POSICION_ABAJO);
            put(TXTTIPOCUENTA, POSICION_ABAJO);
            put(TXTNUMERO_CUENTA, POSICION_ABAJO);
            put(TXTFECHA_CONTRATACION, POSICION_ABAJO);
            put(TXTCUOTA_MENSUAL, VALOR_DINERO);
            put(TXTDIA_CARGO, POSICION_ABAJO);
            put(TXTPLAZO_MESES, POSICION_ABAJO);
            put(TXTFECHA_VENCIMIENTO, POSICION_ABAJO);
            put(TXTAHORRO_ACUMULADO, VALOR_DINERO);
        }
    };
    
    public static Map<String,TipoElemento> valoresCuentas = new LinkedHashMap<String,TipoElemento>(){{
        put(TITULO_AHORRO, TITULO_UNO);
        put(TXTSALDO_DISPONIBLE, VALOR_DINERO);
        put(NUMERO_A, POSICION_LATERAL);
    }};

    public static Map<String,TipoElemento> valoresCuentasVerMas = new LinkedHashMap<String,TipoElemento>(){{
        put(TITULO_AHORRO, TITULO_UNO);
        put(TXTSALDO_DISPONIBLE, VALOR_DINERO);
        put(TXTSALDO_RETENIDO, VALOR_DINERO);
        put(NUMERO_A, POSICION_LATERAL);
    }};

    public static Map<String,TipoElemento> valoresCuentaDeAhorrosMasDetalle = new LinkedHashMap<String,TipoElemento>(){{
        put(TXTALIAS_CUENTA, POSICION_ABAJO);
        put(TXTTIPOCUENTA, POSICION_ABAJO);
        put(TXTNUMERO_CUENTA, POSICION_ABAJO);
        put(TXTSALDO_DISPONIBLE, VALOR_DINERO);
    }};

    public static Map<String,TipoElemento> valoresCuentaDeCorrienteMasDetalle = new LinkedHashMap<String,TipoElemento>(){{
        put(TXTALIAS_CUENTA, POSICION_ABAJO);
        put(TXTTIPOCUENTA, POSICION_ABAJO);
        put(TXTNUMERO_CUENTA, POSICION_ABAJO);
        put(TXTSALDO_DISPONIBLE, VALOR_DINERO);
        put(TXTMONTO, VALOR_DINERO);
        put(TXTTASA_INTERES, POSICION_ABAJO);
        put(TXTMONTO_DISPONIBLE, VALOR_DINERO);
        put(TXTDIAS_DE_USO, POSICION_ABAJO);
    }};

    public static Map<String,TipoElemento> valoresCuentaDeCorrienteAdelantoSalarialMasDetalle = new LinkedHashMap<String,TipoElemento>(){{
        put(TXTALIAS_CUENTA, POSICION_ABAJO);
        put(TXTTIPOCUENTA, POSICION_ABAJO);
        put(TXTNUMERO_CUENTA, POSICION_ABAJO);
        put(TXTMONTO_APROBADO, VALOR_DINERO);
        put(TXTMONTO_UTILIZADO, VALOR_DINERO);
        put(TXTMONTO_DISPONIBLE, VALOR_DINERO);
        put(TXTMONTO_A_PAGAR, VALOR_DINERO);
        put(TXTPORCENTAJE, POSICION_ABAJO);
    }};

    public static Map<String,TipoElemento> valoresCuentasDepositoPlazos = new LinkedHashMap<String,TipoElemento>(){{
        put(TITULO_AHORRO, TITULO_UNO);
        put(TXTSALDO_DISPONIBLE, VALOR_DINERO);
        put(NUMERO_A, POSICION_ARRIBA);
    }};

    public static Map<String,TipoElemento> valoresCuentasDepositoPlazosVerMas = new LinkedHashMap<String,TipoElemento>(){{
        put(TITULO_AHORRO, TITULO_UNO);
        put(TXTSALDO_PRINCIPAL, VALOR_DINERO);
        put(NUMERO_A, POSICION_LATERAL);
        put(TXTFECHA_DE_VENCIMIENTO, POSICION_ARRIBA);
    }};

    public static Map<String,TipoElemento> valoresCuentasDepositoPlazosMasDetalles = new LinkedHashMap<String,TipoElemento>(){{
        put(TXTALIAS_CUENTA, POSICION_ABAJO);
        put(TXTTIPOCUENTA, POSICION_ABAJO);
        put(TXTNUMERO_CUENTA, POSICION_ABAJO);
        put(TXTSALDO_PRINCIPAL, VALOR_DINERO);
        put(TXTFECHA_DE_VENCIMIENTO, POSICION_ABAJO);
        put(TXTULTIMO_PAGO, POSICION_ABAJO);
        put(TXTMONTO_INICIAL, VALOR_DINERO);
        put(TXTTASA_INTERES, POSICION_ABAJO);
        put(TXTSALDO_PIGNORADO, VALOR_DINERO);
    }};

    public static Map<String,TipoElemento> valoresPrestamo = new LinkedHashMap<String,TipoElemento>(){{
        put(TITULO_AHORRO, TITULO_UNO);
        put(TXTDEUDA_TOTAL, VALOR_DINERO);
        put(NUMERO_A, POSICION_ARRIBA);
        put(TXTFECHA_DE_PAGO, POSICION_ARRIBA);
    }};

    public static Map<String,TipoElemento> valoresPrestamoExtrafinanciamientoVerMas = new LinkedHashMap<String,TipoElemento>(){{
        put(TITULO_AHORRO, TITULO_UNO);
        put(TXTDEUDA_TOTAL, VALOR_DINERO);
        put(NUMERO_A, POSICION_LATERAL);
        put(TXTFECHA_DE_PAGO, POSICION_ARRIBA);
    }};

    public static Map<String,TipoElemento> valoresPrestamoVerMas = new LinkedHashMap<String,TipoElemento>(){{
        put(TITULO_AHORRO, TITULO_UNO);
        put(TXTDEUDA_TOTAL, VALOR_DINERO);
        put(NUMERO_A, POSICION_ARRIBA);
        put(TXTFECHA_DE_PAGO, POSICION_ARRIBA);
    }};

    public static Map<String,TipoElemento> valoresPrestamoMasDetalle = new LinkedHashMap<String,TipoElemento>(){{
        put(TXTALIAS_O_REFERENCIA, POSICION_ABAJO);
        put(TXTTIPO, POSICION_ABAJO);
        put(TXTNUMERO, POSICION_ABAJO);
        put(TXTMONTO_ORIGINAL, VALOR_DINERO);
        put(TXTDEUDA_TOTAL, VALOR_DINERO);
        put(TXTCUOTA, VALOR_DINERO);
        put(TXTTASA_INTERES, POSICION_ABAJO);
        put(TXTFECHA_DE_PAGO, POSICION_ABAJO);
        put(TXTVALOR_PENDIENTE_PAGO, VALOR_DINERO);
        put(TXTCUOTAS_EN_MORA, POSICION_ABAJO);
        put(TXTDIAS_EN_MORA, POSICION_ABAJO);
    }};

    public static Map<String,TipoElemento> valoresFondoDeInversion = new LinkedHashMap<String,TipoElemento>(){{
        put(TXTTIPO_FONDO_INVERSION, POSICION_ARRIBA);
        put(NUMERO_A, POSICION_ARRIBA);
        put(TXTSALDO_DISPONIBLE, VALOR_DINERO);
    }};

    public static Map<String,TipoElemento> valoresFondoDeInversionVerMas = new LinkedHashMap<String,TipoElemento>(){{
        put(TXTSALDO_DISPONIBLE, VALOR_DINERO);
        put(TXTNUMERO_CUENTA, POSICION_ARRIBA);
        put(TXTTIPO_FONDO_INVERSION, POSICION_ARRIBA);
        put(TXTMONTO_MAXIMO_RETIRO, VALOR_DINERO);
    }};

    public static Map<String,TipoElemento> valoresFondoDeInversionMasDetalle = new LinkedHashMap<String,TipoElemento>(){{
        put(TXTALIAS, POSICION_ABAJO);
        put(TXTNUMERO_REFERENCIA, POSICION_ABAJO);
        put(TXTTIPO_FONDO_INVERSION, POSICION_ABAJO);
        put(TXTSALDO_DISPONIBLE, VALOR_DINERO);
        put(TXTMONTO_MAXIMO_RETIRO, VALOR_DINERO);
        put(TXTFECHA, POSICION_ABAJO);
        put(TXTSALDO_POR_EFECTIVIZAR, VALOR_DINERO);
        put(TXTSALDO_PROTEGIDO, VALOR_DINERO);
    }};

    public static Map<String,TipoElemento> valoresMeta = new LinkedHashMap<String,TipoElemento>(){{
        put(TXTMETA, VALOR_DINERO);
        put(TXTMONTO_ACUMULADO, VALOR_DINERO);
        put(TXTCUOTA, VALOR_DINERO);
        put(TXTPLAZO, POSICION_ABAJO);
        put(NUMERO_A, POSICION_ABAJO);
    }};

    public static Map<String,TipoElemento> valoresMetaVerMas = new LinkedHashMap<String,TipoElemento>(){{
        put(TXTALIAS, TITULO_UNO);
        put(TXTMONTO_ACUMULADO, VALOR_DINERO);
        put(TXTMETA, VALOR_DINERO);
        put(TXTCUOTA, VALOR_DINERO);
        put(TXTPORCENTAJE_CUMPLIMIENTO, POSICION_ABAJO);
        put(TXTPLAZO, POSICION_ABAJO);
        put(TXTPLAZO_TRANSCURRIDO, POSICION_ABAJO);
        put(TXTDIA_RETENCION, POSICION_ABAJO);
        put(TXTNUMERO, POSICION_ABAJO);
    }};


    public static Map<String, TipoElemento> detallePuntos = new LinkedHashMap<String,TipoElemento>(){{
        put(TXTALIAS,TITULO_UNO);
        put(TXTSALDO_EN_DOLARES,VALOR_DINERO);
        put(TXTPUNTOS_ACUMULADOS, TargetApp.soIsIos()?POSICION_ABAJO:POSICION_ARRIBA);
    }};

    public static Map<String, TipoElemento> detallePuntosVerMas = new LinkedHashMap<String,TipoElemento>(){{
        put(TXTALIAS,TITULO_UNO);
        put(TXTPUNTOS_ACUMULADOS,POSICION_ARRIBA);
        put(TXTSALDO_EN_DOLARES,VALOR_DINERO);
    }};

    public static Map<String, TipoElemento> detallePuntosMasDetalle = new LinkedHashMap<String,TipoElemento>(){{
        put(TXTALIAS,POSICION_ARRIBA);
        put(TXTPUNTOS_ACUMULADOS,POSICION_ARRIBA);
        put(TXTSALDO_EN_DOLARES,VALOR_DINERO);
        put(TXTPROXIMO_A_VENCER,POSICION_ARRIBA);
        put(TXTTIPO,POSICION_ARRIBA);
    }};


    public static Map<String, TipoElemento> tarjetaDeCredito = new LinkedHashMap<String,TipoElemento>(){{
        put(TXTSALDO_DISPONIBLE,VALOR_DINERO);
        put(TXTTIPO,POSICION_ARRIBA);
        put(TXTFECHA_DE_PAGO,POSICION_ARRIBA);
    }};

    public static Map<String, TipoElemento> tarjetaDeCreditoVerMas = new LinkedHashMap<String,TipoElemento>(){{
        put(TXTTARJETA_CREDITO,POSICION_ARRIBA);
        put(TXTTIPO,POSICION_ARRIBA);
        put(TXTSALDO_DISPONIBLE,VALOR_DINERO);
        put(TXTFECHA_DE_PAGO,POSICION_ARRIBA);
        put(TXTSALDO_A_PAGAR,VALOR_DINERO);
    }};

    public static Map<String, TipoElemento> tarjetaDeCreditoMasDetalle = new LinkedHashMap<String,TipoElemento>(){{
        put(TXTALIAS_DE_TARJETA,POSICION_ABAJO);
        put(TXTTIPO,POSICION_ABAJO);
        put(TXTNUMERO,POSICION_ABAJO);
        put(TXTSALDO_DISPONIBLE,VALOR_DINERO);
        put(TXTSALDO_RETENIDO,VALOR_DINERO);
        put(TXTLIMITE_OTORGADO,VALOR_DINERO);
        put(TXTSOBREGIRO,VALOR_DINERO);
        put(TXTPAGOMINIMO,VALOR_DINERO);
        put(TXTPAGO_CONTADO,VALOR_DINERO);
        put(TXTSALDO_A_PAGAR,VALOR_DINERO);
        put(TXTFECHA_DE_PAGO,POSICION_ABAJO);
        put(TXTDIA_CORTE,POSICION_ABAJO);
        put(TXTTASA_INTERES,POSICION_ABAJO);
    }};

    public static Map<String, TipoElemento> cvv2YFechaDeExpitacionEcard = new LinkedHashMap<String,TipoElemento>(){{
        put(TXTTARJETA_TITULAR,POSICION_ABAJO);
        put(TXTTARJETA_ECARD,POSICION_ABAJO);
        put(TXTCONDIGO_SEGURIDAD,POSICION_ABAJO);
        put(TXTFECHA_VENCIMIENTO,POSICION_ABAJO);
    }};

}
