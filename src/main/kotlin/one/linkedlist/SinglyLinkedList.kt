package one.linkedlist

class SinglyLinkedList<T : Any>() {
    constructor(array: Array<T>) : this() {
        array.forEach {
            append(it)
        }
    }

    private var head: one.linkedlist.SinglyNode<T>? = null
    private var tail: one.linkedlist.SinglyNode<T>? = null
    var size = 0

    fun isEmpty() = size == 0

    fun first() = head

    fun last() = tail

    fun push(value: T): one.linkedlist.SinglyLinkedList<T> =
        apply {
            val newNode = one.linkedlist.SinglyNode(value = value, next = head)
            head = newNode
            if (tail == null) tail = newNode
            size++
        }

    fun append(value: T): one.linkedlist.SinglyLinkedList<T> =
        apply {
            if (isEmpty()) {
                push(value)
            } else {
                val newNode = one.linkedlist.SinglyNode(value = value)
                tail?.next = newNode
                tail = newNode
                size++
            }
        }

    fun nodeAt(index: Int): one.linkedlist.SinglyNode<T>? {
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
        node: one.linkedlist.SinglyNode<T>,
    ): one.linkedlist.SinglyLinkedList<T> =
        apply {
            if (node == tail) {
                append(value)
                return@apply
            }
            val newNode = one.linkedlist.SinglyNode(value = value, next = node.next)
            node.next = newNode
            size++
        }

    fun insertBefore(
        value: T,
        node: one.linkedlist.SinglyNode<T>,
    ): one.linkedlist.SinglyLinkedList<T> =
        apply {
            if (node == head) {
                push(value)
                return@apply
            }

            var prev = head
            var current = head

            while (current != null && current != node) {
                prev = current
                current = current.next
            }

            if (current == node) {
                val newNode = one.linkedlist.SinglyNode(value = value, next = node)
                prev?.next = newNode
                size++
            }
        }

    fun popFirst(): T? {
        if (isEmpty()) return null

        return head?.let {
            head = it.next
            size--
            if (isEmpty()) tail = null
            it.value
        }
    }

    fun popLast(): T? {
        if (isEmpty()) return null
        if (size == 1) return popFirst()

        var prev = head!!
        var current = head!!
        var next = current.next

        while (next != null) {
            prev = current
            current = next
            next = current.next
        }

        prev.next = null
        size--
        tail = prev
        return current.value
    }

    fun remove(value: T): T? =
        when {
            isEmpty() -> null

            head?.value == value -> popFirst()

            tail?.value == value -> popLast()

            else -> {
                var prev = head!!
                var current = head

                while (current != null && current.value != value) {
                    prev = current
                    current = current.next
                }

                current?.let {
                    prev.next = current.next
                    size--
                    current.value
                }
            }
        }

    override fun toString(): String = if (isEmpty()) "Empty list" else head.toString()

    fun printInReverse() {
        head?.printInReverse()
    }

    fun removeDuplicates(): one.linkedlist.SinglyLinkedList<T> =
        apply {
            if (isEmpty()) return@apply

            var current = head

            while (current?.next != null) {
                if (current.value == current.next?.value) {
                    current.next = current.next?.next
                    size--
                    if (current.next == null) tail = current
                } else {
                    current = current.next
                }
            }
        }
}
