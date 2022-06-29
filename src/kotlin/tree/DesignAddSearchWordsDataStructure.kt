class DesignAddSearchWordsDataStructure {
    class WordDictionary() {

        val root = TrieNode()

        fun addWord(word: String) {
            var node = root
            for (letter in word) {
                if (!node.isContainsKey(letter)) {
                    node.put(letter, TrieNode())
                }
                node = node.get(letter)
            }
            node.setEnd()
        }


        fun searchInTrie(word: String, node: TrieNode): Boolean {
            var curr = node
            for (i in word.indices) {
                if (curr.isContainsKey(word[i])) {
                    curr = curr.get(word[i])
                } else {
                    if (word[i] == '.') {
                        for (ch in curr.children.keys) {
                            if (searchInTrie(word.substring(i + 1), curr.get(ch))) {
                                return true
                            }
                        }
                    }
                    return false
                }
            }
            return curr.isEnds()
        }

        fun search(word: String): Boolean {
            return searchInTrie(word, root)
        }

    }

    class TrieNode {

        val children = HashMap<Char, TrieNode>()
        var isEnd = false


        fun get(ch: Char): TrieNode {
            return children[ch]!!
        }

        fun put(ch: Char, node: TrieNode) {
            children[ch] = node
        }

        fun isContainsKey(ch: Char): Boolean {
            return children[ch] != null
        }

        fun setEnd() {
            isEnd = true
        }

        fun isEnds(): Boolean {
            return isEnd
        }
    }


    /**
     * Your WordDictionary object will be instantiated and called as such:
     * var obj = WordDictionary()
     * obj.addWord(word)
     * var param_2 = obj.search(word)
     */

    /**
     * Your WordDictionary object will be instantiated and called as such:
     * var obj = WordDictionary()
     * obj.addWord(word)
     * var param_2 = obj.search(word)
     */
    //test case
    fun main() {
        val obj = WordDictionary()
        obj.addWord("bad")
        obj.addWord("dad")
        obj.addWord("mad")
        println(obj.search("pad"))
        println(obj.search("bad"))
        println(obj.search(".ad"))
        println(obj.search("b.."))
    }
}