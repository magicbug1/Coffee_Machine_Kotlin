package machine

const val ESPRESSO = 1
const val ESPRESSO_WATER = 250
const val ESPRESSO_MILK = 0
const val ESPRESSO_BEANS = 16
const val ESPRESSO_PRICE = 4

const val LATTE = 2
const val LATTE_WATER = 350
const val LATTE_MILK = 75
const val LATTE_BEANS = 20
const val LATTE_PRICE = 7

const val CAPPUCCINO = 3
const val CAPPUCCINO_WATER = 200
const val CAPPUCCINO_MILK = 100
const val CAPPUCCINO_BEANS = 12
const val CAPPUCCINO_PRICE = 6

var waterInMachine = 400
var milkInMachine = 540
var coffeeBeansInMachine = 120
var cupsInMachine = 9
var moneyInMachine = 550


fun main() {
    val coffeeData = mutableListOf(
        mutableListOf(ESPRESSO, ESPRESSO_WATER, ESPRESSO_MILK, ESPRESSO_BEANS, ESPRESSO_PRICE),
        mutableListOf(LATTE, LATTE_WATER, LATTE_MILK, LATTE_BEANS, LATTE_PRICE),
        mutableListOf(CAPPUCCINO, CAPPUCCINO_WATER, CAPPUCCINO_MILK, CAPPUCCINO_BEANS, CAPPUCCINO_PRICE)
    )
    actions(coffeeData)
}

private fun actions(coffeeData: MutableList<MutableList<Int>>) {
    while (true) {
        println("Write action (buy, fill, take, remaining, exit):")
        val input = readln()
        println()
        when (input.lowercase()) {
            "buy" -> buyAction(coffeeData)
            "fill" -> fillAction()
            "take" -> takeAction()
            "remaining" -> printMachineState()
            "exit" -> break
        }
    }
}

fun printMachineState() {
    println("The coffee machine has:")
    println("$waterInMachine ml of water")
    println("$milkInMachine ml of milk")
    println("$coffeeBeansInMachine g of coffee beans")
    println("$cupsInMachine disposable cups")
    println("$$moneyInMachine of money")
}

fun takeAction() {
    println("I gave you $moneyInMachine")
    moneyInMachine = 0
}

fun fillAction() {
    println("Write how many ml of water you want to add:")
    waterInMachine += readln().toInt()
    println("Write how many ml of water you want to add:")
    milkInMachine += readln().toInt()
    println("Write how many grams of coffee beans you want to add:")
    coffeeBeansInMachine += readln().toInt()
    println("Write how many disposable cups you want to add:")
    cupsInMachine += readln().toInt()
}

fun buyAction(coffeeData: MutableList<MutableList<Int>>) {
    println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:")
    when (val input = readln().lowercase()) {
        "1" -> {
            processCoffeeChoice(input.toInt(), coffeeData)
        }

        "2" -> {
            waterInMachine -= LATTE_WATER
            milkInMachine -= LATTE_MILK
            coffeeBeansInMachine -= LATTE_BEANS
            cupsInMachine--
            moneyInMachine += LATTE_PRICE
        }

        "3" -> {
            waterInMachine -= CAPPUCCINO_WATER
            milkInMachine -= CAPPUCCINO_MILK
            coffeeBeansInMachine -= CAPPUCCINO_BEANS
            cupsInMachine--
            moneyInMachine += CAPPUCCINO_PRICE
        }

        "back" -> return
        else -> return
    }
    return
}

fun processCoffeeChoice(choice: Int, coffeeData: MutableList<MutableList<Int>>) {
    for (data in coffeeData) {
        if (choice == data[0]) {
            when {
                waterInMachine < data[1] -> println("Sorry, not enough water!")
                milkInMachine < data[2] -> println("Sorry, not enough milk!")
                coffeeBeansInMachine < data[3] -> println("Sorry, not enough coffee beans!")
                cupsInMachine < 1 -> println("Sorry, no cups!")
                else -> {
                    waterInMachine -= data[1]
                    milkInMachine -= data[2]
                    coffeeBeansInMachine -= data[3]
                    cupsInMachine--
                    moneyInMachine += data[4]
                    println("I have enough resources, making you a coffee!")
                }
            }
        }
    }
}