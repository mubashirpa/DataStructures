package stack

interface Stack<T : Any> {
    val count: Int

    val isEmpty: Boolean
        get() = count == 0

    fun push(element: T)

    fun pop(): T?

    fun peek(): T?
}
