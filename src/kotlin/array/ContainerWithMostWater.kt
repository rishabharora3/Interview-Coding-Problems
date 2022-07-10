class ContainerWithMostWater {
    fun maxArea(height: IntArray): Int {
        var maxWater = 0
        var i = 0
        var j = height.size - 1
        while (i < j) {
            val temp = Math.min(height[i], height[j])
            maxWater = Math.max(maxWater, temp * (j - i))
            if (height[i] < height[j]) {
                i++
            } else {
                j--
            }
        }
        return maxWater
    }

    //test
    fun main() {
        val height = intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)
        println(maxArea(height))
    }
}