#language:es
#Author:aeaguila@bancoagricola.com.sv

Característica: Consulta movimientos de Préstamo

  @consulta @ConsultaPRE1 @QA
  Escenario: El cliente podrá consultar movimientos de 'Préstamos' dentro del rango de fechas indicado
    Dado realiza el proceso de logueo con el usuario PRIVADO01
    Entonces valida los movimientos del producto para fecha especifica
      | cuentaOrigen                    | fechaDesde    | fechaHasta    | opcion |
      | 8094190065 Préstamo de Vivienda | 2 Julio, 2023 | 1 Enero, 2024 | PRE    |
