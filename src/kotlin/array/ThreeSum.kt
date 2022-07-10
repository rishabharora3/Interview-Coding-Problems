import java.util.*
import java.util.concurrent.TimeUnit
import kotlin.system.measureTimeMillis


class ThreeSum {
    /*fun threeSum(nums: IntArray): List<List<Int>> {
        val hashmap = mutableMapOf<Int, Int>()
        val hashset = hashSetOf<List<Int>>()
        for (i in nums.indices) {
            for (j in i + 1 until nums.size) {
                val complement = -nums[i] - nums[j]
                if () {
                    val li = listOf(nums[i], nums[j], nums[hashmap[diff]!!]).sorted()
                    hashset.add(li)
                }
                hashmap[nums[j]] = j
            }
        }
        return ArrayList(hashset)
    }*/

    fun threeSum(nums: IntArray): List<List<Int?>?>? {
        val res: MutableSet<List<Int>?> = HashSet()
        val dups: MutableSet<Int> = HashSet()
        val seen: MutableMap<Int, Int> = HashMap()
        for (i in nums.indices)
            if (dups.add(nums[i])) {
                for (j in i + 1 until nums.size) {
                    val complement = -nums[i] - nums[j]
                    if (seen.containsKey(complement) && seen[complement] == i) {
                        val triplet = Arrays.asList(nums[i], nums[j], complement)
                        Collections.sort(triplet)
                        res.add(triplet)
                    }
                    seen[nums[j]] = i
                }
            }
        return ArrayList(res)
    }

    fun main() {
        /*val time = measureTimeMillis {
            val nums = intArrayOf(-1, 0, 1, 2, -1, -4)
            val answer = threeSum(nums)
            println(answer)
        }
        println(TimeUnit.MILLISECONDS.convert(time, TimeUnit.MILLISECONDS))*/
    }
}