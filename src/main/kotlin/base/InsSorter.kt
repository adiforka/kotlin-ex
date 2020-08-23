package base

fun main() {
    val ints: Array<Int> = arrayOf(7, 6, 5, 4, 3, 2, 1)
    insSort(ints)
    println(ints.contentToString())
}

fun insSort(ints: Array<Int>): Array<Int> {
    if (ints.isEmpty() || ints.size < 2)
        return ints

    for (i in 1 until ints.size) {
        val curEl = ints[i]
        var k = i - 1
        while(k >= 0 && curEl < ints[k]) {
            ints[k + 1] = ints[k]
            k -= 1
        }
        ints[k + 1] = curEl
    }
    return ints

}