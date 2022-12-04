class Day4: Day(4){
    override fun part1(input: List<String>, test:Boolean): String {
        var fully_contain = 0
        for (line in input){
            val split_line  = line.split(",")
            val first_start = split_line[0].split("-")[0].toInt()
            val first_end = split_line[0].split("-")[1].toInt()
            val second_start = split_line[1].split("-")[0].toInt()
            val second_end = split_line[1].split("-")[1].toInt()
            if (first_start <= second_start && first_end >= second_end){
                fully_contain++
            }else if (first_start >= second_start && first_end <= second_end){
                fully_contain++
            }
        }
        return fully_contain.toString()
    }

    override fun part2(input: List<String>,  test:Boolean): String {
        var overlap = 0
        for (line in input){
            val split_line  = line.split(",")
            val first_start = split_line[0].split("-")[0].toInt()
            val first_end = split_line[0].split("-")[1].toInt()
            val second_start = split_line[1].split("-")[0].toInt()
            val second_end = split_line[1].split("-")[1].toInt()
            if (first_start in second_start..second_end ||
                first_end in second_start .. second_end ||
                second_start in first_start .. first_end ||
                second_end in first_start .. first_end){
                overlap++
            }
        }
        return overlap.toString()
    }

}