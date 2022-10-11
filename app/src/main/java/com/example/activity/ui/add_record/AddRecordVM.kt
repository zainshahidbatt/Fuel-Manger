package com.example.activity.ui.add_record

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.activity.model.Record
import com.example.activity.repository.RecordRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddRecordVM @Inject constructor(private val repository: RecordRepository) : ViewModel() {
    private val _record=MutableStateFlow<State>(State.Idle)
    val redRecord=_record.asStateFlow()
    var totalCun=0
    init {
        observeRecord()
    }

    private fun observeRecord() {
        viewModelScope.launch {
            repository.getRecords().collect{
                it.forEach { list->
                    totalCun+=list.litters
                }
            }

        }
    }


    fun onBtnClicked(
        meterReading: String,
        litterNum: String,
        litterPrice: String
    ) {

        if (
            meterReading.isNotEmpty()
            && litterNum.toString().isNotEmpty()
            && litterPrice.toString().isNotEmpty()
        ) {
            val price: Int = litterNum.toInt() * litterPrice.toInt()
            viewModelScope.launch {
                repository.insertRecord(
                    Record(
                        meterReading = meterReading,
                        price = litterPrice.toInt(),
                        totalAmount = price,
                        litters = litterNum.toInt(),
                        totalConsumption = totalCun
                    )
                )
            }
        } else {
        }
    }
    sealed class State{
        data class Success(val record:List<Record>):State()
        object Idle:State()
    }
}