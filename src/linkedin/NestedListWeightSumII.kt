package linkedin

class NestedListWeightSumII {
    /**
     * // This is the interface that allows for creating nested lists.
     * // You should not implement it, or speculate about its implementation
     * class NestedInteger {
     *     // Constructor initializes an empty nested list.
     *     constructor()
     *
     *     // Constructor initializes a single integer.
     *     constructor(value: Int)
     *
     *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
     *     fun isInteger(): Boolean
     *
     *     // @return the single integer that this NestedInteger holds, if it holds a single integer
     *     // Return null if this NestedInteger holds a nested list
     *     fun getInteger(): Int?
     *
     *     // Set this NestedInteger to hold a single integer.
     *     fun setInteger(value: Int): Unit
     *
     *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
     *     fun add(ni: NestedInteger): Unit
     *
     *     // @return the nested list that this NestedInteger holds, if it holds a nested list
     *     // Return null if this NestedInteger holds a single integer
     *     fun getList(): List<NestedInteger>?
     * }
     */
    // Dummy class for NestedInteger
    class NestedInteger {
        fun isInteger(): Boolean {
            return false
        }

        fun getInteger(): Int {
            return 0
        }

        fun setInteger(value: Int) {}

        fun add(ni: NestedInteger) {}

        fun getList(): List<NestedInteger> {
            return ArrayList()
        }
    }

    fun depthSumInverse(nestedList: List<NestedInteger>): Int {
        val maxDepth = findMaxDepth(nestedList)
        print(maxDepth)
        return findSum(nestedList, maxDepth, 1)
    }

    fun findMaxDepth(nestedList: List<NestedInteger>): Int {
        var maxDepth = 1
        for (item in nestedList) {
            if (!item.isInteger()) {
                maxDepth = Math.max(maxDepth, 1 + findMaxDepth(item.getList()))
            }
        }
        return maxDepth
    }

    fun findSum(nestedList: List<NestedInteger>, maxDepth: Int, depth: Int): Int {
        var sum = 0
        for (item in nestedList) {
            if (item.isInteger()) {
                sum += item.getInteger() * (maxDepth - depth + 1)
            } else {
                sum += findSum(item.getList(), maxDepth, depth + 1)
            }
        }
        return sum
    }


}