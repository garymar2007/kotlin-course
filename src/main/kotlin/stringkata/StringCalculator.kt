package stringkata

class StringCalculator {
    fun add(numbers: String): Int {
        if (numbers.isEmpty()) {
            return 0
        }
        var defaultDelimeter = mutableListOf(",")
        var newNumbers = numbers

        if (numbers.startsWith("\\/") && numbers.contains("\n")) {
            var delimeterStr = numbers.split("\n")[0]
            delimeterStr = delimeterStr.replace("//", "")
                .replace("[", "")
            val delimeterArray = delimeterStr.split("]")
            delimeterArray.forEach {
                defaultDelimeter.add(it)
            }
            newNumbers = numbers.split("\n")[1]
            defaultDelimeter.forEach {
                newNumbers = newNumbers.replace(it, ",")
            }
        } else {
            newNumbers = numbers.replace("\n", ",")
        }

        val acceptedRegex = Regex("^[0-9]?(,[0-9]+)*$")

        if (!acceptedRegex.matches(newNumbers)) {
            throw IllegalArgumentException("Invalid input")
        }

        if(newNumbers.length == 1) {
            return newNumbers.toInt()
        }

        val numbersArray = newNumbers.split(*defaultDelimeter.toTypedArray())
        numbersArray.forEach {
            if (it.isEmpty()) {
                throw IllegalArgumentException("Invalid input for delimiter")
            }
            if(it.toInt() < 0) {
                throw IllegalArgumentException("Negative numbers are not allowed")
            }
        }
        return numbersArray.filter { it.toInt() < 1000 }.map { it.toInt() }.sum()
    }
}