package two.sorting

fun main() {
    val array = intArrayOf(4, 8, 2, 9, 8, 4, 6, 3, 2)
    array.quickSort(0, array.lastIndex)
    println(array.joinToString())
}
