package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.*;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.userinterface.UiMenuPrincipal.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Constantes.CERO;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Utilidades.informacionRegistroAuditoriaDeTransacciones;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Utilidades.valorEntre;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AuditoriaDeTransaccionesStepDefinition {

    @Cuando("^el cliente desea utilizar el filtro de auditoria de transacciones por fecha, tipo de transaccion y canal$")
    public void elClienteDeseaUtilizarElFiltroDeAuditoriaDeTransaccionesPorFechaTipoDeTransaccionYCanal(List<Cuentas> datos) {
        Cuentas opc = datos.get(0);

        OnStage.theActorInTheSpotlight().attemptsTo(
                IngresarAuditoriaTRX.para(datos),
                SeleccionarEnCalendarioFechaLista.laFecha(datos),
                Click.on(VER_FILTROS_ADIC),
                Scroll.simple(),
                Click.on(TIPO_TRX),
                Scroll.hastaElElemento(SELECTOR_OPC(opc.getTipoTRX())).elementoVisibleEnElMedioDeLaPantalla(),
                Click.on(SELECTOR_OPC(opc.getTipoTRX())),
                Click.on(CANAL),
                Scroll.hastaElElemento(SELECTOR_OPC(opc.getCanal())).elementoVisibleEnElMedioDeLaPantalla(),
                Click.on(SELECTOR_OPC(opc.getCanal())),
                Click.on(BTN_BUSCAR));
        Utilidades.esperar(5);
    }

    @Cuando("^el cliente desea utilizar el filtro de auditoria de transacciones por fecha, tipo de transaccion, rango de montos y canal$")
    public void elClienteDeseaUtilizarElFiltroDeAuditoriaDeTransaccionesPorFechaTipoDeTransaccionRangoDeMontosYCanal(List<Cuentas> datos) throws InterruptedException {
        Cuentas opc = datos.get(0);

        OnStage.theActorInTheSpotlight().attemptsTo(
                IngresarAuditoriaTRX.para(datos),
                SeleccionarEnCalendarioFechaLista.laFecha(datos),
                Click.on(VER_FILTROS_ADIC),
                Scroll.simple(),
                Click.on(TIPO_TRX),
                Scroll.hastaElElemento(SELECTOR_OPC(opc.getTipoTRX())).elementoVisibleEnElMedioDeLaPantalla(),
                Click.on(SELECTOR_OPC(opc.getTipoTRX())),
                Enter.theValue(opc.getDesde()).into(DESDE),
                Enter.theValue(opc.getHasta()).into(HASTA),
                Click.on(CANAL),
                Scroll.hastaElElemento(SELECTOR_OPC(opc.getCanal())).elementoVisibleEnElMedioDeLaPantalla(),
                Click.on(SELECTOR_OPC(opc.getCanal())),
                Click.on(BTN_BUSCAR));
        Utilidades.esperar(5);
    }

    @Cuando("^el cliente desea utilizar el filtro de auditoria de transacciones por fecha, tipo de transaccion, estado de la transaccion y canal$")
    public void elClienteDeseaUtilizarElFiltroDeAuditoriaDeTransaccionesPorFechaTipoDeTransaccionEstadoDeLaTransaccionYCanal(List<Cuentas> datos) throws InterruptedException {
        Cuentas opc = datos.get(0);

        OnStage.theActorInTheSpotlight().attemptsTo(
                IngresarAuditoriaTRX.para(datos),
                SeleccionarEnCalendarioFechaLista.laFecha(datos),
                Click.on(VER_FILTROS_ADIC),
                Scroll.simple(),
                Click.on(TIPO_TRX),
                Scroll.hastaElElemento(SELECTOR_OPC(opc.getTipoTRX())).elementoVisibleEnElMedioDeLaPantalla(),
                Click.on(SELECTOR_OPC(opc.getTipoTRX())),
                Click.on(ESTADO),
                Scroll.hastaElElemento(SELECTOR_OPC(opc.getEstadoTRX())).elementoVisibleEnElMedioDeLaPantalla(),
                Click.on(SELECTOR_OPC(opc.getEstadoTRX())),
                Click.on(CANAL),
                Scroll.hastaElElemento(SELECTOR_OPC(opc.getCanal())).elementoVisibleEnElMedioDeLaPantalla(),
                Click.on(SELECTOR_OPC(opc.getCanal())),
                Click.on(BTN_BUSCAR));
    }

    @Entonces("^el cliente podra observar los registos relacionados al filtro utilizado$")
    public void elClientePodraObservarLosRegistosRelacionadosAlFiltroUtilizado() throws InterruptedException {
        WaitUntil.the(UiGenerico.listaDeInformacion("Movimientos"), isVisible()).forNoMoreThan(45).seconds().performAs(OnStage.theActorInTheSpotlight());
        Ensure.that(Utilidades.obtenerListaDeElementos(UiGenerico.listaDeInformacion("Elementos auditoria de transacciones")).size()).isGreaterThan(CERO).performAs(OnStage.theActorInTheSpotlight());
    }

    @Y("^se debe identificar que todos los registros son de tipo (.*)$")
    public void seDebeIdentificarQueTodosLosRegistrosSonDeTipoTipoDeTransaccion(String tipoDeTransaccion) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Esperar.pantallaDeCarga(),
                Task.where("Valida que todos los elementos filtrados sean de tipo transaccion " + tipoDeTransaccion,
                        Esperar.lista(),
                        Ensure.that(
                                TargetApp.soIsIos() ?
                                        Utilidades.iosObtenerDeListaElCampo(1)
                                        : Utilidades.androidObtenerDeListaElCampo(1)
                        ).allMatch("Todos los elementos de la lista deben ser del tipo de transaccion", var -> var.contains(tipoDeTransaccion))));
    }

    @Y("^se debe identificar que todos los registros tenga como un monto el rango (.*) a (.*)$")
    public void seDebeIdentificarQueTodosLosRegistrosTengaComoUnMontoElRangoDesdeRangoDesdeAHasta(String min, String max) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Esperar.pantallaDeCarga(),
                Task.where("Valida que todos los elementos filtrados esten en el rango desde " + min + " hasta " + max,
                        Esperar.lista(),
                        Ensure.that(
                                        TargetApp.soIsIos() ?
                                                Utilidades.tomarInformacionListaAuditoriaDeTransacciones()
                                                : Utilidades.androidObtenerDeListaElCampo(3))
                                .allMatch("Todos los elementos de la lista deben estar en el rango de monto desde " + min + " hasta " + max,
                                        var -> valorEntre((double) informacionRegistroAuditoriaDeTransacciones(var).get(ValoresAuditoriaDeTrasacciones.VALOR_DE_LA_TRANSACCON), Double.parseDouble(min), Double.parseDouble(max)))));
    }

    @Y("^se debe identificar que todos los registros tenga como un estado de transaccion (.*)$")
    public void seDebeIdentificarQueTodosLosRegistrosTengaComoUnEstadoDeTransaccionEstadoDeLaTransaccion(String estadoDeTransaccion) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Esperar.pantallaDeCarga(),
                Task.where("Valida que todos los elementos filtrados tengan como esatdo de transaccion " + estadoDeTransaccion,
                        Esperar.lista(),
                        Ensure.that(
                                        TargetApp.soIsIos() ?
                                                Utilidades.tomarInformacionListaAuditoriaDeTransacciones()
                                                : Utilidades.androidObtenerDeListaElCampo(2))
                                .allMatch("Todos los elementos de la lista deben tener como estado de transaccion " + estadoDeTransaccion,
                                        var -> informacionRegistroAuditoriaDeTransacciones(var).get(ValoresAuditoriaDeTrasacciones.ESTADO_DE_LA_TRANSACCION).equals(estadoDeTransaccion))));
    }
}