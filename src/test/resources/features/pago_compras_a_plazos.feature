#language:es
#Author:guseche@bancogricola.com.sv

Característica: Pago compras a plazos

  @pago @QA
  Escenario: El cliente podrá realizar pagos de compras a plazo desde CA
    Dado que se el valor de los saldos del usuario automatizada05 de la cuenta
      | cuentaOrigen                |
      | 3005942047 Cuenta de ahorro |
    Cuando se realiza el proceso de pagos de compras a plazo
      | cuentaOrigen                | tarjetaCredito                | compraPlazo                          | monto | concepto          |
      | 3005942047 Cuenta de ahorro | **** 3144 VISA Gold | Samsung galaxy s22fe 256gb | 1     | Pago Compra Plazo |
    Entonces debo observar que la transaccion de pago compras a plazos fue exitosa y el saldo fue descontado correctamente
      | cuentaOrigen                | monto |
      | 3005942047 Cuenta de ahorro | 1     |

  @pago @QA
  Escenario: El cliente podrá realizar pagos de compras a plazo desde CC
    Dado que se el valor de los saldos del usuario automatizada05 de la cuenta
      | cuentaOrigen                |
      | 5000117825 Cuenta corriente |
    Cuando se realiza el proceso de pagos de compras a plazo
      | cuentaOrigen                | tarjetaCredito                | compraPlazo                          | monto | concepto          |
      | 5000117825 Cuenta corriente | **** 3144 VISA Gold | Samsung galaxy s22fe 256gb | 1     | Pago Compra Plazo |
    Entonces debo observar que la transaccion de pago compras a plazos fue exitosa y el saldo fue descontado correctamente
      | cuentaOrigen                | monto |
      | 121005000117825 Cuenta corriente | 1     |