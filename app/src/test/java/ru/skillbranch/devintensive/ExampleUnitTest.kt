package ru.skillbranch.devintensive

import org.junit.Test

import org.junit.Assert.*
import ru.skillbranch.devintensive.extinsions.*
import ru.skillbranch.devintensive.models.*
import ru.skillbranch.devintensive.utils.Utils
import java.util.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }


    @Test
    fun test_factory(){
        val user = User.makeUser("John Wick")
        user.lastVisit = Date()
        println(user.lastVisit?.format("HH:mm"))
        println(user.lastVisit?.add(-2, TimeUnits.DAY))
        println(Date().add(-2, TimeUnits.HOUR))

    }


    @Test
    fun test_abstract_factory(){
        val user = User.makeUser("Jon Wick")
        val txtMessage = BaseMessage.makeMessage(user, Chat("0"), payload = "any text message", type = "text")
        val imgMessage = BaseMessage.makeMessage(user, Chat("0"), payload = "any image url", type = "image")

        when(imgMessage){
            is TextMessage -> println("txt");
            is ImageMessage -> println("img")
        }

        println(txtMessage.formatMessage())
    }

    @Test
    fun test_toInitials_fun(){
        println(Utils.toInitials("Jon", "Don"))
        println(Utils.toInitials("John", null))//J
        println(Utils.toInitials(null, null)) //null
        println(Utils.toInitials(" ", " ")) //null
    }

    @Test
    fun test_transliteration_fun(){
        println( Utils.transliteration("Женя Стереотипов")) //Zhenya Stereotipov
        println(Utils.transliteration("Amazing Петр","_"))
    }

    @Test
    fun test_truncate_fun(){
        println("Bender Bending Rodriguez — дословно «Сгибальщик Сгибающий Родригес»".truncate())
        println("Bender Bending Rodriguez — дословно «Сгибальщик Сгибающий Родригес»".truncate(15))
        println("A      ".truncate(3))
    }

    @Test
    fun test_humanizeDiff_fun(){
        println(Date())
        println(Date().add(-2, TimeUnits.HOUR).humanizeDiff()) //2 часа назад
        println(Date().add(-5, TimeUnits.DAY).humanizeDiff())//5 дней назад
        println(Date().add(2, TimeUnits.MINUTE).humanizeDiff()) //через 2 минуты
        println(Date().add(7, TimeUnits.DAY).humanizeDiff()) //через 7 дней
        println(Date().add(-400, TimeUnits.DAY).humanizeDiff()) //более года назад
        println(Date().add(400, TimeUnits.DAY).humanizeDiff()) //более чем через год
    }
}