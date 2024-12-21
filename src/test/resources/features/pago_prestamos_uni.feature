#language:es
#Author:guseche@bancogricola.com.sv

Característica: Pago préstamo UNI

  @pago @DEV
  Escenario: El cliente podrá realizar pagos de préstamos UNI desde cero
    Dado que se el valor de los saldos del usuario GRANADAUSR de la cuenta
      | cuentaOrigen                |
      | 3112420617 Cuenta de ahorro |
    Cuando realiza el pago de prestamo UNI
      | cuentaOrigen                | banco      | numeroPrestamo | tipoIdentificacion | numeroIdentificacion | nombreRecibidor | correo                        | monto | concepto  |
      | 3112420617 Cuenta de ahorro | DAVIVIENDA | 733572804      | DUI                | 014712643            | Juan Perez      | aeaguila@bancoagricola.com.sv | 1     | PruebaUNI |
    Entonces debe visualizar que el pago de prestamo entre bancos UNI fue exitoso y se le desconto el valor correcto de su cuenta
      | cuentaOrigen                | monto |
      | 3112420617 Cuenta de ahorro | 1     |

  @pago @DEV
  Escenario: El cliente podrá realizar pagos de préstamos UNI desde un favorito
    Dado que existe el favorito PAGO_PRESTAMO_UNI para el usuario GRANADAUSR
    Y que se el valor de los saldos del usuario GRANADAUSR de la cuenta
      | cuentaOrigen                |
      | 3112420617 Cuenta de ahorro |
    Cuando realiza el pago de prestamo UNI desde favorito
      | cuentaOrigen                | monto | concepto  | nombrefavorito |
      | 3112420617 Cuenta de ahorro | 1     | PruebaUNI | FavoritoPRHIP  |
    Entonces debe visualizar que el pago de prestamo entre bancos UNI fue exitoso y se le desconto el valor correcto de su cuenta
      | cuentaOrigen                | monto |
      | 3112420617 Cuenta de ahorro | 1     |