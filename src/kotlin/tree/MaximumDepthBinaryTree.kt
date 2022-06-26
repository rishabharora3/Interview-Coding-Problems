import java.util.*
import kotlin.collections.ArrayDeque

class MaximumDepthBinaryTree {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun maxDepth(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right))
    }

    fun maxDepth2(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        val left = maxDepth2(root.left)
        val right = maxDepth2(root.right)
        return 1 + Math.max(left, right)
    }

    //test case
    fun main() {
        val root = TreeNode(1)
        root.left = TreeNode(2)
        root.right = TreeNode(3)
        root.left!!.left = TreeNode(4)
        root.left!!.right = TreeNode(5)
        root.right!!.left = TreeNode(6)
        root.right!!.right = TreeNode(7)
        //print the tree level by level
        printTree(root)

//        println(maxDepth(root))
        println(maxDepth2(root))
    }

    fun printTree(root: TreeNode?) {
        if (root == null) {
            return
        }
        val queue:Queue<TreeNode?> = LinkedList<TreeNode?>()
        queue.add(root)
        while (!queue.isEmpty()) {
            val size = queue.size
            for (i in 0 until size) {
                val node = queue.poll()
                if (node != null) {
                    print("${node.`val`} ")
                    queue.offer(node.left)
                    queue.offer(node.right)
                }
            }
            println()
        }
    }

}