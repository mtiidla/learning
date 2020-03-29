import java.io.File
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class SebExpenseFileReader : ExpenseFileReader {
    override fun readFile(file: File): List<Row> {
        val dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val regex = "\\s+".toRegex()
        return file.readLines(Charsets.ISO_8859_1)
            .asSequence()
            .filter { it.isNotEmpty() }
            .drop(8) // headers
            .map { it.split(";") }
            .map {
                Row(
                    date = LocalDate.parse(it[0], dateFormatter),
                    title = it[3].replace(regex, " "),
                    amount = it[4].replace("[^0-9,.-]".toRegex(), "").replace(",", ".").toDouble()
                )
            }.toList()
    }

}
