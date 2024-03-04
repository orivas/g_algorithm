package com.orivas.algorithm.tic_tac_toe.domain

import javax.inject.Inject

class TicTacToeCheckWinUseCase @Inject constructor() {

    companion object {

        private val POSITIONS_WIN_CODE: Array<String> = arrayOf(
            "06",
            "33",
            "63",
            "30",
            "33",
            "36"
        )
    }

    fun invoke(data: Array<Array<Int>>?): String {
        val playerA: Array<Array<Int>> = Array(5) { Array(2) { -1 } }
        val playerB: Array<Array<Int>> = Array(5) { Array(2) { -1 } }
        return data?.let {
            data.forEachIndexed { index, ints ->
                if (index % 2 == 0) {
                    playerA.addPoint(ints)
                } else {
                    playerB.addPoint(ints)
                }
            }
            validateWin(playerA, playerB)
        } ?: "Error"
    }

    private fun validateWin(playerA: Array<Array<Int>>, playerB: Array<Array<Int>>): String {
        return if (validateOptionWin(playerA)) {
            "Win: A"
        } else if (validateOptionWin(playerB)) {
            "Win: B"
        } else {
            "None"
        }
    }

    private fun validateOptionWin(movements: Array<Array<Int>>): Boolean {
        println("Array ${movements[0][0]},${movements[0][1]}")
        println("Array ${movements[1][0]},${movements[1][1]}")
        println("Array ${movements[2][0]},${movements[2][1]}")
        return true
    }

}

fun Array<Array<Int>>.addPoint(value: Array<Int>) {
    for (position in 0 until this.size){
        if (this[position][0] == -1) {
            this[position] = value
            break
        }
    }
}
