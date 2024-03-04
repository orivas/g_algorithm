package com.orivas.algorithm.tic_tac_toe.ui

import androidx.lifecycle.ViewModel
import com.orivas.algorithm.balanced_parentheses.domain.usecase.BalancedParenthesesUseCase
import com.orivas.algorithm.tic_tac_toe.domain.TicTacToeCheckWinUseCase
import com.orivas.algorithm.tic_tac_toe.domain.TicTacToeValidUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class TicTacToeViewModel @Inject constructor(
    private val useCase: TicTacToeValidUseCase,
    private val ticTacToeCheckWinUseCase: TicTacToeCheckWinUseCase
) : ViewModel() {

    private val _positionsUI = MutableStateFlow<Array<Array<Int>>?>(emptyArray())
    val positionUI: StateFlow<Array<Array<Int>>?> = _positionsUI.asStateFlow()
    fun validateString(data: String): String {
        _positionsUI.value = useCase.invoke(data)
        return ticTacToeCheckWinUseCase.invoke(_positionsUI.value)
    }

}