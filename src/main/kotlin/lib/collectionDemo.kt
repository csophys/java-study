package lib

import java.util.*


/**
 * Created by csophys on 2018/1/7.
 */

fun main(args: Array<String>) {
    val listOf = listOf(1, 5, 2)
    Collections.sort(listOf, { x, y -> y - x })
    println(listOf)

    val iterator = listOf.iterator()
    if (iterator.hasNext()) {
        println(iterator.next())
    }


}