package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface;

import io.appium.java_client.*;
import net.serenitybdd.screenplay.targets.*;

public class UiCuentas {


    public static Target menuCuentas() {
        return ByTarget.the("menú 'Cuentas'").locatedForAndroid(MobileBy.AccessibilityId("Cuentas")).locatedForIOS(MobileBy.AccessibilityId("Cuentas"));
    }

    public static Target linkMasDetalles() {
        return ByTarget.the("link 'Más detalle'").locatedForAndroid(MobileBy.AccessibilityId("Más detalle")).locatedForIOS(MobileBy.AccessibilityId("Más detalle"));
    }

    public static Target opcionVerMas() {
        return ByTarget.the("opción 'Ver más'").locatedForAndroid(MobileBy.AccessibilityId("Ver más")).locatedForIOS(MobileBy.AccessibilityId("Ver más"));
    }

    public static Target opcionTransferir() {
        return ByTarget.the("opción 'Transferir'").locatedForAndroid(MobileBy.AccessibilityId("Transferir")).locatedForIOS(MobileBy.AccessibilityId("Transferir"));
    }

    public static Target aliasCa(String alias) {
        return ByTarget.the("'Alias de la cuenta'").locatedForAndroid(MobileBy.xpath("//*[contains(@text,'" + alias + "')]")).locatedForIOS(MobileBy.xpath("//*[contains(@label,'" + alias + "')]"));
    }

    public static Target alias2Ca(String alias) {
        return ByTarget.the("'Alias de la cuenta'").locatedForAndroid(MobileBy.xpath("//*[@text='" + alias + "']/preceding::*[1]")).locatedForIOS(MobileBy.xpath("//*[@label='" + alias + "']/preceding::*[1]"));
    }

    public static Target tipoCuentaCa(String cuenta) {
        return ByTarget.the("'Tipo de cuenta'").locatedForAndroid(MobileBy.xpath("//*[@text='" + cuenta + "']/following::*[1]")).locatedForIOS(MobileBy.xpath("//*[@label='" + cuenta + "']/following::*[@label!=''][1]"));
    }

    public static Target numeroCuenta1Ca(String numeroCuenta) {
        return ByTarget.the("'Número de cuenta'").locatedForAndroid(MobileBy.xpath("//*[@text='" + numeroCuenta + "']/following-sibling::*[8]")).locatedForIOS(MobileBy.xpath("//*[@label='" + numeroCuenta + "']/following-sibling::*[8]"));
    }

    public static Target saldoRetenido() {
        return ByTarget.the("'Saldo retenido'").locatedForAndroid(MobileBy.xpath("//*[@class='android.widget.TextView' and @index =(//*[@text='Saldo Retenido']/ancestor::*[1]/@index) - 1]")).locatedForIOS(MobileBy.xpath("(//*[@label='Saldo Retenido'])[1]/following::XCUIElementTypeStaticText[not(contains(@label,'$'))][1]"));
    }

    public static final Target LNK_ELIMINAR_FAVORITOS = Target.the("link 'Eliminar favoritos'").located(MobileBy.AccessibilityId("Eliminar favoritos"));
    public static final Target OPCION_TRANSF_365 = Target.the("opción 'Transferencias Transfer365: Operaciones entre bancos'").located(MobileBy.AccessibilityId("Transferencias Transfer365: Operaciones entre bancos"));
    public static final Target OPCION_TRANSF_TELETON = Target.the("opción 'Ayuda Teletón'").located(MobileBy.AccessibilityId("Ayuda Teletón"));
    public static final Target OPCION_RECARGA_OTRO_NUMERO = Target.the("opción 'Recargar otro número'").located(MobileBy.AccessibilityId("Recargar otro número"));
    public static final Target BTN_ACEPTAR = Target.the("botón 'ACEPTAR'").located(MobileBy.xpath("//android.widget.Button[@text='ACEPTAR']"));
    public static final Target BTN_VER_MAS_TAR = Target.the("botón 'Ver más tarjetas'").located(MobileBy.xpath("//android.widget.TextView[@text='Ver más tarjetas']"));

