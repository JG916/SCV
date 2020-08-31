package com.yagr.scv.repairdetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.yagr.scv.databinding.FragmentRepairDetailBinding
import com.yagr.scv.utility.ViewModelFactory

class RepairDetailFragment : Fragment() {

    private val viewModel: RepairDetailViewModel by viewModels {
        ViewModelFactory(requireActivity().application, this)
    }

    lateinit var binding: FragmentRepairDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRepairDetailBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = viewLifecycleOwner
            viewmodel = viewModel
            adapter = StepListAdapter()
        }

        return binding.root
    }

}