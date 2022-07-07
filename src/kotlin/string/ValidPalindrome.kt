class ValidPalindrome {
    fun isPalindrome(s: String): Boolean {
        var str = s
        for (i in s) {
            if (!i.isLetterOrDigit()) {
                str = str.replace(i.toString(), "")
            }
        }
        return str.toLowerCase().reversed() == str.toLowerCase()
    }

    //test isPalindrome
    fun main() {
        println(isPalindrome("A man, a plan, a canal: Panama"))
    }
}