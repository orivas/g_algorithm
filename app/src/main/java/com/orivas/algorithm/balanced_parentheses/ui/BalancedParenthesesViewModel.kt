package com.orivas.algorithm.balanced_parentheses.ui

import androidx.lifecycle.ViewModel
import com.orivas.algorithm.balanced_parentheses.domain.usecase.BalancedParenthesesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BalancedParenthesesViewModel @Inject constructor(
    private val useCase: BalancedParenthesesUseCase
): ViewModel() {

    fun validateString(data: String): String{
        return useCase.invoke(data)
    }

}