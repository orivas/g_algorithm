package com.orivas.algorithm.tic_tac_toe.domain

import javax.inject.Inject

class TicTacToeValidUseCase @Inject constructor() {
    fun invoke(data: String): Array<Array<Int>>? {
        val arrayInt =
            data.split(" ", "[", ",", "]").filter { it != "" }.map { it.toInt() }.toTypedArray()
        val isValid = arrayInt.none { it > 2 }
        val array: Array<Array<Int>> = Array(9) { Array(2) { -1 } }
        var i = 0
        for (position in 0 until  arrayInt.size / 2 ) {
            array[position] = arrayOf(arrayInt[i], arrayInt[i+1])
            i+=2
        }
        return if (arrayInt.size % 2 != 0 || !isValid) null else array
    }

}