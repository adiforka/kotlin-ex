package base

import java.util.*

class QuickSorterArrays {

    fun sort(items: Array<Int>) {
        sort(items, 0, items.size - 1)
    }

    private fun sort(items: Array<Int>, low: Int, high: Int) {
        val pivotIndex = partition(items, low, high)

        if (low < pivotIndex - 1) {
            sort(items, low, pivotIndex - 1)
        }

        if (pivotIndex < high) {
            sort(items, pivotIndex, high)
        }
    }

    private fun partition(items: Array<Int>, low: Int, high: Int): Int {
        var left = low
        var right = high
        val pivot = items[getPivot(low, high)]
        while (left <= right) {
            while (items[left] < pivot) {
                left++
            }

            while (items[right] > pivot) {
                right--
            }
            if (left <= right) {
                val temp = items[left]
                items[left] = items[right]
                items[right] = temp
                left++
                right--
            }
        }
        return left
    }

    private fun getPivot(low: Int, high: Int): Int {
        // return ThreadLocalRandom.current().nextInt(low, high + 1)
        return Random().nextInt(high + 1 - low) + low
    }
}

fun main() {
    val items = arrayOf(4, 7, 3, 2, 4, 3, 7, 4, 2, 12, 5, -4, 65, -53)
    val quickSorterArrays = QuickSorterArrays()
    quickSorterArrays.sort(items)
    println("items = ${items.contentToString()}")

}