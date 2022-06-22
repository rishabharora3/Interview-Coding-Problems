package companytagged.linkedin

class SortTransformedArray {
    fun sortTransformedArray(nums: IntArray, a: Int, b: Int, c: Int): IntArray {
        val arr = IntArray(nums.size)
        for (i in nums.indices) {
            arr[i] = (a * Math.pow(nums[i].toDouble(), 2.0) + b * nums[i] + c).toInt()
        }
        arr.sort()
        return arr
    }
}