package one.search

fun IntArray.linearSearch(target: Int): Int {
    for (i in indices) {
        if (this[i] == target) {
            return i
        }
    }
    return -1
}
