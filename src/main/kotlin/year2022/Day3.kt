class Day3: Day(3){
    override fun part1(input: List<String>, test:Boolean): String {
        var prioritySum = 0
        for (line in input){
            val length  =line.length
            val firstCompartment  =line.subSequence(0, length/2)
            val secondCompartment  =line.subSequence(length/2, length)
            var duplicate = 'a'
            for (char in firstCompartment){
                if (char in secondCompartment){
                    duplicate = char
                    break
                }
            }
            if (duplicate.isLowerCase()){
                prioritySum += duplicate.code -96
            }else{
                prioritySum += duplicate.code - 38
            }
        }
        return prioritySum.toString()
    }

    override fun part2(input: List<String>,  test:Boolean): String {
        var prioritySum = 0
        for (group in 0.. (input.size-1)/3){
            var duplicate = 'a'
            for (char in input[group*3+0]){
                if (char in input[group*3+1]){
                    if (char in input[group*3+2]){
                        duplicate = char
                        break
                    }
                }
            }
            if (duplicate.isLowerCase()){
                prioritySum += duplicate.code -96
            }else{
                prioritySum += duplicate.code - 38
            }
        }
        return prioritySum.toString()
    }

}