#language:es
#Author:aeaguila@bancoagricola.com.sv

Característica: Transferencias Puntos BA Lifemiles

  @transferenciaPBA_LFM @DEV
  Escenario: El cliente podrá realizar transferencias de Puntos BA a Lifemiles
    Dado realiza el proceso de logueo con el usuario JAVIERROSALES
    Cuando valida los saldo de cuenta origen y para Puntos BA antes de realizar la transacción
      | cuentaOrigen                | alias     |
      | 3040006233 Cuenta de ahorro | Puntos BA |
    Y realiza el proceso de transferencia de Puntos BA a Lifemiles
      | primerNombre | segundoNombre | primerApellido | segundoApellido | numeroLifemiles | puntos | codigoPais  | numeroTelefono |
      | Nelson       | Jose          | Perez          | Garcia          | 02938060705     | 5000   | El Salvador | 78448685       |
    Entonces debe visualiza la disminucion de Puntos BA y en el saldo de la cuenta de origen
      | alias     | puntos | cuentaOrigen                | monto |
      | Puntos BA | 5000   | 3040006233 Cuenta de ahorro | 16.25 |