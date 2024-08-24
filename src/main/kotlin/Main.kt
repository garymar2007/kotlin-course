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

    val itemToGreetings = arrayOf("Kotlin", "Java")
    sayHello2("Hello", *itemToGreetings)

    initializeIntArray()

    val person = Person()
    val person1 = Person("Gary", "Ma")
    person1.fullName = "Gary Ma"
    println(person1.fullName)   // output: The new full name is Gary Ma
    person1.printInfo()         // output: Full name: Gary Ma

    // 1:20:00
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

fun initializeIntArray() {
    val a = intArrayOf(1,2,3)
    val b = intArrayOf(4,5,6)
    val c = intArrayOf(*a, *b, 7,8,9)

    println(c.joinToString())   // output: 1,2,3,4,5,6,7,8,9
}