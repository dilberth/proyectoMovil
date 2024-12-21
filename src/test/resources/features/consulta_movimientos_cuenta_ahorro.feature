#language:es
#Author:aeaguila@bancoagricola.com.sv

Característica: Consulta movimientos de Cuenta de ahorro

  @consulta @ConsultaCA1 @QA
  Esquema del escenario: El cliente podrá consultar movimientos de 'Cuenta de ahorro' para el periodo seleccionado
    Dado realiza el proceso de logueo con el usuario PRIVADO01
    Y realiza transferencia a cuenta de terceros
      | cuentaOrigen   | cuentaTercero | monto | concepto              | correo                        | opcion |
      | <cuentaOrigen> | 3005942047    | 1     | Prueba Automatizacion | aeaguila@bancoagricola.com.sv | CA     |
    Entonces valida los movimientos del producto para el periodo seleccionado
      | cuentaOrigen   | periodo   | opcion |
      | <cuentaOrigen> | <periodo> | CA     |

    Ejemplos:
      | cuentaOrigen                | periodo            |
      | 3111466124 Cuenta de ahorro | Semana actual      |
      | 3111466124 Cuenta de ahorro | Mes actual         |
      | 3111466124 Cuenta de ahorro | Últimos seis meses |

  @consulta @ConsultaCA2 @QA
  Escenario: El cliente podrá consultar movimientos de 'Cuenta de ahorro' dentro del rango de fechas indicado
    Dado realiza el proceso de logueo con el usuario PRIVADO01
    Entonces valida los movimientos del producto para fecha especifica
      | cuentaOrigen                | fechaDesde    | fechaHasta     | opcion |
      | 3111466124 Cuenta de ahorro | 1 Enero, 2024 | 2 Agosto, 2024 | CA     |