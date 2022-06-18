class MergeTwoSortedLists {

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        var firstPtr = list1
        var secondPtr = list2
        val head: ListNode? = ListNode(-1)
        var prev = head
        while (firstPtr != null && secondPtr != null) {
            if (firstPtr.`val` <= secondPtr.`val`) {
                prev?.next = firstPtr
                firstPtr  = firstPtr.next
            } else {
                prev?.next = secondPtr
                secondPtr = secondPtr.next
            }
            prev = prev?.next
        }
        if (firstPtr == null) {
            prev?.next = secondPtr
        } else {
            prev?.next = firstPtr
        }
        return head?.next
    }

    //test case 1
    fun main() {
        val list1 = ListNode(1)
        list1.next = ListNode(2)
        list1.next?.next = ListNode(4)
        val list2 = ListNode(1)
        list2.next = ListNode(2)
        list2.next?.next = ListNode(4)
        val result = mergeTwoLists(list1, list2)
        printList(result)
    }

    //test case 2
    fun main2() {
        val list2 = ListNode(1)
        list2.next = ListNode(3)
        list2.next?.next = ListNode(4)
        val result = mergeTwoLists(list2, null)
        printList(result)
    }

    //test case 3
    fun main3() {
        val list1 = ListNode(5)
        val list2 = ListNode(1)
        list2.next = ListNode(2)
        list2.next?.next = ListNode(4)
        val result = mergeTwoLists(list1, list2)
        printList(result)
    }

    private fun printList(result: ListNode?) {
        var temp = result
        while (temp != null) {
            print("${temp.`val`} ")
            temp = temp.next
        }
    }


}