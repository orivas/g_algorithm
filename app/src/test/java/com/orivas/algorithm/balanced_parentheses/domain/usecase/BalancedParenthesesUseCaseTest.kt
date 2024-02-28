package com.orivas.algorithm.balanced_parentheses.domain.usecase

import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner.StrictStubs::class)
internal class BalancedParenthesesUseCaseTest {

    private lateinit var useCase: BalancedParenthesesUseCase

    @Before
    fun setUp() {
        useCase = BalancedParenthesesUseCase()
    }

    @Test
    fun `sort`() {
        val data = "()"
        val result = useCase.invoke(data)

        Assert.assertEquals(result, "true")
    }

    @Test
    fun `sort 2`() {
        val data = "(hello, world)"
        val result = useCase.invoke(data)

        Assert.assertEquals(result, "true")
    }

    @Test
    fun `sort 3`() {
        val data = "Random text (as this) is ok()."
        val result = useCase.invoke(data)

        Assert.assertEquals(result, "true")
    }

    @Test
    fun `sort 4`() {
        val data = ")("
        val result = useCase.invoke(data)

        Assert.assertEquals(result, "false")
    }

    @Test
    fun `sort 5`() {
        val data = "(Hello (,) world (!))"
        val result = useCase.invoke(data)

        Assert.assertEquals(result, "true")
    }

    @Test
    fun `sort 6`() {
        val data = ")()("
        val result = useCase.invoke(data)

        Assert.assertEquals(result, "false")
    }

    @Test
    fun `sort 7`() {
        val data = "())(()"
        val result = useCase.invoke(data)

        Assert.assertEquals(result, "false")
    }
}