    //Actualización
    public static Target MENU_CUENTAS = Target.the("menu 'Cuentas'")
            .locatedForAndroid(MobileBy.AccessibilityId("Cuentas")).locatedForIOS(MobileBy.AccessibilityId("Cuentas"));

    public static Target PRODUCTO(String texto) {
        return ByTarget.the("'" + texto + "'").locatedForAndroid(MobileBy.xpath("//android.view.View/*[contains(@text,'" + texto + "')]")).locatedForIOS(MobileBy.xpath("//*[contains(@label,'" + texto + "')]"));
    }

    public static Target VER_MAS = Target.the("opción 'Ver más'")
            .locatedForAndroid(MobileBy.AccessibilityId("Ver más")).locatedForIOS(MobileBy.xpath(""));

    public static Target MAS_DETALLE = Target.the("opción 'Más detalle'")
            .locatedForAndroid(MobileBy.AccessibilityId("Más detalle")).locatedForIOS(MobileBy.xpath(""));
    public static Target LABEL_SALDO_DISPONIBLE = Target.the("'Saldo disponible'")
            .locatedForAndroid(MobileBy.xpath("//android.view.View[@text='Saldo disponible']")).locatedForIOS(MobileBy.xpath(""));
    public static Target SALDO_DISPONIBLE = Target.the("'Saldo disponible'")
            .locatedForAndroid(MobileBy.xpath("//android.view.View[@text='Saldo disponible']/following::*[1]")).locatedForIOS(MobileBy.xpath(""));
    public static Target BANNER_BANCO_AGRICOLA = Target.the("banner 'Banco Agrícola'")
            .locatedForAndroid(MobileBy.xpath("//android.view.View[@text='Banco Agrícola']")).locatedForIOS(MobileBy.xpath(""));

    //Transferencias cuentas propias
    public static Target TRANSFERIR = Target.the("opción 'Transferir'")
            .locatedForAndroid(MobileBy.AccessibilityId("Transferir")).locatedForIOS(MobileBy.xpath(""));
    public static Target TITULO_TRANSFERENCIAS = Target.the("'titulo 'Transferencias'")
            .locatedForAndroid(MobileBy.xpath("//android.widget.TextView[@text='Transferencias']")).locatedForIOS(MobileBy.xpath(""));

    public static Target SEL_CUENTA(String texto) {
        return ByTarget.the("'" + texto + "'").locatedForAndroid(MobileBy.xpath("//android.widget.TextView[@text='" + texto + "']")).locatedForIOS(MobileBy.xpath(""));
    }

    public static Target TITULO_TRANSFERENCIAS_CP = Target.the("'titulo 'Transferencia Cuentas Propias'")
            .locatedForAndroid(MobileBy.xpath("//android.view.View[@text='Transferencia Cuentas Propias']")).locatedForIOS(MobileBy.xpath(""));
    public static Target CAMPO_MONTO = Target.the("campo 'Monto'")
            .locatedForAndroid(MobileBy.xpath("(//android.widget.EditText)[1]")).locatedForIOS(MobileBy.xpath(""));

    public static Target CAMPO_CONCEPTO = Target.the("campo 'Concepto'")
            .locatedForAndroid(MobileBy.xpath("//android.view.View[@text='Concepto']/following::*[1]")).locatedForIOS(MobileBy.xpath(""));
    public static Target BOTON_TRANSFERIR = Target.the("botón 'TRANSFERIR'")
            .locatedForAndroid(MobileBy.xpath("//android.widget.Button[@text='TRANSFERIR']")).locatedForIOS(MobileBy.xpath(""));
    public static Target CONFIRMACION_TRANSF = Target.the("'La transferencia se realizó exitosamente'")
            .locatedForAndroid(MobileBy.xpath("//android.view.View[@text='La transferencia se realizó exitosamente']")).locatedForIOS(MobileBy.xpath(""));
    public static Target BOTON_TRANSFERIR_CARD = Target.the("botón 'TRANSFERIR'")
            .locatedForAndroid(MobileBy.xpath("//android.widget.Button[@text='Transferir']")).locatedForIOS(MobileBy.xpath(""));
    public static Target TICKET(String texto) {
        return ByTarget.the("'" + texto + "'").locatedForAndroid(MobileBy.xpath("//android.view.View[@text='" + texto + "']/following::*[1]")).locatedForIOS(MobileBy.xpath(""));
    }

