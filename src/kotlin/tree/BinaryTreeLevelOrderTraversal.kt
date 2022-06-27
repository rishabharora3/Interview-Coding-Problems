import java.util.*
import kotlin.collections.ArrayList

class BinaryTreeLevelOrderTraversal {

    data class TreeNode(val `val`: Int, var left: TreeNode? = null, var right: TreeNode? = null) {
        override fun toString(): String {
            return `val`.toString()
        }
    }


    fun levelOrder(root: TreeNode?): List<List<Int>> {
        if (root == null) {
            return listOf()
        }
        val result = mutableListOf<List<Int>>()
        val queue = mutableListOf<TreeNode>()
        queue.add(root)
        while (queue.isNotEmpty()) {
            val size = queue.size
            val level = mutableListOf<Int>()
            for (i in 0 until size) {
                val node: TreeNode = queue.removeAt(0)
                level.add(node.`val`)
                if (node.left != null) {
                    queue.add(node.left!!)
                }
                if (node.right != null) {
                    queue.add(node.right!!)
                }
            }
            result.add(level)
        }
        return result
    }

    fun levelOrder1(root: TreeNode?): List<List<Int>> {
        val result = ArrayList<ArrayList<Int>>()
        val queue: Queue<TreeNode?> = LinkedList<TreeNode?>()
        queue.add(root)
        while (!queue.isEmpty()) {
            val size = queue.size
            val sublist = ArrayList<Int>()
            for (i in 0 until size) {
                val node = queue.poll()
                if (node != null) {
                    sublist.add(node.`val`)
                    queue.offer(node.left)
                    queue.offer(node.right)
                }
            }
            if (sublist.isNotEmpty())
                result.add(sublist)
        }
        return result
    }

    //test
    fun main() {
        val root = TreeNode(3)
        root.left = TreeNode(9)
        root.right = TreeNode(20)
        root.right!!.left = TreeNode(15)
        root.right!!.right = TreeNode(7)
//        println(levelOrder(root))
        println(levelOrder1(root))
    }
}