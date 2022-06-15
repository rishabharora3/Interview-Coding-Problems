

class ProductExceptSelf {
    fun productExceptSelf(nums: IntArray): IntArray {
        val len = nums.size
        val L = IntArray(len)
        val R = IntArray(len)
        val answer = IntArray(len)
        L[0] = 1
        for (i in 1 until len) {
            L[i] = L[i - 1] * nums[i - 1]
        }
        R[len - 1] = 1
        for (i in len - 2 downTo 0) {
            R[i] = R[i + 1] * nums[i + 1]
        }
        for (i in 0 until len) {
            answer[i] = L[i] * R[i]
        }
        return answer
    }
}