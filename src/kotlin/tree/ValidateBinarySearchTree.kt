import java.util.*

class ValidateBinarySearchTree {

    data class TreeNode(val `val`: Int, val left: TreeNode?, val right: TreeNode?)

    fun isValidBST1(root: TreeNode?): Boolean {
        if (root == null) {
            return true
        } else if (root.left != null && root.left.`val` > root.`val`) {
            return false
        } else if (root.right != null && root.right.`val` < root.`val`) {
            return false
        }
        return isValidBST(root.left) && isValidBST(root.right)
    }

    fun isValidBST(root: TreeNode?): Boolean {
        val stack = Stack<TreeNode?>()
        var curr = root
        var prev:TreeNode? = null
        while(curr!=null || !stack.empty()) {
            while(curr != null) {
                stack.add(curr)
                curr = curr.left
            }
            curr = stack.pop()
            if(prev != null && curr?.`val`!! <= prev.`val`){
                return false
            }
            prev = curr
            curr = curr?.right
        }
        return true
    }



    //test
    fun main() {
        // input [5,4,6,null,null,3,7]

        val root = TreeNode(5, TreeNode(4, null, null), TreeNode(6, null, TreeNode(7, null, null)))
        //print tree
        printTree(root)
        println(isValidBST(root))
//        val root = TreeNode(2, TreeNode(2, null, null), TreeNode(2, null, null))
//        println(isValidBST(root))
    }

    private fun printTree(root: TreeNode) {
        //level order traversal
        val queue = LinkedList<TreeNode>()
        queue.offer(root)
        while (queue.isNotEmpty()) {
            val size = queue.size
            for (i in 0 until size) {
                val node = queue.poll()
                if (node.left != null) {
                    queue.offer(node.left)
                }
                if (node.right != null) {
                    queue.offer(node.right)
                }
                print("${node.`val`} ")
            }
            println()
        }
    }
}