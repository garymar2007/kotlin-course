package org.gary

class Person(val firstName: String, val lastName: String) {
    var fullName: String? = null
        set(value) {
            field = value
            println("The new full name is $value")
        }

    init {
        println("Init 1")
    }

    constructor(): this("Gary", "Chen") {
        println("Secondary constructor")
    }

    init {
        println("Init 2")
    }
}