package linkedin

import java.util.*

class MaxStack {

    val stack: Stack<Int> by lazy {
        Stack<Int>()
    }

    val maxStack: Stack<Int> by lazy {
        Stack<Int>()
    }

    fun push(x: Int) {
        if(!maxStack.isEmpty() && maxStack.peek() > x){
            maxStack.push(peekMax())
        } else{
            maxStack.push(x)
        }
        stack.push(x)
    }

    fun pop(): Int {
        maxStack.pop()
        return stack.pop()
    }

    fun top(): Int {
        return stack.peek()
    }

    fun peekMax(): Int {
        return maxStack.peek()
    }

    fun popMax(): Int {
        val max = peekMax()
        val stackTemp = Stack<Int>()
        while(top() != max){
            stackTemp.push(pop())
        }
        pop()
        while(!stackTemp.isEmpty()){
            push(stackTemp.pop())
        }
        return max
    }

    fun main(){
        push(5)
        push(1)
        println(popMax())
        println(peekMax())
    }

}

/**
 * Your MaxStack object will be instantiated and called as such:
 * var obj = MaxStack()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.peekMax()
 * var param_5 = obj.popMax()
 */