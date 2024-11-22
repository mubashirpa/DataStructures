package one.linkedlist

fun main() {
    arrayToLinkedList()
}

// Singly

private fun arrayToLinkedList() {
    val array = arrayOf(0, 1, 2, 3, 4, 5)
    val list = one.linkedlist.SinglyLinkedList(array)
    println(list)
}

private fun pushExample() {
    val list = one.linkedlist.SinglyLinkedList<Int>()
    list.push(3).push(2).push(1)
    println(list)
    list.printInReverse()
}

private fun appendExample() {
    val list = one.linkedlist.SinglyLinkedList<Int>()
    list.append(1).append(2).append(3)
    println(list)
}

private fun insertAfterExample() {
    val list = one.linkedlist.SinglyLinkedList<Int>()
    list.push(3).push(2).push(1)
    println("Before inserting: $list")

    val middleNode = list.nodeAt(1)!!
    list.insertAfter(-1, middleNode)

    println("After inserting: $list")
}

private fun insertBeforeExample() {
    val list = one.linkedlist.SinglyLinkedList<Int>()
    list.push(3).push(2).push(1)
    println("Before inserting: $list")

    val middleNode = list.nodeAt(1)!!
    list.insertBefore(-1, middleNode)

    println("After inserting: $list")
}

private fun popFirstExample() {
    val list = one.linkedlist.SinglyLinkedList<Int>()
    list.push(3).push(2).push(1)

    println("Before popping list: $list")
    val poppedValue = list.popFirst()
    println("After popping list: $list")
    println("Popped value: $poppedValue")
}

private fun popLastExample() {
    val list = one.linkedlist.SinglyLinkedList<Int>()
    list.push(3).push(2).push(1)

    println("Before removing last node: $list")
    val removedValue = list.popLast()

    println("After removing last node: $list")
    println("Removed value: $removedValue")
}

private fun removeExample() {
    val list = one.linkedlist.SinglyLinkedList<Int>()
    list.push(3).push(2).push(1)

    println("Before popping list: $list")
    val poppedValue = list.remove(2)
    println("After popping list: $list")
    println("Popped value: $poppedValue")
}

private fun removeDuplicatesExample() {
    val array = arrayOf(0, 1, 1, 2, 3, 4, 5, 5)
    val list = one.linkedlist.SinglyLinkedList(array)
    println("Before removing duplicates: $list")
    list.removeDuplicates()
    println("After removing duplicates: $list")
}

// Doubly

private fun arrayToDoublyLinkedList() {
    val array = arrayOf(0, 1, 2, 3, 4, 5)
    val list = DoublyLinkedList(array)
    println(list)
}

private fun pushDoublyExample() {
    val list = DoublyLinkedList<Int>()
    list.push(3).push(2).push(1)
    println(list)
    list.printInReverse()
}

private fun appendDoublyExample() {
    val list = DoublyLinkedList<Int>()
    list.append(1).append(2).append(3)
    println(list)
}

private fun insertAfterDoublyExample() {
    val list = DoublyLinkedList<Int>()
    list.push(3).push(2).push(1)
    println("Before inserting: $list")

    val middleNode = list.nodeAt(1)!!
    list.insertAfter(-1, middleNode)

    println("After inserting: $list")
}

private fun insertBeforeDoublyExample() {
    val list = DoublyLinkedList<Int>()
    list.push(3).push(2).push(1)
    println("Before inserting: $list")

    val middleNode = list.nodeAt(1)!!
    list.insertBefore(-1, middleNode)

    println("After inserting: $list")
}

private fun popFirstDoublyExample() {
    val list = DoublyLinkedList<Int>()
    list.push(3).push(2).push(1)

    println("Before popping list: $list")
    val poppedValue = list.popFirst()
    println("After popping list: $list")
    println("Popped value: $poppedValue")
}

private fun popLastDoublyExample() {
    val list = DoublyLinkedList<Int>()
    list.push(3).push(2).push(1)

    println("Before removing last node: $list")
    val removedValue = list.popLast()

    println("After removing last node: $list")
    println("Removed value: $removedValue")
}

private fun removeDoublyExample() {
    val list = DoublyLinkedList<Int>()
    list.push(3).push(2).push(1)

    println("Before popping list: $list")
    val poppedValue = list.remove(2)
    println("After popping list: $list")
    println("Popped value: $poppedValue")
}
