import org.gary.Person

class FancyInfoProvider: BasicInfoProviderImpl() {
    override val providerInfo: String
        get() = "Fancy Info Provider"

    override val sessionPrefixId: String
        get() = "Fancy session id"

    override fun printInfo(person: Person) {
        super.printInfo(person)
        println("FancyInfoProvider")
    }

    override fun getSessionId(): String {
        return sessionPrefixId
    }
}

fun main() {
    val provider = FancyInfoProvider()
    val person = Person("Carol", "Ma")
    person.fullName = "Carol Ma"
    provider.printInfo(person)
    checkTypes(provider)
    println(provider.getSessionId())
}