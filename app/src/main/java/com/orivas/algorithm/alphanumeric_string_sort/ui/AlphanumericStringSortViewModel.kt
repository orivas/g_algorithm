package com.orivas.algorithm.alphanumeric_string_sort.ui

import androidx.lifecycle.ViewModel
import com.orivas.algorithm.alphanumeric_string_sort.domain.usecase.AlphaNumericStringSortUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AlphanumericStringSortViewModel @Inject constructor(
    private val useCase: AlphaNumericStringSortUseCase
): ViewModel() {

    fun sortString(data: String): String{
        return useCase.invoke(data)
    }

}