import java.io.File
import java.net.URL
import java.text.DecimalFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Stack
import javax.swing.JFileChooser
import javax.swing.filechooser.FileNameExtensionFilter

val CATEGORIES = mapOf(
    "s" to "Söök",
    "v" to "Väljas söömine",
    "kt" to "Kodutarbed",
    "ri" to "Riided",
    "t" to "Transport",
    "p" to "Pesu",
    "a" to "Auto",
    "r" to "Ratas",
    "vr" to "Välismaa reisid",
    "j" to "Kosmeetik/juuksur",
    "ts" to "Tervis ja sport",
    "f" to "Meelelahutus",
    "h" to "Ravimid",
    "l" to "Laen, liising, CC",
    "k" to "Kingitus",
    "m" to "Muu",
    "-" to "Skip"
)

val EXCLUSIONS = listOf(
    "SparOp"
)

val AUTO_ASSIGN = mapOf(
    "Teglh" to "s"
)

fun main() {

    val dkkRate = getCurrencyRate()
    val DF = DecimalFormat("0.00")

    println("-------- Categories ----------")
    CATEGORIES.forEach { k, v ->
        println("$k -> $v")
    }
    println("\n- -> skip expense")
    println("z -> redo previous expense")
    println("exit -> print current totals and exit\n")
    println("1 DKK -> $dkkRate EUR")

    val file = openFile()
//    val file = File("/Users/Marko/Downloads/poster.csv")
    if (file == null) {
        return
    }
    val input = readNordea(file)

    val totals = CATEGORIES.keys.associateWith { mutableListOf<Row>() }

    val expensesList = input
        .filter { it.amount < 0 }
        .filterNot { expense -> EXCLUSIONS.any { expense.title.contains(it, true) } }

    val expenses = Stack<Row>()
    expenses.addAll(expensesList.reversed())
    val undo = Stack<Pair<String, Row>>()

    loop@ while(expenses.isNotEmpty()){
        val expense = expenses.pop()
        val action = actionForRow(expense)
        when (action) {
            is Action.Category -> {
                totals[action.category]!!.add(expense)
                undo.push(action.category to expense)
            }
            is Action.AutoCategory -> {
                totals[action.category]!!.add(expense)
            }
            is Action.Exit -> break@loop
            is Action.Undo -> {
                expenses.push(expense)
                if (!undo.isEmpty()) {
                    val (cat, prev) = undo.pop()
                    totals[cat]!!.remove(prev)
                    expenses.push(prev)
                }
            }
        }
    }

    println("\n-------- Review --------")
    totals
        .filter { it.value.isNotEmpty() }
        .forEach { cat, exp ->
            println("-------- $cat -> ${CATEGORIES[cat]} -------")
            exp.forEach {
                println(it.toString(dkkRate, DF))
            }
        }

    val results = totals.mapValues { it.value.sumByDouble { Math.abs(it.amount) } }
    println("\n-------- Expenses --------")
    results.forEach { cat, amount ->
        println(
            "${CATEGORIES[cat]!!.padEnd(20, ' ')} " +
                "-> ${DF.format(amount)} DKK / ${DF.format(amount * dkkRate)} EUR"
        )
    }

    println("\n-------- Begin Copy -------")
    results.filterKeys { it != "-" }
        .values.forEach { amount ->
        if (amount > 0) {
            println(DF.format(amount * dkkRate))
        } else {
            println()
        }
    }
    println("-------- End Copy -------")

    println("\n--------- Incomes --------")
    val incomes = input.filter { it.amount > 0 }
    incomes.forEach {
        println(it.toString(dkkRate, DF))
    }
}

sealed class Action {
    data class Category(val category: String) : Action()
    data class AutoCategory(val category: String) : Action()
    object Exit : Action()
    object Undo : Action()
}

private fun actionForRow(expense: Row): Action {
    var category: String? =
        AUTO_ASSIGN[AUTO_ASSIGN.keys.firstOrNull { expense.title.contains(it, true) }]
    if (category != null) {
        return Action.AutoCategory(category)
    }
    while (category == null) {
        println()
        println(expense)
        print("Enter category: ")

        val userInput = readLine()

        if (userInput == "z") {
            return Action.Undo
        }
        if (userInput == "exit") {
            return Action.Exit
        }
        category = if (CATEGORIES.containsKey(userInput)) userInput else null
        if (category == null) {
            println("\n$CATEGORIES")
        }
    }
    return Action.Category(category)
}

private fun readNordea(file: File): List<Row> {
    val dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
    val regex = "\\s+".toRegex()
    return file.readLines(Charsets.ISO_8859_1)
        .asSequence()
        .filter { it.isNotEmpty() }
        .drop(1) // header
        .map { it.split(";") }
        .map {
            Row(
                LocalDate.parse(it[0], dateFormatter),
                it[1].replace(regex, " "),
                it[3].replace(",", ".").toDouble()
            )
        }.toList()
}

fun getCurrencyRate(): Double {
    return try {
        val response = URL("https://api.exchangeratesapi.io/latest?base=DKK").readText()
        val rate = "(?<=\"EUR\":)([.0-9]+)(?=,)".toRegex().find(response)!!.groupValues[0]
        rate.toDouble()
    } catch (e: Exception) {
        println("Couldn't load DKK currency rate, please enter e.g. 0.133434: ")
        readLine()!!.replace(",", ".").toDouble()
    }
}

fun openFile(): File? {
    val chooser = JFileChooser()
    val filter = FileNameExtensionFilter("CSV files", "csv")
    chooser.fileFilter = filter
    val returnVal = chooser.showOpenDialog(null)
    if (returnVal == JFileChooser.APPROVE_OPTION) {
        return chooser.selectedFile
    }
    return null
}

data class Row(val date: LocalDate, val title: String, val amount: Double) {

    override fun toString(): String = toString(null, null)

    fun toString(dkkRate: Double? = null, format: DecimalFormat? = null): String {
        return if (dkkRate == null) {
            "$title ----> $amount DKK <---- $date"
        } else {
            "$title ----> $amount DKK / ${format!!.format(amount * dkkRate)} EUR <---- $date"
        }
    }
}
