

class ReorderList {
    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun reorderList(head: ListNode?): Unit {
        //find middle
        var slow = head
        var fast = head
        while (fast != null) {
            slow = slow?.next
            fast = fast.next?.next
        }
        //reverse
        var first: ListNode? = null
        var second = slow
        while (second != null) {
            val temp = second.next
            second.next = first
            first = second
            second = temp
        }
        //merge two lists
        slow = head
        fast = first
        var flag = true
        while (slow != null && fast != null) {
            if (flag) {
                val temp = slow.next
                slow.next = fast
                flag = false
                slow = temp
            } else {
                val temp = fast.next
                fast.next = slow
                flag = true
                fast = temp
            }
        }
        if (flag) {
            slow?.next = null
        }  else {
            fast?.next = null
        }

    }

    //test case 1
    fun test1() {
        val head = ListNode(1)
        head.next = ListNode(2)
        head.next?.next = ListNode(3)
        head.next?.next?.next = ListNode(4)
        head.next?.next?.next?.next = ListNode(5)
        reorderList(head)
        var temp: ListNode? = head
        while (temp != null) {
            println(temp.`val`)
            temp = temp.next
        }
    }

    //test case 2
    fun test2() {
        val head = ListNode(1)
        head.next = ListNode(2)
        head.next?.next = ListNode(3)
        head.next?.next?.next = ListNode(4)
        head.next?.next?.next?.next = ListNode(5)
        head.next?.next?.next?.next?.next = ListNode(6)
        reorderList(head)
        var temp: ListNode? = head
        while (temp != null) {
            println(temp.`val`)
            temp = temp.next
        }
    }

    fun main() {
        test1()
//        test2()
    }
}