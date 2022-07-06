class LongestSubstringWithoutRepeatingCharacters {
    private fun lengthOfLongestSubstring(s: String): Int {
        val arr = IntArray(128)
        var left = 0
        var right = 0
        var ans = 0
        while (right < s.length) {
            val ch = s[right]
            arr[ch.code]++
            while (arr[ch.code] > 1) {
                arr[ch.code]--
                left++
            }
            ans = Math.max(ans, right - left + 1)
            right++
        }
        return ans
    }

    fun lengthOfLongestSubstring1(s: String): Int {
        var left = 0
        var right = 0
        var ans = 0
        val hashmap = HashMap<Char, Int>()
        while (right < s.length) {
            if (hashmap.containsKey(s[right])) {
                left = Math.max(left, hashmap[s[right]]!!)
            }
            ans = Math.max(ans, right - left + 1)
            hashmap.put(s[right], right + 1)
            right++
        }
        return ans
    }

    //test
    fun main() {
        val s = "abcabcbb"
        println(lengthOfLongestSubstring(s))
    }
}