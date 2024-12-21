#language:es
#Author:aeaguila@bancoagricola.com.sv

Característica: Transferencia Transfer365

  @transferencia365_1 @DEV
  Escenario: El cliente podrá realizar una transferencia Transfer365
    Dado realiza el proceso de logueo con el usuario GRANADAUSR
    Cuando valida el saldo de cuenta origen antes de realizar la transacción
      | cuentaOrigen                |
      | 3112420617 Cuenta de ahorro |
    Y realiza la transferencia Transfer 365
      | cuentaOrigen                | tipoCuenta                | banco                    | cuentaDestino      | tipoCliente | nombreRecibidor | apellidoRecibidor | monto | concepto | correo                        | tipoTRX |
      | 3112420617 Cuenta de ahorro | Cuenta de ahorro - propia | BANCO AZUL, S.A.         | 10000002159207     | Jurídico    | Jose            | Perez             | 1     | Prueba   | aeaguila@bancoagricola.com.sv | NORMAL  |
    Entonces debe visualizar la disminucion en la cuenta de origen
      | cuentaOrigen                | monto |
      | 3112420617 Cuenta de ahorro | 1     |

  @transferencia365_2 @DEV
  Escenario: El cliente podrá realizar una transferencia Transfer365 desde favorito
    Dado realiza el proceso de logueo con el usuario GRANADAUSR
    Cuando valida el saldo de cuenta origen antes de realizar la transacción
      | cuentaOrigen                |
      | 3115590271 Cuenta de ahorro |
    Y realiza la transferencia Transfer 365
      | cuentaOrigen                | nombrefavorito | monto | concepto | tipoTRX    |
      | 3115590271 Cuenta de ahorro | Transfer365CTA | 1     | Prueba   | FAV_NORMAL |
    Entonces debe visualizar la disminucion en la cuenta de origen
      | cuentaOrigen                | monto |
      | 3115590271 Cuenta de ahorro | 1     |