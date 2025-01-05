package two.hashtable

class HashTable<K, V>(
    private val size: Int,
) {
    private val table: Array<MutableList<Pair<K, V>>> = Array(size) { mutableListOf() }

    private fun hash(key: K): Int = key.hashCode() % size

    private fun K.bucket() = table[hash(this)]

    operator fun set(
        key: K,
        value: V,
    ) {
        val bucket = key.bucket()

        for (pair in bucket) {
            if (pair.first == key) {
                bucket.remove(pair)
                break
            }
        }

        bucket.add(Pair(key, value))
    }

    operator fun get(key: K): V? {
        val bucket = key.bucket()

        for (pair in bucket) {
            if (pair.first == key) {
                return pair.second
            }
        }

        return null
    }

    fun remove(key: K): Boolean {
        val bucket = key.bucket()

        val iterator = bucket.iterator()
        while (iterator.hasNext()) {
            if (iterator.next().first == key) {
                iterator.remove()
                return true
            }
        }

        return false
    }

    override fun toString(): String =
        buildString {
            table.forEachIndexed { index, bucket ->
                appendLine("Index $index: $bucket")
            }
        }
}
