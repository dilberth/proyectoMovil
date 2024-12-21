package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.runners;

import cucumber.api.*;
import net.serenitybdd.cucumber.*;
import org.junit.runner.*;

import static cucumber.api.SnippetType.*;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/consulta_movimientos_ADS.feature",
        glue = {"com.bancoagricola.certificacion.omnicanalidadpersonas.movil.stepdefinitions", "com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils"},
        snippets = CAMELCASE
)
public class ConsultaMovimientosADS {
}
