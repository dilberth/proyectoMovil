#language:es
#Author:aeaguila@bancoagricola.com.sv

Característica: Consulta detalle de Ahorro programado

  @consulta @QA
  Escenario: El cliente validará que se muestre el detalle de Ahorro programado, validando las 3 capas de información
    Dado realiza el proceso de logueo con el usuario PRIVADO03
    Entonces valida que se muestren de forma correcta los datos del Ahorro Programado
      | cuentaOrigen               |
      | 3490316617 Sueno Realizado |
