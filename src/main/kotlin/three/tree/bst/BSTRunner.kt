package three.tree.bst

fun main() {
    val tree = BinarySearchTree<Int>()
    tree.insertItemsSample()
}

private fun BinarySearchTree<Int>.insertItemsSample() {
    apply {
        insert(3)
        insert(1)
        insert(4)
        insert(0)
        insert(2)
        insert(5)
    }
    println("After inserting elements:\n$this")
}

private fun BinarySearchTree<Int>.checkContainsItemSample(value: Int) {
    if (contains(value)) {
        println("Found $value!")
    } else {
        println("Couldn't find $value")
    }
}

private fun BinarySearchTree<Int>.removeItemSample(value: Int) {
    println("Tree before removing $value:")
    println(this)
    remove(value)
    println("Tree after removing $value:")
    println(this)
}

private fun BinarySearchTree<Int>.traversalsSample() {
    println("Inorder traversal: ")
    root?.traverseInOrder {
        print("$it, ")
    }
    println("\nPreorder traversal: ")
    root?.traversePreOrder {
        print("$it, ")
    }
    println("\nPostorder traversal: ")
    root?.traversePostOrder {
        print("$it, ")
    }
}

private fun BinarySearchTree<Int>.findClosestValueSample(value: Int) {
    root.findClosestValue(value)?.let {
        println("The closest value to $value is $it")
    }
}

private fun BinarySearchTree<Int>.validateBinarySearchTree() {
    if (root?.isBinarySearchTree == true) {
        println("This is Binary Search Tree")
    } else {
        println("This is not a Binary Search Tree")
    }
}
