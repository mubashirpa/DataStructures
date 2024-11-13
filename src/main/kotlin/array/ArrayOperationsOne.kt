package array

// Move all negative numbers to the beginning without sorting
fun main() {
    val array = arrayOf(1, 2, -3, 4, -5, -6, 7)
    var count = 0

    for (i in array.indices) {
        if (array[i] < 0) {
            val temp = array[count]
            array[count++] = array[i]
            array[i] = temp
        }
    }

    println("Result array: ${array.joinToString()}")
}
