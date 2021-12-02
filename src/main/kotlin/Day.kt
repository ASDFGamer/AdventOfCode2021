import java.io.File
import kotlin.system.measureNanoTime

abstract class Day(val file: String) {

    val folder = "src/main/resources/"

    fun run(part1: Boolean = true, part2: Boolean = true, times: Int = 10000){
        val fileName = folder + file
        val lines = File(fileName).readLines()
        if (part1) {
            println("Result: ${part1(lines)}")
            val time = measureNanoTime {
                for (i in 1..times) {
                    part1(lines)
                }
            }
            println("Time: ${time/times} ns")
        }
        if (part2) {
            println("Result: ${part2(lines)}")
            val time = measureNanoTime {
                for (i in 1..times) {
                    part2(lines)
                }
            }
            println("Time: ${(time/times)} ns")
        }
    }

    abstract fun part1(input:List<String>):String
    abstract fun part2(input:List<String>):String
}