#language:es
#Author: gusecheo@bancoagricola.com.sv
#Actualización: aeaguila@bancoagricola.com.sv

Característica: Recuperar clave al ingresar a la opción ¿Olvidaste o bloqueaste tu usuario o clave?

 @general @QA
  Escenario: El cliente podrá recuperar su clave al ingresar a la opción '¿Olvidaste o bloqueaste tu usuario o clave?'
    Cuando realiza la gestion de ¿Olvidaste o bloqueaste tu usuario o clave?
      | password    |
      | Agricola2&  |
      | Agricola3&  |
      | Agricola4&  |
      | Agricola5&  |
      | Agricola6&  |
      | Agricola7&  |
      | Agricola8&  |
      | Agricola9&  |
      | Agricola10& |
      | Agricola11& |
      | Agricola12& |
      | Agricola13& |
      | Agricola2$  |
   Entonces el usuario FELDOUSER7 podra acceder al aplicativo correctamente
