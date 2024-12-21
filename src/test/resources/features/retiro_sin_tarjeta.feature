#language:es
#Author:aeaguila@bancoagricola.com.sv

Característica: Retiro sin tarjeta

  @general @QA
  Escenario: El cliente podrá generar un código para realizar un retiro sin tarjeta
    Dado realiza el proceso de logueo con el usuario PRIVADO01
    Y realiza el proceso para generacion de codigo validando el ticket generado
      | cuentaOrigen                | monto |
      | 3111466124 Cuenta de ahorro | 5     |