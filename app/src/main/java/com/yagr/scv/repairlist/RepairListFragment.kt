package com.yagr.scv.repairlist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.yagr.scv.createrepair.CreateRepairFragment
import com.yagr.scv.databinding.FragmentRepairListBinding
import com.yagr.scv.utility.ViewModelFactory

class RepairListFragment : Fragment() {

    private val viewModel: RepairListViewModel by viewModels {
        ViewModelFactory(requireActivity().application, this)
    }

    lateinit var binding: FragmentRepairListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRepairListBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = viewLifecycleOwner
            viewmodel = viewModel
            adapter = RepairListAdapter()
        }

        binding.floatingActionButton.setOnClickListener {
            val action = RepairListFragmentDirections
                .actionRepairListFragmentToCreateRepairFragment()
            it.findNavController().navigate(action)
        }

        return binding.root
    }
}