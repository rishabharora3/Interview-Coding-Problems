package kotlin.array

class MaximumProductSubArray {
    fun maxProduct(nums: IntArray): Int {
        var min = nums[0]
        var max = nums[0]
        var result = nums[0]
        for (i in 1 until nums.size) {
            val num = nums[i]
            val temp = max
            max = Math.max(Math.max(max * num,min*num),num)
            min = Math.min(Math.min(temp * num,min*num),num)
            if(max > result)
                result = max
        }
        return result
    }
}