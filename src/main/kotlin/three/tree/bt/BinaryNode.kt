package three.tree.bt

typealias Visitor<T> = (T) -> Unit

class BinaryNode<T : Comparable<T>>(
    var value: T,
) {
    var leftChild: BinaryNode<T>? = null
    var rightChild: BinaryNode<T>? = null

    fun traversePreOrder(visit: Visitor<T>) {
        visit(value)
        leftChild?.traversePreOrder(visit)
        rightChild?.traversePreOrder(visit)
    }

    fun traverseInOrder(visit: Visitor<T>) {
        leftChild?.traverseInOrder(visit)
        visit(value)
        rightChild?.traverseInOrder(visit)
    }

    fun traversePostOrder(visit: Visitor<T>) {
        leftChild?.traversePostOrder(visit)
        rightChild?.traversePostOrder(visit)
        visit(value)
    }

    val min: BinaryNode<T>
        get() = leftChild?.min ?: this

    val isBinarySearchTree: Boolean
        get() = isBST(this, null, null)

    private fun isBST(
        tree: BinaryNode<T>?,
        min: T?,
        max: T?,
    ): Boolean =
        tree?.let {
            when {
                min != null && tree.value <= min -> false
                max != null && tree.value > max -> false
                else -> isBST(tree.leftChild, min, tree.value) && isBST(tree.rightChild, tree.value, max)
            }
        } ?: true

    override fun toString(): String = diagram(this)

    private fun diagram(
        node: BinaryNode<T>?,
        top: String = "",
        root: String = "",
        bottom: String = "",
    ): String =
        node?.let {
            if (node.leftChild == null && node.rightChild == null) {
                "$root${node.value}\n"
            } else {
                diagram(node.rightChild, "$top ", "$top┌──", "$top│ ") +
                    root + "${node.value}\n" +
                    diagram(
                        node.leftChild,
                        "$bottom│ ",
                        "$bottom└──",
                        "$bottom ",
                    )
            }
        } ?: "${root}null\n"
}
