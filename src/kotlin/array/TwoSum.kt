// O(n^2)
class TwoSum {

    private fun twoSum(nums: IntArray, target: Int): IntArray {
        for (i in nums.indices) {
            for (j in i + 1 until nums.size) {
                if (nums[i] + nums[j] == target) {
                    val arr = IntArray(2)
                    arr[0] = i
                    arr[1] = j
                    return arr
                }
            }
        }
        return IntArray(0)
    }

    fun main() {
        val arr = IntArray(5)
        arr[0] = 1
        arr[1] = 3
        arr[2] = 4
        arr[3] = 2
        arr[4] = 6
        print(twoSum(arr, 8).joinToString())
    }
}