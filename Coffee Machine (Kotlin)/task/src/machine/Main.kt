package machine

import kotlin.math.min

const val COFFEE_WATER = 200
const val COFFEE_MILK = 50
const val COFFEE_BEANS = 15
fun main() {
    println("Write how many ml of water the coffee machine has:")
    val waterStored = readln().toInt()
    println("Write how many ml of milk the coffee machine has:")
    val milkStored = readln().toInt()
    println("Write how many grams of coffee beans the coffee machine has:")
    val gramsBeansStored = readln().toInt()
    println("Write how many cups of coffee you will need:")
    val cupsToMake = readln().toInt()
    val maxCups = smallest(
        waterStored / COFFEE_WATER,
        milkStored / COFFEE_MILK,
        gramsBeansStored / COFFEE_BEANS
    )
    when {
        maxCups == cupsToMake -> println("Yes, I can make that amount of coffee")
        maxCups < cupsToMake -> println("No, I can make only $maxCups cups of coffee")
        maxCups > cupsToMake -> println("Yes, I can make that amount of coffee (and even ${maxCups - cupsToMake} more than that)")
    }
}

/**
 *  fun smallest(n1: Int, n2: Int, n3: Int): Int
 *  Returns smallest of the three values
 */
fun smallest(n1: Int, n2: Int, n3: Int) = min(min(n1, n2), min(n1, n3))