#language:es
#Author:aeaguila@bancoagricola.com.sv

Característica: Consulta movimientos Fondo de inversión

  @consulta @ConsultaFDI1 @DEV
  Escenario: El cliente podrá consultar movimientos de 'Fondo de inversión' dentro del rango de fechas indicado
    Dado realiza el proceso de logueo con el usuario PRUEBASDESA
    Entonces valida los movimientos del producto para fecha especifica
      | cuentaOrigen                       | fechaDesde        | fechaHasta    | opcion |
      | 1-000244-000539 Fondo de inversión | 1 Noviembre, 2023 | 5 Marzo, 2024 | FDI     |

