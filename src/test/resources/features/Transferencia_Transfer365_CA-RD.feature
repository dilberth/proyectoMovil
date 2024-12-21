#language:es
#Author:aeaguila@bancoagricola.com.sv

Característica: Transferencia Transfer365 CA-RD

  @transferencia365_CARD1
  Escenario: El cliente podrá realizar una transferencia Transfer365 CA-RD
    Dado realiza el proceso de logueo con el usuario GRANADAUSR
    Cuando valida el saldo de cuenta origen antes de realizar la transacción
      | cuentaOrigen                |
      | 3111963027 Cuenta de ahorro |
    Y realiza la transferencia Transfer 365
      | cuentaOrigen                | tipoTRX | tipoPago                       | concepto   | monto | descripcion | paisBanBen | bancoBen                       | tipoProd         | iBAN       | nombreRec         | docRec   | ciudadRec | direccion |
      | 3111963027 Cuenta de ahorro | CA-RD   | Otros, especificar en concepto | PruebaCARD | 1     | PruebaCARD  | Guatemala  | BANCO DE AMERICA CENTRAL, S.A. | Cuenta de ahorro | 1001159240 | cliente de prueba | 40378351 | Guatemala | Guatemala |
    Entonces debe visualizar la disminucion en la cuenta de origen
      | cuentaOrigen                | monto |
      | 3111963027 Cuenta de ahorro | 1     |

  @transferencia365_CARD2 @DEV
  Escenario: El cliente podrá realizar una transferencia Transfer365 CA-RD desde favorito
    Dado realiza el proceso de logueo con el usuario GRANADAUSR
    Cuando valida el saldo de cuenta origen antes de realizar la transacción
      | cuentaOrigen                |
      | 3111963027 Cuenta de ahorro|
    Y realiza la transferencia Transfer 365
      | cuentaOrigen                | tipoTRX   | nombrefavorito  | monto | descripcion |
      | 3111963027 Cuenta de ahorro | FAV_CA-RD | FAVCARDNOBORRAR | 1     | PruebaCARD  |
    Entonces debe visualizar la disminucion en la cuenta de origen
      | cuentaOrigen                | monto |
      | 3111963027 Cuenta de ahorro | 1     |