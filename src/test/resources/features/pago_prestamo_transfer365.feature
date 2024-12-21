#language:es
#Author:guseche@bancogricola.com.sv

Característica: Pago préstamo Transfer365

  @pago @DEV
  Escenario: El cliente podrá realizar el pago de préstamos entre bancos usando Transfer 365 desde su dispositivo móvil
    Dado que se el valor de los saldos del usuario AUTOMATIZADA05 de la cuenta
      | cuentaOrigen                |
      | 3220047196 Cuenta de ahorro |
    Cuando realizar el pago de prestamo a otro banco usando Transfer 365 ingresando los datos
      | cuentaOrigen                | banco             | cuentaDestino | tipoCliente | apellidoRecibidor | nombreRecibidor | monto | concepto    | correo                        |
      | 3220047196 Cuenta de ahorro | BANCO HIPOTECARIO | PH284781      | Jurídico    | Aguila            | Alcides         | 1     | transfer365 | aeaguila@bancoagricola.com.sv |
    Entonces debe visualizar que el pago transfer 365 fue exitoso y se realiza el debito del valor pagado a la cuenta
      | cuentaOrigen                | monto |
      | 3220047196 Cuenta de ahorro | 1     |

  @pago @DEV
  Escenario: El cliente podrá realizar el pago de prestamos entre bancos usando Transfer 365 de un favorito desde su dispositivo móvil
    Dado que existe el favorito PAGO_PRESTAMO_TRANSFER365 para el usuario AUTOMATIZADA05
    Y que se el valor de los saldos del usuario AUTOMATIZADA05 de la cuenta
      | cuentaOrigen                |
      | 3220047196 Cuenta de ahorro |
    Cuando realizar el pago de prestamo a otro banco usando Transfer 365 de un prestramo guardado como favorito
      | cuentaOrigen                | nombrefavorito      | monto | concepto    |
      | 3220047196 Cuenta de ahorro | Favorito365NOBORRAR | 1     | transfer365 |
    Entonces debe visualizar que el pago transfer 365 fue exitoso y se realiza el debito del valor pagado a la cuenta
      | cuentaOrigen                | monto  |
      | 3220047196 Cuenta de ahorro | 1      |