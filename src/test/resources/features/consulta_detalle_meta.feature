#language:es
#Author:aeaguila@bancoagricola.com.sv

Característica: Consula detalle de Meta

  @consulta @QA
  Escenario: El cliente validará que se muestre el detalle de meta
    Dado realiza el proceso de logueo con el usuario PRIVADO01
    #Cuando completa el proceso para crear meta
    #  | nombreMeta   | montoMeta | plazoMeta | diaRetencion | cuentaARelacionar |
    #  | Prueba Meta3 | 2         | 12        | 1            | 31320008506 CA    |
    Y valida el detalle para la meta
      | nombreMeta   | diaRetencion |
      | Meta 34      | 11            |
    #Entonces realiza el proceso de eliminacion de la meta
    #  | nombreMeta   |
    #  | Prueba Meta3 |