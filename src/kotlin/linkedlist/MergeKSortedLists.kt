import java.util.*
import kotlin.Comparator

class MergeKSortedLists {
    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        val queue = PriorityQueue<ListNode?>(lists.size) { o1, o2 ->
            if (o1!!.`val` == o2!!.`val`) {
                0
            } else if (o1.`val` < o2.`val`) {
                -1
            } else {
                1
            }
        }
        for (node in lists) {
            if (node != null)
                queue.add(node)
        }
        var dummy = ListNode(0)
        while (!queue.isEmpty()) {
            dummy.next = queue.poll()
            dummy = dummy.next!!
            if (dummy.next != null) {
                queue.add(dummy.next)
            }
        }
        return dummy.next
    }
}