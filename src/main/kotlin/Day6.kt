class Day6: Day(6){
    override fun part1(input: List<String>, test:Boolean): String {
        var fishes: MutableList<Int> = input[0].split(",").map { it.toInt() }.toMutableList()
        val days = 80
        val newfischesonDay = generateMutableList(days, 0)
        for (fish in fishes){
            newfischesonDay[fish]++
        }
        var numfishes:Long = fishes.size.toLong()
        for (day in 1 until days){
            numfishes+= newfischesonDay[day]
//            genLine(newfischesonDay, day)
            if ((day + 7) < days){
                newfischesonDay[day + 7] += newfischesonDay[day]
            }
            if ((day + 9) < days ) {
                newfischesonDay[day + 9] += newfischesonDay[day]
            }

        }
        return numfishes.toString()
    }

    fun genLine(newfischesonDay: List<Int>, day: Int){
        var out = ""
        for (i in day until newfischesonDay.size){
            for(j in 0 until  newfischesonDay[i]){
                out += "${i-day},"
            }
        }
        println(out)
    }

    override fun part2(input: List<String>, test:Boolean): String {
        val fishes: MutableList<Int> = input[0].split(",").map { it.toInt() }.toMutableList()
        val days = 256
        val newfischesonDay = generateMutableList(days, 0L)
        for (fish in fishes){
            newfischesonDay[fish]++
        }
        var numfishes:Long = fishes.size.toLong()
        for (day in 1 until days){
            numfishes+= newfischesonDay[day]
//            genLine(newfischesonDay, day)
            if ((day + 7) < days){
                newfischesonDay[day + 7] += newfischesonDay[day]
            }
            if ((day + 9) < days ) {
                newfischesonDay[day + 9] += newfischesonDay[day]
            }

        }
        return numfishes.toString()
    }

}