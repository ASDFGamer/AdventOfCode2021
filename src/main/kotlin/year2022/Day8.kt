class Day8: Day(8){
    override fun part1(input: List<String>, test:Boolean): String {
        var visible_trees = 0
        val initHeight = -1
        val rowVisibilityHightRight = generateMutableList(input.size, initHeight)
        val columnVisibilityHightDown = generateMutableList(input[0].length, initHeight)
        val visibleTreesGrid= generateMutableGrid(input.size, input[0].length, false)
        for (row in input.indices){
            for (column in 0 until input[row].length){
                if (rowVisibilityHightRight[row] < input[row][column].code){
                    rowVisibilityHightRight[row] = input[row][column].code
                    if (!visibleTreesGrid[row][column]){
                        visibleTreesGrid[row][column] = true
                        visible_trees++
                    }
                }
                if (columnVisibilityHightDown[column] < input[row][column].code){
                    columnVisibilityHightDown[column] = input[row][column].code
                    if (!visibleTreesGrid[row][column]){
                        visibleTreesGrid[row][column] = true
                        visible_trees++
                    }
                }
            }
        }

        val rowVisibilityHightLeft = generateMutableList(input.size, initHeight)
        val columnVisibilityHightUp = generateMutableList(input[0].length, initHeight)
        for (row in input.size -1 downTo 0){
            for (column in input[row].length-1 downTo  0){
                if (rowVisibilityHightLeft[row] < input[row][column].code){
                    rowVisibilityHightLeft[row] = input[row][column].code
                    if (!visibleTreesGrid[row][column]){
                        visibleTreesGrid[row][column] = true
                        visible_trees++
                    }
                }
                if (columnVisibilityHightUp[column] < input[row][column].code){
                    columnVisibilityHightUp[column] = input[row][column].code
                    if (!visibleTreesGrid[row][column]){
                        visibleTreesGrid[row][column] = true
                        visible_trees++
                    }
                }
            }
        }
        for (i in visibleTreesGrid){
            for (j in i){
                if (j){
                    print("X")
                }else{
                    print(" ")
                }
            }
            println()
        }
        return visible_trees.toString()
    }

    override fun part2(input: List<String>,  test:Boolean): String {
        var scenicScore = 0
        for (row in 1 .. input.size -2) {
            for (column in 1 .. input[row].length-2) {
                var tmpScenicScore = 1
                var tmpmultiplier = 0
                var tmpRow = row
                do {
                    tmpmultiplier ++
                    tmpRow --
                } while (tmpRow > 0 && input[tmpRow][column]<input[row][column])
                tmpScenicScore *= tmpmultiplier
                tmpmultiplier = 0
                tmpRow= row
                do {
                    tmpmultiplier ++
                    tmpRow ++
                } while (tmpRow < input.size-1  && input[tmpRow][column]<input[row][column])
                tmpScenicScore *= tmpmultiplier
                tmpmultiplier = 0
                var tmpColumn= column
                do {
                    tmpmultiplier ++
                    tmpColumn --
                } while (tmpColumn > 0  && input[row][tmpColumn]<input[row][column])
                tmpScenicScore *= tmpmultiplier
                tmpmultiplier = 0
                tmpColumn= column
                do {
                    tmpmultiplier ++
                    tmpColumn ++
                } while (tmpColumn < input[row].length -1 && input[row][tmpColumn]<input[row][column])
                tmpScenicScore *= tmpmultiplier
                if (tmpScenicScore > scenicScore){
                    scenicScore = tmpScenicScore
                }
            }
        }
        return scenicScore.toString()

    }

}