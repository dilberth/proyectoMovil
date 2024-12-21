#language:es
#Author:guseche@bancoagricola.com.sv

Característica: Pago de tarjeta transfer365

  @pagoTDC1 @DEV
  Escenario: El cliente podrá realizar el pago de tarjetas entre bancos usando transfer 365
    Dado que se el valor de los saldos del usuario GRANADAUSR de la cuenta
      | cuentaOrigen                |
      | 3112420617 Cuenta de ahorro |
    Cuando diligencia los campos para realizar el pago de tarjeta a otro banco usando Transfer 365 desde cero
      | CuentaOrigen                | banco      | cuentaDestino    | tipoCliente | nombreRecibidor | apellidoRecibidor | monto | concepto    | correo                        |
      | 3112420617 Cuenta de ahorro | DAVIVIENDA | 4295185516887952 | Natural     | LUIS            | LOPEZ             | 1     | transfer365 | aeaguila@bancoagricola.com.sv |
    Entonces debe visualizar que el pago de tarjeta mediante el servicio de transfer 365 fue exitoso y se le desconto el valor correcto de su cuenta
      | cuentaOrigen                | monto |
      | 3112420617 Cuenta de ahorro | 1     |

  @pagoTDC2 @DEV
  Escenario: El cliente podrá realizar el pago de tarjetas entre bancos usando transfer 365 usando un favorito
    Dado que existe el favorito PAGO_TARJETA_TRANSFER365 para el usuario GRANADAUSR
    Y que se el valor de los saldos del usuario GRANADAUSR de la cuenta
      | cuentaOrigen                |
      | 3115590271 Cuenta de ahorro |
    Cuando realiza el pago de tarjeta a otro banco usando Transfer 365 desde un favorito
      | CuentaOrigen                | nombrefavorito | monto | concepto                               |
      | 3115590271 Cuenta de ahorro | PagoTarjeta365     | 1     | Tarjetas de otros bancos - transfer365 |
    Entonces debe visualizar que el pago de tarjeta mediante el servicio de transfer 365 fue exitoso y se le desconto el valor correcto de su cuenta
      | cuentaOrigen                | monto |
      | 3115590271 Cuenta de ahorro | 1     |