    //Transferencias a terceros
    public static Target LINK_TRANSFERENCIAS_TER = Target.the("link 'Transferir a tercero'")
            .locatedForAndroid(MobileBy.xpath("//android.view.View[@text='Transferir a tercero']")).locatedForIOS(MobileBy.xpath(""));
    public static Target TITULO_TRANSFERENCIAS_TER = Target.the("titulo 'Transferencia a terceros'")
            .locatedForAndroid(MobileBy.xpath("//android.widget.TextView[@text='Transferencia a terceros']")).locatedForIOS(MobileBy.xpath(""));
    public static Target CAMPO_NUMERO_CUENTA = Target.the("campo 'Número de cuenta'")
            .locatedForAndroid(MobileBy.xpath("//android.view.View[@text='Número de cuenta']/following::*[1]")).locatedForIOS(MobileBy.xpath(""));
    public static Target CAMPO_CORREO = Target.the("campo 'Correo electrónico'")
            .locatedForAndroid(MobileBy.xpath("//android.view.View[@text='Correo electrónico']/following::*[1]")).locatedForIOS(MobileBy.xpath(""));
    public static Target CAMPO_MONTO_TT = Target.the("campo 'Monto'")
            .locatedForAndroid(MobileBy.xpath("(//android.widget.EditText)[3]")).locatedForIOS(MobileBy.xpath(""));
    public static Target BOTON_CONTINUAR = Target.the("botón 'CONTINUAR'")
            .locatedForAndroid(MobileBy.xpath("//android.widget.Button[@text='CONTINUAR']")).locatedForIOS(MobileBy.xpath(""));

    public static Target MODAL_CONFIRMACION = Target.the("ventana con confirmación '¿Deseas continuar?'")
            .locatedForAndroid(MobileBy.xpath("//android.widget.TextView[@text='¿Deseas continuar?']")).locatedForIOS(MobileBy.xpath(""));
    public static Target MODAL_CONFIRMACION2 = Target.the("ventana con confirmación '¿Deseas continuar?'")
            .locatedForAndroid(MobileBy.xpath("//android.view.View[@text='¿Deseas continuar?']")).locatedForIOS(MobileBy.xpath(""));

    public static Target BOTON_ACEPTAR = Target.the("botón 'ACEPTAR'")
            .locatedForAndroid(MobileBy.xpath("//android.widget.Button[@text='ACEPTAR']")).locatedForIOS(MobileBy.xpath(""));
    public static Target CAMPO_CELULAR_TT = Target.the("'campo 'Celular'")
            .locatedForAndroid(MobileBy.xpath("(//android.widget.EditText)[1]")).locatedForIOS(MobileBy.xpath(""));
    public static Target OPCION_MOVIMIENTOS = Target.the("opción 'Movimientos'")
            .locatedForAndroid(MobileBy.AccessibilityId("Movimientos")).locatedForIOS(MobileBy.xpath(""));

    public static Target OPCIONES(String texto) {
        return ByTarget.the("'" + texto + "'").locatedForAndroid(MobileBy.xpath("//*[@text='" + texto + "']")).locatedForIOS(MobileBy.xpath(""));
    }

    public static Target ELEMENTOS_TABLA_MOVIMIENTOS = Target.the("'Movimientos'")
            .locatedForAndroid(MobileBy.xpath("(//android.widget.ListView)[2]/*[@class='android.view.View']")).locatedForIOS(MobileBy.xpath(""));
    public static Target MENSAJE_NO_MOVIMIENTOS = Target.the("'No hay movimientos'")
            .locatedForAndroid(MobileBy.xpath("//android.view.View[@text='No hay movimientos']")).locatedForIOS(MobileBy.xpath(""));

    public static Target MES_ACTUAL_FILTRAR = Target.the("'Mes actual Filtrar'")
            .locatedForAndroid(MobileBy.xpath("//android.view.View[@text='Mes actual Filtrar']")).locatedForIOS(MobileBy.xpath(""));

