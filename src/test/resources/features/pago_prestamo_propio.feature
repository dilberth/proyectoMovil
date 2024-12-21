#language:es
#Author:guseche@bancogricola.com.sv

Característica: Pago préstamo propio

  @pago @QA
  Escenario:El cliente podrá realizar el pago desde sus cuentas a su préstamo propio
    Dado que se el valor de los saldos del usuario AUTOMATIZADA05 de la cuenta
      | cuentaOrigen                |
      | 3005942047 Cuenta de ahorro |
    Cuando realiza el pago de prestamo desde la cuenta propia
      | cuentaOrigen                | numeroPrestamo                 | monto | concepto                 | correo                        |
      | 3005942047 Cuenta de ahorro | 2126490150 Préstamo de Consumo | 1     | pago prestamo automatico | eguevara@bancoagricola.com.sv |
    Entonces debe visualizar que el pago de prestamo fue exitoso y se le desconto el valor correcto de su cuenta
      | monto | cuentaOrigen                | numeroDeCuenta |
      | 1     | 3005942047 Cuenta de ahorro | 8094190065     |

  @pago @QA
  Escenario: El cliente podrá realizar el pago préstamo propio ingresando desde préstamo
    Dado que se el valor de los saldos del usuario AUTOMATIZADA05 de la cuenta
      | cuentaOrigen                |
      | 3005942047 Cuenta de ahorro |
    Cuando realiza el pago de prestamo desde el menu de cuentas
      | cuentaOrigen  | numeroPrestamo                 | monto | concepto                 | correo                        |
      | 3005942047 CA | 2126490150 Préstamo de Consumo | 1     | pago prestamo automatico | eguevara@bancoagricola.com.sv |
    Entonces debe visualizar que el pago de prestamo fue exitoso y se le desconto el valor correcto de su cuenta
      | monto | cuentaOrigen                | numeroDeCuenta |
      | 1     | 3005942047 Cuenta de ahorro | 8094190065     |

  @pago @DEV
  Escenario:El cliente podrá realizar el pago de su prestamo con bitcoins
    Dado que se el valor de los saldos del usuario PRIVADO01 de la cuenta
      | cuentaOrigen                 |
      | 31320008506 Cuenta de ahorro |
    Cuando realiza el pago de prestamo desde la cuenta propia con bitcoins
      | cuentaOrigen                 | numeroPrestamo                 | monto | concepto                 | correo                        |
      | 31320008506 Cuenta de ahorro | 2130437600 Préstamo de Consumo | 1     | pago prestamo automatico | eguevara@bancoagricola.com.sv |
    Entonces se debe visualizar el QR de pago con bitcoins