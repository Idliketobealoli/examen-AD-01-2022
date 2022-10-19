package processor

import model.CasosHospProvres
import java.util.stream.Collectors
/**
 * @author Daniel Rodriguez Muñoz - Email: daniel.ro.mu02@gmail.com
 */
class CSVProcessor(val casos: Set<CasosHospProvres>) {
    private val provinciasISO = setOf(
        "C","VI","AB","A","AL","O","AV","BA","PM","B","BI","BU","CC","CA","S","CS","CR","CO","CU","SS","GI","GR",
        "GU","H","HU","J","LO","GC","LE","L","LU","M","MA","MU","NA","OR","P","PO","SA","TF","SG","SE","SO","T","TE",
        "TO","V","VA","ZA","Z"
    )
    fun ejercicio2() {
        val listProvincias = mutableSetOf<List<CasosHospProvres>>()

        provinciasISO.forEach {
            val filteredProvincia = casos.stream().filter {
                x ->
                x.provinciaISO.contentEquals(it)
            }.collect(Collectors.toList())
            listProvincias.add(filteredProvincia)
        }

        listProvincias.forEach {
            println("Minimo de casos para ${it.first().provinciaISO} : ${it.stream().min { o1, o2 -> o1.numCasos.compareTo(o2.numCasos) }.get().numCasos}")
            println("Maximo de casos para ${it.first().provinciaISO} : ${it.stream().max { o1, o2 -> o1.numCasos.compareTo(o2.numCasos) }.get().numCasos}")
            var avgUp = 0.0
            it.stream().forEach {
                x ->
                avgUp += x.numCasos
            }
            println("Media de casos para ${it.first().provinciaISO} : ${(avgUp/it.size)}")
            println("***")

            println("Minimo de hospitalizados para ${it.first().provinciaISO} : ${it.stream().min { o1, o2 -> o1.numHosp.compareTo(o2.numHosp) }.get().numHosp}")
            println("Maximo de hospitalizados para ${it.first().provinciaISO} : ${it.stream().max { o1, o2 -> o1.numHosp.compareTo(o2.numHosp) }.get().numHosp}")
            avgUp = 0.0
            it.stream().forEach {
                    x ->
                avgUp += x.numHosp
            }
            println("Media de hospitalizados para ${it.first().provinciaISO} : ${(avgUp/it.size)}")
            println("***")

            println("Minimo de UCIS para ${it.first().provinciaISO} : ${it.stream().min { o1, o2 -> o1.numUci.compareTo(o2.numUci) }.get().numUci}")
            println("Maximo de UCIS para ${it.first().provinciaISO} : ${it.stream().max { o1, o2 -> o1.numUci.compareTo(o2.numUci) }.get().numUci}")
            avgUp = 0.0
            it.stream().forEach {
                    x ->
                avgUp += x.numUci
            }
            println("Media de UCIS para ${it.first().provinciaISO} : ${(avgUp/it.size)}")
            println("***")

            println("Minimo de defunciones para ${it.first().provinciaISO} : ${it.stream().min { o1, o2 -> o1.numDef.compareTo(o2.numDef) }.get().numDef}")
            println("Maximo de defunciones para ${it.first().provinciaISO} : ${it.stream().max { o1, o2 -> o1.numDef.compareTo(o2.numDef) }.get().numDef}")
            avgUp = 0.0
            it.stream().forEach {
                    x ->
                avgUp += x.numDef
            }
            println("Media de defunciones para ${it.first().provinciaISO} : ${(avgUp/it.size)}")
            println("***")
        }
    }
}