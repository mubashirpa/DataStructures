package one.string

fun main() {
    val roman = "MCMXCIV"
    println("The value of $roman is ${romanToInt(roman)}")
}

fun romanToInt(s: String): Int {
    var num = 0

    val value =
        mapOf(
            'I' to 1,
            'V' to 5,
            'X' to 10,
            'L' to 50,
            'C' to 100,
            'D' to 500,
            'M' to 1000,
        )

    val newString =
        s
            .replace("IV", "IIII")
            .replace("IX", "VIIII")
            .replace("XL", "XXXX")
            .replace("XC", "LXXXX")
            .replace("CD", "CCCC")
            .replace("CM", "DCCCC")

    for (char in newString) {
        num += value[char] ?: 0
    }
    return num
}
