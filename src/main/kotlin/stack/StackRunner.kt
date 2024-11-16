package stack

fun main() {
    val stack =
        StackImpl<Int>().apply {
            push(0)
            push(1)
            push(2)
            push(3)
            push(4)
        }
    print(stack)
    val poppedElement = stack.pop()
    if (poppedElement != null) {
        println("Popped: $poppedElement")
    }
    print(stack)
}
