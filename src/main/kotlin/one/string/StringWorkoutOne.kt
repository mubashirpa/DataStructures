package one.string

fun main() {
    println("Replaced string: ${replace("hello", 5)}")
}

fun replace(
    s: String,
    n: Int,
): String {
    val small = ('a'..'z').toList()
    val caps = ('A'..'Z').toList()
    val result = StringBuilder()

    s.forEach {
        when (it) {
            in small -> {
                val index = (it - 'a' + n) % 26
                result.append(small[index])
            }

            in caps -> {
                val index = (it - 'A' + n) % 26
                result.append(caps[index])
            }

            else -> result.append(it)
        }
    }

    return result.toString()
}
