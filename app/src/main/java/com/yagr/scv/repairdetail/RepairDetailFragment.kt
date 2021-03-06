package com.yagr.scv.repairdetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.yagr.scv.databinding.FragmentRepairDetailBinding
import com.yagr.scv.repairlist.RepairListFragmentDirections
import com.yagr.scv.utility.ViewModelFactory

class RepairDetailFragment : Fragment() {

    private val args: RepairDetailFragmentArgs by navArgs()

    private val viewModel: RepairDetailViewModel by viewModels {
        ViewModelFactory(requireActivity().application, this, args.toBundle())
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

        binding.floatingActionButton.setOnClickListener {
            val action = RepairDetailFragmentDirections
                .actionRepairDetailFragmentToCreateStepFragment()
            findNavController().navigate(action)
        }

        return binding.root
    }

}