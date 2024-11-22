package one.linkedlist

data class DoublyNode<T : Any>(
    var value: T,
    var prev: DoublyNode<T>? = null,
    var next: DoublyNode<T>? = null,
) {
    override fun toString(): String =
        if (next != null) {
            "$value -> $next"
        } else {
            "$value"
        }

    fun printInReverse() {
        next?.printInReverse()

        if (next != null) {
            print(" <- ")
        }

        print("$value")
    }
}
