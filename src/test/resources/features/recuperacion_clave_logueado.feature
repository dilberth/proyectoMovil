#language:es
#Author: gusecheo@bancoagricola.com.sv
#Actualización: aeaguila@bancoagricola.com.sv

Característica: Cambiar clave al ingresar a la opción 'Clave de acceso'

  @general @QA
  Escenario: El cliente podrá cambiar su clave al ingresar a la opción 'Clave de acceso'
    Cuando se realiza la gestion de cambio de Clave de acceso
      | password    |
      | Agricola2@  |
      | Agricola3@  |
      | Agricola4@  |
      | Agricola5@  |
      | Agricola6@  |
      | Agricola7@  |
      | Agricola8@  |
      | Agricola9@  |
      | Agricola10@ |
      | Agricola11@ |
      | Agricola12@ |
      | Agricola13@ |
      | Agricola2$  |
    Entonces el usuario FELDOUSER7 podra acceder al aplicativo correctamente
