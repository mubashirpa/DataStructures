package two.sorting

fun IntArray.swapAt(
    first: Int,
    second: Int,
) {
    val temp = this[first]
    this[first] = this[second]
    this[second] = temp
}

fun <T : Any> Array<T>.swapAt(
    first: Int,
    second: Int,
) {
    val temp = this[first]
    this[first] = this[second]
    this[second] = temp
}
