package one.array

// Find duplicate elements in an array
fun main() {
    val array = arrayOf(45, 54, 21, 64, 21, 32, 45, 21)
    val duplicate = mutableSetOf<Int>()

    for (i in array.indices) {
        for (j in (i + 1)..array.lastIndex) {
            if (array[j] == array[i]) {
                duplicate.add(array[i])
            }
        }
    }

    println("Duplicate elements are: $duplicate")
}
