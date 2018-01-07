@file:Suppress("VARIABLE_WITH_REDUNDANT_INITIALIZER")

package grammar

/**
 * Created by csophys on 2018/1/1.
 */

fun main(args: Array<String>) {
    println("hello world,kotlin")
    val i = 4
    var i1 = 5
    i1 = 6
    funStrFormat(i, i1)
    funStrWithNoResult()
    funStrWithNoResult1()
    println(funWithTypeRefer(3, i))


}



fun funWithTypeRefer(i: Int, i1: Int) = i + i1


fun funStrWithNoResult1() = Unit

fun funStrWithNoResult(): Unit {
}


fun funStrFormat(i: Int, i1: Int) {
    println("$i,$i1,hello world")
}
