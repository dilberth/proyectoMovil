#language:es
#Author:aeaguila@bancoagricola.com.sv

Característica: Transferencias Ahorro programado

  @transferenciaAP1 @QA
  Escenario: El cliente podrá realizar tranferencias desde ahorro programado a cuenta propia
    Dado realiza el proceso de logueo con el usuario PRIVADO01
    Cuando valida el saldo de cuenta destino antes de realizar la transacción
      | cuentaDestino               |
      | 3001329786 Cuenta de ahorro |
    Y valida el saldo de ahorro programado antes de realizar la transacción
      | cuentaOrigen               |
      | 3009267649 Sueño Realizado|
    Y realiza el traslado de saldo de la cuenta origen a la cuenta destino
      | cuentaOrigen               | cuentaDestino | monto | concepto | tipoTRX |
      | 3009267649 Sueño Realizado| 3001329786 CA | 1     | Prueba   | CA      |
    Y debe visualizar la disminucion en el ahorro programado
      | cuentaOrigen               | monto |
      | 3009267649 Sueño Realizado | 1   |
    Entonces debe visualizar un aumento en la cuenta destino
      | cuentaDestino               | monto |
      | 3001329786 Cuenta de ahorro | 1  |

  @transferenciaAP2 @QA
  Escenario: El cliente podrá realizar tranferencias desde ahorro programado a tercero seleccionando cuenta
    Dado realiza el proceso de logueo con el usuario PRIVADO03
    Y valida el saldo de ahorro programado antes de realizar la transacción
      | cuentaOrigen               |
      | 3490316617 Sueno Realizado |
    Y realiza el traslado de saldo de la cuenta origen a cuenta de terceros
      | cuentaOrigen               | cuentaTercero | monto | concepto              | correo                        |
      | 3490316617 Sueno Realizado | 3005942047    | 1     | Prueba Automatizacion | aeaguila@bancoagricola.com.sv |
    Y debe visualizar la disminucion en el ahorro programado
      | cuentaOrigen               | monto |
      | 3490316617 Sueno Realizado | 1     |

  @transferenciaAP3 @QA
  Escenario: El cliente podrá realizar tranferencias desde ahorro programado a tercero seleccionando celular
    Dado realiza el proceso de logueo con el usuario PRIVADO03
    Y valida el saldo de ahorro programado antes de realizar la transacción
      | cuentaOrigen               |
      | 3490316617 Sueno Realizado |
    Y realiza el traslado de saldo de la cuenta origen celular asociado a cuenta
      | cuentaOrigen               | celular  | monto | concepto              | correo                        |
      | 3490316617 Sueno Realizado | 78746447 | 1     | Prueba Automatizacion | aeaguila@bancoagricola.com.sv |
    Y debe visualizar la disminucion en el ahorro programado
      | cuentaOrigen               | monto |
      | 3490316617 Sueno Realizado | 1   |

  @transferenciaAP4 @QA
  Escenario: El cliente podrá realizar tranferencias desde ahorro programado a tercero seleccionando favorito
    Dado realiza el proceso de logueo con el usuario PRIVADO03
    Y valida el saldo de ahorro programado antes de realizar la transacción
      | cuentaOrigen               |
      | 3490316617 Sueno Realizado |
    Y realiza el traslado de saldo de la cuenta origen a cuenta de tercero desde favorito
      | cuentaOrigen               | monto | concepto              | nombrefavorito        |
      | 3490316617 Sueno Realizado | 1     | Prueba Automatizacion | favFirefox99ACEP       |
    Y debe visualizar la disminucion en el ahorro programado
      | cuentaOrigen               | monto |
      | 3490316617 Sueno Realizado | 1    |