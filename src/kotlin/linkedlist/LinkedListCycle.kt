

class LinkedListCycle {

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun hasCycle(head: ListNode?): Boolean {
        if (head == null)
            return false
        var slowPtr = head
        var fastPtr = head.next
        while (slowPtr != fastPtr && slowPtr != null && fastPtr != null) {
            slowPtr = slowPtr.next
            fastPtr = fastPtr.next?.next
        }
        return slowPtr == fastPtr
    }

    //test case
    fun main() {
        val head = ListNode(1)
        head.next = ListNode(2)
        head.next?.next = ListNode(3)
        head.next?.next?.next = ListNode(4)
        head.next?.next?.next?.next = ListNode(5)
        head.next?.next?.next?.next?.next = head.next?.next
        println(hasCycle(head))
    }

}