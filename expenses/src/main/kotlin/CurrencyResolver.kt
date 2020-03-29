import java.net.URL

object CurrencyResolver {

    fun getCurrencyRate(currency: String): Double {
        return try {
            val response = URL("https://api.exchangeratesapi.io/latest?base=$currency").readText()
            val rate = "(?<=\"EUR\":)([.0-9]+)(?=,)".toRegex().find(response)!!.groupValues[0]
            rate.toDouble()
        } catch (e: Exception) {
            println("Couldn't load $currency currency rate, please enter e.g. 0.133434: ")
            readLine()!!.replace(",", ".").toDouble()
        }
    }
}
