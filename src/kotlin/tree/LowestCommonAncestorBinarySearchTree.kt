

class LowestCommonAncestorBinarySearchTree {
    data class TreeNode(var `val`: Int, var left: TreeNode? = null, var right: TreeNode? = null)

    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        return if (p?.`val`!! < root?.`val`!! && q?.`val`!! < root.`val`) {
            lowestCommonAncestor(root.left, p, q)
        } else if (p.`val` > root.`val` && q?.`val`!! > root.`val`) {
            lowestCommonAncestor(root.right, p, q)
        } else {
            root
        }
    }
}