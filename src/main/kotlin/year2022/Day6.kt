class Day6: Day(6){
    override fun part1(input: List<String>, test:Boolean): String {
        val dataStream = input[0]
        val dataLength = 4
        for(char in dataLength until dataStream.length){
            if (dataStream.subSequence(char - dataLength, char).toSortedSet().size == dataLength){
                return char.toString()
            }
        }
        return ""
    }

    override fun part2(input: List<String>,  test:Boolean): String {
        val dataStream = input[0]
        val dataLength = 14
        for(char in dataLength until dataStream.length){
            if (dataStream.subSequence(char - dataLength, char).toHashSet().size == dataLength){
                return char.toString()
            }
        }
        //sorted set: 935446 ns
        //set: 704383 ns
        //hash set: 499728 ns
        return ""
    }

}