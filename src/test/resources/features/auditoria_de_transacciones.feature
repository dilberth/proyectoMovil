#language:es
#Author: guseche@bancogricola.com.sv
#Author: aeaguila@bancogricola.com.sv

Característica: Auditoria de transacciones

  @general @auditoria1 @QA
  Esquema del escenario: El cliente validará que se muestren los registros filtrados por tipo de transacción y fecha especifica para los canales e-banca Personas y Banca Móvil
    Dado realiza el proceso de logueo con el usuario JAVIERROSALES
    Cuando el cliente desea utilizar el filtro de auditoria de transacciones por fecha, tipo de transaccion y canal
      | FechaDesde   | FechaHasta   | tipoTRX   | canal   |
      | <FechaDesde> | <FechaHasta> | <tipoTRX> | <canal> |
    Entonces el cliente podra observar los registos relacionados al filtro utilizado
    Y se debe identificar que todos los registros son de tipo <tipoTRX>

    Ejemplos:
      | FechaDesde     | FechaHasta     | tipoTRX       | canal            |
      | 1 Agosto, 2023 | 1 Agosto, 2024 | Ayuda Teletón | Banca Móvil      |
      | 1 Agosto, 2023 | 1 Agosto, 2024 | Ayuda Teletón | e-banca Personas |

  @general @auditoria2 @QA
  Esquema del escenario: El cliente validará que se muestren registros filtrados por rango de monto y una fecha especifica para los canales e-banca Personas y Banca Móvil
    Dado realiza el proceso de logueo con el usuario JAVIERROSALES
    Cuando el cliente desea utilizar el filtro de auditoria de transacciones por fecha, tipo de transaccion, rango de montos y canal
      | FechaDesde   | FechaHasta   | tipoTRX   | canal   | desde   | hasta   |
      | <FechaDesde> | <FechaHasta> | <tipoTRX> | <canal> | <desde> | <hasta> |
    Entonces el cliente podra observar los registos relacionados al filtro utilizado
    Y se debe identificar que todos los registros tenga como un monto el rango <desde> a <hasta>

    Ejemplos:
      | FechaDesde     | FechaHasta     | tipoTRX       | desde | hasta | canal            |
      | 1 Agosto, 2023 | 1 Agosto, 2024 | Ayuda Teletón | 1     | 2     | Banca Móvil      |
      | 1 Enero, 2023  | 1 Agosto, 2024 | Ayuda Teletón | 1     | 20    | e-banca Personas |

  @general @auditoria3 @QA
  Esquema del escenario: El cliente validará que se muestren registros filtrados por estado de la transacción y una fecha especifica para los canales e-banca Personas y Banca Móvil
    Dado realiza el proceso de logueo con el usuario JAVIERROSALES
    Cuando el cliente desea utilizar el filtro de auditoria de transacciones por fecha, tipo de transaccion, estado de la transaccion y canal
      | FechaDesde   | FechaHasta   | tipoTRX   | estadoTRX   | canal   |
      | <FechaDesde> | <FechaHasta> | <tipoTRX> | <estadoTRX> | <canal> |
    Entonces el cliente podra observar los registos relacionados al filtro utilizado
    Y se debe identificar que todos los registros tenga como un estado de transaccion <estadoTRX>

    Ejemplos:
      | FechaDesde     | FechaHasta     | tipoTRX       | estadoTRX  | canal            |
      | 1 Agosto, 2023 | 1 Agosto, 2024 | Ayuda Teletón | FINALIZADO | Banca Móvil      |
      | 1 Agosto, 2023 | 1 Agosto, 2024 | Ayuda Teletón | FINALIZADO | e-banca Personas |