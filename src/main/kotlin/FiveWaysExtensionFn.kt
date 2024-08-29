import java.time.LocalDate
import java.time.Month
import java.util.*
import kotlin.math.pow

class FiveWaysExtensionFn {
}

fun main() {
    data class User(val id: Int, val name: String)

    val user = User(1, "John")

    //1. Destructor
    val (userId, userName) = user

    println(user.component1())
    println(user.component2())

    println(userId)
    println(userName)

    operator fun LocalDate.component1() = year
    operator fun LocalDate.component2() = monthValue
    operator fun LocalDate.component3() = dayOfMonth

    val today = LocalDate.parse("2024-08-29")
    val (year, month, day) = today
    println("$year $month $day")
    println("${today.component1()} ${today.component2()} ${today.component3()}")

    //2. Calling any object
    operator fun Any?.invoke() = println(this)

    "Hello Kotlin World"()
    1()
    5.6()
    true()
    null()

    operator fun Int.invoke(other: Int) = this * other
    println(5(6 + 4))

    //3. index anything
    val letters = listOf("a", "b", "c")
    val bravo = letters[1]
    println(bravo)

    val number = 597

    operator fun Int.get(digit: Int) : Int =
        div(10.0.pow(digit.toDouble()))
            .rem(10.0)
            .toInt()

    println(number[0])
    println(number[1])
    println(number[2])
    println(number[3])

    val double: (Int) -> Int = { it * 2 }
    operator fun <T, R> ((T) -> R).get(param: T): R {
        return this(param)
    }
    operator fun <T, R> ((T) -> R).invoke(paramProvider: ()->(T)): R {
        return this(paramProvider())
    }
    val result = double(12)
    val result2 = double[12]
    val result3 = double { 12 }
    println("${result}, ${result2}, ${result3}")

    operator fun <K,V> TreeMap<K, V>.get(index: Int): V? {
        return this.values.elementAt(index)
    }
    val map = TreeMap<String, String>()
    map["b"] = "Bravo"
    map["a"] = "Alpha"
    map["c"] = "Charlie"
    println(map[1])
    println(map["b"])

    //4. Create Factory functions
    operator fun Int.Companion.get(vararg items: Int): IntArray =
        intArrayOf(*items)

    val evenNumbers = Int[2, 4, 6, 8, 10]
    evenNumbers.forEach(::println)

    //5. check "in" on things
    val date = LocalDate.parse("2024-08-29")
    operator fun Month.contains(date: LocalDate): Boolean {
        return date.month == this
    }
    operator fun Int.contains(date: LocalDate): Boolean {
        return date.year == this
    }

    infix fun Month.of(year: Int): Pair<Month, Int> = this to year
    operator fun Pair<Month, Int>.contains(date: LocalDate): Boolean {
        return date in first && date in second
    }
    println(date in Month.FEBRUARY)
    println(date in 2024)
    println(date in Month.AUGUST of 2025)

}