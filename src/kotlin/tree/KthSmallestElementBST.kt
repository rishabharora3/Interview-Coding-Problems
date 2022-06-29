

import java.util.*

class KthSmallestElementBST {
    data class TreeNode(var `val`: Int, var left: TreeNode? = null, var right: TreeNode? = null)

    fun kthSmallest(root: TreeNode?, k: Int): Int {
        val stack = Stack<TreeNode?>()
        var curr = root
        var l = 0
        while (curr != null || !stack.empty()) {
            while (curr != null) {
                stack.add(curr)
                curr = curr.left
            }
            curr = stack.pop()
            l++
            if (l == k) {
                return curr?.`val`!!
            }

            curr = curr?.right
        }
        return -1
    }
}