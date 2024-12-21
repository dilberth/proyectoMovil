package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.Cuentas;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.*;
import net.serenitybdd.core.steps.*;
import net.serenitybdd.screenplay.*;
import net.serenitybdd.screenplay.waits.*;
import net.thucydides.core.annotations.*;

import java.util.*;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Constantes.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class ProcesoRecargaCelularConFavorito implements Task {
    private final List<Cuentas> datos;

    public ProcesoRecargaCelularConFavorito(List<Cuentas> datos) {
        this.datos = datos;
    }

    @Step("{0} realiza el proceso de recarga de celular")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Cuentas cu = datos.get(0);

        actor.attemptsTo(
                ClickEn.elElemento(UiGenerico.elementoQueContengaElTexto(TXTREALIZAR_OTRA)),
                WaitUntil.the(UiGenerico.elementoQueContengaElTexto(TXTRECARGA_CELULAR), isVisible()).forNoMoreThan(30).seconds(),
                ClickEn.elElemento(UiGenerico.elementoQueContengaElTexto(cu.getNombrefavorito())),
                WaitUntil.the(UiGenerico.elementoQueContengaElTexto(TXTCELULAR), isVisible()).forNoMoreThan(30).seconds(),
                SeleccionarLista.conCordenadasDelNombre(TXTPAQUETEMONTO,TargetApp.soIsIos()).laOpcion(cu.getMontopaquete()),
                ClickEnBoton.elElemento(TXTBTN_CONTINUAR),
                Esperar.texto(TXTDESEA_CONTINUAR),
                ClickEnBoton.elElemento(TXTBTN_ACEPTAR),
                WaitUntil.the(UiGenerico.elementoQueContengaElTexto(TXTMSG_CONF16), isVisible()).forNoMoreThan(30).seconds(),
                VolverInicio.click()
        );

    }

    public static ProcesoRecargaCelularConFavorito para(List<Cuentas> datos) {
        return Instrumented.instanceOf(ProcesoRecargaCelularConFavorito.class).withProperties(datos);
    }
}