#language:es
#Author:aeaguila@bancoagricola.com.sv

Característica: Transferencia Cuentas Terceros

  @transferenciaTer1 @QA
  Escenario: El cliente podrá realizar transferencia a tercero seleccionando cuenta
    Dado realiza el proceso de logueo con el usuario PRIVADO01

    Cuando valida el saldo de cuenta origen antes de realizar la transacción
      | cuentaOrigen                |
      | 3001329786 Cuenta de ahorro |
    Y realiza el traslado de saldo de la cuenta origen a cuenta de terceros
      | cuentaOrigen                | cuentaTercero | monto | concepto              | correo                        |
      | 3001329786 Cuenta de ahorro | 3005942047    | 1     | Prueba Automatizacion | aeaguila@bancoagricola.com.sv |
    Y debe visualizar la disminucion en la cuenta de origen
      | cuentaOrigen                | monto |
      | 3001329786 Cuenta de ahorro | 1     |

  @transferenciaTer2 @QA
  Escenario: El cliente podrá realizar transferencia a tercero seleccionando favorito
    Dado realiza el proceso de logueo con el usuario GRANADAUSR
    Cuando valida el saldo de cuenta origen antes de realizar la transacción
      | cuentaOrigen                |
      | 3007451738 Cuenta de ahorro |
    Y realiza el traslado de saldo de la cuenta origen a cuenta de tercero desde favorito
      | cuentaOrigen                | monto | concepto              | nombrefavorito     |
      | 3007451738 Cuenta de ahorro | 1     | Prueba Automatizacion | Favorito           |
    Y debe visualizar la disminucion en la cuenta de origen
      | cuentaOrigen                | monto |
      | 3007451738 Cuenta de ahorro | 1     |

  @transferenciaTer3 @QA
  Escenario: El cliente podrá realizar transferencia a tercero seleccionando celular
    Dado realiza el proceso de logueo con el usuario PRIVADO01
    Cuando valida el saldo de cuenta origen antes de realizar la transacción
      | cuentaOrigen                |
      | 3001329786 Cuenta de ahorro |
    Y realiza el traslado de saldo de la cuenta origen celular asociado a cuenta
      | cuentaOrigen                | celular  | monto | concepto              | correo                        |
      | 3001329786 Cuenta de ahorro | 72893976 | 1     | Prueba Automatizacion | aeaguila@bancoagricola.com.sv |
    Y debe visualizar la disminucion en la cuenta de origen
      | cuentaOrigen                | monto |
      | 3001329786 Cuenta de ahorro | 1     |