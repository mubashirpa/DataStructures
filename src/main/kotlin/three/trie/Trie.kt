package three.trie

class Trie<K : Any> {
    private val root: TrieNode<K> = TrieNode(key = null, parent = null)

    fun insert(list: List<K>) {
        var current = root
        list.forEach { element ->
            val child = current.children[element] ?: TrieNode(key = element, parent = current)
            current.children[element] = child
            current = child
        }
        current.isTerminating = true
    }

    fun contains(list: List<K>): Boolean {
        var current = root
        list.forEach { element ->
            val child = current.children[element] ?: return false
            current = child
        }
        return current.isTerminating
    }

    fun remove(list: List<K>) {
        var current = root
        list.forEach { element ->
            val child = current.children[element] ?: return
            current = child
        }

        if (!current.isTerminating) return
        current.isTerminating = false

        val parent = current.parent
        while (parent != null && current.children.isEmpty() && !current.isTerminating) {
            parent.children.remove(current.key)
            current = parent
        }
    }

    fun collections(prefix: List<K>): List<List<K>> {
        var current = root
        prefix.forEach { element ->
            val child = current.children[element] ?: return emptyList()
            current = child
        }

        return collections(prefix, current)
    }

    private fun collections(
        prefix: List<K>,
        node: TrieNode<K>,
    ): List<List<K>> {
        val results = mutableListOf<List<K>>()

        if (node.isTerminating) {
            results.add(prefix)
        }

        node.children.forEach { (key, node) ->
            results.addAll(collections(prefix + key, node))
        }

        return results
    }
}

fun Trie<Char>.insert(string: String) {
    insert(string.toList())
}

fun Trie<Char>.contains(string: String): Boolean = contains(string.toList())

fun Trie<Char>.remove(string: String) {
    remove(string.toList())
}

fun Trie<Char>.collections(prefix: String): List<String> = collections(prefix.toList()).map { it.joinToString(separator = "") }
