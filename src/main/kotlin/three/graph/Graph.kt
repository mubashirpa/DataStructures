package three.graph

import two.queue.QueueImpl
import two.stack.StackImpl

interface Graph<T : Any> {
    fun createVertex(data: T): Vertex<T>

    fun addDirectedEdge(
        source: Vertex<T>,
        destination: Vertex<T>,
        weight: Double?,
    )

    fun addUnDirectedEdge(
        source: Vertex<T>,
        destination: Vertex<T>,
        weight: Double?,
    )

    fun add(
        type: EdgeType,
        source: Vertex<T>,
        destination: Vertex<T>,
        weight: Double?,
    )

    fun edges(source: Vertex<T>): ArrayList<Edge<T>>

    fun weight(
        source: Vertex<T>,
        destination: Vertex<T>,
    ): Double?

    fun breadthFirstSearch(source: Vertex<T>): ArrayList<Vertex<T>> {
        val queue = QueueImpl<Vertex<T>>()
        val enqueued = mutableSetOf<Vertex<T>>()
        val visited = ArrayList<Vertex<T>>()

        queue.enqueue(source)
        enqueued.add(source)
        while (true) {
            val vertex = queue.dequeue() ?: break
            visited.add(vertex)
            val neighborEdges = edges(vertex)
            neighborEdges.forEach {
                if (!enqueued.contains(it.destination)) {
                    queue.enqueue(it.destination)
                    enqueued.add(it.destination)
                }
            }
        }

        return visited
    }

    fun depthFirstSearch(source: Vertex<T>): ArrayList<Vertex<T>> {
        val stack = StackImpl<Vertex<T>>()
        val visited = arrayListOf<Vertex<T>>()
        val pushed = mutableSetOf<Vertex<T>>()
        stack.push(source)
        pushed.add(source)
        visited.add(source)

        outer@ while (true) {
            if (stack.isEmpty) break
            val vertex = stack.peek()!!
            val neighbors = edges(vertex)
            if (neighbors.isEmpty()) {
                stack.pop()
                continue
            }
            for (i in 0 until neighbors.size) {
                val destination = neighbors[i].destination
                if (destination !in pushed) {
                    stack.push(destination)
                    pushed.add(destination)
                    visited.add(destination)
                    continue@outer
                }
            }
            stack.pop()
        }

        return visited
    }
}

enum class EdgeType {
    DIRECTED,
    UNDIRECTED,
}
