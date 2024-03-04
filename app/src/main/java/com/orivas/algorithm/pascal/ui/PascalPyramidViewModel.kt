package com.orivas.algorithm.pascal.ui

import androidx.lifecycle.ViewModel
import com.orivas.algorithm.pascal.domain.PascalPyramidUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PascalPyramidViewModel @Inject constructor(
    private val useCase: PascalPyramidUseCase
) : ViewModel() {

    fun onPrint(rows: Int) {
        useCase.invoke(rows)
    }

}