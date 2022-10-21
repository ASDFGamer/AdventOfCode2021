import java.lang.Math.abs

class Day7: Day(7){
    override fun part1(input: List<String>, test:Boolean): String {
        val positions = input[0].split(",").map { it.toInt() }
        val minPos = positions.minOrNull()
        val maxPos = positions.maxOrNull()
        var bestCost = Int.MAX_VALUE
        for (i in minPos!! ..maxPos!!){
            var cost = 0;
            for (position in positions){
                cost+=abs(position-i)
            }
            if(cost < bestCost){
                bestCost = cost
            }
        }
        return bestCost.toString()
    }

    override fun part2(input: List<String>,  test:Boolean): String {
        val positions = input[0].split(",").map { it.toInt() }
        val minPos = positions.minOrNull()
        val maxPos = positions.maxOrNull()
        var bestCost = Int.MAX_VALUE
        for (i in minPos!! ..maxPos!!){
            var cost = 0;
            for (position in positions){
                cost+=moreCosts(abs(position-i))
            }
            if(cost < bestCost){
                bestCost = cost
            }
        }
        return bestCost.toString()
    }

    fun moreCosts(change: Int): Int{
        return ((change + 1)* (change/2F)).toInt()
    }

}