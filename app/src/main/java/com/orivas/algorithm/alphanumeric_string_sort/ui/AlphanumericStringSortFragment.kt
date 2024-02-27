package com.orivas.algorithm.alphanumeric_string_sort.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.orivas.algorithm.databinding.FragmentFirstBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
@AndroidEntryPoint
class AlphanumericStringSortFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val viewModel: AlphanumericStringSortViewModel by viewModels()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.sort.setOnClickListener {
            binding.result.text = "Result: ${viewModel.sortString(binding.input.editText?.text.toString())}"
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}