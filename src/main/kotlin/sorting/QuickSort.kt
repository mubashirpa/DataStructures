package sorting

fun IntArray.quickSort(
    low: Int = 0,
    high: Int = lastIndex,
) {
    if (low < high) {
        val pivotIndex = partition(low, high)
        quickSort(low, pivotIndex - 1)
        quickSort(pivotIndex + 1, high)
    }
}

private fun IntArray.partition(
    low: Int,
    high: Int,
): Int {
    val pivot = this[high]
    var i = low

    for (j in low..<high) {
        if (this[j] <= pivot) {
            swapAt(i++, j)
        }
    }

    swapAt(i, high)
    return i
}
