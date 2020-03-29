import java.io.File
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class NordeaExpenseFileReader : ExpenseFileReader {
    override fun readFile(file: File): List<Row> {
        val dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
        val regex = "\\s+".toRegex()
        return file.readLines(Charsets.ISO_8859_1)
            .asSequence()
            .filter { it.isNotEmpty() }
            .drop(1) // header
            .map { it.split(";") }
            .map {
                Row(
                    date = LocalDate.parse(it[0], dateFormatter),
                    title = it[1].replace(regex, " "),
                    amount = it[3].replace(",", ".").toDouble()
                )
            }.toList()
    }
}
