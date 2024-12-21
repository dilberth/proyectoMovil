package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import java.util.List;

public class ProcesoRecuperacionDeUsuario implements Task {

    private final String tipoDeDocumento;
    private final String numeroDeDocumento;

    public ProcesoRecuperacionDeUsuario(List<String> informacionDocumento) {
        this.tipoDeDocumento = informacionDocumento.get(0);
        this.numeroDeDocumento = informacionDocumento.get(1);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                ClickEnEnlace.deNombre("Recuperar usuario o clave"),
                ClickEnEnlace.deNombre("Olvidé mi usuario"),
                SeleccionarLista.conCordenadasDelNombre("Documento de Identidad", TargetApp.soIsIos()).laOpcion(tipoDeDocumento),
                IngresarEn.elCampo("Número de Documento").elValor(numeroDeDocumento),
                ClickEnBoton.elElemento("CONTINUAR"));
    }

    public static ProcesoRecuperacionDeUsuario conLaInformacion(List<String> informacionDocumento) {
        return Tasks.instrumented(ProcesoRecuperacionDeUsuario.class,informacionDocumento);
    }



}
