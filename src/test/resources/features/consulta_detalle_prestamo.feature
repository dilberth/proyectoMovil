#language:es
#Author:aeaguila@bancoagricola.com.sv

Característica: Consulta detalle de Préstamo

  @consulta @QA
  Escenario: El cliente validará que se muestre el detalle de Préstamo, validando las 3 capas de información
    Dado realiza el proceso de logueo con el usuario PRIVADO01
    Entonces valida que se muestren de forma correcta los datos de Préstamo
      | referencia                     |
      | 2131947871 Préstamo de Consumo |
