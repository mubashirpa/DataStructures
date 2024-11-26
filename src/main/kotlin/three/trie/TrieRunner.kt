package three.trie

fun main() {
    trieInsertSample()
}

private fun trieInsertSample() {
    val trie = Trie<Char>()
    trie.insert("hello world".toList())
    if (trie.contains("hello world".toList())) {
        println("\"hello world\" is in the trie")
    }
}

private fun trieContainsSample() {
    val trie = Trie<Char>()
    trie.insert("cut")
    trie.insert("cute")
    assert(trie.contains("cut"))
    println("\"cut\" is in the trie")
    assert(trie.contains("cute"))
    println("\"cute\" is in the trie")
}

private fun trieRemoveSample() {
    val trie = Trie<Char>()
    trie.insert("cut")
    trie.insert("cute")

    println("Before removing")
    assert(trie.contains("cut"))
    println("\"cut\" is in the trie")
    assert(trie.contains("cute"))
    println("\"cute\" is in the trie")

    println("After removing cut")
    trie.remove("cut")
    assert(!trie.contains("cut"))
    assert(trie.contains("cute"))
    println("\"cute\" is still in the trie")
}
