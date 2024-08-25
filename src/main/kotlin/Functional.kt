fun main() {
    val list = listOf("Kotlin", "Java", "C++", "JavaScript", null)

    list.forEach(::println)

    //alternatively
    list.forEach { println(it) }

    list.takeLast(3).forEach { println(it) }

    list.filterNotNull()    //filter out null values
        .take(3)
        .filter { it.startsWith("J")}
        .map { it.length }
        .forEach(::println)

    list.filterNotNull()
        .associate { it to it.length }
        .forEach { println("${it.key} -> ${it.value}") }

    val map = list.filterNotNull()
        .associate { it to it.length }

    val language = list.first()
    println(language)

    val language1 = list.filterNotNull().last()
    println(language1)

    val language2 = list.filterNotNull().find { it.startsWith("Java") }
    println(language2)

    val language3 = list.filterNotNull().findLast { it.startsWith("Java") }
    println(language3)

   val language4 = list.filterNotNull().findLast { it.startsWith("foo") }.orEmpty()
    println(language4)

    val language5 = list.filterNotNull().firstOrNull { it.startsWith("foo") }.orEmpty()
    println(language5)

    val language7 = list.filterNotNull().lastOrNull { it.startsWith("foo") }.orEmpty()
    println(language7)

    val language9 = list.filterNotNull().singleOrNull { it.startsWith("foo") }.orEmpty()
    println(language9)

    val language10 = list.filterNotNull().singleOrNull { it.startsWith("Java") }.orEmpty()
    println(language10)

    val language11 = list.filterNotNull().first { it.startsWith("Java") }
    println(language11)

    val language12 = list.filterNotNull().last { it.startsWith("Java") }
    println(language12)

    val language13 = list.filterNotNull().single { it.startsWith("Java") }
    println(language13)

    val language14 = list.filterNotNull().single { it.startsWith("foo") }
    println(language14)

}