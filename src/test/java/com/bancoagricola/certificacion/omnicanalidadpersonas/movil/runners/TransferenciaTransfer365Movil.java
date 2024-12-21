package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.runners;

import cucumber.api.*;
import net.serenitybdd.cucumber.*;
import org.junit.runner.*;

import static cucumber.api.SnippetType.*;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/transferencia_transfer365_movil.feature",
        glue = {"com.bancoagricola.certificacion.omnicanalidadpersonas.movil.stepdefinitions", "com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils"},
        snippets = CAMELCASE
)
public class TransferenciaTransfer365Movil {
}
