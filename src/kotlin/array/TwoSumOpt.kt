// O(n)
class TwoSumOpt {

    fun twoSum(nums: IntArray, target: Int): IntArray? {
        val hashmap = mutableMapOf<Int, Int>()
        for (i in nums.indices) {
            if (hashmap.containsKey(target - nums[i]) && hashmap[target - nums[i]] != i) {
                return intArrayOf(hashmap[target - nums[i]]!!, i)
            }
            hashmap[nums[i]] = i
        }
        return null
    }

}