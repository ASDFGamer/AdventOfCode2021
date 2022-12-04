class Day2: Day(2){

    enum class OpponentShape(val symbol: String) {
        EMPTY("E"),
        Rock("A"),
        Paper("B"),
        Scissors("C");
        companion object {
            fun getShape(symbol: String): OpponentShape {
                for (value in OpponentShape.values()) {
                    if (value.symbol == symbol) {
                        return value
                    }
                }
                return EMPTY
            }
        }

    }

    enum class OwnShape(val symbol: String){
        EMPTY("E"),
        Rock("X"),
        Paper("Y"),
        Scissors("Z");
        companion object {
            fun getShape(symbol: String): OwnShape {
                for (value in OwnShape.values()) {
                    if (value.symbol == symbol) {
                        return value
                    }
                }
                return EMPTY
            }
        }
    }
    override fun part1(input: List<String>, test:Boolean): String {
        var points = 0
        for (line in input){
            val opponent = OpponentShape.getShape(line.split(" ")[0])
            val own = OwnShape.getShape(line.split(" ")[1])
            points += own.ordinal
            points += when (opponent){
                OpponentShape.Rock -> {
                    when(own){
                        OwnShape.Rock -> 3
                        OwnShape.Paper -> 6
                        OwnShape.Scissors -> 0
                        else -> throw IllegalStateException()
                    }
                }
                OpponentShape.Paper -> {
                    when(own){
                        OwnShape.Rock -> 0
                        OwnShape.Paper -> 3
                        OwnShape.Scissors -> 6
                        else -> throw IllegalStateException()
                    }
                }
                OpponentShape.Scissors -> {
                    when(own){
                        OwnShape.Rock -> 6
                        OwnShape.Paper -> 0
                        OwnShape.Scissors -> 3
                        else -> throw IllegalStateException()
                    }
                }
                else -> throw IllegalStateException()

            }
        }
        return points.toString()
    }

    enum class OwnResult(val symbol: String){
        EMPTY("E"),
        Lose("X"),
        Draw("Y"),
        Win("Z");
        companion object {
            fun getShape(symbol: String): OwnResult {
                for (value in OwnResult.values()) {
                    if (value.symbol == symbol) {
                        return value
                    }
                }
                return EMPTY
            }
        }
    }

    override fun part2(input: List<String>,  test:Boolean): String {
        var points = 0
        for (line in input){
            val opponent = OpponentShape.getShape(line.split(" ")[0])
            val own = OwnResult.getShape(line.split(" ")[1])
            points += when (opponent){
                OpponentShape.Rock -> {
                    when(own){
                        OwnResult.Lose -> 3
                        OwnResult.Draw -> 4
                        OwnResult.Win -> 8
                        else -> throw IllegalStateException()
                    }
                }
                OpponentShape.Paper -> {
                    when(own){
                        OwnResult.Lose -> 1
                        OwnResult.Draw -> 5
                        OwnResult.Win -> 9
                        else -> throw IllegalStateException()
                    }
                }
                OpponentShape.Scissors -> {
                    when(own){
                        OwnResult.Lose -> 2
                        OwnResult.Draw -> 6
                        OwnResult.Win -> 7
                        else -> throw IllegalStateException()
                    }
                }
                else -> throw IllegalStateException()

            }
        }
        return points.toString()
    }

}