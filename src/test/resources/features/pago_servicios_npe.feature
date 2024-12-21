#language:es
#Author:guseche@bancoagricola.com.sv

Característica: Pago de servicios NPE

  @pago @QA
  Escenario: El cliente podrá realizar pago de servicios con NPE desde cuenta de ahorro
    Dado que se el valor de los saldos del usuario AUTOMATIZADA05 de la cuenta
      | cuentaOrigen                 |
      | 3005942047 Cuenta de ahorro |
    Cuando realiza el proceso de pago de servicio con NPE desde cuenta de ahorro
      | cuentaOrigen                 | npe                          | monto | concepto       |
      | 3005942047 Cuenta de ahorro | 0833001087000045738401787287   | 1     | Pago Siman NPE |
    Entonces debe visualizar que el pago de servicios npe fue exitoso y se le desconto el valor correcto de su cuenta
      | cuentaOrigen                 | monto |
      | 3005942047 Cuenta de ahorro | 1     |

  @pago @QA
  Escenario: El cliente podrá realizar pago de servicios con NPE desde tarjeta de crédito
    Dado que se el valor de los saldos del usuario GRANADAUSR de la tarjeta de credito
      | cuentaOrigen            |
      | **** 5855 VISA Platinum |
    Cuando realiza el proceso de pago de servicio con NPE desde tarjeta de crédito
      | cuentaOrigen            | npe                          | monto | concepto       |
      | **** 5855 VISA Platinum | 0833001087000045738401787287  | 1     | Pago Siman NPE |
    Entonces debe visualizar que el pago de servicios npe fue exitoso y se le desconto el valor correcto de su tarjeta
      | cuentaOrigen            | monto |
      | **** 5855 VISA Platinum | 1     |

  @pago @QA
  Escenario: El cliente podrá realizar pago de servicios con NPE desde cuenta corriente
    Dado que se el valor de los saldos del usuario PRIVADO01 de la cuenta
      | cuentaOrigen                 |
      | 1210039767 Cuenta Corriente  |
    Cuando realiza el proceso de pago de servicio con NPE desde cuenta de ahorro
      | cuentaOrigen                 | npe                          | monto | concepto       |
      | 1210039767 Cuenta Corriente | 0833001087000045738401787287   | 1     | Pago Siman NPE |
    Entonces debe visualizar que el pago de servicios npe fue exitoso y se le desconto el valor correcto de su cuenta
      | cuentaOrigen                 | monto |
      | 1210039767 Cuenta Corriente | 1     |
