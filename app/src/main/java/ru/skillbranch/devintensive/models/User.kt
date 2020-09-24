package ru.skillbranch.devintensive.models

import java.util.*

data class User (
    val id : String,
    var firstName : String?,
    var lastName : String?,
    var avatar : String?,
    var rating : Int = 0,
    var respect : Int = 0,
    var lastVisit : Date? = Date(),
    var isOnline : Boolean = false
)  {

    constructor(id: String, firstName: String?, lastName: String?) : this(
        id = id,
        firstName = firstName,
        lastName = lastName,
        avatar = null
    )

    init {
        println(this)
    }

    companion object Factory {
        private var lastId = -1
        fun makeUser(fullName : String?) : User{
            lastId++

            val parts : List<String>? = fullName?.split(" ");
            val lastName = parts?.getOrNull(1)
            val firstName = parts?.getOrNull(0)
            return User(id = "$lastId", lastName = lastName, firstName = firstName)
        }
    }

}