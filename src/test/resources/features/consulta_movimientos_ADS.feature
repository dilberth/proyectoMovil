#language:es
#Author:aeaguila@bancoagricola.com.sv

Característica: Consulta movimientos de Adelanto de salario

  @consulta @ConsultaADS1 @DEV
  Esquema del escenario: El cliente podrá consultar movimientos de 'ADS' para el periodo seleccionado
    Dado realiza el proceso de logueo con el usuario ACTADS4
    Y realiza transferencia a cuenta de terceros
      | cuentaOrigen   | cuentaTercero | monto | concepto              | correo                        | opcion |
      | <cuentaOrigen> | 3115861266    | 1     | Prueba Automatizacion | aeaguila@bancoagricola.com.sv | ADS    |
    Entonces valida los movimientos del producto para el periodo seleccionado
      | cuentaOrigen   | periodo   | opcion |
      | <cuentaOrigen> | <periodo> | ADS    |

    Ejemplos:
      | cuentaOrigen                | periodo            |
      | 5167481504 Cuenta corriente | Semana actual      |
      | 5167481504 Cuenta corriente | Mes actual         |
      | 5167481504 Cuenta corriente | Últimos seis meses |

  @consulta @ConsultaADS2 @DEV
  Escenario: El cliente podrá consultar movimientos de 'ADS' dentro del rango de fechas indicado
    Dado realiza el proceso de logueo con el usuario ACTADS4
    Entonces valida los movimientos del producto para fecha especifica
      | cuentaOrigen                | fechaDesde         | fechaHasta         | opcion |
      | 5167481504 Cuenta corriente | 5 Diciembre, 2024  | 6 Diciembre, 2024 | ADS    |