    public static Target TITULO_AYUDA_TELETON = Target.the("'titulo 'Ayuda Teletón'")
            .locatedForAndroid(MobileBy.xpath("//android.view.View[@text='Ayuda Teletón']")).locatedForIOS(MobileBy.xpath(""));

    public static Target RETIRO_SIN_TARJETA = Target.the("opción 'Retiro sin tarjeta'")
            .locatedForAndroid(MobileBy.AccessibilityId("Retiro sin tarjeta")).locatedForIOS(MobileBy.xpath(""));

    public static Target TITULO_RETIRO_SIN_TARJETA = Target.the("'titulo 'Retirar dinero de manera rápida y segura'")
            .locatedForAndroid(MobileBy.xpath("//android.view.View[@text='Retirar dinero de manera rápida y segura']")).locatedForIOS(MobileBy.xpath(""));

    public static Target BOTON_GENERAR_CODIGO = Target.the("botón 'GENERAR CÓDIGO'")
            .locatedForAndroid(MobileBy.xpath("//android.widget.Button[@text='GENERAR CÓDIGO']")).locatedForIOS(MobileBy.xpath(""));

    public static Target SELECTOR2 = Target.the("Selector 'Institución de ONG'")
            .locatedForAndroid(MobileBy.xpath("//*[@text='Institución de ONG']/following::*[1]")).locatedForIOS(MobileBy.xpath(""));

    //Transfer 365 Movil
    public static Target OPCION_TRANSFER365_MOVIL = Target.the("opción 'Transfer365 Móvil'")
            .locatedForAndroid(MobileBy.AccessibilityId("Transfer365 Móvil")).locatedForIOS(MobileBy.xpath(""));
    public static Target TITULO_T365M = Target.the("titulo 'Transfer365 Móvil'")
            .locatedForAndroid(MobileBy.xpath("(//android.widget.TextView[@text='Transfer365 Móvil'])[1]")).locatedForIOS(MobileBy.xpath(""));
    public static Target LINK_TRANSFERIR_CELULAR = Target.the("link 'Transferir a un número de celular'")
            .locatedForAndroid(MobileBy.AccessibilityId("Transferir a un número de celular")).locatedForIOS(MobileBy.xpath(""));

    public static Target CAMPO_NOMBRE_RECIB = Target.the("campo 'Nombre del recibidor'")
            .locatedForAndroid(MobileBy.xpath("(//android.widget.EditText)[2]")).locatedForIOS(MobileBy.xpath(""));

    public static Target CAMPO_CORREO_T365 = Target.the("campo 'Correo electrónico'")
            .locatedForAndroid(MobileBy.xpath("//android.view.View[@text='Correo electrónico (opcional)']/following::*[1]")).locatedForIOS(MobileBy.xpath(""));

    public static Target CONFIRMACION_TRANSF_T365M = Target.the("'Transfer365 Móvil pendiente de aplicación'")
            .locatedForAndroid(MobileBy.xpath("//android.widget.TextView[@text='Transfer365 Móvil pendiente de aplicación']")).locatedForIOS(MobileBy.xpath(""));

    //Transfer 365
    public static Target OPCION_TRANSFER365 = Target.the("opción 'Transferencias Transfer365: Operaciones entre bancos'")
            .locatedForAndroid(MobileBy.AccessibilityId("Transferencias Transfer365: Operaciones entre bancos")).locatedForIOS(MobileBy.xpath(""));

    public static Target TITULO_T365 = Target.the("titulo 'Transferencias Transfer365: Operaciones entre bancos'")
            .locatedForAndroid(MobileBy.xpath("//android.widget.TextView[@text='Transferencias Transfer365: Operaciones entre bancos']")).locatedForIOS(MobileBy.xpath(""));

    public static Target LINK_TRANSFERIR_OTRA_CUENTA = Target.the("link 'Transferir a otra cuenta'")
            .locatedForAndroid(MobileBy.AccessibilityId("Transferir a otra cuenta")).locatedForIOS(MobileBy.xpath(""));

