package sorting

fun IntArray.swapAt(
    first: Int,
    second: Int,
) {
    val temp = this[first]
    this[first] = this[second]
    this[second] = temp
}
