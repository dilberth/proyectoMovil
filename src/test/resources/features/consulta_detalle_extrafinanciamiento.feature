#language:es
#Author:aeaguila@bancoagricola.com.sv

Característica: Consulta detalle de Extrafinanciamiento

  @consulta @DEV
  Escenario: El cliente validará que se muestre el detalle de Extrafinanciamiento, validando las 3 capas de información
    Dado realiza el proceso de logueo con el usuario AUTOMATIZADA05
    Entonces valida que se muestren de forma correcta los datos de Extrafinanciamiento
      | referencia                                 |
      | 2124783544 Préstamo de Extrafinanciamiento  |