package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.runners;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

import static cucumber.api.SnippetType.CAMELCASE;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/recarga_paquetes_TDC.feature",
        glue = {"com.bancoagricola.certificacion.omnicanalidadpersonas.movil.stepdefinitions", "com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils"},
        snippets = CAMELCASE
)
public class RecargaPaquetesTDC {
}
