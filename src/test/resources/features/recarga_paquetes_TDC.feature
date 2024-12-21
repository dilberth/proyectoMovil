#language:es
#Author:aeaguila@bancoagricola.com.sv

Característica: Recarga de celular TDC

  @Recarga1TDC @DEV
  Escenario: El cliente podrá realizar recargas desde tarjeta de crédito
    Dado realiza el proceso de logueo con el usuario JAVIERROSALES
    Cuando valida el saldo de la tarjeta de credito antes de realizar la transacción
      | cuentaOrigen                  |
      | **** 4006 VISA CLASICA PILOTO |
    Y realiza proceso de recarga de celular
      | celular  | compania                 | montopaquete | concepto | tipoTRX |
      | 78746447 | CLARO, PREPAGO (RECARGA) | \\$ 1.00     | Recarga  | NORMAL  |
    Y debe visualizar la disminucion en la tarjeta de credito
      | cuentaOrigen              | monto |
      | **** 4006 VISA CLASICA PILOTO | 1     |

  @Recarga2TDC @DEV
  Escenario: El cliente podrá realizar compra de paquetes desde tarjeta de crédito
    Dado realiza el proceso de logueo con el usuario JAVIERROSALES
    Cuando valida el saldo de la tarjeta de credito antes de realizar la transacción
      | cuentaOrigen              |
      | **** 4006 VISA CLASICA PILOTO |
    Y realiza proceso de recarga de celular
      | celular  | compania                 | montopaquete                                 | concepto | tipoTRX |
      | 78746447 | CLARO, PREPAGO (RECARGA) | SUPERPACK TODO INCLUIDO M POR 7 DIAS $ 30.00 | Paquete  | NORMAL  |
    Y debe visualizar la disminucion en la tarjeta de credito
      | cuentaOrigen              | monto |
      | **** 4006 VISA CLASICA PILOTO | 30    |

  @Recarga3TDC @DEV
  Escenario: El cliente podrá realizar recargas desde cuenta de ahorro utilizando favorito
    Dado realiza el proceso de logueo con el usuario JAVIERROSALES
    Cuando valida el saldo de la tarjeta de credito antes de realizar la transacción
      | cuentaOrigen              |
      | **** 4006 VISA CLASICA PILOTO |
    Y realiza proceso de recarga de celular
      | montopaquete | nombrefavorito | tipoTRX |
      | \\$ 1.00     | FavoritoPaqC3   | FAV     |
    Y debe visualizar la disminucion en la tarjeta de credito
      | cuentaOrigen              | monto |
      | **** 4006 VISA CLASICA PILOTO | 1     |

  @Recarga4TDC @DEV
  Escenario: El cliente podrá realizar compra de paquetes desde cuenta de ahorro utilizando favorito
    Dado realiza el proceso de logueo con el usuario JAVIERROSALES
    Cuando valida el saldo de la tarjeta de credito antes de realizar la transacción
      | cuentaOrigen              |
      | **** 4006 VISA CLASICA PILOTO |
    Y realiza proceso de recarga de celular
      | montopaquete                                 | nombrefavorito | tipoTRX |
      | SUPERPACK TODO INCLUIDO M POR 7 DIAS $ 30.00 | FavoritoPaqC3   | FAV     |
    Y debe visualizar la disminucion en la tarjeta de credito
      | cuentaOrigen              | monto |
      | **** 4006 VISA CLASICA PILOTO | 30    |