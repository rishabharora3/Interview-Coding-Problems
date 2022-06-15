class MaxSubArray {
    fun maxSubArray(nums: IntArray): Int {
        var max = Integer.MIN_VALUE
        var sum = 0
        for (num in nums) {
            sum += num
            max = Math.max(sum, max)
            if (sum < 0) {
                sum = 0
            }
        }
        return max
    }
}