package com.bancoagricola.certificacion.omnicanalidadpersonas.movil.utils;

import com.bancoagricola.certificacion.omnicanalidadpersonas.movil.models.*;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.targets.Target;

import java.util.*;
import java.util.stream.Collectors;

public class TomarValores {

    static int inicial = 0;
    static int intFinal = 0;

    public static Map<String, String> delElemento(Target xpath, Map<String, TipoElemento> dato) {

        List<String> list = tomarDatosLista(xpath);
        Map<String, String> informacionValores = new HashMap<String, String>();

        dato.forEach(
                (nombreDato, posicion) -> {
                    switch (posicion) {
                        case TITULO_UNO:
                            informacionValores.put(nombreDato, list.get((int) posicion.getValue()));
                            list.remove((int) posicion.getValue());
                            break;

                        case VALOR_DINERO:
                            inicial = indexOfConstains(list, "$");
                            if (inicial > 0) {
                                intFinal = siguienteCampo(list, inicial);
                                informacionValores.put(nombreDato, (list.get(inicial - 1).length() > 2 ? list.get(inicial - 1) : String.join(".", list.subList(inicial, intFinal))).replace("$.", "").replace("$", ""));

                                if (list.get(inicial - 1).length() > 2) {
                                    list.remove(--inicial);
                                } else {
                                    list.remove(--inicial);
                                    list.remove(inicial);
                                }

                            }
                            break;

                        case POSICION_LATERAL:
                        case POSICION_ABAJO:
                            if (indexOfConstains(list, nombreDato) > 0) {
                                inicial = indexOfConstains(list, nombreDato) - 1;
                                intFinal = inicial + 1 + (int) posicion.getValue();
                                informacionValores.put(nombreDato, String.join("", list.subList(inicial, (intFinal > list.size()) ? intFinal - 1 : intFinal)).replace(nombreDato, ""));
                            }
                            break;

                        case POSICION_ARRIBA:
                            if (indexOfConstains(list, nombreDato) > 0) {
                                inicial = indexOfConstains(list, nombreDato) - 1;
                                intFinal = inicial - (int) posicion.getValue();
                                informacionValores.put(nombreDato, String.join("", list.subList(intFinal, inicial)).replace(nombreDato, ""));
                            }
                            break;
                    }

                }
        );

        return informacionValores;

    }


    private static int indexOfConstains(List<String> lista, String contain) {

        int posicionValor = 0;

        for (String dato : lista) {

            posicionValor++;
            if (dato.contains(contain))
                return posicionValor;

        }

        return -1;

    }

    private static int siguienteCampo(List<String> lista, int posicion) {

        ++posicion;

        if (posicion < lista.size()) {
            for (String dato : lista.subList(posicion, lista.size())) {

                if (dato.matches(".*[a-zA-Z$?)-].*") || dato.isEmpty() || dato.length() > 2)
                    break;

                ++posicion;

            }
        }

        return posicion;

    }

    private static List<String> tomarDatosLista(Target xpath){

        long timeSeg = System.currentTimeMillis() / 1000;
        long timeSegAct = timeSeg;
        List<String> list;

       do {
           try {
               list = xpath.resolveAllFor(OnStage.theActorInTheSpotlight()).stream().map(element -> element.getAttribute(TargetApp.soIsIos() ? "label" : "text")).collect(Collectors.toList());
           }catch (Exception e){
               list = Collections.<String>emptyList();
           }

           if(timeSegAct-timeSeg>=30){
               throw new RuntimeException("no fue posible identificar informacion en la pantalla");
           }

           timeSegAct = System.currentTimeMillis() / 1000;

       }while(list.size() == 0);

        list.removeIf(value -> value == null || value.equals("") || value.equals(" ") || value.equals("  ") || value.equals("Bancoagrícola") || value.equals("Banco Agrícola"));
        list.replaceAll(value -> value.replace("(", ""));
        list.replaceAll(value -> value.replace(")", ""));
        list.removeIf(value -> value == null || value.equals("") || value.equals(" ") || value.equals("  ") || value.equals("Bancoagrícola") || value.equals("Banco Agrícola"));

        return list;

    }

}


