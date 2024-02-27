package com.orivas.algorithm.alphanumeric_string_sort.domain.usecase

import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner.StrictStubs::class)
internal class AlphaNumericStringSortUseCaseTest {

    private lateinit var useCase: AlphaNumericStringSortUseCase

    @Before
    fun setUp() {
        useCase = AlphaNumericStringSortUseCase()
    }

    @Test
    fun `sort`() {
        val data = "asdDFD34534asddDFGFDGD\$%\$%\$%\$%%\$/%&//"
        val result = useCase.invoke(data)

        Assert.assertEquals(result, "asdasddDFDDFGFDGD35344\$%\$%\$%\$%%\$/%&//")
    }

    @Test
    fun `sort 2`() {
        val data = "asdDFD34534asddDFGFDGDasasdsasdf"
        val result = useCase.invoke(data)

        Assert.assertEquals(result, "asdasddasasdsasdfDFDDFGFDGD35344")
    }

    @Test
    fun `sort 3`() {
        val data = "1234asdf!,.."
        val result = useCase.invoke(data)

        Assert.assertEquals(result, "asdf1324!,..")
    }

    @Test
    fun `sort 4`() {
        val data = "1234512345"
        val result = useCase.invoke(data)

        Assert.assertEquals(result, "1351352424")
    }

    @Test
    fun `sort 5`() {
        val data = "1234512345asdfASDF_"
        val result = useCase.invoke(data)

        Assert.assertEquals(result, "asdfASDF1351352424_")
    }
}