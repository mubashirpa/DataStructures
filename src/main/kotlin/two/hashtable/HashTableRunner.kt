package two.hashtable

fun main() {
    val hashTable = HashTable<Int, String>(5)
    hashTable[0] = "Zero"
    hashTable[1] = "One"
    hashTable[2] = "Two"
    hashTable[3] = "Three"
    hashTable[4] = "Four"
    println(hashTable)

    println("Get Value for '0': ${hashTable[0]}")
    println("Get Value for '4': ${hashTable[4]}")

    println("Removing '2': ${hashTable.remove(2)}")
    println(hashTable)

    println("Removing '5': ${hashTable.remove(5)}")
}
