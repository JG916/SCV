package com.yagr.scv.createstep

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.yagr.scv.createstep.CreateStepViewModel.StepCreationStatus
import com.yagr.scv.databinding.FragmentCreateStepBinding
import com.yagr.scv.utility.ViewModelFactory

class CreateStepFragment : Fragment() {

    private val viewModel: CreateStepViewModel by viewModels {
        ViewModelFactory(requireActivity().application, this)
    }

    lateinit var binding: FragmentCreateStepBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCreateStepBinding
            .inflate(inflater, container, false)
            .apply {
                lifecycleOwner = viewLifecycleOwner
                viewmodel = viewModel
            }

        viewModel.status.observe(viewLifecycleOwner, Observer {
            if (it == StepCreationStatus.SUCCESS) {
                // Go back to the step list once the user has created a step
                findNavController().navigateUp()
            }
        })

        return binding.root
    }
}