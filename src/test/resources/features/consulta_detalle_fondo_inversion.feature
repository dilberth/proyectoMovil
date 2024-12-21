#language:es
#Author:aeaguila@bancoagricola.com.sv

Característica: Consulta detalle de Fondo de inversión

  @consulta @DEV
  Escenario: El cliente validará que se muestre el detalle de Fondo de inversión, validando las 3 capas de información
    Dado realiza el proceso de logueo con el usuario PRUEBASDESA
    Entonces valida que se muestren de forma correcta los datos de Fondo de inversión
      | fondoInversion                     |
      | 1-000244-000539 Fondo de inversión |

