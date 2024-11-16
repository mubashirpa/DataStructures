package stack

class StackImpl<T : Any> : Stack<T> {
    private var storage = arrayListOf<T>()

    override val count: Int
        get() = storage.size

    override fun push(element: T) {
        storage.add(element)
    }

    override fun pop(): T? = storage.removeLastOrNull()

    override fun peek(): T? = storage.lastOrNull()

    override fun toString(): String =
        buildString {
            appendLine("----top----")
            storage.reversed().forEach {
                appendLine(it)
            }
            appendLine("-----------")
        }
}

fun String.validParentheses(): Boolean {
    val stack = StackImpl<Char>()

    for (char in this) {
        when (char) {
            '(' -> stack.push(char)
            ')' -> {
                if (stack.isEmpty) {
                    return false
                } else {
                    stack.pop()
                }
            }
        }
    }

    return stack.isEmpty
}
