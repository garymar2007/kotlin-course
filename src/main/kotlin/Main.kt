package org.gary

//Reference: https://www.youtube.com/watch?v=F9UC9DY-vIU&t=902s

fun main() {
    val interestingthings = arrayOf("Kotlin", "Programming", "Comic Books")

    // for loop to iterate through the array
    for (interestingthing in interestingthings) {
        println(interestingthing)
    }

    // forEach loop to iterate through the array
    interestingthings.forEach { interestingthing ->
        println(interestingthing)
    }

    // forEach loop to iterate through the array by using it
    interestingthings.forEach {
        println(it)
    }

    // forEachIndexed loop to iterate through the array by using it
    interestingthings.forEachIndexed { index, interestingThing ->
        println("$interestingThing is at index $index")
    }

    val listOfThing = listOf("Kotlin", "Programming", "Comic Books")
    listOfThing.forEach {
        println(it)
    }
    println(listOfThing[0])
    println(listOfThing.get(1))

    val map = mapOf(1 to "a", 2 to "b", 3 to "c")
    map.forEach { (key, value) ->
        println("$key -> $value")
    }
    val map1 = map + (4 to "d")
    map1.forEach { (key, value) ->
        println("$key -> $value")
    }

    val mutableMap = mutableMapOf(1 to "a", 2 to "b", 3 to "c")
    mutableMap.put(4, "d")
    mutableMap.forEach { (key, value) ->
        println("$key -> $value")
    }

    val itemToGreeting = listOf("Kotlin", "Java")
    sayHello("Hello", itemToGreeting)
    sayHello2("Hello", "Kotlin1", "Java1")
    // 49:27
}

fun sayHello(greeting: String, itemToGreet: List<String>) {
    itemToGreet.forEach {
        println("$greeting $it")
    }
}

fun sayHello2(greeting: String, vararg itemToGreet: String) {
    itemToGreet.forEach {
        println("$greeting $it")
    }
}