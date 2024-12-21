package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.*;
import net.serenitybdd.screenplay.*;
import net.serenitybdd.screenplay.conditions.*;
import net.serenitybdd.screenplay.targets.*;
import net.thucydides.core.annotations.*;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Constantes.TXTCUENTAS;

public class IrAProducto implements Interaction {

    private String producto;
    private Target claseProducto;
    private String transaccion;
    private boolean elegirTransaccion = true;

    public IrAProducto(Target claseProducto, String producto, String transaccion) {
        this.producto = producto;
        this.claseProducto = claseProducto;
        this.transaccion = transaccion;
    }

    public IrAProducto(Target claseProducto, String producto, boolean elegirTransaccion) {
        this.producto = producto;
        this.claseProducto = claseProducto;
        this.transaccion = ".";
        this.elegirTransaccion = elegirTransaccion;
    }

    @Step("{0} selecciona la transaccion '#transaccion' con el producto '#producto' ")
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                VolverInicio.click(),
                ClickEn.elElemento(UiGenerico.accesibilityId(TXTCUENTAS)),
                RestaurarEstadoVerMas.dandoClick(claseProducto),
                ClickEn.elElemento(claseProducto),
                ClickEn.elElemento(UiGenerico.elementoDeTexto(producto)),
                ClickEn.elElemento(UiGenerico.accesibilityId("Ver más")),
                Esperar.pantallaDeCarga(),
                Check.whether(elegirTransaccion).andIfSo(
                ClickEn.elElemento(UiGenerico.accesibilityId(transaccion))),
                Esperar.pantallaDeCarga());
    }

    public static TransaccionProducto cuenta(String cuenta) {
        return new TransaccionProducto(cuenta, Constantes.TXTCUENTAS);
    }

    public static TransaccionProducto tarjeta(String tarjeta) {
        return new TransaccionProducto(tarjeta, Constantes.TXTTARJETAS);
    }

    public static TransaccionProducto ahorros(String ahorros) {
        return new TransaccionProducto(ahorros, Constantes.TXTAHORROS);
    }

    public static class TransaccionProducto {

        private String producto;
        private Target claseProducto;

        public TransaccionProducto(String producto, String claseProducto) {
            this.producto = producto;
            this.claseProducto = UiGenerico.accesibilityId(claseProducto);
        }

        public IrAProducto ySeleccionarLaTransaccion(String transaccion) {
            return Tasks.instrumented(IrAProducto.class, this.claseProducto, this.producto, transaccion);
        }

        public IrAProducto verMas() {
            return Tasks.instrumented(IrAProducto.class, this.claseProducto, this.producto, false);
        }

    }


}
