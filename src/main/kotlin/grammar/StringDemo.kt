package grammar

/**
 * Created by csophys on 2018/1/4.
 */


fun main(args: Array<String>) {
    println(getPattern())
    println(getPatternStr())

}

val month = "(JAN|FEB)"

fun getPattern(): String = """\d{2} ${month} \d{4}"""

fun getPatternStr(): String = "\\d{2} \${month}  \\d{4}"