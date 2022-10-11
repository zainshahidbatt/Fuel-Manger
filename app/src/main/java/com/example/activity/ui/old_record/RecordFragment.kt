package com.example.activity.ui.old_record

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.activity.R
import com.example.activity.databinding.FragmentRecordBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecordFragment : Fragment(R.layout.fragment_record) {

    private var _binding: FragmentRecordBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModels<OldRecordVM>()

    private val mAdapter = RecordAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentRecordBinding.bind(view)
        binding.apply {
            btnBack.setOnClickListener {
                findNavController().navigateUp()
            }
        }
        initObserver()
    }

    private fun initObserver() {
        lifecycleScope.launchWhenCreated {
            viewModel.readRecord.collect { state ->
                when (state) {
                    is OldRecordVM.State.Success -> {
                        binding.recyclerview.adapter = mAdapter
                        mAdapter.submitList(state.record)
                    }
                    else -> {}
                }
            }
        }
    }
}