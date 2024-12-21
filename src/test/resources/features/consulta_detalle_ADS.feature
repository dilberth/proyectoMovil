#language:es
#Author:aeaguila@bancoagricola.com.sv

Característica: Consulta detalle de Adelanto de salario

  @consulta @DEV
  Escenario: El cliente validará que se muestre el detalle de Adelanto de salario
    Dado realiza el proceso de logueo con el usuario ACTADS4
    Entonces valida que se muestren de forma correcta los datos de Adelanto de salario
      | ads                         |
      | 5167481504 Cuenta corriente |
