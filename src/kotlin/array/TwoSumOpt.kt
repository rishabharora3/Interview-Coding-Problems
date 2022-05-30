// O(n)
class TwoSumOpt {

    fun twoSum(nums: IntArray, target: Int): IntArray? {
        val hashmap: MutableMap<Int, Int> = mutableMapOf()
        for (i in nums.indices) {
            if (hashmap.containsKey(target - nums[i]) && hashmap[target - nums[i]] != i) {
                val arr = IntArray(2)
                arr[0] = i
                arr[1] = hashmap[target - nums[i]]!!
                return arr
            }
            hashmap[nums[i]] = i
        }
        return null
    }

}