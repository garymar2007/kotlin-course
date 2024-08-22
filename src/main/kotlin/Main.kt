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



}