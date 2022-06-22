package kotlin.tree

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
}