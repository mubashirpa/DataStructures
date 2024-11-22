package one.array

// Find second-largest element without sorting
fun main() {
    val array = arrayOf(45, 54, 21, 64, 55, 32, 48)

    var largest: Int
    var secondLargest =
        if (array[0] > array[1]) {
            largest = array[0]
            array[1]
        } else {
            largest = array[1]
            array[0]
        }

    for (i in 2..array.lastIndex) {
        when {
            array[i] > largest -> {
                secondLargest = largest
                largest = array[i]
            }

            array[i] > secondLargest -> {
                secondLargest = array[i]
            }
        }
    }

    println("Largest element in the array is: $largest")
    println("Second largest element in the array is: $secondLargest")
}
