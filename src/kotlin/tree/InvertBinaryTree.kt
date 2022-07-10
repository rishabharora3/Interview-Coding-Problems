import java.util.*

class InvertBinaryTree {

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun invertTree(root: TreeNode?): TreeNode? {
        if (root == null)
            return root
        val left = invertTree(root.left)
        val right = invertTree(root.right)
        root.left = right
        root.right = left
        return root
    }

    //test
    fun main() {
        val root = TreeNode(1)
        root.left = TreeNode(2)
        root.right = TreeNode(3)
        root.left!!.left = TreeNode(4)
        root.left!!.right = TreeNode(5)
        root.right!!.left = TreeNode(6)
        root.right!!.right = TreeNode(7)
        //print tree level by level with new line
        printTree(root)
        invertTree(root)
    }

    //print tree level by level with new line
    fun printTree(root: TreeNode?) {
        if (root == null)
            return
        val queue = LinkedList<TreeNode?>()
        queue.offer(root)
        while (!queue.isEmpty()) {
            val size = queue.size
            for (i in 0 until size) {
                val node = queue.poll()
                if (node != null) {
                    print("${node.`val`} ")
                    queue.offer(node.left)
                    queue.offer(node.right)
                } else {
                    print("null ")
                }
            }
            println()
        }
    }

}