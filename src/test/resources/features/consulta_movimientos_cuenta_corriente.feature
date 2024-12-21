#language:es
#Author:aeaguila@bancoagricola.com.sv

Característica: Consulta movimientos de Cuenta corriente

  @consulta @ConsultaCC1 @QA
  Esquema del escenario: El cliente podrá consultar movimientos de 'Cuenta corriente' para el periodo seleccionado
    Dado realiza el proceso de logueo con el usuario PRIVADO01
    Y realiza transferencia a cuenta de terceros
      | cuentaOrigen   | cuentaTercero | monto | concepto              | correo                        | opcion |
      | <cuentaOrigen> | 3005942047    | 1     | Prueba Automatizacion | aeaguila@bancoagricola.com.sv | CC     |
    Entonces valida los movimientos del producto para el periodo seleccionado
      | cuentaOrigen   | periodo   | opcion |
      | <cuentaOrigen> | <periodo> | CC     |

    Ejemplos:
      | cuentaOrigen                | periodo            |
      | 1210039767 Cuenta corriente | Semana actual      |
      | 1210039767 Cuenta corriente | Mes actual         |
      | 1210039767 Cuenta corriente | Últimos seis meses |

  @consulta @ConsultaCC2 @QA
  Escenario: El cliente podrá consultar movimientos de 'Cuenta corriente' dentro del rango de fechas indicado
    Dado realiza el proceso de logueo con el usuario PRIVADO01
    Entonces valida los movimientos del producto para fecha especifica
      | cuentaOrigen                | fechaDesde    | fechaHasta     | opcion |
      | 1210039767 Cuenta corriente | 1 Enero, 2024 | 2 Agosto, 2024 | CC     |
