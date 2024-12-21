#language:es
#Author:aeaguila@bancoagricola.com.sv

Característica: Consulta movimientos de Tarjeta de crédito

  @consulta @ConsultaTDC1 @QA
  Escenario: El cliente podrá consultar movimientos de 'Tarjeta de crédito' dentro del rango de fechas indicado
    Dado realiza el proceso de logueo con el usuario JAVIERROSALES
    Entonces valida los movimientos del producto para fecha especifica
      | cuentaOrigen                  | fechaDesde        | fechaHasta     | opcion |
      | **** 4006 VISA CLASICA PILOTO | 1 Noviembre, 2023 | 14 Marzo, 2024 | TDC    |
