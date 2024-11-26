package three.graph

class AdjacencyList<T : Any> : Graph<T> {
    private val adjacencies: HashMap<Vertex<T>, ArrayList<Edge<T>>> = hashMapOf()

    override fun createVertex(data: T): Vertex<T> {
        val vertex = Vertex(adjacencies.size, data)
        adjacencies[vertex] = arrayListOf()
        return vertex
    }

    override fun addDirectedEdge(
        source: Vertex<T>,
        destination: Vertex<T>,
        weight: Double?,
    ) {
        val edge = Edge(source, destination, weight)
        adjacencies[source]?.add(edge)
    }

    override fun addUnDirectedEdge(
        source: Vertex<T>,
        destination: Vertex<T>,
        weight: Double?,
    ) {
        addDirectedEdge(source, destination, weight)
        addDirectedEdge(destination, source, weight)
    }

    override fun add(
        type: EdgeType,
        source: Vertex<T>,
        destination: Vertex<T>,
        weight: Double?,
    ) {
        when (type) {
            EdgeType.DIRECTED -> addDirectedEdge(source, destination, weight)
            EdgeType.UNDIRECTED -> addUnDirectedEdge(source, destination, weight)
        }
    }

    override fun edges(source: Vertex<T>): ArrayList<Edge<T>> = adjacencies[source] ?: arrayListOf()

    override fun weight(
        source: Vertex<T>,
        destination: Vertex<T>,
    ): Double? = edges(source).firstOrNull { it.destination == destination }?.weight

    override fun toString(): String =
        buildString {
            adjacencies.forEach { (vertex, edges) ->
                val edgeString = edges.joinToString { it.destination.data.toString() }
                append("${vertex.data} ---> [ $edgeString ]\n")
            }
        }
}
