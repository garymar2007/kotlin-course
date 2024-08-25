class Employee(var name: String, var age: Int, var salary: Int)

fun main() {
    val employee = Employee("John", 30, 10000)
    val employee1 = Employee("George", 40, 20000)
    val employee2 = Employee("Gary", 50, 60000)

    /**
     * Scope funtion: with
     * 1. Refer to context object by using 'this';
     * 2. The return value is the lambda result.
     */
    val increasedSalary = with(employee) {
        println("Name: $name, Age: $age, Salary: $salary")
        println(this.name)
        this.salary + 5000
    }
    println("Increased salary: $increasedSalary")

    /**
     * Scope function: apply
     * 1. Refer to context object by using 'this';
     * 2. The return value is the context object.
     */
    val boss = Employee("Boss", 55, 50000).apply {
        name = "Boss"
        age = 55
        salary = 95000
    }

    println("Name: ${boss.name}, Age: ${boss.age}, Salary: ${boss.salary}")

    /**
     * Scope function: also
     * 1. Refer to context object by using 'it';
     * 2. The return value is the context object.
     */
    val numberList = mutableListOf(1, 2, 3)
    numberList.also {
        println("The list elements are: $it")
        it.add(5)
    }.add(4)
    println("The updated list elements are: $numberList")
    boss.also {
        it.age = 56
        it.salary = 100000
    }
    println("Name: ${boss.name}, Age: ${boss.age}, Salary: ${boss.salary}")

    /**
     * Scope function: let
     * 1. Refer to context object by using 'it';
     * 2. The return value is the lambda result.
     */
    val result = employee.let {
        println("Name: ${it.name}, Age: ${it.age}, Salary: ${it.salary}")
        it.salary + 5000
    }
    println("Increased salary for ${employee.name}: $result")

    val name: String? = "this is a test string"
    val stringLenth = name?.let {
        println(it!!.reversed())
        println(it.capitalize())
        it.length
    }
    println("String length: $stringLenth")

    /**
     * Scope function: run
     * 1. Refer to context object by using 'this';
     * 2. The return value is the lambda result.
     *
     * 'run' is combination of 'with' and 'let', if you want to operate on a Nullable
     * object and avoid NullPointerException, you can use 'run'.
     */
    val clerk: Employee? = Employee("Clerk", 25, 12000)
    val offerSalary = clerk?.run {
        println("Name: ${this.name}, Age: ${this.age}, Salary: ${this.salary}")
        this.salary + 5000
    }
    println(offerSalary)

    /**
     * Summary:
     * with - if you want to operate on a non-nullable object.
     * let - if you want to execute lambda expression on a nullable object and avoid NullPointerException.
     * run - if you want to operate on a nullable object, execute lambda expression and avoid NullPointerException.
     * apply - if you want to initialize or configure an object.
     * also - if you want to do some additional actions object configuration or operations.
     */
}