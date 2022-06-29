

class ImplementTriePrefixTree {

    class Trie() {

        var root = TrieNode()

        fun insert(word: String) {
            var node = root
            for (letter in word) {
                if (!node.containsKey(letter)) {
                    node.put(letter, TrieNode())
                }
                node = node.get(letter)
            }
            node.setEnd()
        }

        fun searchPrefix(word: String): TrieNode? {
            var node = root
            for (letter in word) {
                if (node.containsKey(letter)) {
                    node = node.get(letter)
                } else {
                    return null
                }
            }
            return node
        }

        fun search(word: String): Boolean {
            val node = searchPrefix(word)
            return node != null && node.isEnd()
        }

        fun startsWith(prefix: String): Boolean {
            val node = searchPrefix(prefix)
            return node != null
        }

    }

    class TrieNode {
        var arr: Array<TrieNode?> = arrayOfNulls<TrieNode?>(26)
        var isEndFlag: Boolean = false

//     init {
//         arr: Array<TrieNode> =
//     }

        fun containsKey(ch: Char): Boolean {
            return arr[ch - 'a'] != null
        }

        fun get(ch: Char): TrieNode {
            return arr[ch - 'a']!!
        }

        fun put(ch: Char, node: TrieNode) {
            arr[ch - 'a'] = node
        }

        fun setEnd() {
            isEndFlag = true
        }

        fun isEnd(): Boolean {
            return isEndFlag
        }
    }

    /**
     * Your Trie object will be instantiated and called as such:
     * var obj = Trie()
     * obj.insert(word)
     * var param_2 = obj.search(word)
     * var param_3 = obj.startsWith(prefix)
     */

    fun main() {
        val trie = Trie()
        trie.insert("apple")
        print(trie.search("apple")) // return True
        print(trie.search("app")) // return False
        print(trie.startsWith("app")) // return True
        print(trie.insert("app"))
        print(trie.search("app")) // return True
    }

}