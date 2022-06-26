

class IsSubtree {
    data class TreeNode(var `val`: Int, var left: TreeNode?, var right: TreeNode?)

    fun isSubTree(root: TreeNode?, subRoot: TreeNode?): Boolean {
        if (root == null)
            return false
        return isSameTree(root, subRoot) || isSameTree(root.right, subRoot) || isSameTree(root.left, subRoot)
    }

    fun isSameTree(root: TreeNode?, subRoot: TreeNode?): Boolean {
        if (root == null && subRoot == null) {
            return true
        } else if (root == null || subRoot == null) {
            return false
        }
        if (root.`val` == subRoot.`val`)
            return true
        return isSameTree(root.left, subRoot.left) && isSameTree(root.right, subRoot.right)
    }

}