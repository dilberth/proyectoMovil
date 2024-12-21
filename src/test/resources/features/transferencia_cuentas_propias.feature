#language:es
#Author:aeaguila@bancoagricola.com.sv

Característica: Transferencia Cuentas Propias

  @transferenciaCP1 @QA
  Escenario: El cliente podrá realizar transferencias entre cuentas propias (Cuenta Ahorro a Cuenta Ahorro)
    Dado realiza el proceso de logueo con el usuario PRIVADO01
    Cuando valida los saldos antes de realizar la transacción
      | cuentaOrigen                | cuentaDestino                |
      | 3111466124 Cuenta de ahorro | 3001329786 Cuenta de ahorro |
    Y realiza el traslado de saldo de la cuenta origen a la cuenta destino
      | cuentaOrigen                | cuentaDestino  | monto | concepto | tipoTRX |
      | 3111466124 Cuenta de ahorro | 3001329786 CA | 1     | Prueba   | CA      |
    Entonces debe visualizar la disminucion en la cuenta de origen y un aumento en la cuenta destino
      | cuentaOrigen                | cuentaDestino                | monto |
      | 3111466124 Cuenta de ahorro | 3001329786 Cuenta de ahorro | 1     |

  @transferenciaCP2 @QA
  Escenario: El cliente podrá realizar transferencias entre cuentas propias (Cuenta Ahorro a Cuenta Corriente)
    Dado realiza el proceso de logueo con el usuario PRIVADO01
    Cuando valida los saldos antes de realizar la transacción
      | cuentaOrigen                | cuentaDestino               |
      | 1210039767 Cuenta corriente | 3001329786 Cuenta de ahorro |
    Y realiza el traslado de saldo de la cuenta origen a la cuenta destino
      | cuentaOrigen                | cuentaDestino | monto | concepto | tipoTRX |
      | 1210039767 Cuenta corriente | 3001329786 CA | 1     | Prueba   | CC      |
    Entonces debe visualizar la disminucion en la cuenta de origen y un aumento en la cuenta destino
      | cuentaOrigen                | cuentaDestino               | monto |
      | 1210039767 Cuenta corriente | 3001329786 Cuenta de ahorro | 1     |
