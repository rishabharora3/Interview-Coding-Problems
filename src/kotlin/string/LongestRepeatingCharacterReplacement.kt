class LongestRepeatingCharacterReplacement {
    fun characterReplacement(s: String, k: Int): Int {
        var max = 0
        var left = 0
        var right = 0
        var answer = 0
        val ch = IntArray(26)
        while (right < s.length) {
            max = Math.max(max, ++ch[s[right].toInt() - 'A'.toInt()])
            if ((right - left + 1) - max > k) {
                ch[s[left].toInt() - 'A'.toInt()]--
                left++
            }
            answer = Math.max(answer, right - left + 1)
            right++
        }
        return answer
    }

    //test
    fun main() {
        println(characterReplacement("ABAB", 2))
    }
}