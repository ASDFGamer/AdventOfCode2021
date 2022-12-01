package year2021

import Day

class Day2: Day(2) {
    //Part1: 8:10
    //Part2: +2 min


    override fun part1(input: List<String>, test: Boolean): String {
        var depth = 0
        var horizontal = 0
        for (line in input){
            val split = line.split(" ")
            when(split[0]) {
                "forward" -> horizontal += split[1].toInt()
                "down" -> depth += split[1].toInt()
                "up" -> depth -= split[1].toInt()
                else -> throw IllegalStateException(split[0])
            }
        }
        return (depth*horizontal).toString()
        //Original: 157238 ns
        //Optimised:  6369 ns
    }

    override fun part1Optimised(input: List<String>): String {
        var depth = 0
        var horizontal = 0
        input.forEach{
            when(it[0]){
                'f' -> horizontal  += it[8].code -48
                'd' -> depth += it[5].code -48
                'u' -> depth -= it[3].code -48
            }
        }
        return (depth*horizontal).toString()
        //Original: 157238 ns
        //Optimised:  6369 ns
    }

    override fun part2(input: List<String>, test: Boolean): String {
        var aim = 0
        var depth = 0
        var horizontal = 0
        for (line in input){
            val split = line.split(" ")
            when(split[0]){
                "forward" -> {
                    horizontal  += split[1].toInt()
                    depth  += split[1].toInt()*aim
                }
                "down" -> aim += split[1].toInt()
                "up" -> aim -= split[1].toInt()
                else -> throw IllegalStateException(split[0])
            }
        }
        return (depth*horizontal).toString()
        //Original: 93262 ns
    }
}