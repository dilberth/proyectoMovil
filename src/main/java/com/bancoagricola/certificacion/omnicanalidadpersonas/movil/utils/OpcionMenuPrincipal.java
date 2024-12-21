package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.*;
import net.serenitybdd.screenplay.targets.Target;

public enum OpcionMenuPrincipal {

    DATOS_PERSONALES(UiMenuPrincipal.datosPersonales()),
    ACTUALIZACION_DE_INFORMACION(UiMenuPrincipal.actualizacionDeInformacion()),
    CLAVE_DE_ACCESO(UiMenuPrincipal.claveDeAcceso()),
    SEGURIDAD_AVANZADA(UiMenuPrincipal.seguridadAvanzada()),
    NOTIFICACIONES(UiMenuPrincipal.notificaciones()),
    FAVORITOS(UiMenuPrincipal.favoritos()),
    GESTION_DE_LIMITES(UiMenuPrincipal.gestionDeLimites()),
    SERVICIOS(UiMenuPrincipal.servicios()),
    SALIR(UiMenuPrincipal.salir());

    private Target opcionMenu;

    OpcionMenuPrincipal(Target opcionMenu){
        this.opcionMenu = opcionMenu;
    }

    public Target tomarOpcion() {
        return opcionMenu;
    }

}
