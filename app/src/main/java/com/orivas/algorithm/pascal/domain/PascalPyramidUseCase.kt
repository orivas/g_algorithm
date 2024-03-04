package com.orivas.algorithm.pascal.domain

import javax.inject.Inject

class PascalPyramidUseCase @Inject constructor() {

    fun invoke(rows: Int): Int {
        var number = 1
        var result = 0;

        for (i in 0 until rows) {

            for (space in 1 until rows - i) {
                print("  ")
            }

            for (j in 0..i) {
                if (j == 0 || i == 0) {
                    number = 1
                    if(j == 0)
                    System.out.printf("%4d result:", result + 1)
                }
                else
                    number = number * (i - j + 1) / j

                result += number

                System.out.printf("%4d", number)
            }

            println()
        }

        return result
    }

}