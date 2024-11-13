package search

fun IntArray.binarySearch(target: Int): Int {
    var left = 0
    var right = lastIndex

    while (left <= right) {
        val mid = left + (right - left) / 2

        when {
            this[mid] == target -> return mid
            this[mid] < target -> left = mid + 1
            else -> right = mid - 1
        }
    }

    return -1
}

fun IntArray.binarySearch(
    target: Int,
    left: Int,
    right: Int,
): Int {
    if (left <= right) {
        val mid = left + (right - left) / 2

        return when {
            this[mid] == target -> mid
            this[mid] < target -> binarySearch(target, mid + 1, right)
            else -> binarySearch(target, left, mid - 1)
        }
    }

    return -1
}
