package com.orivas.algorithm.tic_tac_toe.domain

import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner.StrictStubs::class)
class TicTacToeCheckWinUseCaseTest {

    private lateinit var useCase: TicTacToeCheckWinUseCase

    @Before
    fun setUp() {
        useCase = TicTacToeCheckWinUseCase()
    }

    @Test
    fun `test 1`() {
        val data: Array<Array<Int>> = arrayOf(
            arrayOf(0, 0),
            arrayOf(2, 0),
            arrayOf(1, 1),
            arrayOf(2, 1),
            arrayOf(0, 1),
            arrayOf(2, 2)
        )
        val resul = useCase.invoke(data)
        Assert.assertEquals("Win: B", resul)
    }

    @Test
    fun `test 2`() {
        val data: Array<Array<Int>> = arrayOf(
            arrayOf(0, 0),
            arrayOf(2, 0),
            arrayOf(1, 1),
            arrayOf(2, 1),
            arrayOf(0, 1),
            arrayOf(2, 0)
        )
        val resul = useCase.invoke(data)
        Assert.assertEquals("None", resul)
    }

    @Test
    fun `test 3`() {
        val data: Array<Array<Int>> = arrayOf(
            arrayOf(0, 0),
            arrayOf(2, 0),
            arrayOf(1, 1),
            arrayOf(2, 1),
            arrayOf(0, 1),
            arrayOf(2, 0),
            arrayOf(0, 2)
        )
        val resul = useCase.invoke(data)
        Assert.assertEquals("Win: A", resul)
    }
}