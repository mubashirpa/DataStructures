package three.heap

import two.sorting.swapAt

private fun leftChildIndex(index: Int) = (2 * index) + 1

private fun rightChildIndex(index: Int) = (2 * index) + 2

private fun <T : Any> Array<T>.siftDown(
    index: Int,
    upTo: Int,
    comparator: Comparator<T>,
) {
    var parent = index
    while (true) {
        val left = leftChildIndex(parent)
        val right = rightChildIndex(parent)
        var candidate = parent
        if (left < upTo && comparator.compare(this[left], this[candidate]) > 0) {
            candidate = left
        }
        if (right < upTo &&
            comparator.compare(this[right], this[candidate]) > 0
        ) {
            candidate = right
        }
        if (candidate == parent) {
            return
        }
        swapAt(parent, candidate)
        parent = candidate
    }
}

private fun <T : Any> Array<T>.heapify(comparator: Comparator<T>) {
    if (isNotEmpty()) {
        (size / 2 downTo 0).forEach {
            siftDown(it, size, comparator)
        }
    }
}

fun <T : Any> Array<T>.heapSort(comparator: Comparator<T>) {
    heapify(comparator)
    for (index in indices.reversed()) {
        swapAt(0, index)
        siftDown(0, index, comparator)
    }
}
