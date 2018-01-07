package lib

/**
 * Created by csophys on 2018/1/3.
 */

fun main(args: Array<String>) {
    //集合类字符的组装
    val list = listOf(1, 5, 4)
    println(list.joinToString(separator = "&"))

    //集合类的匿名函数操作 any
    println(list.any { it == 5 })

    //集合类的匿名函数操作 map，简写
    println(list.map { it + 2 })

    //集合类的lambda操作。
    println(list.map { x -> x - 2 })

}