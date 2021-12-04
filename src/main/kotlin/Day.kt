import java.io.File
import kotlin.system.measureNanoTime

abstract class Day(day: Int) {

    fun runPart1(test: Boolean = true){
        val fileName = if (test) {
            folder + testname
        } else{
            folder+ filename
        }
        val lines = File(fileName).readLines()
        println("Result: ${part1(lines)}")
    }

    fun runPart2(test: Boolean = true){
        val fileName = if (test) {
            folder + testname
        } else{
            folder+ filename
        }
        val lines = File(fileName).readLines()
        println("Result: ${part2(lines)}")
    }

    private val folder = "src/main/resources/"
    private val filename = "day${day}.txt"
    private val testname = "day${day}_test.txt"
    fun run(part1: Boolean = true, part2: Boolean = true, times: Int = 10000,test: Boolean = false){
        val fileName = if (test) {
            folder + filename
        } else{
            folder+testname
        }
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
    open fun part1Optimised(input:List<String>):String{
        TODO()
    }
    abstract fun part2(input:List<String>):String
}