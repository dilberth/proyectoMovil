package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.Cuentas;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.UiGenerico;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.TransaccionesCuentas;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.UiCuentas.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.UiCuentas.MAS_DETALLE;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class ProcesoCobroAmigo implements Task {

    private final List<Cuentas> datos;
    public ProcesoCobroAmigo(List<Cuentas> datos) {
        this.datos = datos;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Cuentas cu = datos.get(0);

        actor.attemptsTo(
                WaitUntil.the(MENU_CUENTAS, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(MENU_CUENTAS, isClickable()).forNoMoreThan(30).seconds(),
                Scroll.hastaElElemento(PRODUCTO(cu.getCuentaOrigen())).elementoVisibleEnElMedioDeLaPantalla(),
                Click.on(PRODUCTO(cu.getCuentaOrigen())),
                Scroll.hastaElElemento(VER_MAS).elementoVisibleEnElMedioDeLaPantalla(),
                WaitUntil.the(VER_MAS, isVisible()).forNoMoreThan(30).seconds(),
                WaitUntil.the(VER_MAS, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(VER_MAS, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(VER_MAS),
                WaitUntil.the(MAS_DETALLE, isVisible()).forNoMoreThan(30).seconds(),
                Scroll.hastaElElemento(PAGO_COBRO_AMIGO).elementoVisibleEnElMedioDeLaPantalla(),
                WaitUntil.the(PAGO_COBRO_AMIGO, isVisible()).forNoMoreThan(30).seconds(),
                WaitUntil.the(PAGO_COBRO_AMIGO, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(PAGO_COBRO_AMIGO, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(PAGO_COBRO_AMIGO),
                Esperar.texto("Cobra y paga a tus contactos"),
                Esperar.texto("Añadir un contacto"),
                ClickEn.elElemento(UiGenerico.elementoDeTexto("Añadir un contacto")));

        actor.attemptsTo(
                IrAProducto.cuenta(cu.getCuentaOrigen()).ySeleccionarLaTransaccion(TransaccionesCuentas.COBRO_PAGO_AMIGO.tomarTransaccion()),
                ClickEn.elElemento(UiGenerico.elementoDeTexto("Añadir un contacto")),
                Esperar.texto("Añade un nuevo contacto para realizar un cobro"),
                IngresarEn.elCampo("Nombre").elValor(cu.getNombre()),
                IngresarEn.elCampo("Celular").elValor(cu.getCelular()),
                IngresarEn.elCampo("Correo electrónico").elValor(cu.getCorreo()),
                ClickEnBoton.elElemento("AÑADIR Y CONTINUAR"),
                Esperar.texto("Cobra y paga a tus contactos"),
                ClickEn.elElemento(UiGenerico.elementoDeTexto(cu.getNombre())),
                Esperar.texto("Cobra a tus contactos"),
                IngresarEn.elCampo("Monto").elValor(cu.getMonto()),
                ClickEnBoton.elElemento("CONTINUAR"),
                Esperar.texto("La solicitud de cobro se realizó exitosamente")
        );


    }

    public static ProcesoCobroAmigo conLaInformacion(List<Cuentas> datos) {
        return Tasks.instrumented(ProcesoCobroAmigo.class,datos);
    }


}
