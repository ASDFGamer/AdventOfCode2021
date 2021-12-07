import java.io.File
import kotlin.system.measureNanoTime

abstract class Day(day: Int) {

    fun runPart1(test: Boolean = true, measureTime:Boolean = false, iterations: Int = 10000){
        runPart(part = ::part1, test = test, measureTime=measureTime , iterations = iterations)
    }

    fun runPart2(test: Boolean = true,  measureTime:Boolean = false, iterations: Int = 10000){
        runPart(part = ::part2, test = test, measureTime=measureTime, iterations = iterations)
    }

    private fun runPart(part: (List<String>, Boolean) -> String, test :Boolean= true, measureTime:Boolean = false, iterations: Int = 10000){
        val lines = loadFile(test)
        println("Result: ${part(lines, test)}")
        if (measureTime){
            measureRuntime(block = {part(lines, test)}, iterations = iterations)
        }
    }

    private fun measureRuntime(block: () -> Unit, iterations : Int = 10000) {
        val time = measureNanoTime {
            for (i in 1..iterations) {
                block()
            }
        }
        println("Time: ${time/iterations} ns")
    }

    private fun loadFile(test:Boolean = true): List<String>{
        val fileName = if (test) {
            folder + filenameTest
        } else{
            folder+filename
        }
        return File(fileName).readLines()
    }

    private val folder = "src/main/resources/"
    private val filename = "day${day}.txt"
    private val filenameTest = "day${day}_test.txt"
    fun run(part1: Boolean = true, part2: Boolean = true, times: Int = 10000,test: Boolean = false, measureTime: Boolean = true){
        if (part1) {
            runPart1(test = test, measureTime =measureTime, iterations = times)
        }
        if (part2) {
            runPart2(test = test, measureTime =measureTime, iterations = times)
        }
    }

    abstract fun part1(input: List<String>, test: Boolean):String
    open fun part1Optimised(input:List<String>):String{
        TODO()
    }
    abstract fun part2(input: List<String>, test: Boolean):String
}