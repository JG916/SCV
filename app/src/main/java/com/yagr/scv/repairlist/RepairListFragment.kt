package com.yagr.scv.repairlist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.yagr.scv.data.repairs.Repair
import com.yagr.scv.databinding.FragmentRepairListBinding
import com.yagr.scv.utility.ViewModelFactory

class RepairListFragment : Fragment(), RepairListAdapter.RepairItemClickListener {

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
            adapter = RepairListAdapter(this@RepairListFragment)
        }

        binding.floatingActionButton.setOnClickListener {
            val action = RepairListFragmentDirections
                .actionRepairListFragmentToCreateRepairFragment()
            findNavController().navigate(action)
        }

        return binding.root
    }

    override fun onRepairClicked(repair: Repair) {
        val action = RepairListFragmentDirections
            .actionRepairListFragmentToRepairDetailFragment()
        findNavController().navigate(action)
    }
}