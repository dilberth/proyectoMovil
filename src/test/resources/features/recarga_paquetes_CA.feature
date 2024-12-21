#language:es
#Author:aeaguila@bancoagricola.com.sv

Característica: Recarga de celular CA

  @Recarga1CA @DEV
  Escenario: El cliente podrá realizar recargas desde cuenta de ahorro
    Dado realiza el proceso de logueo con el usuario PRIVADO01
    Cuando valida el saldo de cuenta origen antes de realizar la transacción
      | cuentaOrigen                 |
      | 31320008506 Cuenta de ahorro |
    Y realiza proceso de recarga de celular
      | celular  | compania                 | montopaquete | concepto | tipoTRX |
      | 78746447 | CLARO, PREPAGO (RECARGA) | \\$ 1.00     | Recarga  | NORMAL  |
    Entonces debe visualizar la disminucion en la cuenta de origen
      | cuentaOrigen                 | monto |
      | 31320008506 Cuenta de ahorro | 1     |

  @Recarga2CA @DEV
  Escenario: El cliente podrá realizar compra de paquetes desde cuenta de ahorro
    Dado realiza el proceso de logueo con el usuario PRIVADO01
    Cuando valida el saldo de cuenta origen antes de realizar la transacción
      | cuentaOrigen                 |
      | 31320008506 Cuenta de ahorro |
    Y realiza proceso de recarga de celular
      | celular  | compania                 | montopaquete                                 | concepto | tipoTRX |
      | 78746447 | CLARO, PREPAGO (RECARGA) | SUPERPACK TODO INCLUIDO M POR 7 DIAS $ 30.00 | Paquete  | NORMAL  |
    Entonces debe visualizar la disminucion en la cuenta de origen
      | cuentaOrigen                 | monto |
      | 31320008506 Cuenta de ahorro | 30    |

  @Recarga3CA @DEV
  Escenario: El cliente podrá realizar recargas desde cuenta de ahorro utilizando favorito
    Dado realiza el proceso de logueo con el usuario PRIVADO01
    Cuando valida el saldo de cuenta origen antes de realizar la transacción
      | cuentaOrigen                 |
      | 31320008506 Cuenta de ahorro |
    Y realiza proceso de recarga de celular
      | montopaquete | nombrefavorito | tipoTRX |
      | \\$ 1.00     | ClaroRecarga   | FAV     |
    Entonces debe visualizar la disminucion en la cuenta de origen
      | cuentaOrigen                 | monto |
      | 31320008506 Cuenta de ahorro | 1     |

  @Recarga4CA @DEV
  Escenario: El cliente podrá realizar compra de paquetes desde cuenta de ahorro utilizando favorito
    Dado realiza el proceso de logueo con el usuario PRIVADO01
    Cuando valida el saldo de cuenta origen antes de realizar la transacción
      | cuentaOrigen                 |
      | 31320008506 Cuenta de ahorro |
    Y realiza proceso de recarga de celular
      | montopaquete                                 | nombrefavorito | tipoTRX |
      | SUPERPACK TODO INCLUIDO M POR 7 DIAS $ 30.00 | ClaroRecarga   | FAV     |
    Entonces debe visualizar la disminucion en la cuenta de origen
      | cuentaOrigen                 | monto |
      | 31320008506 Cuenta de ahorro | 30    |
