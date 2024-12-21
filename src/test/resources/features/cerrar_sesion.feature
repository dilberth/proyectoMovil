#language:es
#Author: dnolasco@bancogricola.com.sv

Característica: Cerrar sesion

  @general @QA
    Escenario: El cliente iniciara sesion y luego cerrara su sesion.
    Dado realiza el proceso de logueo con el usuario PRIVADO01
    Cuando el usuario se encuentra logueado y cierra su sesion
    Entonces el usuario ve la pantalla de logueo