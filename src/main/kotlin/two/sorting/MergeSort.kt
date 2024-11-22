package two.sorting

fun IntArray.mergeSort(): IntArray {
    if (size < 2) return this

    val middle = size / 2
    val left = sliceArray(0..<middle)
    val right = sliceArray(middle..<size)

    return merge(left.mergeSort(), right.mergeSort())
}

private fun merge(
    left: IntArray,
    right: IntArray,
): IntArray {
    val result = IntArray(left.size + right.size)
    var i = 0 // Index for left array
    var j = 0 // Index for right array
    var k = 0 // Index for result array

    while (i < left.size && j < right.size) {
        result[k++] =
            if (left[i] <= right[j]) {
                left[i++]
            } else {
                right[j++]
            }
    }

    while (i < left.size) {
        result[k++] = left[i++]
    }

    while (j < right.size) {
        result[k++] = right[j++]
    }

    return result
}

fun Array<String>.mergeSort(): Array<String> {
    if (size < 2) return this

    val middle = size / 2
    val left = sliceArray(0..<middle)
    val right = sliceArray(middle..<size)

    return merge(left.mergeSort(), right.mergeSort())
}

private fun merge(
    left: Array<String>,
    right: Array<String>,
): Array<String> {
    val result = Array<String>(left.size + right.size) { "" }
    var i = 0 // Index for left array
    var j = 0 // Index for right array
    var k = 0 // Index for result array

    while (i < left.size && j < right.size) {
        result[k++] =
            if (left[i] <= right[j]) {
                left[i++]
            } else {
                right[j++]
            }
    }

    while (i < left.size) {
        result[k++] = left[i++]
    }

    while (j < right.size) {
        result[k++] = right[j++]
    }

    return result
}
