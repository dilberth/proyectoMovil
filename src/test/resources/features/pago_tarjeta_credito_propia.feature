#language:es
#Author:guseche@bancoagricola.com.sv

Característica: Pago de tarjeta credito propia

  @pago @QA
  Escenario: El cliente podra realizar el pago de las tarjeta de credito propia desde sus cuentas desde el menu de cuentas
    Dado que se el valor de los saldos del usuario AUTOMATIZADA05 de la cuenta
      | CuentaOrigen                |
      | 3005942047 Cuenta de ahorro |
    Cuando realiza el pago de tarjeta desde cuentas con los datos
      | CuentaOrigen                | tarjetaCredito      | monto | concepto                    |
      | 3005942047 Cuenta de ahorro | **** 3144 VISA Gold | 1     | pago tarjeta credito propia |
    Entonces debe visualizar que el pago de tarjeta propia fue exitoso y se le desconto el valor correcto de su cuenta
      | CuentaOrigen                | monto |
      | 3005942047 Cuenta de ahorro | 1     |

  @pago @QA
  Escenario: El cliente podra realizar el pago de las tarjeta de credito propia desde sus cuentas desde el menu de tarjetas
    Dado que se el valor de los saldos del usuario AUTOMATIZADA05 de la cuenta
      | CuentaOrigen                |
      | 3005942047 Cuenta de ahorro |
    Y realiza el pago de tarjeta desde tarjetas con los datos
      | CuentaOrigen  | tarjetaCredito      | monto | concepto                    |
      | 3005942047 CA | **** 3144 VISA Gold | 1     | pago tarjeta credito propia |
    Entonces debe visualizar que el pago de tarjeta propia fue exitoso y se le desconto el valor correcto de su cuenta
      | CuentaOrigen                | monto |
      | 3005942047 Cuenta de ahorro | 1     |

  @pago @DEV
  Escenario:El cliente podrá realizar el pago de su tarjeta con bitcoins
    Dado que se el valor de los saldos del usuario PRIVADO01 de la cuenta
      | cuentaOrigen                |
      | 3111466124 Cuenta de ahorro |
    Cuando realiza el pago de tarjeta propia desde la cuenta propia con bitcoins
      | CuentaOrigen                | tarjetaCredito            | monto | concepto                    |
      | 3111466124 Cuenta de ahorro | **** 6474 Dorada Selectos | 1     | pago tarjeta credito propia |
    Entonces se debe visualizar el QR de pago con bitcoins