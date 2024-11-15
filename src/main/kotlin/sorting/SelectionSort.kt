package sorting

fun IntArray.selectionSort() {
    if (size < 2) return

    for (i in 0..<lastIndex) {
        var lowest = i

        for (j in (i + 1)..lastIndex) {
            if (this[j] < this[lowest]) {
                lowest = j
            }
        }

        if (lowest != i) {
            swapAt(lowest, i)
        }
    }
}
