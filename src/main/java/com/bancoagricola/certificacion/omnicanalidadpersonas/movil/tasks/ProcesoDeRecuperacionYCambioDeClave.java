package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Boton;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Usuario;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Constantes.*;

public class ProcesoDeRecuperacionYCambioDeClave implements Task {

    private final List<String> informacionClaves;

    ProcesoDeRecuperacionYCambioDeClave(List<String> informacionClaves){
        this.informacionClaves = informacionClaves.subList(1,informacionClaves.toArray().length);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        informacionClaves.forEach(
                claveNueva -> actor.attemptsTo(
                        Esperar.texto(TXTBIENVENIDO),
                        ClickEnEnlace.deNombre(TXTRECUPERAR),
                        IngresarEn.elCampo(TXTUSUARIO).elValor(Usuario.FELDOUSER7.getNombreUsuario()),
                        ClickEnBoton.elElemento(TXTBTN_CONTINUAR),
                        ClickEnBoton.elElemento(TXTRECUPERAR_CLAVE),
                        IngresarEn.elCampo(TXTCODIGOCONF).elValor(TXTCODIGO),
                        ClickEnBoton.elElemento(Boton.CONTINUAR),
                        Esperar.pantallaDeCarga(),
                        IngresarEn.elCampo(TXTNUEVA_CLAVE).elValor(claveNueva),
                        IngresarEn.elCampo(TXT_VUELVE_ESCRIBIR_CLAVE).elValor(claveNueva),
                        Task.where("Click",Click.on(UiGenerico.campoEditableFormulario(TXTNUEVA_CLAVE))).withNoReporting(),
                        ClickEnBoton.elElemento(Boton.CONTINUAR),
                        Esperar.texto(TXTMSG_CONF18),
                        ClickEnBoton.elElemento(Boton.ACEPTAR)));
    }

    public static ProcesoDeRecuperacionYCambioDeClave conLaInformacion(List<String> informacionClaves){
        return Tasks.instrumented(ProcesoDeRecuperacionYCambioDeClave.class, informacionClaves);
    }
}