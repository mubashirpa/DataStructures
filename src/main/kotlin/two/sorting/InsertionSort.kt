package two.sorting

fun IntArray.insertionSort() {
    if (size < 2) return

    for (i in 1..lastIndex) {
        for (j in i downTo 1) {
            if (this[j] < this[j - 1]) {
                swapAt(j, j - 1)
            } else {
                break
            }
        }
    }
}

fun Array<String>.insertionSort() {
    if (size < 2) return

    for (i in 1..lastIndex) {
        for (j in i downTo 1) {
            if (this[j] < this[j - 1]) {
                swapAt(j, j - 1)
            } else {
                break
            }
        }
    }
}
