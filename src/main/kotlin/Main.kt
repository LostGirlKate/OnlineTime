const val SECONDS_IN_MINUTE = 60
const val SECONDS_IN_HOUR = 60 * 60
const val HOURS_IN_DAY = 24

fun main() {
    println(agoToText(5))
    println(agoToText(145))
    println(agoToText(300))
    println(agoToText(800))
    println(agoToText(3700))
    println(agoToText(7700))
    println(agoToText(29388))
    println(agoToText(99380))
    println(agoToText(199380))
    println(agoToText(2938800))
}

fun agoToText(timeInSeconds: Int): String {
    var resultString = "был(а) "
    resultString += when (timeInSeconds) {
        in 0..SECONDS_IN_MINUTE -> "только что"
        in SECONDS_IN_MINUTE + 1..SECONDS_IN_HOUR -> "${minuteText(timeInSeconds)} назад"
        in SECONDS_IN_HOUR + 1..HOURS_IN_DAY * SECONDS_IN_HOUR -> "${hourText(timeInSeconds)} назад"
        in HOURS_IN_DAY * SECONDS_IN_HOUR + 1..HOURS_IN_DAY * SECONDS_IN_HOUR * 2 -> "вчера"
        in HOURS_IN_DAY * SECONDS_IN_HOUR * 2 + 1..HOURS_IN_DAY * SECONDS_IN_HOUR * 3 -> "позавчера"
        else -> "давно"
    }
    return resultString
}

fun minuteText(timeInSeconds: Int): String {
    val resultMinuteStr = when (val timeInMinute = timeInSeconds / SECONDS_IN_MINUTE) {
        1, 21, 31, 41, 51 -> "$timeInMinute минуту"
        2, 22, 32, 42, 52 -> "$timeInMinute минуты"
        3, 23, 33, 43, 53 -> "$timeInMinute минуты"
        4, 24, 34, 44, 54 -> "$timeInMinute минуты"
        else -> "$timeInMinute минут"
    }
    return resultMinuteStr
}

fun hourText(timeInSeconds: Int): String {
    val resultMinuteStr = when (val timeInHour = timeInSeconds / SECONDS_IN_HOUR) {
        1, 21 -> "$timeInHour час"
        2, 3, 4, 22, 23, 24 -> "$timeInHour часа"
        else -> "$timeInHour часов"
    }
    return resultMinuteStr
}