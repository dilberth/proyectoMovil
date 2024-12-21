package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks.Scroll;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import org.openqa.selenium.JavascriptExecutor;

import java.util.HashMap;
import java.util.Map;

public class EscribirConJs implements Interaction {

    private Target campo;
    private String valor;

    public EscribirConJs(Target campo, String valor) {
        this.campo = campo;
        this.valor = valor;
    }

    @Step("{0} ingresa en el campo 'campo' el valor '#valor'")
    @Override
    public <T extends Actor> void performAs(T actor) {

        Map<String, Object> params = new HashMap<>();
        params.put("text", valor);

        actor.attemptsTo(
                Scroll.hastaElElemento(campo),
                Click.on(campo),
                Task.where("enter the value '" + valor)
        );


        if (TargetApp.soIsIos()) {
            actor.attemptsTo(
                    SendKeys.of(valor).into(campo)
            );
        } else {
            ((JavascriptExecutor) ThucydidesWebDriverSupport.getProxiedDriver()).executeScript("mobile: type", params);
        }

        EsconderTeclado.enIos();

    }

    public static ValorCampo elTexto(String texto) {
        return new ValorCampo(texto);
    }

    public static class ValorCampo {

        private String texto;

        public ValorCampo(String texto) {
            this.texto = texto;
        }

        public EscribirConJs enElCampo(Target campo) {
            return Tasks.instrumented(EscribirConJs.class, campo, texto);
        }

    }


}
