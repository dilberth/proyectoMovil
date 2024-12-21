#language:es
#Author:aeaguila@bancoagricola.com.sv

Característica: Transferencia Transfer365 Móvil

  @transferencia365M1 @DEV
  Escenario: El cliente podrá realizar una transferencia Transfer365 Móvil
    Dado realiza el proceso de logueo con el usuario GRANADAUSR
    Cuando valida el saldo de cuenta origen antes de realizar la transacción
      | cuentaOrigen                |
      | 3112420617 Cuenta de ahorro |
    Y realiza la transferencia Transfer 365
      | cuentaOrigen                | celular  | institucionDestino       | nombreRecibidor | monto | concepto | correo                        | tipoTRX |
      | 3112420617 Cuenta de ahorro | 71252165 | BANCO DE AMERICA CENTRAL | Alcides         | 1     | Prueba   | aeaguila@bancoagricola.com.sv | CEL     |
    Entonces debe visualizar la disminucion en la cuenta de origen
      | cuentaOrigen                | monto |
      | 3112420617 Cuenta de ahorro | 1     |

  @transferencia365M2 @DEV
  Escenario: El cliente podrá realizar una transferencia Transfer365 Móvil desde favorito
    Dado realiza el proceso de logueo con el usuario GRANADAUSR
    Cuando valida el saldo de cuenta origen antes de realizar la transacción
      | cuentaOrigen                |
      | 3115590271 Cuenta de ahorro |
    Y realiza la transferencia Transfer 365
      | cuentaOrigen                | nombrefavorito | monto | concepto | tipoTRX |
      | 3115590271 Cuenta de ahorro | Transfer365Mo  | 1     | Prueba   | FAV_CEL |
    Entonces debe visualizar la disminucion en la cuenta de origen
      | cuentaOrigen                | monto |
      | 3115590271 Cuenta de ahorro | 1     |