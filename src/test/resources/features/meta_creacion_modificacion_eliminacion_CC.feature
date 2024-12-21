#language:es
#Author:aeaguila@bancoagricola.com.sv

Característica: Creación, modificación y eliminación de meta

  @general @QA
  Escenario: El cliente podrá añadir, modificar y eliminar una meta con cuenta corriente
    Dado realiza el proceso de logueo con el usuario PRIVADO01
    Cuando completa el proceso para crear meta y valida el ticket
      | nombreMeta   | montoMeta | plazoMeta | diaRetencion | cuentaARelacionar | cuotaMensual |
      | Prueba Meta2 | 1.00      | 1         | 2            | 1210039767 CC    | 1.00         |
    Y realiza el proceso de modificación de la meta y valida el ticket
      | nombreMeta   | montoMeta | plazoMeta | diaRetencion |
      | Prueba Meta2 | 120       | 8         | 6            |
    Entonces realiza el proceso de eliminacion de la meta y valida el ticket
      | nombreMeta   |
      | Prueba Meta2 |