package com.yagr.scv.createrepair

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.yagr.scv.createrepair.CreateRepairViewModel.RepairCreationStatus
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

        viewModel.status.observe(viewLifecycleOwner, Observer {
            if (it == RepairCreationStatus.SUCCESS) {
                // Go back to the repair list once the user has created a repair
                findNavController().navigateUp()
            }
        })

        return binding.root
    }
}