    public static Target CAMPO_CUENTA_TRANSFERIR = Target.the("'campo 'Cuenta a transferir'")
            .locatedForAndroid(MobileBy.xpath("//android.view.View[@text='Cuenta a transferir']/following::*[1]")).locatedForIOS(MobileBy.xpath(""));

    public static Target CAMPO_NOMBRE_RECIBIDOR = Target.the("'campo 'Nombre del recibidor'")
            .locatedForAndroid(MobileBy.xpath("//android.view.View[@text='Nombre del recibidor']/following::*[1]")).locatedForIOS(MobileBy.xpath(""));

    public static Target CAMPO_APELLIDO_RECIBIDOR = Target.the("'campo 'Apellido del recibidor'")
            .locatedForAndroid(MobileBy.xpath("//android.view.View[@text='Apellido del recibidor']/following::*[1]")).locatedForIOS(MobileBy.xpath(""));

    public static Target CAMPO_CORREO_T365_N = Target.the("'campo 'Correo electrónico'")
            .locatedForAndroid(MobileBy.xpath("//android.view.View[@text='Correo electrónico']/following::*[1]")).locatedForIOS(MobileBy.xpath(""));

    public static Target CAMPO_MONTO_T365 = Target.the("'campo 'Monto'")
            .locatedForAndroid(MobileBy.xpath("//android.view.View[@text='Monto']/following::*[3]")).locatedForIOS(MobileBy.xpath(""));

    public static Target MENU_TARJETAS = Target.the("menu 'Tarjetas'")
            .locatedForAndroid(MobileBy.AccessibilityId("Tarjetas")).locatedForIOS(MobileBy.AccessibilityId("Tarjetas"));

    //Transferencia QR

    public static Target OPCION_TRANSF_QR = Target.the("opción 'Transferencia QR'")
            .locatedForAndroid(MobileBy.AccessibilityId("Transferencia QR")).locatedForIOS(MobileBy.AccessibilityId("Transferencia QR"));

    public static Target TITULO_TRANSFERENCIA_QR = Target.the("'titulo 'Transferencia QR'")
            .locatedForAndroid(MobileBy.xpath("//android.widget.TextView[@text='Transferencia QR']")).locatedForIOS(MobileBy.xpath(""));

    public static Target CONFIRMACION_TRANSF_QR = Target.the("'Transferencia QR - Resultado'")
            .locatedForAndroid(MobileBy.xpath("//android.widget.TextView[@text='Transferencia QR - Resultado']")).locatedForIOS(MobileBy.xpath(""));

    //Transferencias UNI
    public static Target OPCION_TRANSF_UNI = Target.the("opción 'Transferencias UNI: Operaciones entre bancos'")
            .locatedForAndroid(MobileBy.AccessibilityId("Transferencias UNI: Operaciones entre bancos")).locatedForIOS(MobileBy.AccessibilityId("Transferencias UNI: Operaciones entre bancos"));
    public static Target TITULO_TUNI = Target.the("titulo 'Transferencias UNI: Operaciones entre bancos'")
            .locatedForAndroid(MobileBy.xpath("//android.widget.TextView[@text='Transferencias UNI: Operaciones entre bancos']")).locatedForIOS(MobileBy.xpath(""));

    public static Target OPCION_TRANSF_OC = Target.the("opción 'Transferir a otra cuenta'")
            .locatedForAndroid(MobileBy.AccessibilityId("Transferir a otra cuenta")).locatedForIOS(MobileBy.AccessibilityId("Transferir a otra cuenta"));
    public static Target CAMPO_NOMBRE_DE_RECIBIDOR = Target.the("'campo 'Nombre de recibidor'")
            .locatedForAndroid(MobileBy.xpath("//android.view.View[@text='Nombre de recibidor']/following::*[1]")).locatedForIOS(MobileBy.xpath(""));
    public static Target CAMPO_NUMERO_DOCUMENTO = Target.the("'campo 'Número de documento'")
            .locatedForAndroid(MobileBy.xpath("//android.view.View[@text='Número de documento']/following::*[1]")).locatedForIOS(MobileBy.xpath(""));
    public static Target PUNTOS_ACUMULADOS = Target.the("'Puntos acumulados'")
            .locatedForAndroid(MobileBy.xpath("//android.view.View[@text='Puntos acumulados']/preceding::*[1]")).locatedForIOS(MobileBy.xpath(""));

