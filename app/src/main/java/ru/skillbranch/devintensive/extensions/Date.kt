package ru.skillbranch.devintensive.extensions

import java.lang.IllegalStateException
import java.text.SimpleDateFormat
import java.util.*

const val SECOND = 1000L
const val MINUTE = 60 * SECOND
const val HOUR = 60 * MINUTE
const val DAY = 24 * HOUR

fun Date.format(pattern: String = "HH:mm:ss dd.MM.yy") : String {
    val dateFormat = SimpleDateFormat(pattern, Locale("ru"))
    return dateFormat.format(this)
}


fun Date.add(value:Int, units: TimeUnits = TimeUnits.SECOND) : Date{

    var time = this.time

    time += when(units) {
        TimeUnits.SECOND -> value * SECOND
        TimeUnits.MINUTE -> value * MINUTE
        TimeUnits.HOUR -> value * HOUR
        TimeUnits.DAY -> value * DAY
        else -> throw IllegalStateException("invalid unit")
    }

    this.time = time
    return this
}

//fun Date.humanizeDiff() : String{
//    val dateCur = Date()
//    val dateAdd = this
//    val currSecond = dateCur.format("ss").toInt()
//    val currMin = dateCur.format("mm").toInt()
//    val currH = dateCur.format("HH").toInt()
//    val currDay = dateCur.format("dd").toInt()
//    val currMonth = dateCur.format("MM").toInt()
//    val currYear = dateCur.format("yy").toInt()
//
//    val addSecond = dateAdd.format("ss").toInt()
//    val addMin = dateAdd.format("mm").toInt()
//    val addH = dateAdd.format("HH").toInt()
//    val addDay = dateAdd.format("dd").toInt()
//    val addMonth = dateAdd.format("MM").toInt()
//    val addYear = dateAdd.format("yy").toInt()
//
//    //println("$currDay  $currMonth  $currYear    $currH  $currMin  $currSecond")
//
//    if(currYear == addYear) {
//       if(currMonth == addMonth){
//           if(currDay == addDay){
//               if(currH == addH){
//                   if(currMin == addMin){
//                       if(currSecond - addSecond in 0..1) return "только что"
//                       if(currSecond - addSecond in 2..45) return "несколько секунд назад"
//                       if(currSecond - addSecond in 46..59) return "минуту назад"
//                   }
//                   if(currSecond in 0..15) return "минуту назад"
//                   if(currMin - addMin in 16..45) return "${currMin - addMin} минут назад"
//                   if(currMin - addMin in 46..59) return "час назад"
//               }
//               if(currMin in 0..15) return "час назад"
//               if(currH - addH in 1..22) return "${currH - addH} часов назад"
//               if(currH - addH == 23) return "день назад"
//           }
//           if(currH in 0..2) return "день назад"
//           if(currDay - addDay in 1..31) return "${currDay - addDay} дней назад"
//       }
//       val temp = currMonth - addMonth
//        return "${temp * 30} дней назад"
//    }
//    else return "более года назад"
//        //    0с - 1с "только что"
// //    1с - 45с "несколько секунд назад"
// //    45с - 75с "минуту назад"
// //    75с - 45мин "N минут назад"
//  //    45мин - 75мин "час назад"
// //    75мин 22ч "N часов назад"
//  //    22ч - 26ч "день назад"
//  //    26ч - 360д "N дней назад"
// //    >360д "более года назад"
//
//    return dateCur.toString()
//}


enum class TimeUnits{
    SECOND,
    MINUTE,
    HOUR,
    DAY
}