#language:es
#Author:aeaguila@bancoagricola.com.sv

Característica: Redención de CashBac

  @redencionCB @QA
  Escenario: El cliente podrá realizar la redencion de Cash Bac transfiriendo a una de sus cuentas propias
    Dado realiza el proceso de logueo con el usuario PRIVADO01
    Cuando valida el saldo de cuenta destino antes de realizar la transacción
      | cuentaDestino               |
      | 3001329786 Cuenta de ahorro |
    Cuando valida saldo de puntos BA previo a realizar la transacción
      | alias     |
      | Puntos BA |
    Y realiza el proceso de transferencia de cashbac a una cuenta propia
      | tipoOperacion        | cuentaDestino               | tipoCobro     | monto | concepto                    |
      | Redención de CashBac | 3001329786 Cuenta de ahorro | Cobro parcial | 10    | RedencionCashBac Automatico |
    Y debe visualizar la disminucion en Puntos BA posterior a realizar la transacción
      | alias     | puntos |
      | Puntos BA | 1000   |
    Entonces debe visualizar un aumento en la cuenta destino
      | cuentaDestino               | monto |
      | 3001329786 Cuenta de ahorro | 10    |