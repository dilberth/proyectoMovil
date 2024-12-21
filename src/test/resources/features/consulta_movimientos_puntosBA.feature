#language:es
#Author:aeaguila@bancoagricola.com.sv

Característica: Consulta movimientos de Puntos BA

  @consulta @ConsultaPBA1 @QA
  Escenario: El cliente podrá consultar movimientos de 'Puntos BA' para 'Egresos' dentro del rango de fechas indicado
    Dado realiza el proceso de logueo con el usuario PRIVADO01
    Entonces valida los movimientos del producto para fecha especifica
      | cuentaOrigen | fechaDesde    | fechaHasta    | opcion |
      | Puntos BA    | 1 Julio, 2023 | 14 Mayo, 2024 | PBA    |
