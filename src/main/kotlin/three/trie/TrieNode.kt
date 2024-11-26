package three.trie

class TrieNode<K : Any>(
    var key: K?,
    var parent: TrieNode<K>?,
) {
    val children: HashMap<K, TrieNode<K>> = HashMap()
    var isTerminating = false
}
