package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.questions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.Esperar;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.IrAProducto;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.VolverInicio;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;

public class ValidarQueElUltimoMovimientoCuenta implements Task {

    private String cuenta;
    private String movimiento;
    private Target primeroMovimiento = Target.the("primer movimiento de tipo '{0}'").locatedBy("(//*[@class='android.widget.ListView'])//parent::*[@index=0]//*[contains(@text,'{0}')]");

    public ValidarQueElUltimoMovimientoCuenta(String cuenta,String movimiento) {
        this.cuenta = cuenta;
        this.movimiento = movimiento;
    }

    @Step("{0} valida que el ultimo movimiento hecho en la cuenta '#cuenta' es '#movimiento'")
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                VolverInicio.click(),
                IrAProducto.cuenta(cuenta).ySeleccionarLaTransaccion("Movimientos"),
                Esperar.target(primeroMovimiento.of(movimiento)),
                ElementoEnPantalla.elemento(primeroMovimiento.of(movimiento))
        );

    }

    public static DescripcionMovimiento numero(String cuenta) {
        return new DescripcionMovimiento(cuenta);
    }

    public static class DescripcionMovimiento {

        private String cuenta;

        public DescripcionMovimiento(String cuenta) {
            this.cuenta = cuenta;
        }

        public ValidarQueElUltimoMovimientoCuenta es(String movimiento){
            return Tasks.instrumented(ValidarQueElUltimoMovimientoCuenta.class,this.cuenta,movimiento);
        }

    }

}
