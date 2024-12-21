#language:es
#Author:gusecheo@bancoagricola.com.sv

Característica: Recuperación de usuario desde la opción 'Olvidé mi usuario'

  @general @QA
  Escenario: El cliente podrá recuperar su usuario desde la opción 'Olvidé mi usuario'
    Cuando ingresa a recuperar usuario e ingresa los datos de identificacion
      | DUI | 039693173 |
    Entonces se visualiza el resultado de "¡Tu usuario ha sido recuperado con éxito!"

