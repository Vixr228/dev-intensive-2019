package ru.skillbranch.devintensive.utils

object Utils {


   const  val CYRILLIC_TO_LATIN = "Cyrillic-Latin"

    fun parseFullName(fullName : String?) : Pair<String?, String?>{
        val parts : List<String>? = fullName?.split(" ");

        if(fullName == " " || fullName == null || fullName == "") return Pair(null, null)
        val lastName = parts?.getOrNull(1)
        val firstName = parts?.getOrNull(0)
        return Pair(firstName, lastName)
    }

    fun toInitials(firstName: String?, lastName: String?) : String? {

        if(firstName == null && lastName == null) return null
        if(firstName == " " && lastName == " ") return null

        val first: String? = firstName?.substring(0, 1)
        val last: String? = lastName?.substring(0, 1)

        if(last == null) return first
        if(first == null) return last

        return (first + last)

    }

    fun toLatyan(letter: Char?) : String?{
        when(letter){
            'а' -> return "a"
            'А' -> return "A"
            'б' -> return "b"
            'Б' -> return "B"
            'в' -> return "v"
            'В' -> return "V"
            'г' -> return "g"
            'Г' -> return "G"
            'д' -> return "d"
            'Д' -> return "D"
            'е' -> return "e"
            'Е' -> return "E"
            'ж' -> return "zh"
            'Ж' -> return "Zh"
            'з' -> return "z"
            'З' -> return "Z"
            'и' -> return "i"
            'И' -> return "I"
            'й' -> return "i"
            'Й' -> return "I"
            'к' -> return "k"
            'К' -> return "K"
            'л' -> return "l"
            'Л' -> return "L"
            'м' -> return "m"
            'М' -> return "M"
            'н' -> return "n"
            'Н' -> return "N"
            'о' -> return "o"
            'О' -> return "O"
            'п' -> return "p"
            'П' -> return "P"
            'р' -> return "r"
            'Р' -> return "R"
            'с' -> return "s"
            'С' -> return "S"
            'т' -> return "t"
            'Т' -> return "T"
            'у' -> return "u"
            'Г' -> return "U"
            'ф' -> return "f"
            'Ф' -> return "F"
            'х' -> return "h"
            'Х' -> return "H"
            'ц' -> return "c"
            'Ц' -> return "C"
            'ч' -> return "ch"
            'Ч' -> return "Ch"
            'ш' -> return "sh"
            'Ш' -> return "Sh"
            'щ' -> return "shh"
            'Щ' -> return "Sh"
            'ы' -> return "i"
            'Ы' -> return "I"
            'э' -> return "e"
            'Э' -> return "E"
            'ю' -> return "yu"
            'Ю' -> return "Yu"
            'я' -> return "ya"
            'Я' -> return "Ya"
            'ь' -> return ""
            'ъ' -> return ""
            else -> return letter.toString()
        }
    }
    fun transliteration(payload: String, divider: String? = " ") : String?{
        var newText: String = ""

        for(char in payload) {
            if (char.equals(' ')) newText += divider
            else newText += toLatyan(char)
        }
        return newText

    }
}