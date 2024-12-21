#language:es
#Author:aeaguila@bancoagricola.com.sv

Característica: Consulta detalle de Tarjeta de crédito

  @consulta @QA
  Escenario: El cliente validará que se muestre el detalle de Tarjeta de crédito, validando las 3 capas de información
    Dado realiza el proceso de logueo con el usuario JAVIERROSALES
    Entonces valida que se muestren de forma correcta los datos de la tarjeta de crédito
      | tarjetaCredito                 |
      | **** 4006 VISA CLASICA PILOTO  |