import java.net.URL

object CurrencyResolver {

    fun getCurrencyRate(currency: String): Double {
        return try {
            val url = "http://api.exchangeratesapi.io/v1/latest?access_key=ef31d20a45f29e9215dd1fd0d23580b1&symbols=$currency"
            val response = URL(url).readText()
            val rate = "(?<=\"$currency\":)([.0-9]+)".toRegex().find(response)!!.groupValues[0]
            1 / rate.toDouble()
        } catch (e: Exception) {
            println("Couldn't load $currency currency rate, please enter e.g. 0.133434: ")
            readLine()!!.replace(",", ".").toDouble()
        }
    }
}
