

import java.util.*
import kotlin.collections.ArrayList

class SerializeDeserializeBinaryTree {

    data class TreeNode(var `val`: Int, var left: TreeNode? = null, var right: TreeNode? = null)

    fun serialize(root: TreeNode?): String {
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
        return result.toString().substring(1, result.toString().length - 1) // remove first and last '[' and ']'
    }

    fun deserialize(data: String): TreeNode? {
        return null
    }

}