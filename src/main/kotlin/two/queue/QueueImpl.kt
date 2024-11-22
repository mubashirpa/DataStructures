package two.queue

class QueueImpl<T : Any> : Queue<T> {
    private val storage = arrayListOf<T>()

    override val count: Int
        get() = storage.size

    override fun enqueue(element: T): Boolean = storage.add(element)

    override fun dequeue(): T? = storage.removeFirstOrNull()

    override fun peek(): T? = storage.firstOrNull()

    override fun toString(): String = storage.joinToString()
}
