package com.orivas.algorithm.alphanumeric_string_sort.domain.usecase

import javax.inject.Inject

class AlphaNumericStringSortUseCase @Inject constructor() {

    fun invoke(data: String): String {
        return getLowerCase(data) + getUpperCase(data) + getNumbers(data) + getSpecialCharacters(data)
    }

    private fun getNumbers(data: String): String {
        val numbers = data.replace("[^0-9]".toRegex(), "")
        return "${getOddNumbers(numbers) + getEvenNumbers(numbers)}"
    }

    private fun getLowerCase(data: String): String {
        return data.replace("[^a-z]".toRegex(), "")
    }

    private fun getUpperCase(data: String): String {
        return data.replace("[^A-Z]".toRegex(), "")
    }

    private fun getSpecialCharacters(data: String): String {
        return data.replace("[A-Z-a-z-0-9]".toRegex(), "")
    }

    private fun getOddNumbers(data: String): String {
        return data.asIterable().filter { it.digitToInt() % 2 == 1 }.toString().toFormat()
    }

    private fun getEvenNumbers(data: String): String {
        return data.asIterable().filter { it.digitToInt() % 2 == 0 }.toString().toFormat()
    }

}

fun String.toFormat(): String{
    return this
        .replace("[","")
        .replace("]","")
        .replace(",","")
        .replace(" ","")
}