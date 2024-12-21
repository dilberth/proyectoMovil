#language:es
#Author:aeaguila@bancoagricola.com.sv

Característica: Aporte, retiro y validación de movimientos a meta

  @general @QA
  Escenario: El cliente podrá realizar aporte y retiro a una meta
    Dado realiza el proceso de logueo con el usuario PRIVADO01
    Y valida que no se encuentre creada la meta
      | nombreMeta   |
      | Prueba Meta2 |
    Y valida el saldo de cuenta antes de realizar la transacción
      | cuentaOrigen                 |
      | 31320008506 Cuenta de ahorro |
    Y completa el proceso para crear meta
      | nombreMeta   | montoMeta | plazoMeta | diaRetencion | cuentaARelacionar |
      | Prueba Meta2 | 100       | 12        | 2            | 31320008506 CA    |
    Y realiza el proceso de aporte y retiro a la meta validando los movimientos y el ticket
      | nombreMeta   | aporteMeta | retiroMeta |
      | Prueba Meta2 | 2          | 1          |
    Entonces debera visualizar la disminucion en la cuenta de origen
      | cuentaOrigen                 | monto |
      | 31320008506 Cuenta de ahorro | 1     |
    Y realiza el proceso de eliminacion de la meta
      | nombreMeta   |
      | Prueba Meta2 |