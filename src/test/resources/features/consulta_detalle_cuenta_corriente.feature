#language:es
#Author:aeaguila@bancoagricola.com.sv

Característica: Consulta detalle de Cuentas corriente

  @consulta @QA
  Escenario: El cliente validará que se muestre el detalle de Cuenta corriente, validando las 3 capas de información
    Dado realiza el proceso de logueo con el usuario JAVIERROSALES
    Entonces valida que se muestren de forma correcta los datos de la cuenta corriente
      | cuentaOrigen                |
      | 5110002623 Cuenta corriente |