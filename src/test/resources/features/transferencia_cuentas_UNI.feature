#language:es
#Author:aeaguila@bancoagricola.com.sv

Característica: Transferencias UNI

  @transferenciaUNI_1 @DEV
  Escenario: El cliente podrá realizar una transferencia UNI
    Dado realiza el proceso de logueo con el usuario GRANADAUSR
    #Cuando valida que el favorito no se encuentre creado
    #  | nombrefavorito | opcion                  |
    #  | TransfUNI8     | Cuentas de otros bancos |
    Cuando valida el saldo de cuenta origen antes de realizar la transacción
      | cuentaOrigen                |
      | 3112420617 Cuenta de ahorro |
    Y realiza la transferencia UNI
      | cuentaOrigen                | tipoCuenta                | banco           | cuentaDestino   | tipoIdentificacion | numeroIdentificacion | nombreRecibidor | monto | concepto | correo                        | nombrefavorito | opcion                  | tipoTRX |
      | 3112420617 Cuenta de ahorro | Cuenta de ahorro - propia | BANCO CUSCATLAN | 000000010103830 | DUI                | 014712643            | Juan Perez      | 1     | Prueba   | aeaguila@bancoagricola.com.sv | TransfUNI8     | Cuentas de otros bancos | NORMAL  |
    Entonces debe visualizar la disminucion en la cuenta de origen
      | cuentaOrigen                | monto |
      | 3112420617 Cuenta de ahorro | 1     |

  @transferenciaUNI_2 @DEV
  Escenario: El cliente podrá realizar una transferencia UNI desde favorito
    Dado realiza el proceso de logueo con el usuario GRANADAUSR
    Cuando valida el saldo de cuenta origen antes de realizar la transacción
      | cuentaOrigen                |
      | 3115590271 Cuenta de ahorro |
    Y realiza la transferencia UNI
      | cuentaOrigen                | nombrefavorito  | monto | concepto | tipoTRX |
      | 3115590271 Cuenta de ahorro | FavUNICuscatlan | 1     | Prueba   | FAV     |
    Entonces debe visualizar la disminucion en la cuenta de origen
      | cuentaOrigen                | monto |
      | 3115590271 Cuenta de ahorro | 1     |