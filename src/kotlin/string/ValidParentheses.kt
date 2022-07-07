import java.util.*
import kotlin.collections.HashMap

class ValidParentheses {
    fun isValid(s: String): Boolean {
        val hashmap = HashMap<Char, Char>()
        hashmap['('] = ')'
        hashmap['{'] = '}'
        hashmap['['] = ']'
        val stack = Stack<Char>()
        for (item in s) {
            if (stack.size != 0 && stack.peek() == item) {
                stack.pop()
            } else {
                stack.push(hashmap[item])
            }
        }
        return stack.size == 0
    }
}