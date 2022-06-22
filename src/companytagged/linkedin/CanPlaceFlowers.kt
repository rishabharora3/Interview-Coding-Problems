package companytagged.linkedin

class CanPlaceFlowers {
    fun canPlaceFlowers(flowerbed: IntArray, n: Int): Boolean {
        var count = 0
        for (i in flowerbed.indices) {
            if (flowerbed[i] == 1)
                continue
            val left = if (i == 0) true else flowerbed[i - 1] == 0
            val right = if (i == flowerbed.size - 1) true else flowerbed[i + 1] == 0
            if (left && right) {
                count += 1
                flowerbed[i] = 1
            }
            if (count >= n) {
                return true
            }
        }
        return count >= n
    }
}