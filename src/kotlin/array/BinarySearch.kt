class BinarySearch {
    fun binarySearch(arr: Array<Int>, start: Int, end: Int, x: Int): Int {
        if (end >= start) {
            val mid = start + (end - start) / 2
            if (arr[mid] == x) {
                return mid
            }
            if (arr[mid] > x) {
                return binarySearch(arr, start, mid - 1, x)
            }
            return binarySearch(arr, mid + 1, end, x)
        }
        return -1
    }

    fun main() {
        val arr1 = arrayOf(-4, -2, 2, 4)
        val idx = binarySearch(arr1, 0, arr1.size - 1, 2)
        // for(item in arr){
        //   print(item)
        // }
        print(idx)
    }
}