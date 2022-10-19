package model

/**
 * @author Daniel Rodriguez Muñoz - Email: daniel.ro.mu02@gmail.com
 */
data class CasosHospProvres(
    val provinciaISO: String,
    val sex: String,
    val grupoEdad: String,
    val fecha: String,
    val numCasos: Int,
    val numHosp: Int,
    val numUci: Int,
    val numDef: Int
)