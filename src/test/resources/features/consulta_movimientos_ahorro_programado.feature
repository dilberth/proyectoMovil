#language:es
#Author:aeaguila@bancoagricola.com.sv

Característica: Consulta movimientos de Ahorro programado

  @consulta @ConsultaAP1 @QA
  Esquema del escenario: El cliente podrá consultar movimientos de 'Ahorro programado' para el periodo seleccionado
    Dado realiza el proceso de logueo con el usuario PRIVADO03
    Y realiza transferencia a cuenta de terceros
      | cuentaOrigen   | cuentaTercero | monto | concepto              | correo                        | opcion |
      | <cuentaOrigen> | 3005942047    | 1     | Prueba Automatizacion | aeaguila@bancoagricola.com.sv | AP     |
    Entonces valida los movimientos del producto para el periodo seleccionado
      | cuentaOrigen   | periodo   | opcion |
      | <cuentaOrigen> | <periodo> | AP     |

    Ejemplos:
      | cuentaOrigen               | periodo            |
      | 3490316617 Sueno Realizado | Semana actual      |
      | 3490316617 Sueno Realizado | Mes actual         |
      | 3490316617 Sueno Realizado | Últimos seis meses |

  @consulta @ConsultaAP2 @QA
  Escenario: El cliente podrá consultar movimientos de 'Ahorro programado' dentro del rango de fechas indicado
    Dado realiza el proceso de logueo con el usuario PRIVADO03
    Entonces valida los movimientos del producto para fecha especifica
      | cuentaOrigen               | fechaDesde    | fechaHasta     | opcion |
      | 3490316617 Sueno Realizado | 1 Enero, 2024 | 29 Enero, 2024 | AP     |
