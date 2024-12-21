package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.Esperar;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.VolverInicio;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.Cuentas;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.questions.ValidarQueElUltimoMovimientoCuenta;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.questions.ValidarTicketPagoCompraAPlazos;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.Usuario;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;

import java.util.List;

public class PagoComprasAPlazosStepDefinition {

    @Dado("^que se el valor de los saldos del usuario (.*) de la cuenta$")
    public void queSeElValorDeLosSaldosDeLaCuenta(Usuario usuario,List<Cuentas> informacionPago) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ProcesoLogueo.con(usuario),
                ValidaSaldosOrigenAntes.para(informacionPago),
                VolverInicio.click());
    }
    @Cuando("^se realiza el proceso de pagos de compras a plazo$")
    public void seRealizaElProcesoDePagosDeComprasAPlazo(List<Transferencias> informacionPago) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ProcesoPagoCompraAPlazos.conLaInformacion(informacionPago));
    }


    @Entonces("^debo observar que la transaccion de pago compras a plazos fue exitosa y el saldo fue descontado correctamente$")
    public void deboObservarQueLaTransaccionFueExitosaYElSaldoFueDescontadoCorrectamente(List<Cuentas> informacionPago) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Esperar.texto("La compra a plazo se pagó exitosamente"),
                ValidarTicketPagoCompraAPlazos.enPantalla(),
                ValidaSaldosOrigenDespues.para(informacionPago)
        );
    }
}