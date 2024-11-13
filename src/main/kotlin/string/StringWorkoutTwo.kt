package string

// Return the length of the last word in the string
fun main() {
    val word = "How are you?"
    println("The length of last word in '$word' is: ${lengthOfLastWord(word)}")
}

private fun lengthOfLastWord(s: String): Int =
    s
        .trim()
        .split(" ")
        .last()
        .length
