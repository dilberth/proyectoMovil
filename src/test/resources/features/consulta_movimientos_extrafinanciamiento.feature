#language:es
#Author:aeaguila@bancoagricola.com.sv

Característica: Consulta movimientos Extrafinanciamiento

  @consulta @ConsultaEXT1 @QA
  Escenario: El cliente podrá consultar movimientos de 'Extrafinanciamiento' dentro del rango de fechas indicado
    Dado realiza el proceso de logueo con el usuario AUTOMATIZADA05
    Entonces valida los movimientos del producto para fecha especifica
      | cuentaOrigen                               | fechaDesde    | fechaHasta    | opcion |
      | 2130032594 Préstamo de Extrafinanciamiento | 1 Enero, 2024 | 8 Julio, 2024 | EXT    |
