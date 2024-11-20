package hashtable

fun main() {
    val hashTable = HashTable<Int, String>(5)
    hashTable.put(0, "Zero")
    hashTable.put(1, "One")
    hashTable.put(2, "Two")
    hashTable.put(3, "Three")
    hashTable.put(4, "Four")
    println(hashTable)

    println("Get Value for '0': ${hashTable.get(0)}")
    println("Get Value for '4': ${hashTable.get(4)}")

    println("Removing '2': ${hashTable.remove(2)}")
    println(hashTable)

    println("Removing '5': ${hashTable.remove(5)}")
}
