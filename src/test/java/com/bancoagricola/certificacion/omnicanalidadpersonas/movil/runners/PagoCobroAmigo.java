package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/pago_y_cobro_a_un_amigo.feature",
        glue = {"com.bancoagricola.certificacion.omnicanalidadpersonas.movil.stepdefinitions", "com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils"},
        snippets = SnippetType.CAMELCASE
)

public class PagoCobroAmigo {
}
