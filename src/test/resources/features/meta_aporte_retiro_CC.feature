#language:es
#Author:aeaguila@bancoagricola.com.sv

Característica: Aporte, retiro y validación de movimientos a meta

  @general @QA
  Escenario: El cliente podrá realizar aporte y retiro a una meta con cuenta corriente
    Dado realiza el proceso de logueo con el usuario PRIVADO01
    Y valida que no se encuentre creada la meta
      | nombreMeta   |
      | Prueba Meta3 |
    Y valida el saldo de cuenta antes de realizar la transacción
      | cuentaOrigen                 |
      | 1210039767 Cuenta corriente|
    Y completa el proceso para crear meta
      | nombreMeta   | montoMeta | plazoMeta | diaRetencion | cuentaARelacionar |
      | Prueba Meta3 | 100       | 12        | 2            | 1210039767 CC     |
    Y realiza el proceso de aporte y retiro a la meta validando los movimientos y el ticket
      | nombreMeta   | aporteMeta | retiroMeta |
      | Prueba Meta3 | 2          | 1          |
    Entonces debera visualizar la disminucion en la cuenta de origen
      | cuentaOrigen                 | monto |
      | 1210039767 Cuenta corriente  | 1     |
    Y realiza el proceso de eliminacion de la meta
      | nombreMeta   |
      | Prueba Meta3 |