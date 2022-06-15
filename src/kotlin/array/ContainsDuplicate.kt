

class ContainsDuplicate {
    fun containsDuplicate(nums: IntArray): Boolean {
        val setColl = mutableSetOf<Int>()
        for (item in nums) {
            if(setColl.contains(item))
                return true
            setColl.add(item)
        }
        return false
    }
}