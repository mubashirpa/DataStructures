package search

fun main() {
    findLastOccurrence(2)
}

fun findTargetLinear(target: Int) {
    val array = intArrayOf(3, 5, 1, 9, 2)
    println("Number $target found at position: ${array.linearSearch(target)}")
}

fun countOccurrences(target: Int) {
    val array = intArrayOf(2, 4, 2, 5, 2, 6)
    var count = 0

    array.forEach {
        if (it == target) {
            count++
        }
    }

    println("$target is present $count times")
}

fun findMinValue() {
    val array = intArrayOf(7, 3, 9, 1, 6)
    var min = array.first()

    for (i in 1..array.lastIndex) {
        if (array[i] < min) {
            min = array[i]
        }
    }

    println("Min value in the array is: $min")
}

fun findTargetBinary(target: Int) {
    val array = intArrayOf(1, 3, 5, 7, 9)
    println("Number $target found at position: ${array.linearSearch(target)}")
}

fun findFirstOccurrence(target: Int) {
    val array = intArrayOf(1, 2, 2, 2, 3, 4)
    var left = 0
    var right = array.lastIndex

    var firstOccurrence = -1

    while (left <= right) {
        val mid = left + (right - left) / 2

        when {
            array[mid] == target -> {
                firstOccurrence = mid
                right = mid - 1
            }

            array[mid] < target -> left = mid + 1

            else -> right = mid - 1
        }
    }

    println("First occurrence of $target is at: $firstOccurrence")
}

fun findLastOccurrence(target: Int) {
    val array = intArrayOf(1, 2, 2, 2, 3, 4)
    var left = 0
    var right = array.lastIndex

    var firstOccurrence = -1

    while (left <= right) {
        val mid = left + (right - left) / 2

        when {
            array[mid] == target -> {
                firstOccurrence = mid
                left = mid + 1
            }

            array[mid] < target -> left = mid + 1

            else -> right = mid - 1
        }
    }

    println("First occurrence of $target is at: $firstOccurrence")
}
