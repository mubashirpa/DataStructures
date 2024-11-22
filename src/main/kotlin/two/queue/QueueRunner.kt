package two.queue

fun main() {
    val queue =
        QueueImpl<String>().apply {
            enqueue("Ray")
            enqueue("Brian")
            enqueue("Eric")
        }
    println(queue)
    queue.dequeue()
    println(queue)
    println("Next up: ${queue.peek()}")
}
