#language:es
#Author:aeaguila@bancoagricola.com.sv

Característica: Recarga de celular PBA

  @Recarga1PBA @DEV
  Escenario: El cliente podrá realizar recargas desde Puntos BA
    Dado realiza el proceso de logueo con el usuario GRANADAUSR
    Cuando valida saldo de puntos BA antes de realizar la transacción
      | alias     |
      | Puntos BA |
    Y realiza proceso de recarga de celular
      | celular  | compania                 | montopaquete  | concepto | tipoTRX |
      | 78746447 | CLARO, PREPAGO (RECARGA) | 100 Puntos BA | Recarga  | NORMAL  |
    Y debe visualizar la disminucion en Puntos BA posterior a realizar la transacción
      | alias     | puntos |
      | Puntos BA | 100    |

  @Recarga2PBA @DEV
  Escenario: El cliente podrá realizar compra de paquetes desde Puntos BA
    Dado realiza el proceso de logueo con el usuario GRANADAUSR
    Cuando valida saldo de puntos BA antes de realizar la transacción
      | alias     |
      | Puntos BA |
    Y realiza proceso de recarga de celular
      | celular  | compania                 | montopaquete                                         | concepto | tipoTRX |
      | 78746447 | CLARO, PREPAGO (RECARGA) | SUPERPACK TODO INCLUIDO M POR 7 DIAS 3,000 Puntos BA | Paquete  | NORMAL  |
    Y debe visualizar la disminucion en Puntos BA posterior a realizar la transacción
      | alias     | puntos |
      | Puntos BA | 3000   |

  @Recarga3PBA @DEV
  Escenario: El cliente podrá realizar recargas desde Puntos BA utilizando favorito
    Dado realiza el proceso de logueo con el usuario GRANADAUSR
    Cuando valida saldo de puntos BA antes de realizar la transacción
      | alias     |
      | Puntos BA |
    Y realiza proceso de recarga de celular
      | montopaquete  | nombrefavorito | tipoTRX |
      | 300 Puntos BA | claro          | FAV     |
    Y debe visualizar la disminucion en Puntos BA posterior a realizar la transacción
      | alias     | puntos |
      | Puntos BA | 300    |

  @Recarga4PBA @DEV
  Escenario: El cliente podrá realizar compra de paquetes desde Puntos BA utilizando favorito
    Dado realiza el proceso de logueo con el usuario GRANADAUSR
    Cuando valida saldo de puntos BA antes de realizar la transacción
      | alias     |
      | Puntos BA |
    Y realiza proceso de recarga de celular
      | montopaquete                                         | nombrefavorito | tipoTRX |
      | SUPERPACK TODO INCLUIDO M POR 7 DIAS 3,000 Puntos BA | claro          | FAV     |
    Y debe visualizar la disminucion en Puntos BA posterior a realizar la transacción
      | alias     | puntos |
      | Puntos BA | 3000   |
