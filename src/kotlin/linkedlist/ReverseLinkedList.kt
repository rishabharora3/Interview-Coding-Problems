class ReverseLinkedList {

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }


    fun reverseList(head: ListNode?): ListNode? {
        var first = head
        var second = head?.next
        var third = head?.next?.next
        first?.next = null
        while (second != null) {
            second.next = first
            first = second
            second = third
            third = third?.next
        }
        return first
    }

    fun reverseListImproved(head: ListNode?): ListNode? {
        var first:ListNode? = null
        var second = head
        while (second != null) {
            val temp = second.next
            second.next = first
            first = second
            second = temp
        }
        return first
    }
}