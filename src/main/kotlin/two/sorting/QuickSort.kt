package two.sorting

fun IntArray.quickSort(
    low: Int = 0,
    high: Int = lastIndex,
) {
    if (this.size < 2) return

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

fun Array<String>.quickSort(
    low: Int = 0,
    high: Int = lastIndex,
) {
    if (this.size < 2) return

    if (low < high) {
        val pivotIndex = partition(low, high)
        quickSort(low, pivotIndex - 1)
        quickSort(pivotIndex + 1, high)
    }
}

private fun Array<String>.partition(
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
