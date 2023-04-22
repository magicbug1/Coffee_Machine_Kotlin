const val HOURS_PER_DAY = 24
const val MINUTES_PER_HOUR = 60
const val SECONDS_PER_MINUTE = 60
const val SECONDS_PER_DAY = HOURS_PER_DAY * MINUTES_PER_HOUR * SECONDS_PER_MINUTE

fun main() {
    val totalSeconds = System.currentTimeMillis() / 1000 // do not change this line
    val seconds = totalSeconds % SECONDS_PER_MINUTE
    val minutes = totalSeconds % (MINUTES_PER_HOUR * SECONDS_PER_MINUTE) / SECONDS_PER_MINUTE
    val hours   = totalSeconds % SECONDS_PER_DAY / (SECONDS_PER_MINUTE * MINUTES_PER_HOUR)
    println("$hours:$minutes:$seconds")
}
