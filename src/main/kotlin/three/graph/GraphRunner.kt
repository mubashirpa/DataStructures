package three.graph

fun main() {
    val graph = AdjacencyList<String>()
    val singapore = graph.createVertex("Singapore")
    val tokyo = graph.createVertex("Tokyo")
    val hongKong = graph.createVertex("Hong Kong")
    val detroit = graph.createVertex("Detroit")
    val sanFrancisco = graph.createVertex("San Francisco")
    val washingtonDC = graph.createVertex("Washington DC")
    val austinTexas = graph.createVertex("Austin Texas")
    val seattle = graph.createVertex("Seattle")

    graph.add(EdgeType.UNDIRECTED, singapore, hongKong, 300.0)
    graph.add(EdgeType.UNDIRECTED, singapore, tokyo, 500.0)
    graph.add(EdgeType.UNDIRECTED, hongKong, tokyo, 250.0)
    graph.add(EdgeType.UNDIRECTED, tokyo, detroit, 450.0)
    graph.add(EdgeType.UNDIRECTED, tokyo, washingtonDC, 300.0)
    graph.add(EdgeType.UNDIRECTED, hongKong, sanFrancisco, 600.0)
    graph.add(EdgeType.UNDIRECTED, detroit, austinTexas, 50.0)
    graph.add(EdgeType.UNDIRECTED, austinTexas, washingtonDC, 292.0)
    graph.add(EdgeType.UNDIRECTED, sanFrancisco, washingtonDC, 337.0)
    graph.add(EdgeType.UNDIRECTED, washingtonDC, seattle, 277.0)
    graph.add(EdgeType.UNDIRECTED, sanFrancisco, seattle, 218.0)
    graph.add(EdgeType.UNDIRECTED, austinTexas, sanFrancisco, 297.0)

    println(graph)
}

private fun graphBFS(
    graph: AdjacencyList<String>,
    source: Vertex<String>,
) {
    println("Breadth First Search: ${source.data}")
    val vertices = graph.breadthFirstSearch(source)
    vertices.forEach {
        println(it.data)
    }
}

private fun graphDFS(
    graph: AdjacencyList<String>,
    source: Vertex<String>,
) {
    println("Depth First Search: ${source.data}")
    val vertices = graph.depthFirstSearch(source)
    vertices.forEach {
        println(it.data)
    }
}
