#language:es
  #Author:guseche@bancoagricola.com.sv

Característica: Pago y cobro a un amigo

  @cobro1 @QA
  Escenario: El cliente podrá realizar el cobro a un amigo
    Dado realiza el proceso de logueo con el usuario privado01
    Cuando realiza el proceso de Cobro a un amigo
      | cuentaOrigen                | nombre     | correo                        | celular  | monto |
      | 3001329786 Cuenta de ahorro | CobroAmigo | aeaguila@bancoagricola.com.sv | 60043306 | 1     |
    Entonces el sistema le informa que la solicitud de cobro fue enviada de manera exitosa

  @pago1 @QA
  Escenario: El cliente podrá realizar  el pago a un amigo
    Dado realiza el proceso de logueo con el usuario AUTOMATIZADA05
    Entonces el usuario AUTOMATIZADA05 realiza el pago a su amigo
      | cuentaOrigen                | nombre       | monto | concepto   |
      | 3005942047 Cuenta de ahorro | BLANCA RODAS | 1     | Pago amigo  |
    Entonces el sistema le informa que la solicitud de pago fue realizada de manera exitosa