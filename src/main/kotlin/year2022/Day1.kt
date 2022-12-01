package year2022

import Day

class Day1() : Day(1) {
    override fun part1(input: List<String>, test: Boolean): String {
        val calories = ArrayList<Int>()
        var curr_calories = 0
        for (line in input){
            if (line.isEmpty()){
                calories.add(curr_calories)
                curr_calories = 0
            }else {
                curr_calories += line.toInt()
            }
        }
        calories.sort()
        calories.reverse()
        return calories[0].toString()
    }

    override fun part2(input: List<String>, test: Boolean): String {
        val calories = ArrayList<Int>()
        var curr_calories = 0
        for (line in input){
            if (line.isEmpty()){
                calories.add(curr_calories)
                curr_calories = 0
            }else {
                curr_calories += line.toInt()
            }
        }
        calories.sort()
        calories.reverse()
        return (calories[0] + calories[1] + calories[2]).toString()
    }
}