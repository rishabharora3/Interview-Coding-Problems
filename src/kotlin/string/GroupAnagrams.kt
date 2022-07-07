class GroupAnagrams {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val hashmap = HashMap<String, ArrayList<String>>()
        for (item in strs) {
            val arr = IntArray(26)
            for (element in item) {
                arr[element.toInt() - 'a'.toInt()]++
            }
            val str = arr.joinToString(separator = "#")
            val list = hashmap.getOrDefault(str, ArrayList())
            list.add(item)
            hashmap[str] = list
        }
        return ArrayList(hashmap.values)
    }

    //test
    fun main() {
        val strs = arrayOf("bdddddddddd", "bbbbbbbbbbc")
        val result = groupAnagrams(strs)
        println(result)
    }
}