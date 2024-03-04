package com.orivas.algorithm.tic_tac_toe

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.orivas.algorithm.databinding.FragmentTicTacToeBinding
import com.orivas.algorithm.tic_tac_toe.ui.TicTacToeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class TicTacToeFragment : Fragment() {

    private var _binding: FragmentTicTacToeBinding? = null
    private val viewModel: TicTacToeViewModel by viewModels()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentTicTacToeBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.validate.setOnClickListener {
            clean()
            binding.result.text = viewModel.validateString(binding.input.text.toString())
        }

        lifecycleScope.launch {
            viewModel.positionUI.collect {
                println("array : ${it.contentDeepToString()}")
                it?.let {
                    it.forEachIndexed { index, element ->
                        val player = if(index %2 == 0) "A" else "B"
                        if (element[0] == 0 && element[1] == 0) {
                            binding.b1.text = player
                        }else if (element[0] == 1 && element[1] == 0) {
                            binding.b2.text = player
                        }else if (element[0] == 2 && element[1] == 0) {
                            binding.b3.text = player
                        }else if (element[0] == 0 && element[1] == 1) {
                            binding.b4.text = player
                        }else if (element[0] == 1 && element[1] == 1) {
                            binding.b5.text = player
                        }else if (element[0] == 2 && element[1] == 1) {
                            binding.b6.text = player
                        }else if (element[0] == 0 && element[1] == 2) {
                            binding.b7.text = player
                        }else if (element[0] == 1 && element[1] == 2) {
                            binding.b8.text = player
                        }else if (element[0] == 2 && element[1] == 2) {
                            binding.b9.text = player
                        }
                    }
                }
            }
        }
    }

    private fun clean(){
        binding.b1.text = ""
        binding.b2.text = ""
        binding.b3.text = ""
        binding.b4.text = ""
        binding.b5.text = ""
        binding.b6.text = ""
        binding.b7.text = ""
        binding.b8.text = ""
        binding.b9.text = ""
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}