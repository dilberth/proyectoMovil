package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import org.openqa.selenium.JavascriptExecutor;

import java.util.HashMap;
import java.util.Map;

public class ClickConJs implements Task {

    private String nombreElemento;
    private int coordenadaEnX;
    private int coordenadaEnY;
    private int cantidadClicks = 1;
    private boolean tag;

    public ClickConJs(Coordenadas coordenadas) {
        this.nombreElemento = coordenadas.tomarNombreElemento();
        this.coordenadaEnX = coordenadas.TomarCoordenadaEnX();
        this.coordenadaEnY = coordenadas.TomarCoordenadaEnY();
    }

    @Step("{0} da #cantidadClicks click al elemento #nombreElemento")
    @Override
    public <T extends Actor> void performAs(T actor) {

        Map<String, Object> params = new HashMap<>();
        params.put("x", (coordenadaEnX + (tag ? 10 : 0)));
        params.put("y", (coordenadaEnY + (tag ? 10 : 0)));

        for (int i = 0; i < this.cantidadClicks; i++) {
            Utilidades.esperarMilis(100);
            ((JavascriptExecutor) ThucydidesWebDriverSupport.getProxiedDriver()).executeScript(TargetApp.soIsIos() ? "mobile: tap" : "mobile: longClickGesture", params);
        }

    }

    public static ClickConJs enLasCoordenadas(Coordenadas coordenadas) {
        return Tasks.instrumented(ClickConJs.class, coordenadas);
    }

    public ClickConJs cantidadDeClicks(int veces) {
        this.cantidadClicks = veces;
        return this;
    }

    public ClickConJs clickBasadoEnTag(boolean tag) {
        this.tag = tag;
        return this;
    }


}
