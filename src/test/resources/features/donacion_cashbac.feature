#language:es
#Author:aeaguila@bancoagricola.com.sv

Característica: Donación de CashBac

  @donacionCB @QA
  Escenario: El cliente podrá realizar la donacion de Cash Bac a una institucion ONG
    Dado realiza el proceso de logueo con el usuario PRIVADO02
    Cuando valida saldo de puntos BA antes de realizar la transacción
      | alias     |
      | Puntos BA |
    Y realiza el proceso de donacion para una ONG
      | alias     | tipoOperacion       | institucionOng | tipoCobro     | monto | concepto             |
      | Puntos BA | Donación de CashBac | LIBRAS DE AMOR | Cobro parcial | 10    | Donacion CashBac ONG |
    Entonces debe visualizar la disminucion en Puntos BA posterior a realizar la transacción
      | alias     | puntos |
      | Puntos BA | 1000   |