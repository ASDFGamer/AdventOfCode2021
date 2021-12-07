import java.util.*

fun <T> generateList(size: Int, value: T): List<T> {
    return Collections.nCopies(size, value)
}

fun <T> generateMutableList(size: Int, value: T): MutableList<T> {
    return Collections.nCopies(size, value).toMutableList()
}

fun <T> generateGrid(sizeX: Int, sizeY: Int, value: T): List<List<T>> {
    return Collections.nCopies(sizeX, Collections.nCopies(sizeY, value))
}

fun <T> generateMutableGrid(sizeX: Int, sizeY: Int, value: T): List<MutableList<T>> {
    return (0 until sizeX).map { Collections.nCopies(sizeY, value).toMutableList() }
}