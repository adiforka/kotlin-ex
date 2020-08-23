package base

class MergeSorter {

    fun sort(list: List<Int>): List<Int> {
        if (list.size <= 1) return list

        val middle = list.size / 2
        val left = list.subList(0, middle)
        val right = list.subList(middle, list.size)

        return merge(sort(left), sort(right))
    }

    private fun merge(left: List<Int>, right: List<Int>): List<Int> {
        var indexLeft = 0
        var indexRight = 0
        val newList: MutableList<Int> = mutableListOf()

        while (indexLeft < left.size && indexRight < right.size) {
            if (left[indexLeft] < right[indexRight]) {
                newList.add(left[indexLeft])
                indexLeft++
            }
            else  {
                newList.add(right[indexRight])
                indexRight++
            }
        }

        while (indexLeft < left.size) {
            newList.add(left[indexLeft])
            indexLeft++
        }

        while (indexRight < right.size) {
            newList.add(right[indexRight])
            indexRight++
        }
        return newList
    }
}

fun main() {
    val items = listOf(5, 3, 6, 8, 5, 3, 6, 5, 2, 65, 4, 78)
    val mergeSorter = MergeSorter()
    val sortedList = mergeSorter.sort(items)
    println("sortedList = $sortedList")
}