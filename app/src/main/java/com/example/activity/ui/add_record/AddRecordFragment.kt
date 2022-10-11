package com.example.activity.ui.add_record

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.activity.R
import com.example.activity.databinding.FragmentAddRecordBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddRecordFragment : Fragment(R.layout.fragment_add_record) {
    private var _binding: FragmentAddRecordBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<AddRecordVM>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentAddRecordBinding.bind(view)

        binding.apply {
            btnBack.setOnClickListener {
                findNavController().navigateUp()
            }

            btnSubmit.setOnClickListener {
                viewModel.onBtnClicked(
                    edMeterReading.text.toString(),
                    totalLitters.text.toString(),
                    totalPrice.text.toString()
                )
                moveFrag()
            }
        }
    }

    private fun moveFrag() {
        binding.apply {
            if (
                edMeterReading.text.toString().isNotEmpty()&&
            totalLitters.text.toString().isNotEmpty()&&
            totalPrice.text.toString().isNotEmpty()
            ){
                findNavController().navigate(AddRecordFragmentDirections.actionAddRecordFragmentToRecordFragment())
            }else{
                Toast.makeText(requireActivity(),"Please Fill All Feilds",Toast.LENGTH_SHORT).show()
            }
            }
        }

    }

