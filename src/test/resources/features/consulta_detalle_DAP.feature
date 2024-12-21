#language:es
#Author:aeaguila@bancoagricola.com.sv

Característica: Consulta detalle de Deposito a plazo

  @consulta @QA
  Escenario: El cliente validará que se muestre el detalle de Deposito a plazo, validando las 3 capas de información
    Dado realiza el proceso de logueo con el usuario privado01
    Entonces valida que se muestren de forma correcta los datos de Deposito a plazo
      | cuentaOrigen                        |
      | 7110347144 Depósito a plazo digital |