#language:es
#Author:aeaguila@bancoagricola.com.sv

Característica: Consulta CVV2 y fecha de expiración de e-card

  @consulta @QA
  Escenario: El cliente podrá consultar CVV2 y fecha de expiración de e-card
    Dado realiza el proceso de logueo con el usuario AUTOMATIZADA05
    Y realiza validación de  datos de e-card
      | tarjetaCredito  |
      | **** 2337 ECARD |

