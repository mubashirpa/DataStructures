package recursion

fun main() {
    println("Factorial of 5 is: ${factorial(5)}")

    val array = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    println("Sum of elements of the array is: ${sumOfElements(array, array.lastIndex, 0)}")

    println("Fibonacci of 8 is: ${fibonacci(8)}")
}

fun factorial(n: Int): Int =
    if (n <= 1) {
        n
    } else {
        n * factorial(n - 1)
    }

tailrec fun factorial(
    n: Int,
    f: Int = 1,
): Int = if (n <= 1) f else factorial(n - 1, f * n)

fun sumOfElements(
    array: IntArray,
    index: Int,
): Int =
    if (index == 0) {
        array[0]
    } else {
        array[index] + sumOfElements(array, index - 1)
    }

tailrec fun sumOfElements(
    array: IntArray,
    index: Int,
    sum: Int = 0,
): Int = if (index < 0) sum else sumOfElements(array, index - 1, sum + array[index])

fun fibonacci(n: Int): Int = if (n <= 1) n else fibonacci(n - 1) + fibonacci(n - 2)
