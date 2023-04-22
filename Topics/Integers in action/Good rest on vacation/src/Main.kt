@Suppress("MagicNumber")
fun main() {
    val duration = readln().toInt()
    val foodCostPerDay = readln().toInt()
    val oneWayFlight = readln().toInt()
    val hotelCostPerNight = readln().toInt()
    val totalCost = foodCostPerDay * duration + oneWayFlight * 2 + hotelCostPerNight * (duration - 1)
    println(totalCost)
}
