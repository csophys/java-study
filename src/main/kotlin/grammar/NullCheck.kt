package grammar

/**
 * Created by csophys on 2018/1/3.
 */

fun main(args: Array<String>) {
    //函数入参不为null
    notNullParam("csophys")
    nullParam(null)

    //如果为null和非null的处理
    nullParam("csophys")
}

fun nullParam(nothing: String?) {
    val s = nothing

    //java 语法
    if (s == null) {
        println("null")
    }else{
        println("not null")
    }
}

fun notNullParam(s: String) {
    println(s)
}

