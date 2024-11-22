package one.linkedlist

data class SinglyNode<T : Any>(
    var value: T,
    var next: SinglyNode<T>? = null,
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
