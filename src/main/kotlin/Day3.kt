class Day3: Day(3){
    override fun part1(input: List<String>, test: Boolean): String {
        val mostCommon = mutableListOf<Int>()
        for (i in 0 until input[0].length){
            mostCommon.add(0)
        }
        for(line in input){
            for (char in line.indices){
                if (line[char] == '0'){
                    mostCommon[char] -= 1
                }else {
                    mostCommon[char] += 1
                }
            }
        }
        var gamma = ""
        var epsilon = ""
        for (number in mostCommon){
            if (number < 0){
                gamma += 0
                epsilon += 1
            }else{
                gamma += 1
                epsilon += 0
            }
        }
        return  (gamma.toInt(2)*epsilon.toInt(2)).toString()
        //10 min
    }

    override fun part2(input: List<String>, test: Boolean): String {
        val mostCommon = mutableListOf<Int>()
        for (i in 0 until input[0].length){
            mostCommon.add(0)
        }
        var oxygenLines: List<String> = input
        var pos = 0
        while(oxygenLines.size > 1){
            val char = getMostCommonAtPos(oxygenLines, pos)
            oxygenLines = oxygenLines.filter { it[pos]==char }
            pos++

        }
        val oxygen = oxygenLines[0].toInt(2)

        var co2Lines: List<String> = input
        pos = 0
        while(co2Lines.size > 1){
            val char = if (getMostCommonAtPos(co2Lines, pos) == '0'){
                '1'
            }else{
                '0'
            }
            co2Lines = co2Lines.filter { it[pos]==char }
            pos++

        }
        val co2 = co2Lines[0].toInt(2)

        return  (oxygen*co2).toString()
    }

    private fun getMostCommonAtPos(lines : List<String>, pos: Int): Char{
        var mostCommon = 0
        for(line in lines){

            if (line[pos] == '0'){
                mostCommon-= 1
            }else {
                mostCommon += 1
            }

        }
        return if (mostCommon<0){
            '0'
        }else {
            '1'
        }
    }
    //Time: forgot timer, probably 8 min

}