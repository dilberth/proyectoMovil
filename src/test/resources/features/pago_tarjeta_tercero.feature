#language:es
#Author:guseche@bancogricola.com.sv

Característica: Pago tarjeta tercero

  @pago @QA
  Escenario: El cliente podra realizar el pago desde sus cuentas a tarjetas de terceros
    Dado que se el valor de los saldos del usuario JAVIERROSALES de la cuenta
      | CuentaOrigen                |
      | 3115267968 Cuenta de ahorro |
    Y realiza el pago de tarjeta a tercero desde la cuenta propia
      | CuentaOrigen                | tarjetaCreditoTercero | monto | concepto                            | correo                        |
      | 3115267968 Cuenta de ahorro | 5293320004356272      | 1     | pagar tarjeta a terceros automatico | aeaguila@bancoagricola.com.sv |
    Entonces debe visualizar que el pago de tarjeta terceros fue exitoso y se le desconto el valor correcto de su cuenta
      | CuentaOrigen                | monto |
      | 3115267968 Cuenta de ahorro | 1     |

  @pago @QA
  Escenario: El cliente podra realizar el pago desde sus cuentas a tarjetas de un favorito de tarjeta de terceros
    Dado que existe el favorito PAGO_TARJETA_TERCERO para el usuario JAVIERROSALES
    Y que se el valor de los saldos del usuario JAVIERROSALES de la cuenta
      | CuentaOrigen                |
      | 3115267968 Cuenta de ahorro |
    Y realiza el pago de tarjeta tercero Nuevo desde la cuenta propia a un favorito
      | CuentaOrigen                | nombrefavorito | monto | concepto                            |
      | 3115267968 Cuenta de ahorro | AUTOMATIZADA   | 1     | pagar tarjeta a terceros automatico |
    Entonces debe visualizar que el pago de tarjeta terceros fue exitoso y se le desconto el valor correcto de su cuenta
      | CuentaOrigen                | monto |
      | 3115267968 Cuenta de ahorro | 1      |

  @pago @DEV
  Escenario:El cliente podrá realizar el pago de una tarjeta de terceros con bitcoins
    Dado que se el valor de los saldos del usuario GRANADAUSR de la cuenta
      | cuentaOrigen                |
      | 3112420617 Cuenta de ahorro |
    Cuando realiza el pago de tarjeta a terceros desde la cuenta propia con bitcoins
      | CuentaOrigen                | tarjetaCreditoTercero | monto | concepto                            | correo                        |
      | 3112420617 Cuenta de ahorro | 5293320004356272      | 1     | pagar tarjeta a terceros automatico | aeaguila@bancoagricola.com.sv |
    Entonces se debe visualizar el QR de pago con bitcoins