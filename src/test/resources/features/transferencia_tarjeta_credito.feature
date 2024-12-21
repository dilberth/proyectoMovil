#language:es
#Author:aeaguila@bancoagricola.com.sv

Característica: Transferencia Tarjeta de crédito

  @transferenciaTC1 @QA
  Escenario: El cliente podrá realizar transferencias de tarjeta de crédito a Cuenta de Ahorro
    Dado realiza el proceso de logueo con el usuario privado01
    Cuando valida el saldo de cuenta destino antes de realizar la transacción
      | cuentaDestino               |
      | 3001329786 Cuenta de ahorro|
    Cuando valida el saldo de la tarjeta de credito antes de realizar la transacción
      | cuentaOrigen        |
      | **** 1392 VISA Infinite Lifemiles |
    Y realiza el traslado de saldo de la cuenta origen a la cuenta destino
      | cuentaOrigen        | cuentaDestino | monto | concepto | tipoTRX |
      | **** 1392 VISA Infinite Lifemiles | 3001329786 CA | 1     | Prueba   | TDC     |
    Y debe visualizar la disminucion en la tarjeta de credito
      | cuentaOrigen        | monto |
      | **** 1392 VISA Infinite Lifemiles | 1     |
    Entonces debe visualizar un aumento en la cuenta destino
      | cuentaDestino               | monto |
      | 3001329786 Cuenta de ahorro | 1     |

  @transferenciaTC2 @QA
  Escenario: El cliente podrá realizar transferencias de tarjeta de crédito a Cuenta Corriente
    Dado realiza el proceso de logueo con el usuario PRIVADO01
    Cuando valida el saldo de cuenta destino antes de realizar la transacción
      | cuentaDestino               |
      | 1210039767 Cuenta corriente |
    Cuando valida el saldo de la tarjeta de credito antes de realizar la transacción
      | cuentaOrigen                |
      | **** 1392 VISA Infinite Lifemiles|
    Y realiza el traslado de saldo de la cuenta origen a la cuenta destino
      | cuentaOrigen                | cuentaDestino | monto | concepto | tipoTRX |
      | **** 1392 VISA Infinite Lifemiles | 1210039767 CC | 1     | Prueba   | TDC     |
    Y debe visualizar la disminucion en la tarjeta de credito
      | cuentaOrigen                | monto |
      | **** 1392 VISA Infinite Lifemiles| 1     |
    Entonces debe visualizar un aumento en la cuenta destino
      | cuentaDestino               | monto |
      | 1210039767 Cuenta corriente | 1     |