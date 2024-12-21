package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.*;
import net.serenitybdd.screenplay.*;
import net.serenitybdd.screenplay.actions.*;

import java.util.*;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Constantes.*;

public class ProcesoCambioDeClave implements Task {

    private final List<String> pass;
    private String oldPass;

    public ProcesoCambioDeClave(List<String> pass) {
        this.pass = pass;
        this.oldPass = TXTCLAVEA;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        SeleccionarEnMenuPrincipal.laOpcion(OpcionMenuPrincipal.CLAVE_DE_ACCESO).performAs(actor);

        pass.subList(1, pass.size()).forEach(
                passValue -> {
                    actor.attemptsTo(
                            Task.where("Click", Clear.field(UiGenerico.campoEditableFormulario(TXTCLAVE_ACTUAL))).withNoReporting(),
                            IngresarEn.elCampo(TXTCLAVE_ACTUAL).elValor(oldPass),
                            Task.where("Click", Clear.field(UiGenerico.campoEditableFormulario(TXTNUEVA_CLAVE))).withNoReporting(),
                            IngresarEn.elCampo(TXTNUEVA_CLAVE).elValor(passValue),
                            Task.where("Click", Clear.field(UiGenerico.campoEditableFormulario(TXTREPETIR_NUEVA_CLAVE))).withNoReporting(),
                            IngresarEn.elCampo(TXTREPETIR_NUEVA_CLAVE).elValor(passValue),
                            Task.where("Click", Click.on(UiGenerico.campoEditableFormulario(TXTNUEVA_CLAVE))).withNoReporting(),
                            ClickEnBoton.elElemento(TXTGUARDAR),
                            Esperar.texto(TXTMSG_CONF19)
                    );
                    oldPass = passValue;
                    System.out.println("Password: "+oldPass);
                }

        );
    }

    public static ProcesoCambioDeClave alUsuarioConLasClaves(List<String> pass) {
        return Tasks.instrumented(ProcesoCambioDeClave.class, pass);
    }
}