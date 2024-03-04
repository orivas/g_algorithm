package com.orivas.algorithm.pascal.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.orivas.algorithm.R
import com.orivas.algorithm.databinding.FragmentPascalPyramidBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PascalPyramidFragment : Fragment() {

    private var _binding: FragmentPascalPyramidBinding? = null
    private val viewModel: PascalPyramidViewModel by viewModels()

    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentPascalPyramidBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding?.create?.setOnClickListener {
            viewModel.onPrint(_binding?.input?.editText?.text.toString().toInt())
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}