#language:es
#Author:aeaguila@bancoagricola.com.sv

Característica: Consulta detalle de PuntosBA

  @consulta @QA
  Escenario: El cliente validará que se muestre el detalle de Puntos BA, validando las 3 capas de información
    Dado realiza el proceso de logueo con el usuario PRIVADO01
    Entonces valida que se muestren de forma correcta los datos de Puntos BA
      | alias     |
      | Puntos BA |