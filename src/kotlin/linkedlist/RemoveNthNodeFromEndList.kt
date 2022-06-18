class RemoveNthNodeFromEndList {
    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        val dummy = ListNode(0)
        dummy.next = head
        var curr = head
        var count = 0
        while(curr!= null) {
            curr = curr.next
            count++
        }
        var n1 = count-n
        curr = dummy
        while (n1 > 0) {
            curr = curr?.next
            n1--
        }
        curr?.next = curr?.next?.next
        return dummy.next
    }

    fun main() {
        val head = ListNode(1)
        head.next = ListNode(2)
        head.next?.next = ListNode(3)
        head.next?.next?.next = ListNode(4)
        head.next?.next?.next?.next = ListNode(5)
        //print
        var curr: ListNode? = head
        while (curr != null) {
            print("${curr.`val`} ")
            curr = curr.next
        }
        println()
        //remove
        val newHead = removeNthFromEnd(head, 2)
        //print
        curr = newHead
        while (curr != null) {
            print("${curr.`val`} ")
            curr = curr.next
        }
    }
}