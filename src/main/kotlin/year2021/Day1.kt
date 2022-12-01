package year2021

import Day

class Day1: Day(1) {

    override fun part1(input: List<String>, test: Boolean): String{
        var deeper = 0
        for (line in 1 until input.size){
            if ( input[line] > input[line-1]){
                deeper += 1
            }
        }
        return deeper.toString()
    }

    fun day1_part1_func(lines: List<String> ): String{
        var deeper = 0
//    return lines.zipWithNext().filter { pair -> pair.first<pair.second }.size.toString()
        lines.reduce { acc, num -> if (acc < num){deeper++}; return@reduce num }
        return deeper.toString()
    }

    override fun part2(input: List<String>, test: Boolean):String {
        var line1 = -1
        var line2 = -1
        var line3 = -1
        var deeper = 0
        for (line in input){
            if(line1 != -1){
                if ( line.toInt() > line1){
                    deeper++
                }
            }
            line1 = line2
            line2 = line3
            line3 = line.toInt()
        }
        return deeper.toString()
    }

}