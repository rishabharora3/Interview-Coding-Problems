

class MinimumRotatedSortedArray {

    fun findMin(nums: IntArray): Int {
        var start = 0
        var end = nums.size - 1
        while (start < end) {
            val mid = (start + end) / 2
            if (mid > 0 && nums[mid] < nums[mid - 1]) {
                return nums[mid]
            }
            if (nums[mid] >= nums[start] && nums[mid] > nums[end]) {
                start = mid + 1
            } else {
                end = mid - 1
            }
        }
        return nums[start]
    }

}