package three.heap

fun main() {
    heapSample()
}

private fun heapSample() {
    val array = arrayListOf(1, 12, 3, 4, 1, 6, 8, 7)
    val heap = MaxHeap(array)
    println("Heap: $heap")
}

private fun minHeapSample() {
    val array = arrayListOf(1, 12, 3, 4, 1, 6, 8, 7)
    val heap = MinHeap(array)
    println("Heap: $heap")
}

private fun heapPeekSample() {
    val array = arrayListOf(1, 12, 3, 4, 1, 6, 8, 7)
    val heap = MaxHeap(array)
    println("Root element: ${heap.peek()}")
}

private fun heapRemoveSample() {
    val array = arrayListOf(1, 12, 3, 4, 1, 6, 8, 7)
    val heap = MaxHeap(array)
    println("Removing elements:")
    while (!heap.isEmpty) {
        println(heap.remove())
    }
}

private fun heapSortSample() {
    val array = arrayOf(6, 12, 2, 26, 8, 18, 21, 9, 5)
    println("Unsorted Array: ${array.joinToString()}")
    array.heapSort { a, b -> a.compareTo(b) }
    println("Sorted Array (Ascending): ${array.joinToString()}")
}

private fun heapSortDescendingSample() {
    val array = arrayOf(6, 12, 2, 26, 8, 18, 21, 9, 5)
    println("Unsorted Array: ${array.joinToString()}")
    array.heapSort { a, b -> b.compareTo(a) }
    println("Sorted Array (Descending): ${array.joinToString()}")
}

private fun heapSortMaxNumberSample() {
    val array = arrayOf(6, 12, 2, 26, 8, 18, 21, 9, 5)
    println("Array: $array")
    array.heapSort { a, b -> a.compareTo(b) }
    print("Largest number in the array is: ${array.last()}")
}