    //Transferencia PuntosBA a Lifemiles
    public static Target TRANSFERIR_PBA_LFM = Target.the("opción 'Transferencia de Puntos a LifeMiles'")
            .locatedForAndroid(MobileBy.AccessibilityId("Transferencia de Puntos a LifeMiles")).locatedForIOS(MobileBy.xpath(""));

    public static Target TITULO_TRANSFERENCIAS_PBA_LFM = Target.the("'titulo 'Transferencias de Puntos a LifeMiles'")
            .locatedForAndroid(MobileBy.xpath("//android.widget.TextView[@text='Transferencias de Puntos a LifeMiles']")).locatedForIOS(MobileBy.xpath(""));

    public static Target CONFIRMACION_LM = Target.the("'La solicitud se realizó exitosamente'")
            .locatedForAndroid(MobileBy.xpath("//android.widget.TextView[@text='La solicitud se realizó exitosamente']")).locatedForIOS(MobileBy.xpath(""));

    public static Target CONFIRMACION = Target.the("'La solicitud se realizó exitosamente'")
            .locatedForAndroid(MobileBy.xpath("//android.view.View[@text='La solicitud se realizó exitosamente']")).locatedForIOS(MobileBy.xpath(""));
    public static Target OPCION_TRANSF_OC2 = Target.the("'opción 'Transferir a otra cuenta'")
            .locatedForAndroid(MobileBy.xpath("//android.view.View[@text='Transferir a otra cuenta']")).locatedForIOS(MobileBy.xpath(""));
    public static final Target TRANSF_OC = Target.the("'Transferir a otra cuenta'")
            .locatedBy("//*[@text='Transferir a otra cuenta']");
    //Transferencia Ahorro programado
    public static Target MENU_METAS = Target.the("menu 'Metas'")
            .locatedForAndroid(MobileBy.AccessibilityId("Metas")).locatedForIOS(MobileBy.AccessibilityId("Metas"));
    public static Target LABEL_AHORRO_ACUMULADO = Target.the("'Ahorro acumulado'")
            .locatedForAndroid(MobileBy.xpath("//android.view.View[@text='Ahorro acumulado']")).locatedForIOS(MobileBy.xpath(""));

    public static Target CAMPO_AHORRO_ACUMULADO = Target.the("campo 'Ahorro acumulado'")
            .locatedForAndroid(MobileBy.xpath("//android.view.View[@text='Ahorro acumulado']/following::*[1]")).locatedForIOS(MobileBy.xpath(""));

    //Recargas
    public static Target RECARGA_CELULAR = Target.the("opción 'Recarga de celular'")
            .locatedForAndroid(MobileBy.AccessibilityId("Recarga de celular")).locatedForIOS(MobileBy.AccessibilityId("Recarga de celular"));
    public static Target TITULO_RECARGA_CELULAR = Target.the("titulo 'Recarga de celular'")
            .locatedForAndroid(MobileBy.xpath("//android.view.View[@text='Recarga de celular']")).locatedForIOS(MobileBy.xpath(""));
    public static Target RECARGA_OTRO_NUMERO = Target.the("opción 'Recargar otro número'")
            .locatedForAndroid(MobileBy.AccessibilityId("Recargar otro número")).locatedForIOS(MobileBy.AccessibilityId("Recargar otro número"));
    public static Target CAMPO_CELULAR = Target.the("campo 'Celular'")
            .locatedForAndroid(MobileBy.xpath("(//android.widget.EditText)[1]")).locatedForIOS(MobileBy.xpath(""));
    public static Target CONFIRMACION_RECARGA = Target.the("'La recarga de celular ha sido completada exitosamente'")
            .locatedForAndroid(MobileBy.xpath("//android.widget.TextView[@text='La recarga de celular ha sido completada exitosamente']")).locatedForIOS(MobileBy.xpath(""));

