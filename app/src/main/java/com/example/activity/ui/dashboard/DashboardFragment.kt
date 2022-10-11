package com.example.activity.ui.dashboard

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.example.activity.R
import com.example.activity.databinding.FragmentDashboardBinding
import com.example.activity.ui.add_record.AddRecordVM
import com.example.activity.ui.dashboard.dashboard_component.ButtonCardComponent
import com.example.activity.ui.dashboard.dashboard_component.DataComponent
import com.jjoe64.graphview.series.DataPoint
import com.jjoe64.graphview.series.LineGraphSeries
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DashboardFragment : Fragment(R.layout.fragment_dashboard) {

    private lateinit var _binding: FragmentDashboardBinding
    private val binding get() = _binding
    val viewModel by viewModels<DashBoardVM>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentDashboardBinding.bind(view)
        navigateFrag()
//        getUserDetails()
//        val series: LineGraphSeries<DataPoint> = LineGraphSeries(
//            arrayOf(
//                // on below line we are adding
//                // each point on our x and y axis.
//                DataPoint(0.0, 1.0),
//                DataPoint(1.0, 3.0),
//                DataPoint(2.0, 4.0),
//                DataPoint(3.0, 9.0),
//                DataPoint(4.0, 6.0),
//                DataPoint(5.0, 3.0),
//                DataPoint(6.0, 6.0),
//                DataPoint(7.0, 1.0),
//                DataPoint(8.0, 2.0)
//            )
//        )
        ButtonCardComponent(
            binding=binding.addRecord,
            title = "Add Record",
            img = R.drawable.plus
        )
        ButtonCardComponent(
            binding = binding.oldRecord,
            title = "Old Record",
            img = R.drawable.oldrecord
        )



    }

    private fun navigateFrag(){
        binding.apply {
            graphComponent.root.setOnClickListener {
                findNavController().navigate(DashboardFragmentDirections.actionDashboardFragmentToGraphFragment())
            }
            addRecord.root.setOnClickListener {
                findNavController().navigate(DashboardFragmentDirections.actionDashboardFragmentToAddRecordFragment())
            }
            oldRecord.root.setOnClickListener {
                findNavController().navigate(DashboardFragmentDirections.actionDashboardFragmentToRecordFragment())
            }

        }
    }

    private fun getUserDetails(){
        this.lifecycleScope.launch{
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.readRecord
                viewModel.readRecord.collect{records->

//                        DataComponent(
//                            binding=binding.dataComponent,
//                            totalConsumption =
//                            averageOfCar = record.totalKm.toString()
//                        )
                    }
                    }

                }
            }
        }

