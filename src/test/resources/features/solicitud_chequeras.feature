#language:es
#Author:aeaguila@bancoagricola.com.sv

Característica: Solicitud de chequeras

  @general @QA
  Escenario: El cliente podrá solicitar chequeras
    Dado realiza el proceso de logueo con el usuario PRIVADO01
    Cuando realiza proceso para solicitud de chequeras
      | cuentaOrigen                | tipoChequera | cantidadCheques | departamentoEntrega | agenciaEntrega  |
      | 1210039767 Cuenta corriente | Con Taco     | 25              | LA LIBERTAD         | AGENCIA MERLIOT |
    Entonces el sistema me informa que la solicitud de creacion de chequera fue exitosa