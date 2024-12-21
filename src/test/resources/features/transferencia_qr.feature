#language:es
#Author:aeaguila@bancoagricola.com.sv

Característica: Transferencias QR

  @transferenciaQR1 @DEV
  Escenario: El cliente podrá realizar tranferencias con QR desde la cuenta de ahorro
    Dado realiza el proceso de logueo con el usuario GRANADAUSR
    Cuando valida el saldo de cuenta origen antes de realizar la transacción
      | cuentaOrigen                |
      | 3112420617 Cuenta de ahorro |
    Cuando realizo una transferencia con QR
      | cuentaOrigen                | codigoQR     | monto | concepto                | tipoTRX |
      | 3112420617 Cuenta de ahorro | 471922594762 | 1     | transferencia QR prueba | CA      |
    Entonces debe visualizar la disminucion en la cuenta de origen
      | cuentaOrigen                | monto |
      | 3112420617 Cuenta de ahorro | 1     |

  @transferenciaQR2 @DEV
  Escenario: El cliente podrá realizar tranferencias con QR desde la tarjeta de credito
    Dado realiza el proceso de logueo con el usuario GRANADAUSR
    Cuando valida el saldo de la tarjeta de credito antes de realizar la transacción
      | cuentaOrigen            |
      | **** 9576 VISA Platinum |
    Cuando realizo una transferencia con QR
      | cuentaOrigen            | codigoQR     | monto | concepto                | tipoTRX |
      | **** 9576 VISA Platinum | 471922594762 | 1     | transferencia QR prueba | CA      |
    Y debe visualizar la disminucion en la tarjeta de credito
      | cuentaOrigen            | monto |
      | **** 9576 VISA Platinum | 1     |



