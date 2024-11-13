package linkedlist

class DoublyLinkedList<T : Any>() {
    constructor(array: Array<T>) : this() {
        array.forEach {
            append(it)
        }
    }

    private var head: DoublyNode<T>? = null
    private var tail: DoublyNode<T>? = null
    var size = 0

    fun isEmpty() = size == 0

    fun first() = head

    fun last() = tail

    fun push(value: T): DoublyLinkedList<T> =
        apply {
            val newNode = DoublyNode(value = value, next = head)
            head?.prev = newNode
            head = newNode
            if (tail == null) tail = newNode
            size++
        }

    fun append(value: T): DoublyLinkedList<T> =
        apply {
            if (isEmpty()) {
                push(value)
            } else {
                val newNode = DoublyNode(value = value, prev = tail)
                tail?.next = newNode
                tail = newNode
                size++
            }
        }

    fun nodeAt(index: Int): DoublyNode<T>? {
        var currentNode = head
        var currentIndex = 0

        while (currentNode != null && currentIndex < index) {
            currentNode = currentNode.next
            currentIndex++
        }

        return currentNode
    }

    fun insertAfter(
        value: T,
        node: DoublyNode<T>,
    ): DoublyLinkedList<T> =
        apply {
            if (node == tail) {
                append(value)
                return@apply
            }
            val newNode = DoublyNode(value = value, prev = node, next = node.next)
            node.next?.prev = newNode
            node.next = newNode
            size++
        }

    fun insertBefore(
        value: T,
        node: DoublyNode<T>,
    ): DoublyLinkedList<T> =
        apply {
            if (node == head) {
                push(value)
                return@apply
            }
            val newNode = DoublyNode(value = value, prev = node.prev, next = node)
            node.prev?.next = newNode
            node.prev = newNode
            size++
        }

    fun popFirst(): T? {
        if (isEmpty()) return null

        return head?.let {
            it.next?.prev = null
            head = it.next
            size--
            if (isEmpty()) tail = null
            it.value
        }
    }

    fun popLast(): T? {
        if (isEmpty()) return null
        if (size == 1) return popFirst()

        return tail?.let {
            tail = it.prev
            tail?.next = null
            size--
            it.value
        }
    }

    fun remove(value: T): T? =
        when {
            isEmpty() -> null

            head?.value == value -> popFirst()

            tail?.value == value -> popLast()

            else -> {
                var current = head

                while (current != null && current.value != value) {
                    current = current.next
                }

                current?.let {
                    it.prev?.next = it.next
                    it.next?.prev = it.prev
                    size--
                    it.value
                }
            }
        }

    override fun toString(): String = if (isEmpty()) "Empty list" else head.toString()

    fun printInReverse() {
        head?.printInReverse()
    }
}
