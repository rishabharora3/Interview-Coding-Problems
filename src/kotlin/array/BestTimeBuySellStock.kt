class BestTimeBuySellStock {
    fun maxProfit(prices: IntArray): Int {
        var minNum = Integer.MAX_VALUE
        var profit = 0
        for (item in prices) {
            if (item < minNum) {
                minNum = item
            } else if (item - minNum > profit) {
                profit = item - minNum
            }
        }
        return profit
    }
}