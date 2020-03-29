import java.io.File

interface ExpenseFileReader {

    fun readFile(file: File): List<Row>
}
