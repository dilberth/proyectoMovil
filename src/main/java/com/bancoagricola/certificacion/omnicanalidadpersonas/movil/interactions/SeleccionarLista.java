package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks.Scroll;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.*;
import net.serenitybdd.screenplay.*;
import net.serenitybdd.screenplay.actions.*;
import net.thucydides.core.annotations.*;

public class SeleccionarLista implements Interaction {

    private String lista;
    private String opcion;
    private boolean buscarPorCoordenadas;
    private Coordenadas coordenadas;
    private boolean tag;

    public SeleccionarLista(String lista, String opcion, boolean buscarPorCoordenadas, boolean tag) {
        this.lista = lista;
        this.opcion = opcion.replace("\\","");
        this.buscarPorCoordenadas = buscarPorCoordenadas;
        this.tag = tag;
    }

    @Step("{0} selecciona en la lista desplegable '#lista' la opcion '#opcion'")
    @Override
    public <T extends Actor> void performAs(T actor) {

        Scroll.hastaElElemento(
                tag ? UiGenerico.elementoDeTexto(lista) :
                        UiGenerico.selectorFormulario(lista)
        ).performAs(actor);

        if (buscarPorCoordenadas) {
            coordenadas = tag ?
                    Coordenadas.esquinaInferiorDelElementoXpath(lista, UiGenerico.elementoDeTexto(lista)) :
                    Coordenadas.centralesDelElementoXpath(lista, UiGenerico.selectorFormulario(lista));
            ClickConJs.enLasCoordenadas(coordenadas).cantidadDeClicks(3).clickBasadoEnTag(tag).performAs(actor);
        } else {
            Click.on(UiGenerico.selectorFormulario(lista)).performAs(actor);
        }

        if(!opcion.isEmpty()) {
            ClickEn.elElemento(UiGenerico.elementoDeTexto(opcion)).performAs(actor);
        }

    }

    public static SeleccionarOpcion deNombre(String lista) {
        return new SeleccionarOpcion(lista, false);
    }

    public static SeleccionarOpcion conCordenadasDelNombre(String lista) {
        return new SeleccionarOpcion(lista, true);
    }

    public static SeleccionarOpcion conCordenadasDelNombre(String lista, boolean tag) {
        return new SeleccionarOpcion(lista, true, tag);
    }

    public static class SeleccionarOpcion {

        private String lista;
        private boolean buscarPorCoordenadas;
        private boolean tag;

        public SeleccionarOpcion(String lista, boolean buscarPorCoordenadas) {
            this.lista = lista;
            this.buscarPorCoordenadas = buscarPorCoordenadas;
        }

        public SeleccionarOpcion(String lista, boolean buscarPorCoordenadas, boolean tag) {
            this.lista = lista;
            this.buscarPorCoordenadas = buscarPorCoordenadas;
            this.tag = tag;
        }

        public SeleccionarLista laOpcion(String opcion) {
            return Tasks.instrumented(SeleccionarLista.class, this.lista, opcion, this.buscarPorCoordenadas,this.tag);
        }

        public SeleccionarLista sinOpcion() {
            return Tasks.instrumented(SeleccionarLista.class, this.lista, "", this.buscarPorCoordenadas,this.tag);
        }

    }
}
