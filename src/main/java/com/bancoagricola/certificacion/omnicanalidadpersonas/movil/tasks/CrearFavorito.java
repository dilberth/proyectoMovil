package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.interactions.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils.*;
import net.serenitybdd.screenplay.*;
import net.serenitybdd.screenplay.conditions.*;

public class CrearFavorito implements Task {

    private final Favorito favorito;

    public CrearFavorito(Favorito favorito) {
        this.favorito = favorito;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

                IrAProducto.cuenta(favorito.infoPago.getCuentaOrigen()).ySeleccionarLaTransaccion(favorito.transaccion).performAs(actor);

                Esperar.pantallaDeCarga().performAs(actor);
                Utilidades.esperar(2);

                Task.where("{0} Valida que el favorito " + favorito.nombreFavorito + " exista",
                        Task.where("Valida si existe o no el favorito " + favorito.nombreFavorito),
                        Check.whether(!BuscarEnPantalla.elTexto(favorito.nombreFavorito)).andIfSo(
                                VolverInicio.click(),
                                favorito.tareaDePago,
                                AgregaFavorito.con(favorito.nombreFavorito)
                        ),
                        VolverInicio.click()
                ).performAs(actor);

    }

    public static CrearFavorito paraLaTransaccion(Favorito favorito) {
        return Tasks.instrumented(CrearFavorito.class, favorito);
    }


}
