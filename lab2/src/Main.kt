import java.util.*

fun main(args: Array<String>) {
    printHello()

    val isUnit = println("This is an expression")
    println(isUnit)

    val temperature = 10
    val isHot = if (temperature > 50) true else false
    println(isHot)

    val temperature1 = 10
    val message = "The water temperature is ${if (temperature1 > 50) "too warm" else "OK"}."
    println(message)

    feedTheFish()
    feedTheFish1()

    swim() // uses default speed
    swim("slow") // positional argument
    swim(speed = "turtle-like") // named parameter

    feedTheFish2()

    val decorations = listOf("rock", "pagoda", "plastic plant", "alligator", "flowerpot")
    println(decorations.filter { it[0] == 'p' })

    val decorations1 = listOf("rock", "pagoda", "plastic plant", "alligator", "flowerpot")
    // eager, creates a new list
    val eager = decorations1.filter { it[0] == 'p' }
    println("eager: $eager")

    val mySports = listOf("basketball", "fishing", "running")
    val myPlayers = listOf("LeBron James", "Ernest Hemingway", "Usain Bolt")
    val myCities = listOf("Los Angeles", "Chicago", "Jamaica")
    val myList = listOf(mySports, myPlayers, myCities) // list of lists
    println("-----")
    println("Flat: ${myList.flatten()}")

    var dirtyLevel = 20
    val waterFilter = { dirty: Int -> dirty / 2 }
    println(waterFilter(dirtyLevel))

    var dirtyLevel1 = 19
    dirtyLevel1 = updateDirty(dirtyLevel1) { it + 23 }
    println(dirtyLevel1)
}

fun printHello() {
    println("Hello World")
}

fun feedTheFish() {
    val day = randomDay()
    val food = "pellets"
    println("Today is $day and the fish eat $food")
}

fun randomDay(): String {
    val week = arrayOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    return week[Random().nextInt(week.size)]
}

fun fishFood(day: String): String {
    return when (day) {
        "Monday" -> "flakes"
        "Tuesday" -> "pellets"
        "Wednesday" -> "redworms"
        "Thursday" -> "granules"
        "Friday" -> "mosquitoes"
        "Saturday" -> "lettuce"
        "Sunday" -> "plankton"
        else -> ""
    }
}

fun feedTheFish1() {
    val day = randomDay()
    val food = fishFood(day)
    println("Today is $day and the fish eat $food")
}

fun swim(speed: String = "fast") {
    println("swimming $speed")
}

fun shouldChangeWater(day: String, temperature: Int = 22, dirty: Int = 20): Boolean {
    return when {
        temperature > 30 -> true
        dirty > 30 -> true
        day == "Sunday" -> true
        else -> false
    }
}

fun feedTheFish2() {
    val day = randomDay()
    val food = fishFood(day)
    println("Today is $day and the fish eat $food")
    println("Change water: ${shouldChangeWater(day)}")
}

fun isTooHot(temperature: Int) = temperature > 30

fun isDirty(dirty: Int) = dirty > 30

fun isSunday(day: String) = day == "Sunday"

fun shouldChangeWater1(day: String, temperature: Int = 22, dirty: Int = 20): Boolean {
    return when {
        isTooHot(temperature) -> true
        isDirty(dirty) -> true
        isSunday(day) -> true
        else -> false
    }
}

fun updateDirty(dirty: Int, operation: (Int) -> Int): Int {
    return operation(dirty)
}
