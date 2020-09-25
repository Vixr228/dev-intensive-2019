package ru.skillbranch.devintensive.utils

object Utils {

    fun parseFullName(fullName : String?) : Pair<String?, String?>{
        val parts : List<String>? = fullName?.split(" ");

        val lastName = parts?.getOrNull(1)
        val firstName = parts?.getOrNull(0)

        return Pair(firstName, lastName)
    }
}