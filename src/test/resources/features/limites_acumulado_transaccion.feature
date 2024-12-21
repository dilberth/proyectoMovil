#language:es
#Author:aeaguila@bancoagricola.com.sv

Característica: Límite acumulado y por transacción

  Antecedentes:
    Dado realiza el proceso de logueo con el usuario PRIVADO01

  @general @QA @limites1
  Escenario: El cliente actualizara los limites por transacción y validará que sean efectivos los cambios
    Cuando actualiza los valores de limites de transacción y valida ticket
      | limitePorTRX |
      | 2            |
    Y realiza el traslado de saldo de la cuenta origen a cuenta de tercero
      | cuentaOrigen                | cuentaTercero | monto | concepto                 | correo                        |
      | 3111466124 Cuenta de ahorro | 3110481891    | 3     | transferencia tercero CA | aeaguila@bancoagricola.com.sv |
    Entonces valida mensaje y reestablece los valores de limite de transacción y limite acumulado por defecto
      | limitePorTRX | limiteSem |
      | 750          | 4000      |

  @general @QA @limites2
  Escenario: El cliente actualizara los limites por transacción y los limites acumulables semanales y validará que sean efectivos los cambios
    Cuando actualiza los valores de limites de canal y limites de transacción y valida ticket
      | limitePorTRX | limiteSem |
      | 79           | 80        |
    Y realiza el traslado de saldo de la cuenta origen a cuenta de tercero
      | cuentaOrigen                | cuentaTercero | monto | concepto                 | correo                        |
      | 3111466124 Cuenta de ahorro | 3110481891    | 81    | transferencia tercero CA | aeaguila@bancoagricola.com.sv |
    Entonces valida mensaje y reestablece los valores de limite de transacción y limite acumulado por defecto
      | limitePorTRX | limiteSem |
      | 750          | 4000      |