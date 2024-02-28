package com.orivas.algorithm.balanced_parentheses.domain.usecase

import javax.inject.Inject

class BalancedParenthesesUseCase @Inject constructor() {

    fun invoke(data: String): String {
        return getParentheses(data)
    }

    private fun getParentheses(data: String): String {
        val parentheses = data.replace("[^(-)]".toRegex(), "")
        return "${areValidParentheses(parentheses)}"
    }

    private fun areValidParentheses(data: String): Boolean {
        return if (data.length % 2 != 0) {
            false
        } else {
            var last = ""
            var current = data
            var isValid = true
            while (current.isNotEmpty()) {
                if(last == current){
                    isValid = false
                    break
                }else {
                    last = current
                }
                current = current.replace("()","")

            }
            return isValid
        }
    }

}