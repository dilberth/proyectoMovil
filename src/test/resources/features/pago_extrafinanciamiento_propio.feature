#language:es
#Author:guseche@bancogricola.com.sv

Característica: Pago de extrafinanciamiento propio

  @pago @QA
  Escenario: El cliente podrá realizar el pago de un prestamos por extrafinanciamiento desde una de sus cuentas propias
    Dado que se el valor de los saldos del usuario AUTOMATIZADA05 de la cuenta
      | cuentaOrigen                |
      | 3005942047 Cuenta de ahorro |
    Cuando realiza el pago de extrafinanciamiento usando una cuenta propia
      | cuentaOrigen  | numeroPrestamo                             | tipoCobro  | monto | concepto                          |
      | 3005942047 CA | 2130032594 Préstamo de Extrafinanciamiento | Otro monto | 1     | pago prestamo extrafinanciamiento |
    Entonces debe visualizar que el pago de prestamo de extrafinanciamiento fue exitoso y diminuyo el saldo de cuenta la origen por el valor del pago
      | cuentaOrigen                | monto | numeroDeCuenta |
      | 3005942047 Cuenta de ahorro | 1     | 2124564303     |
