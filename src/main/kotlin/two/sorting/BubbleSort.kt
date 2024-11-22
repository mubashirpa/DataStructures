package two.sorting

fun IntArray.bubbleSort() {
    if (size < 2) return

    for (i in lastIndex downTo 1) {
        var swapped = false

        for (j in 0..<i) {
            if (this[j] > this[j + 1]) {
                swapAt(j, j + 1)
                swapped = true
            }
        }

        if (!swapped) break
    }
}

fun Array<String>.bubbleSort() {
    if (size < 2) return

    for (i in lastIndex downTo 1) {
        var swapped = false

        for (j in 0..<i) {
            if (this[j] > this[j + 1]) {
                swapAt(j, j + 1)
                swapped = true
            }
        }

        if (!swapped) break
    }
}
