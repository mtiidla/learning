package ee.mtiidla.variance

fun main() {

    lateinit var phoneProducer: Manufacturer<Hardware.Phone>
    lateinit var phoneConsumer: Consumer<Hardware.Phone>

    val hardware: Hardware = phoneProducer.create()
    val phone: Hardware.Phone = phoneProducer.create()
    val android: Hardware.Phone.Android = phoneProducer.create()

    phoneConsumer.buy(hardware)
    phoneConsumer.buy(phone)
    phoneConsumer.buy(android)
}

sealed class Hardware {

    sealed class Phone : Hardware() {

        class Android : Phone()

        class BlackBerry : Phone()
    }
}

interface Manufacturer<out T : Hardware> {
    fun create(): T
}

interface Consumer<in T : Hardware> {
    fun buy(t: T)
}
