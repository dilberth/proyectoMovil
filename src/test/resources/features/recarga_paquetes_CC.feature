#language:es
#Author:dnolasco@bancoagricola.com.sv

Característica: Recarga de celular CC

  @Recarga1CC @DEV
  Escenario: El cliente podrá realizar recargas desde cuenta corriente
    Dado realiza el proceso de logueo con el usuario PRIVADO01
    Cuando valida el saldo de cuenta origen antes de realizar la transacción
      | cuentaOrigen                 |
      | 1210039767 Cuenta corriente  |
    Y realiza proceso de recarga de celular
      | celular  | compania                 | montopaquete | concepto | tipoTRX |
      | 78746447 | CLARO, PREPAGO (RECARGA) | \\$ 1.00     | Recarga  | NORMAL  |
    Entonces debe visualizar la disminucion en la cuenta de origen
      | cuentaOrigen                 | monto |
      | 1210039767 Cuenta corriente  | 1     |

  @Recarga2CC @DEV
  Escenario: El cliente podrá realizar compra de paquetes desde cuenta corriente
    Dado realiza el proceso de logueo con el usuario PRIVADO01
    Cuando valida el saldo de cuenta origen antes de realizar la transacción
      | cuentaOrigen                 |
      | 1210039767 Cuenta corriente  |
    Y realiza proceso de recarga de celular
      | celular  | compania                 | montopaquete                                 | concepto | tipoTRX |
      | 78746447 | CLARO, PREPAGO (RECARGA) | SUPERPACK TODO INCLUIDO M POR 7 DIAS $ 30.00 | Paquete  | NORMAL  |
    Entonces debe visualizar la disminucion en la cuenta de origen
      | cuentaOrigen                 | monto |
      | 1210039767 Cuenta corriente  | 30    |

  @Recarga3CC @DEV
  Escenario: El cliente podrá realizar recargas desde cuenta corriente utilizando favorito
    Dado realiza el proceso de logueo con el usuario PRIVADO01
    Cuando valida el saldo de cuenta origen antes de realizar la transacción
      | cuentaOrigen                 |
      | 1210039767 Cuenta corriente |
    Y realiza proceso de recarga de celular
      | montopaquete | nombrefavorito | tipoTRX |
      | \\$ 1.00     | ClaroRecarga   | FAV     |
    Entonces debe visualizar la disminucion en la cuenta de origen
      | cuentaOrigen                 | monto |
      | 1210039767 Cuenta corriente  | 1     |

  @Recarga4CC @DEV
  Escenario: El cliente podrá realizar compra de paquetes desde cuenta corriente utilizando favorito
    Dado realiza el proceso de logueo con el usuario PRIVADO01
    Cuando valida el saldo de cuenta origen antes de realizar la transacción
      | cuentaOrigen                 |
      | 1210039767 Cuenta corriente  |
    Y realiza proceso de recarga de celular
      | montopaquete                                 | nombrefavorito | tipoTRX |
      | SUPERPACK TODO INCLUIDO M POR 7 DIAS $ 30.00 | ClaroRecarga   | FAV     |
    Entonces debe visualizar la disminucion en la cuenta de origen
      | cuentaOrigen                 | monto |
      | 1210039767 Cuenta corriente  | 30    |
