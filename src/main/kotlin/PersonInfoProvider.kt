package org.gary

interface PersonInfoProvider {
    val providerInfo: String
        get() = "PersonInfoProvider"
    fun printInfo(person: Person) {
        println(providerInfo)
        person.printInfo()
    }
}

interface SessionInfoProvider {
    fun getSessionId(): String
}

abstract class BasicInfoProvider : PersonInfoProvider, SessionInfoProvider


class BasicInfoProviderImpl : BasicInfoProvider() {
    override val providerInfo: String
        get() = "BasicInfoProvider"

    override fun printInfo(person: Person) {
        super.printInfo(person)
        println("Additional print statement")
    }

    override fun getSessionId(): String {
        return "Session abc"
    }
}

fun main() {
    val provider = BasicInfoProviderImpl()
    val person = Person("Carol", "Ma")
    person.fullName = "Carol Ma"
    provider.printInfo(person)
    checkTypes(provider)
    println(provider.getSessionId())
}

fun checkTypes(infoProvider: PersonInfoProvider) {
    if (infoProvider !is SessionInfoProvider) {
        println("Not a session info provider")
    } else {
        println("Is a session info provider")
        (infoProvider as SessionInfoProvider).getSessionId()
    }
}

