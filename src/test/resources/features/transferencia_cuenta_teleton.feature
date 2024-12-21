#language:es
#Author:aeaguila@bancoagricola.com.sv

Característica: Transferencias cuenta Teletón

  @transferenciaTel1 @QA
  Escenario: El cliente podrá realizar una tranferencia a cuenta Teletón desde su cuenta de ahorros
    Dado realiza el proceso de logueo con el usuario AUTOMATIZADA05
    Cuando valida el saldo de cuenta origen antes de realizar la transacción
      | cuentaOrigen                |
      | 3005942047 Cuenta de ahorro |
    Y realiza la transferencia desde su cuenta a una cuenta teleton
      | cuentaOrigen                | monto | concepto                     |
      | 3005942047 Cuenta de ahorro | 1     | transferencia cuenta Teleton |
    Entonces debe visualizar la disminucion en la cuenta de origen
      | cuentaOrigen                | monto |
      | 3005942047 Cuenta de ahorro | 1     |

  @transferenciaTel2 @QA
  Escenario: El cliente podrá realizar una tranferencia a cuenta Teletón desde su cuenta corriente
    Dado realiza el proceso de logueo con el usuario PRIVADO01
    Cuando valida el saldo de cuenta origen antes de realizar la transacción
      | cuentaOrigen                |
      | 1210039767 Cuenta corriente |
    Y realiza la transferencia desde su cuenta a una cuenta teleton
      | cuentaOrigen                | monto | concepto                     |
      | 1210039767 Cuenta corriente | 1     | transferencia cuenta Teleton |
    Entonces debe visualizar la disminucion en la cuenta de origen
      | cuentaOrigen                | monto |
      | 1210039767 Cuenta corriente | 1     |
