class Day4: Day(4){
    override fun part1(input: List<String>): String {
        val numbers = input[0].split(",")
        val boards = getBoards(input.subList(2, input.size))
        var boardHasWon: Board? = null
        for (number in numbers) {
            if (number.isEmpty()){
                continue
            }
            val intNumber = number.toInt()
            for (board in boards) {
                board.mark(intNumber)
            }
            for (board in boards){
                if (board.hasWon()){
                    boardHasWon = board
                }
            }
            if (boardHasWon != null){
                break
            }
        }
        return boardHasWon?.calculateResult().toString()
        //Time: ca 35 min
    }

    fun getBoards(input: List<String>): List<Board>{
        val boards = mutableListOf<Board>()
        var boardLayout = mutableListOf<String>()
        for (line in input){
            if (line.isEmpty()) {
                if (boardLayout.size == 5) {
                    boards.add(Board(boardLayout))
                }
                boardLayout = mutableListOf()
            }else{
                boardLayout.add(line)
            }
        }
        if (boardLayout.size == 5) {
            boards.add(Board(boardLayout))
        }
        return boards
    }

    override fun part2(input: List<String>): String {
        val numbers = input[0].split(",")
        val boards = getBoards(input.subList(2, input.size))
        val boardHasWon = mutableListOf<Board>()
        for (number in numbers) {
            if (number.isEmpty()){
                continue
            }
            val intNumber = number.toInt()
            for (board in boards) {
                board.mark(intNumber)
            }
            for (board in boards){
                if (board.hasWon() && !boardHasWon.contains(board)){
                    boardHasWon.add(board)
                }
            }
            if (boardHasWon.size == boards.size){
                break
            }
        }

        return boardHasWon.last().calculateResult().toString()
        //Time: ca 5 min
    }

}

class Board(boardLayout: List<String>) {
    val boardGrid = generateGrid(boardLayout)
    var lastNumber = 0
    private fun generateGrid(boardLayout: List<String>): List<List<Cell>> {
        val grid = mutableListOf<List<Cell>>()
        for (line in boardLayout){
            val gridLine = mutableListOf<Cell>()
            val split = line.split(" ")
            for (number in split){
                if (number.isEmpty()){
                    continue
                }
                gridLine.add(Cell(number.toInt()))
            }
            grid.add(gridLine)
        }
        return grid
    }

    fun mark(number: Int) {
        for (line in boardGrid){
            for (cell in line){
                if (cell.number == number){
                    cell.checked = true
                }
            }
        }
        lastNumber = number
    }

    fun hasWon(): Boolean {
        for (line in boardGrid){
            var won = true
            for (cell in line){
                won = if (won){
                    cell.checked
                }else{
                    won
                }
            }
            if (won){
                return true
            }
        }

        for (i in 0 ..4 ){
            var won = true
            for (j in 0..4 ){
                won = if (won){
                    boardGrid[j][i].checked
                }else{
                    won
                }
            }
            if (won){
                return true
            }
        }

        var diagwon = true
        for (i in 0..4){
            diagwon = if (diagwon){
                boardGrid[i][i].checked
            }else{
                diagwon
            }
        }
        if (diagwon){
            return true
        }
        return false
    }

    fun calculateResult(): Int {
        var sum = 0
        for (line in boardGrid){
            for (cell in line){
                if (!cell.checked){
                   sum += cell.number
                }
            }
        }
        return sum * lastNumber
    }

}

class Cell(val number: Int){
    var checked = false
}