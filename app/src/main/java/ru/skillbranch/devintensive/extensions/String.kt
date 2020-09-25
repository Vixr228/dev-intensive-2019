package ru.skillbranch.devintensive.extensions

import java.text.SimpleDateFormat
import java.util.*

fun String.truncate(size: Int = 16) : String {

    var string = this
    var resultString: String

    resultString = string
    while(resultString[resultString.length - 1].equals(' ')) resultString = resultString.substring(0, resultString.length - 1)
    if(resultString.length < size) return resultString

    resultString = string.substring(0, size)
    while(resultString[resultString.length - 1].equals(' ')) resultString = resultString.substring(0, resultString.length - 1)
    if(string.length > size) resultString += "..."

    return resultString
}

fun String.stripHTML(){
    TODO("сделать")
}