package three.heap

import java.util.*
import kotlin.collections.ArrayList

class MaxHeap<T : Comparable<T>>(
    list: ArrayList<T> = arrayListOf(),
) {
    private val elements: ArrayList<T> = arrayListOf()

    val count: Int
        get() = elements.size

    val isEmpty: Boolean
        get() = elements.isEmpty()

    init {
        heapify(list)
    }

    fun peek(): T? = elements.firstOrNull()

    fun insert(element: T) {
        elements.add(element)
        shiftUp(count - 1)
    }

    fun remove(): T? {
        if (isEmpty) return null
        Collections.swap(elements, 0, count - 1)
        val item = elements.removeAt(count - 1)
        shiftDown(0)
        return item
    }

    fun remove(index: Int): T? {
        if (index >= count) return null
        return if (index == count - 1) {
            elements.removeAt(count - 1)
        } else {
            Collections.swap(elements, index, count - 1)
            val item = elements.removeAt(count - 1)
            shiftDown(index)
            shiftUp(index)
            item
        }
    }

    private fun heapify(values: ArrayList<T>) {
        elements.clear()
        elements.addAll(values)
        for (index in count / 2 downTo 0) {
            shiftDown(index)
        }
    }

    private fun leftChildIndex(index: Int) = (2 * index) + 1

    private fun rightChildIndex(index: Int) = (2 * index) + 2

    private fun parentIndex(index: Int) = (index - 1) / 2

    private fun shiftUp(index: Int) {
        var child = index
        var parent = parentIndex(child)
        while (child > 0 && elements[child] > elements[parent]) {
            Collections.swap(elements, child, parent)
            child = parent
            parent = parentIndex(child)
        }
    }

    private fun shiftDown(index: Int) {
        var parent = index
        while (true) {
            val left = leftChildIndex(parent)
            val right = rightChildIndex(parent)
            var largest = parent

            if (left < count && elements[left] > elements[largest]) {
                largest = left
            }
            if (right < count && elements[right] > elements[largest]) {
                largest = right
            }
            if (largest == parent) break
            Collections.swap(elements, parent, largest)
            parent = largest
        }
    }

    override fun toString(): String = elements.joinToString()
}
