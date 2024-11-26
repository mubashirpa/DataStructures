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
}

fun Trie<Char>.insert(string: String) {
    insert(string.toList())
}

fun Trie<Char>.contains(string: String): Boolean = contains(string.toList())

fun Trie<Char>.remove(string: String) {
    remove(string.toList())
}
