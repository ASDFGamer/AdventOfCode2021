package year2021

import Day
import generateMutableGrid
import generateMutableList
import java.lang.Integer.max
import java.lang.Integer.min

class Day5: Day(5){
    override fun part1(input: List<String>, test: Boolean): String {
        val size = if (test) 10 else 1000
        val grid = generateMutableGrid(size, size, 0)
        for (line in input){
            val start_end = line.split(" -> ")
            val start = start_end[0].split(",")
            val end = start_end[1].split(",")
            if (start[0] == end[0]){
                val startInt = start[0].toInt()
                val max_v = max(start[1].toInt(), end[1].toInt())
                val min_v = min(start[1].toInt(), end[1].toInt())
                for (i in min_v .. max_v){
                    grid[i][startInt] ++
                }
            }
            else if (start[1] == end[1]){
                val startInt = start[1].toInt()
                val max_v = max(start[0].toInt(), end[0].toInt())
                val min_v = min(start[0].toInt(), end[0].toInt())
                for (i in min_v .. max_v){
                    grid[startInt][i] ++
                }
            }else{
                //throw IllegalStateException()
            }
        }
        if (test) {
            for (line in grid) {
                println(line)
            }
        }
        val linesPerCell = generateMutableList(10, 0)
        grid.forEach{ line -> line.forEach{linesPerCell[it]++} }
        val result = linesPerCell.sum()-linesPerCell[0]-linesPerCell[1]
        return result.toString()
        //20 min
        //runtime: 16915340 ns
    }

    override fun part2(input: List<String>, test: Boolean): String {
        val size = 1000
        val grid = mutableListOf<MutableList<Int>>()
        for(i in 0 until size){
            val line = mutableListOf<Int>()
            for (j in 0 until size){
                line.add(0)
            }
            grid.add(line)
        }
        for (line in input){
            val start_end = line.split(" -> ")
            val start = start_end[0].split(",")
            val end = start_end[1].split(",")
            if (start[0] == end[0]){
                val startInt = start[0].toInt()
                val max_v = max(start[1].toInt(), end[1].toInt())
                val min_v = min(start[1].toInt(), end[1].toInt())
                for (i in min_v .. max_v){
                    grid[i][startInt] ++
                }
            }
            else if (start[1] == end[1]){
                val startInt = start[1].toInt()
                val max_v = max(start[0].toInt(), end[0].toInt())
                val min_v = min(start[0].toInt(), end[0].toInt())
                for (i in min_v .. max_v){
                    grid[startInt][i] ++
                }
            }else{
                val curr_pos = mutableListOf<Int>(start[0].toInt(), start[1].toInt())

                while(end[1].toInt() != curr_pos[1]){
                    grid[curr_pos[1]][curr_pos[0]] ++
                    if (end[0].toInt() < curr_pos[0]){
                        curr_pos[0]--
                    }else {
                        curr_pos[0]++
                    }
                    if (end[1].toInt() < curr_pos[1]){
                        curr_pos[1]--
                    }else {
                        curr_pos[1]++
                    }
                }
                grid[curr_pos[1]][curr_pos[0]] ++
            }
        }
        val haeufig = mutableListOf<Int>()
        for (i in 0..10){
            haeufig.add(0)
        }
        for (line in grid){
            for (cell in line){
                haeufig[cell]++
            }
        }
        var result = 0
        for (i in 2 .. 10){
            result += haeufig[i]
        }
//        for (line in grid){
//            println(line)
//        }
        return result.toString()
        //10 min
        //runtime: 28573997 ns
    }

}