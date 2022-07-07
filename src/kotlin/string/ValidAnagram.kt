class ValidAnagram {
    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) {
            return false
        }
        val arr = IntArray(26)
        for (ch in s) {
            arr[ch.toInt() - 'a'.toInt()]++
        }

        for (ch in t) {
            arr[ch.toInt() - 'a'.toInt()]--
            if (arr[ch.toInt() - 'a'.toInt()] < 0) {
                return false
            }
        }
        return true
    }

    //test
    fun main() {
        println(isAnagram("anagram", "nagaram"))
    }
}