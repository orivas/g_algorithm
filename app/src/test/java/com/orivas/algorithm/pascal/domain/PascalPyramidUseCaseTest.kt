package com.orivas.algorithm.pascal.domain

import com.orivas.algorithm.tic_tac_toe.domain.TicTacToeCheckWinUseCase
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner.StrictStubs::class)
class PascalPyramidUseCaseTest {

    private lateinit var useCase: PascalPyramidUseCase

    @Before
    fun setUp() {
        useCase = PascalPyramidUseCase()
    }

    @Test
    fun `test 1`() {
        val rows = 1
        val result = useCase.invoke(rows)

        Assert.assertEquals(Math.pow(2.0, rows.toDouble()).toInt(), result + 1 )
    }

    @Test
    fun `test 2`() {
        val rows = 2
        val result = useCase.invoke(rows)

        Assert.assertEquals(Math.pow(2.0, rows.toDouble()).toInt(), result + 1 )
    }


    @Test
    fun `test 3`() {
        val rows = 3
        val result = useCase.invoke(rows)

        Assert.assertEquals(Math.pow(2.0, rows.toDouble()).toInt(), result + 1 )
    }

    @Test
    fun `test 4`() {
        val rows = 4
        val result = useCase.invoke(rows)

        Assert.assertEquals(Math.pow(2.0, rows.toDouble()).toInt(), result + 1 )
    }

    @Test
    fun `test 5`() {
        val rows = 5
        val result = useCase.invoke(rows)

        Assert.assertEquals(Math.pow(2.0, rows.toDouble()).toInt(), result + 1 )
    }

    @Test
    fun `test 6`() {
        val rows = 6
        val result = useCase.invoke(rows)

        Assert.assertEquals(Math.pow(2.0, rows.toDouble()).toInt(), result + 1 )
    }
}