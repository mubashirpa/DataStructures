package three.tree.bst

import three.tree.bt.BinaryNode
import kotlin.math.abs

class BinarySearchTree<T : Comparable<T>> {
    var root: BinaryNode<T>? = null

    override fun toString(): String = root?.toString() ?: "Empty tree"

    fun insert(value: T) {
        root = insert(root, value)
    }

    private fun insert(
        node: BinaryNode<T>?,
        value: T,
    ): BinaryNode<T> {
        node ?: return BinaryNode(value)

        if (value < node.value) {
            node.leftChild = insert(node.leftChild, value)
        } else {
            node.rightChild = insert(node.rightChild, value)
        }

        return node
    }

    fun contains(value: T): Boolean {
        var current = root

        while (current != null) {
            if (current.value == value) {
                return true
            }

            current =
                if (value < current.value) {
                    current.leftChild
                } else {
                    current.rightChild
                }
        }

        return false
    }

    fun remove(value: T) {
        root = remove(root, value)
    }

    private fun remove(
        node: BinaryNode<T>?,
        value: T,
    ): BinaryNode<T>? {
        node ?: return null

        when {
            value == node.value -> {
                when {
                    node.leftChild == null && node.rightChild == null -> return null

                    node.leftChild == null -> return node.rightChild

                    node.rightChild == null -> return node.leftChild
                }

                node.rightChild?.min?.value?.let {
                    node.value = it
                }

                node.rightChild = remove(node.rightChild, node.value)
            }

            value < node.value -> node.leftChild = remove(node.leftChild, value)

            else -> node.rightChild = remove(node.rightChild, value)
        }

        return node
    }
}

fun BinaryNode<Int>?.findClosestValue(value: Int): Int? {
    var current = this
    var closest = current?.value ?: return null

    while (current != null) {
        if (abs(value - closest) > abs(value - current.value)) {
            closest = current.value
        }

        current =
            when {
                value < current.value -> current.leftChild
                value > current.value -> current.rightChild
                else -> break
            }
    }

    return closest
}
