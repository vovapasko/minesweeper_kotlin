package minesweeper

import kotlin.random.Random

const val mineFigure = "X"
const val safeCellFigure = "."
const val fieldRowsAmount = 9
const val fieldColsAmount = 9

fun main() {
    print("How many mines do you want on the field?")
    val minesAmount = readLine()!!.toInt()
    val mineField: MutableList<MutableList<String>> = generateEmptyField()
    val mines: MutableList<MutableList<Int>> = generateMines(minesAmount)
    for (i in 0 until mines.size){
        val mineRow = mines[i][0]
        val mineCol = mines[i][1]
        mineField[mineRow][mineCol] = mineFigure
    }
    displayField(mineField)
}

fun displayField(field: MutableList<MutableList<String>>) {
    for (i in field.indices) {
        println(field[i].joinToString(""))
    }

}

fun generateEmptyField(): MutableList<MutableList<String>> {
    return MutableList(fieldColsAmount) { MutableList(fieldRowsAmount) { safeCellFigure } }
}

fun generateMines(minesAmount: Int): MutableList<MutableList<Int>> {
    val mines = mutableListOf<MutableList<Int>>()
    var i = 0
    while (i < minesAmount) {
        val newCell: MutableList<Int> = randomizeList()
        if (newCell !in mines) {
            mines.add(newCell)
            i++
        }
    }
    return mines
}

fun randomizeList(): MutableList<Int> {
    val randomRowIndex = Random.nextInt(fieldRowsAmount)
    val randomColIndex = Random.nextInt(fieldColsAmount)
    return mutableListOf(randomRowIndex, randomColIndex)
}