package com.yagr.scv.createrepair

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.yagr.scv.databinding.FragmentCreateRepairBinding
import com.yagr.scv.utility.ViewModelFactory

class CreateRepairFragment : Fragment() {

    private val viewModel: CreateRepairViewModel by viewModels {
        ViewModelFactory(requireActivity().application, this)
    }

    lateinit var binding: FragmentCreateRepairBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCreateRepairBinding
            .inflate(inflater, container, false)
            .apply {
                lifecycleOwner = viewLifecycleOwner
                viewmodel = viewModel
            }

        return binding.root
    }
}