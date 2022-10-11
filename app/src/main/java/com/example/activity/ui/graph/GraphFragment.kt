package com.example.activity.ui.graph

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.activity.R
import com.example.activity.databinding.FragmentGraphBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GraphFragment : Fragment(R.layout.fragment_graph) {
    private var _binding:FragmentGraphBinding?=null
    private val binding get() = _binding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding=FragmentGraphBinding.bind(view)
    }

}