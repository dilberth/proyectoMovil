#language:es
#Author:aeaguila@bancoagricola.com.sv

Característica: Consulta detalle de Cuenta de ahorro

  @consulta @QA
  Escenario: El cliente validará que se muestre el detalle de Cuentas de ahorro, validando las 3 capas de información
    Dado realiza el proceso de logueo con el usuario PRIVADO01
    Entonces valida que se muestren de forma correcta los datos de la cuenta de ahorro
      | cuentaOrigen                 |
      | 3111466124 Cuenta de ahorro |