    //Movimientos PuntosBA
    public static Target EGRESOS = Target.the("opción 'Egresos'")
            .locatedForAndroid(MobileBy.AccessibilityId("Egresos")).locatedForIOS(MobileBy.xpath("Egresos"));

    //Logueo
    public static Target BIENVENIDO = Target.the("'Bienvenido a la aplicación de Banco Agrícola'")
            .locatedForAndroid(MobileBy.xpath("//android.view.View[@text='Bienvenido a la aplicación de Banco Agrícola']")).locatedForIOS(MobileBy.xpath(""));
    public static Target CAMPO_USUARIO = Target.the("campo 'Usuario'")
            .locatedForAndroid(MobileBy.xpath("//android.view.View[@text='Usuario']/following::*[1]")).locatedForIOS(MobileBy.xpath(""));
    public static Target CAMPO_CLAVE = Target.the("campo 'Clave'")
            .locatedForAndroid(MobileBy.xpath("//android.view.View[@text='Clave']/following::*[1]")).locatedForIOS(MobileBy.xpath(""));

    //Pago/Cobro a un amigo
    public static Target PAGO_COBRO_AMIGO = Target.the("opción 'Cobro/Pago a un amigo'")
            .locatedForAndroid(MobileBy.AccessibilityId("Cobro/Pago a un amigo")).locatedForIOS(MobileBy.xpath(""));

    public static Target TITULO_COBRA_Y_PAGA = Target.the("titulo 'Cobra y paga a tus contactos'")
            .locatedForAndroid(MobileBy.xpath("//android.view.View[@text='Cobra y paga a tus contactos']")).locatedForIOS(MobileBy.xpath(""));

    public static Target AÑADIR_CONTACTO = Target.the("opción 'Añadir un contacto'")
            .locatedForAndroid(MobileBy.xpath("//android.view.View[@text='Añadir un contacto']")).locatedForIOS(MobileBy.xpath("Egresos"));

    public static Target BTON_ACEPTAR = Target.the("botón 'ACEPTAR'")
            .locatedForAndroid(MobileBy.xpath("//android.widget.Button[@text='ACEPTAR']")).locatedForIOS(MobileBy.xpath(""));

    public static Target GUARDARCOMO = Target.the("'Guardar como:'")
            .locatedForAndroid(MobileBy.xpath("//android.widget.TextView[@text='Guardar como:']")).locatedForIOS(MobileBy.xpath(""));
    public static Target CAMPO_GUARDARCOMO = Target.the("campo 'Guardar como:'")
            .locatedForAndroid(MobileBy.xpath("(//android.widget.EditText)[1]")).locatedForIOS(MobileBy.xpath(""));

    //Transfer365 CA-RD
    public static Target OPCION_TRANSFER365_CARD = Target.the("opción 'Transfer365 Móvil CA-RD'")
            .locatedForAndroid(MobileBy.AccessibilityId("Transfer365 CA-RD")).locatedForIOS(MobileBy.xpath(""));

    public static Target MONTO = Target.the("campo 'Monto (USD)'")
            .locatedForAndroid(MobileBy.xpath("//android.view.View[@text='Monto (USD)']/following::*[3]")).locatedForIOS(MobileBy.xpath(""));
    public static Target DESCRIPCION = Target.the("campo 'Descripción'")
            .locatedForAndroid(MobileBy.xpath("//android.widget.TextView[@text='Descripción']/following::*[2]")).locatedForIOS(MobileBy.xpath(""));
    public static Target LISTA = Target.the("'Listado de movimientos'")
            .locatedForAndroid(MobileBy.xpath("(//android.widget.ListView)[2]")).locatedForIOS(MobileBy.xpath(""));
    public static Target BTN_CONTINUAR = Target.the("botón 'CONTINUAR'")
            .locatedForAndroid(MobileBy.xpath("//*[@text='CONTINUAR']")).locatedForIOS(MobileBy.xpath(""));

    public static final Target AYUDA_TELETON = Target.the("'Ayuda Teletón'")
            .locatedBy("//*[@text='Ayuda Teletón']");

}

