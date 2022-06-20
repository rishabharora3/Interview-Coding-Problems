package kotlin.tree

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

}