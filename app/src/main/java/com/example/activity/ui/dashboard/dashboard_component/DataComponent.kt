package com.example.activity.ui.dashboard.dashboard_component

import com.example.activity.databinding.DataComponentBinding

class DataComponent(
    binding: DataComponentBinding,
    totalConsumption: String,
    averageOfCar: String
) {
    init {
        binding.apply {
            totalPetrol.text = totalConsumption
            averageCar.text = averageOfCar
        }
    }
}