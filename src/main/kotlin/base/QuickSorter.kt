package base

class QuickSorter {

    fun sort(items: List<Int>): List<Int> {
        if (items.size < 2)
            return items

        val pivot = items[items.size / 2]
        // println("pivot value is: $pivot")
        val equal = items.filter { it == pivot }
        // println("equal items are: $equal")
        val lesser = items.filter { it < pivot }
        // println("lesser items are:  $lesser")
        val greater = items.filter { it > pivot }
        // println("greater items are: $greater\n")
        return sort(lesser) + equal + sort(greater)
    }
}

fun main() {
    val list = listOf(5, 4, 3, 8, 5, 3, 7, 4, 5, 2)
    val quickSorter = QuickSorter()
    val orderedList = quickSorter.sort(list)
    println("orderedList = $orderedList")
}