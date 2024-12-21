package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.Esperar;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.IrAProducto;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.questions.VerEnPantalla;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks.CambiarAlias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks.ProcesoLogueo;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Fecha;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.TransaccionesTarjetas;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Usuario;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Variables;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actors.OnStage;

public class CambioDeAliasStepDefinitions {

    @Cuando("^el usuario (.*) realiza el cambio de alias en uno de sus productos$")
    public void elUsuarioUSR_PASSRealizaElCambioDeAliasEnUnoDeSusProductos(Usuario usuario) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ProcesoLogueo.con(usuario),
                IrAProducto.tarjeta("Puntos BA").ySeleccionarLaTransaccion(TransaccionesTarjetas.MAS_DETALLE.tomarTransaccion()),
                CambiarAlias.porElNuevoAlias(Fecha.tomarFecha())
        );
    }

    @Entonces("^debe visualizar el nuevo alias en el producto$")
    public void debeVisualizarElNuevoAliasEnElProducto() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Esperar.pantallaDeCarga(),
                VerEnPantalla.elTexto(Variables.NUEVO_ALIAS.obtenerValorGuardado().toString()),
                Task.where("Valor por defecto del alias",actor -> {
                    actor.attemptsTo(
                    IrAProducto.tarjeta("Puntos BA").ySeleccionarLaTransaccion(TransaccionesTarjetas.MAS_DETALLE.tomarTransaccion()),
                    CambiarAlias.porElNuevoAlias("Puntos BA"));
                }).withNoReporting()
        );
    }

}
