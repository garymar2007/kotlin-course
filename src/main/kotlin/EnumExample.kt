enum class Direction {
    NORTH, SOUTH, WEST, EAST
}

fun main() {
    val direction = "NORTH"
    println(Direction.NORTH.toString())
    when (direction) {
        Direction.NORTH.toString() -> println("You are going North")
        Direction.SOUTH.name
             -> println("You are going South")
        Direction.WEST.name -> println("You are going West")
        Direction.EAST.name -> println("You are going East")
    }
}
