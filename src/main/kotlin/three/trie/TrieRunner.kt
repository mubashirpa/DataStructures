package three.trie

fun main() {
    trieRemoveSample()
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

private fun trieAutoCompleteSample() {
    val trie =
        Trie<Char>().apply {
            insert("car")
            insert("card")
            insert("care")
            insert("cared")
            insert("cars")
            insert("carbs")
            insert("carapace")
            insert("cargo")
        }

    println("\nCollections starting with \"car\"")
    val prefixedWithCar = trie.collections("car")
    println(prefixedWithCar)

    println("\nCollections starting with \"care\"")
    val prefixedWithCare = trie.collections("care")
    println(prefixedWithCare)
}
