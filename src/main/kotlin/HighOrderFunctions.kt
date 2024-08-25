fun printFilteredSrings(list: List<String>, predicate: ((String) -> Boolean)?) {
    list.forEach {
        if (predicate?.invoke(it) == true) {
            println(it)
        }
    }
}

val predicaqte: (String) -> Boolean = {
    it.startsWith("J")
}

fun getPrintPredicate(): (String) -> Boolean {
    return { it.startsWith("J") }
}

fun main() {
    val list = listOf("Kotlin", "Java", "C++", "JavaScript")

    // using a lambda function
    printFilteredSrings(list, { it.startsWith("J") })
    // simply:
    printFilteredSrings(list) { it.startsWith("J") }

    printFilteredSrings(list, null)

    // using a function reference
    printFilteredSrings(list, predicaqte)

    // using a function
    printFilteredSrings(list, getPrintPredicate())
}