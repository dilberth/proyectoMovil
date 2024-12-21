#language:es
#Author:aeaguila@bancoagricola.com.sv

Característica: Notificación de viajeros

  @general @QA
  Escenario: El cliente podrá crear la gestión de notificación de viajeros para una tarjeta
    Dado realiza el proceso de logueo con el usuario privado01
    Y crea la gestion para notificación de viajeros para una tarjeta
      | tarjetaCredito              | fechaSalida | fechaRegreso | paisDestino | comentarios    |
      | **** 0331 Infantil          | 10/12/2024  | 10/01/2025   | Mexico      | PruebaNFAutUna |
    Entonces valida que se muestre mensaje de confirmación de creación de gestión y valida el ticket

  #@general @QA
  #Escenario: El cliente podrá crear la gestión de notificación de viajeros para todas las tarjetas
  #  Dado realiza el proceso de logueo con el usuario PRIVADO02
  #  Y crea la gestion para notificación de viajeros para todas las tarjetas
  #    | fechaSalida | fechaRegreso | paisDestino | comentarios      |
  #    | 10/12/2024  | 10/12/2024   | Mexico      | PruebaNFAutTodas |
  #  Entonces valida que se muestre mensaje de confirmación de creación de gestión y valida el ticket



