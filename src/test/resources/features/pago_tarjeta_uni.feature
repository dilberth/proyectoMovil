#language:es
#Author: guseche@bancoagricola.com.sv

Característica: Pago de tarjeta UNI

  @pagoUNI1 @DEV
  Escenario: El cliente podrá realizar el pago de tarjetas entre bancos usando UNI
    Dado que se el valor de los saldos del usuario GRANADAUSR de la cuenta
      | CuentaOrigen                |
      | 3112420617 Cuenta de ahorro |
    Cuando realiza el pago de tarjetas nueva entre bancos usando UNI
      | CuentaOrigen                | banco           | tarjetaOtroBanco | tipoIdentificacion | numeroIdentificacion | nombreRecibidor | monto | concepto               | correo                        |
      | 3112420617 Cuenta de ahorro | DAVIVIENDA | 4282912836741014 | DUI                | 014712643            | LUIS LOPEZ      | 1     | Pago tarjeta UNI Nuevo | eguevara@bancoagricola.com.sv |
    Entonces debo observar que la transaccion de pago de tarjeta de credito de otros bancos mediante UNI fue exitosa y el saldo fue descontado correctamente
      | CuentaOrigen                | monto |
      | 3112420617 Cuenta de ahorro | 1     |

  @pagoUNI2 @DEV
  Escenario: El cliente podrá realizar el pago de un favorito de tarjetas entre bancos usando UNI
    Dado que existe el favorito PAGO_TARJETA_UNI para el usuario GRANADAUSR
    Y que se el valor de los saldos del usuario GRANADAUSR de la cuenta
      | CuentaOrigen                |
      | 3115590271 Cuenta de ahorro |
    Cuando realiza el pago de tarjetas guardada como favorito entre bancos usando UNI
      | CuentaOrigen                | nombrefavorito | monto | concepto                  | opcion                   |
      | 3115590271 Cuenta de ahorro | TestAutUNI     | 1     | Pago tarjeta UNI Favorito | Tarjetas de otros bancos |
    Entonces debo observar que la transaccion de pago de tarjeta de credito de otros bancos mediante UNI fue exitosa y el saldo fue descontado correctamente
      | CuentaOrigen                | monto |
      | 3115590271 Cuenta de ahorro | 1     |