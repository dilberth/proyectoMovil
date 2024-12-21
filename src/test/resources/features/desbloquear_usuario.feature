#language:es
#Author: gusecheo@bancoagricola.com.sv
#Author: aeaguila@bancogricola.com.sv

Característica: Desbloquear usuario desde la opción '¿Olvidaste o bloqueaste tu usuario o clave?'

  @general @QA
  Escenario: El cliente podrá desbloquear su usuario desde la opción '¿Olvidaste o bloqueaste tu usuario o clave?'
    Dado que esta bloqueado el usuario FELDOUSER7
    Cuando realiza proceso de desbloqueo del usuario FELDOUSER7
    Entonces valida que el usuario FELDOUSER7 se encuentre desbloqueado