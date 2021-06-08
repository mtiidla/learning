import java.io.File
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.time.LocalDate
import java.util.*
import javax.swing.JFileChooser
import javax.swing.filechooser.FileNameExtensionFilter

class Config(
    val currency: String,
    val expenseFileReader: ExpenseFileReader
)

private val NORDEA = Config("DKK", NordeaExpenseFileReader())
private val SEB = Config("SEK", SebExpenseFileReader())

val RELEASE: Config = SEB

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
    "sp" to "Sport",
    "f" to "Meelelahutus",
    "tr" to "Tervis ja ravimid",
    "l" to "Laen, liising, CC",
    "k" to "Kingitus",
    "m" to "Muu",
    "-" to "Skip"
)

val EXCLUSIONS = listOf(
    "SparOp"
)

val AUTO_ASSIGN = mapOf(
    "SYSTEMBOLAGE" to "s",
    "COOP" to "s",
    "HEMKÃP" to "s",
    "KLARNA ARST" to "s"
)

fun main() {

    val currency = RELEASE.currency

    val currencyRate = CurrencyResolver.getCurrencyRate(currency)
    val DF = DecimalFormat("0.00", DecimalFormatSymbols.getInstance(Locale.UK))

    println("-------- Categories ----------")
    CATEGORIES.forEach { (k, v) ->
        println("$k -> $v")
    }
    println("\n- -> skip expense")
    println("z -> redo previous expense")
    println("exit -> print current totals and exit\n")
    println("1 $currency -> $currencyRate EUR")

    val file = openFile()
//    val file = File("/Users/markot/Documents/kontoutdrag.csv")
    if (file == null) {
        return
    }
    val input = RELEASE.expenseFileReader.readFile(file)

    val totals = CATEGORIES.keys.associateWith { mutableListOf<Row>() }

    val expensesList = input
        .filter { it.amount < 0 }
        .filterNot { expense -> EXCLUSIONS.any { expense.title.contains(it, true) } }

    val expenses = Stack<Row>()
    expenses.addAll(expensesList.reversed())
    val undo = Stack<Pair<String, Row>>()

    loop@ while (expenses.isNotEmpty()) {
        val expense = expenses.pop()
        val action = actionForRow(currency, expense)
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
                println(it.format(currency, currencyRate, DF))
            }
        }

    val results = totals.mapValues { it.value.sumByDouble { Math.abs(it.amount) } }
    println("\n-------- Expenses --------")
    results.forEach { cat, amount ->
        println(
            "${CATEGORIES[cat]!!.padEnd(20, ' ')} " +
                    "-> ${DF.format(amount)} $currency / ${DF.format(amount * currencyRate)} EUR"
        )
    }

    println("\n-------- Begin Copy -------")
    results.filterKeys { it != "-" }
        .values.forEach { amount ->
        if (amount > 0) {
            println(DF.format(amount * currencyRate))
        } else {
            println()
        }
    }
    println("-------- End Copy -------")

    println("\n--------- Incomes --------")
    val incomes = input.filter { it.amount > 0 }
    incomes.forEach {
        println(it.format(currency, currencyRate, DF))
    }
}

sealed class Action {
    data class Category(val category: String) : Action()
    data class AutoCategory(val category: String) : Action()
    object Exit : Action()
    object Undo : Action()
}

private fun actionForRow(currency: String, expense: Row): Action {
    var category: String? =
        AUTO_ASSIGN[AUTO_ASSIGN.keys.firstOrNull { expense.title.contains(it, true) }]
    if (category != null) {
        return Action.AutoCategory(category)
    }
    while (category == null) {
        println()
        println(expense.format(currency))
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

private fun openFile(): File? {
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

    fun format(currency: String): String {
        return "$title ----> $amount $currency <---- $date"
    }

    fun format(
        currency: String,
        currencyRate: Double,
        format: DecimalFormat
    ): String {
        return "$title ----> $amount $currency / ${format.format(amount * currencyRate)} EUR <---- $date"
    }
}
