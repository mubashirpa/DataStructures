package three.graph

data class Edge<T : Any>(
    val source: Vertex<T>,
    val destination: Vertex<T>,
    val weight: Double?,
)
