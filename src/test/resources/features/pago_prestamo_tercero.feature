#language:es
#Author:guseche@bancogricola.com.sv

Característica: Pago préstamo tercero

  @pago1 @QA
  Escenario: El cliente podrá realizar el pago de préstamo de tercero desde cuenta propia
    Dado que se el valor de los saldos del usuario PRIVADO01 de la cuenta
      | cuentaOrigen                |
      | 3111466124 Cuenta de ahorro |
    Cuando realiza el pago de prestamo a tercero Nuevo desde la cuenta propia
      | cuentaOrigen                | numeroPrestamo | monto | concepto                          | correo                        |
      | 3111466124 Cuenta de ahorro | 8094190065     | 1     | pago prestamo terceros automatico | eguevara@bancoagricola.com.sv |
    Entonces debe visualizar que el pago de prestamo a terceros fue exitoso y se le desconto el valor correcto de su cuenta
      | monto | cuentaOrigen                | numeroDeCuenta |
      | 1     | 3111466124 Cuenta de ahorro | 8094190065     |

  @pago2 @QA
  Escenario: El cliente podrá realizar el pago de préstamo de tercero guardado como favorito desde cuenta propia
    Dado que se el valor de los saldos del usuario PRIVADO02 de la cuenta
      | cuentaOrigen                |
      | 3110481891 Cuenta de ahorro |
    Cuando realiza el pago de prestamo a tercero Nuevo desde la cuenta propia a un favorito
      | cuentaOrigen                | nombrefavorito      | monto | concepto                          |
      | 3110481891 Cuenta de ahorro | FavoritoPagoTercero | 1     | pago prestamo terceros automatico |
    Entonces debe visualizar que el pago de prestamo a terceros fue exitoso y se le desconto el valor correcto de su cuenta
      | monto | cuentaOrigen                | numeroDeCuenta |
      | 1     | 3110481891 Cuenta de ahorro | 8094512503     |

  @pago @DEV
  Escenario:El cliente podrá realizar el pago de su prestamo con bitcoins
    Dado que se el valor de los saldos del usuario GRANADAUSR de la cuenta
      | cuentaOrigen                |
      | 3112420617 Cuenta de ahorro  |
    Cuando realiza el pago de prestamo a terceros desde la cuenta propia con bitcoins
      | cuentaOrigen                | numeroPrestamo | monto | concepto                 | correo                        |
      | 3112420617 Cuenta de ahorro | 2130437600     | 1     | pago prestamo automatico | aeaguila@bancoagricola.com.sv |
    Entonces se debe visualizar el QR de pago con bitcoins