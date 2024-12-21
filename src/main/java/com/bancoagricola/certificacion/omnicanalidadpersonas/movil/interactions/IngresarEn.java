package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks.Scroll;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.*;
import net.serenitybdd.screenplay.*;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.targets.*;
import net.thucydides.core.annotations.*;

public class IngresarEn implements Task {

    private Target campo;
    private String valor;

    public IngresarEn(Target campo, String valor) {
        this.campo = campo;
        this.valor = valor;
    }

    @Step("{0} ingresa en el campo '#campo' el valor '#valor'")
    @Override
    public <T extends Actor> void performAs(T actor) {

        Scroll.hastaElElemento(campo).elementoVisibleEnElMedioDeLaPantalla().performAs(actor);
        Task.where("Click",Click.on(campo)).withNoReporting().performAs(actor);
        Clear.field(campo).performAs(actor);
        Enter.theValue(valor).into(campo).performAs(actor);
        EsconderTeclado.enIos();
    }

    public static ValorCampo elCampo(String campo) {
        return new ValorCampo(campo);
    }

    public static ValorCampo elCampoNumero(String campo,int numero) {
        return new ValorCampo(campo,numero);
    }

    public static ValorCampo elCampo(Target campo) {
        return new ValorCampo(campo);
    }

    public static class ValorCampo {

        private Target campo;

        public ValorCampo(Target campo) {
            this.campo = campo;
        }

        public ValorCampo(String campo) {
            this.campo = UiGenerico.campoEditableFormulario(campo);
        }

        public ValorCampo(String campo,int numero) {
            this.campo = UiGenerico.campoEditableFormularioNumero(campo,numero);
        }

        public IngresarEn elValor(String valor) {
            return Tasks.instrumented(IngresarEn.class, this.campo, valor);
        }
    }
}
