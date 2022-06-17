package linkedin

class WordDistance(val wordsDict: Array<String>) {

    val hashmap = HashMap<String, ArrayList<Int>>()

    init {
        for (i in wordsDict.indices) {
            val list = hashmap.getOrDefault(wordsDict[i], ArrayList<Int>())
            list.add(i)
            hashmap[wordsDict[i]] = list
        }
    }

    fun shortest(word1: String, word2: String): Int {
        val list1 = hashmap[word1]
        val list2 = hashmap[word2]
        var i = 0
        var j = 0
        var shortest = Int.MAX_VALUE
        list1?.let { loc1->
            list2?.let { loc2 ->
                while (i < loc1.size && j < loc2.size) {
                    shortest = Math.min(shortest, Math.abs(loc1[i] - loc2[j]))
                    if (loc1[i] < loc2[j]) {
                        i++
                    } else {
                        j++
                    }
                }
            }
        }
        return shortest
    }
}

/**
 * Your LinkedIn.WordDistance object will be instantiated and called as such:
 * var obj = LinkedIn.WordDistance(wordsDict)
 * var param_1 = obj.shortest(word1,word2)
 */